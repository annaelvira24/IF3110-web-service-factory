package services;
import java.sql.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService()
public class ReqAddStock {
    @WebMethod
    public String ReqAddStock(@XmlElement (name = "productId") String productId,
                             @XmlElement (name = "amount") String amount) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws-factory", "root", "");

            String query = "insert into addStock (id_product, amount, status) values (?, ?, ?)";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, productId);
            preparedStmt.setString(2, amount);
            preparedStmt.setString(3, "Pending");

            // execute the preparedstatement
            preparedStmt.execute();

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
