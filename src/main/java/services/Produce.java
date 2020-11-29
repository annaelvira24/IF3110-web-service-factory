package services;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService()
public class Produce {
    @WebMethod
    public String Produce(@XmlElement (name = "productId") String productId,
                          @XmlElement (name = "amount") int amountToAdd) {

        String result = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws-factory", "root", "");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String query = String.format("select * from recipe where id_product = %s", productId);
            ResultSet res = stmt.executeQuery(query);

            if (res.next()) {
                res.beforeFirst();

                List<String> dataIngredient = new ArrayList<String>();
                List<Integer> dataAmount = new ArrayList<Integer>();

                while (res.next()) {
                    dataIngredient.add(res.getString("id_ingredient"));
                    dataAmount.add(res.getInt("amount_need"));
                }

                boolean isEnoughStock = true;
//                java.util.Date today = new Date();
//                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
//                java.util.Date dateStr = formatter.parse(String.valueOf(today));
//                java.sql.Date todayString = new java.sql.Date(dateStr.getTime());

                for (int i = 0; i < dataIngredient.size(); i++) {
                    String query1 = "select sum(stock) from ingredient_details where id_ingredient = ? and expiry_date >= CURRENT_DATE()";
                    PreparedStatement preparedStmt1 = conn.prepareStatement(query1);
                    preparedStmt1.setString(1, dataIngredient.get(i));

                    res = preparedStmt1.executeQuery();

                    res.next();

                    int sumStock = res.getInt("sum(stock)");
                    if (sumStock < (amountToAdd * dataAmount.get(i))) {
                        isEnoughStock = false;
                        break;
                    }
                }

                if (isEnoughStock) {
                    for (int i = 0; i < dataIngredient.size(); i++) {
                        int amountNeed = amountToAdd * dataAmount.get(i);
                        query = String.format("select * from ingredient_details where id_ingredient = %s and expiry_date >= CURRENT_DATE() order by expiry_date asc", dataIngredient.get(i));
                        res = stmt.executeQuery(query);
                        while (amountNeed > 0) {
                            res.next();
                            int stockAvail = res.getInt("stock");
                            java.sql.Date expiryDate = res.getDate("expiry_date");

                            Statement stmtUpdate = conn.createStatement();
                            if (amountNeed >= stockAvail) {
                                String query2 = "update ingredient_details set stock = 0 where id_ingredient = ? and expiry_date = ?";
                                PreparedStatement preparedStmt1 = conn.prepareStatement(query2);
                                preparedStmt1.setString(1, dataIngredient.get(i));
                                preparedStmt1.setDate(2, expiryDate);

                                preparedStmt1.executeUpdate();

                                amountNeed -= stockAvail;
                            } else {
                                String query2 = "update ingredient_details set stock = stock - ? where id_ingredient = ? and expiry_date = ?";
                                PreparedStatement preparedStmt1 = conn.prepareStatement(query2);
                                preparedStmt1.setInt(1, amountNeed);
                                preparedStmt1.setString(2, dataIngredient.get(i));
                                preparedStmt1.setDate(3, expiryDate);

                                preparedStmt1.executeUpdate();

                                amountNeed = 0;
                            }
                        }
                    }
                    Statement stmtUpdate = conn.createStatement();
                    String queryUpdate = String.format("update product set stock = stock + %s where id_product = %s", amountToAdd, productId);
                    stmtUpdate.executeUpdate(queryUpdate);

                    result = "200";

                } else {
                    result = "300";
                }
            }
        } catch (SQLException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            result = errors.toString();
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            result = errors.toString();
        } finally {
            return result;
        }
    }
}