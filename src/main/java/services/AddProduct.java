package services;
import java.sql.*;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService()
public class AddProduct {
    @WebMethod
    public String AddProduct(@XmlElement (name = "productId") String productId,
                             @XmlElement (name = "productName") String productName,
                             @XmlElement (name = "stock") String stock,
                             @XmlElement (name = "ingredient") List<String> ingredient,
                             @XmlElement (name = "amountNeed") List<String> amountNeed) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws-factory", "root", "");
            Statement stmt = conn.createStatement();
            String query1 = String.format("insert into product (id_product, name, stock) values (%s, %s, %s)", productId, productName, stock);
            stmt.executeUpdate(query1);
            
            for (int i = 0; i < ingredient.size(); i++) {
                stmt.executeUpdate(String.format("insert into recipe (id_product, id_ingredient, amount_need) values (%s, %s, %s)", productId, ingredient.get(i), amountNeed.get(i)));
            }

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
