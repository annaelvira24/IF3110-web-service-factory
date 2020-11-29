package services;
import java.sql.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService()
public class AddRecipe {
    @WebMethod
    public String AddRecipe(@XmlElement (name = "productId") String productId,
                             @XmlElement (name = "ingredientId") String ingredientId,
                             @XmlElement (name = "amountNeed") String amountNeed) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws-factory", "root", "");

            String query1 = "insert into recipe (id_product, id_ingredient, amount_need) values (?, ?, ?)";
            PreparedStatement preparedStmt1 = conn.prepareStatement(query1);
            preparedStmt1.setString(1, productId);
            preparedStmt1.setString(2, ingredientId);
            preparedStmt1.setString(3, amountNeed);

            preparedStmt1.execute();

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
