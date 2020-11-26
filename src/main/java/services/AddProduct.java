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
                             @XmlElement (name = "amount") String amount) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws-factory", "root", "");
            Statement stmt = conn.createStatement();
            String query = String.format("insert into product (id_product, name, stock) values (%s, %s, %s)", productId, productName, amount);
            stmt.executeQuery(query);

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
