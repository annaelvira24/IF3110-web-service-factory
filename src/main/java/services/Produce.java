package services;
import java.sql.*;
//import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService()
public class Produce {
    @WebMethod
    public String Produce(@XmlElement (name = "productId") String productId,
                          @XmlElement (name = "amount") String stock) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws-factory", "root", "");
            Statement stmt = conn.createStatement();

            String query1 = String.format("update product set stock = stock + %s where product_id = %s)", stock, productId);
            stmt.executeUpdate(query1);

            String query2 = String.format("update product set stock = stock + %s where product_id = %s)", stock, productId);
            stmt.executeUpdate(query1);

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