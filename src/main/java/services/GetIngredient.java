package services;
import data.Ingredient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class GetIngredient {
    @WebMethod
    public Ingredient GetIngredient() {
        Ingredient result = new Ingredient();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws-factory", "root", "");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select * from ingredient_details join ingredient using (id_ingredient) order by id_ingredient";
            ResultSet res = stmt.executeQuery(query);

            if (res.next()) {
                res.beforeFirst();

                List<String> dataId = new ArrayList<String>();
                List<String> dataName = new ArrayList<String>();
                List<String> dataStock = new ArrayList<String>();
                List<String> dataExpiry = new ArrayList<String>();


                result.setStatus(200);

                while (res.next()) {
                    dataId.add(res.getString("id_ingredient"));
                    dataName.add(res.getString("name"));
                    dataStock.add(res.getString("stock"));
                    dataExpiry.add(res.getString("expiry_date"));
                }

                result.setIngredientId(dataId);
                result.setIngredientName(dataName);
                result.setStock(dataStock);
                result.setExpiryDate(dataExpiry);

            } else {
                result.setStatus(300);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result.setStatus(500);
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(400);
        } finally {
            return result;
        }
    }
}
