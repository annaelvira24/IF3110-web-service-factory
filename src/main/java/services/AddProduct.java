package services;
import java.sql.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService()
public class AddProduct {
    @WebMethod
    public String AddProduct(@XmlElement (name = "productId") String productId,
                             @XmlElement (name = "productName") String productName,
                             @XmlElement (name = "stock") String stock) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws-factory", "root", "");

            String query1 = "insert into product (id_product, name, stock) values (?, ?, ?)";
            PreparedStatement preparedStmt1 = conn.prepareStatement(query1);
            preparedStmt1.setString(1, productId);
            preparedStmt1.setString(2, productName);
            preparedStmt1.setString(3, stock);

            preparedStmt1.execute();

//            String query2 = "insert into recipe (id_product, id_ingredient, amount_need) values (?, ?, ?)";
//            PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
//            preparedStmt2.setString(1, productId);
//
//            for (RecipeItem recipeItem : recipeItems) {
//                preparedStmt2.setString(2, recipeItem.getIngredientId());
//                preparedStmt2.setString(3, recipeItem.getAmountNeed());
//                preparedStmt2.execute();
//            }

            conn.commit();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return "500";
        } catch (Exception e) {
            e.printStackTrace();
            return "400";
        } finally {
            return "200";
        }
    }
}
