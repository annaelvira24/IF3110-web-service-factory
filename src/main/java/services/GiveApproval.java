package services;
import java.sql.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService()
public class GiveApproval {
    @WebMethod
    public String GiveApproval(@XmlElement (name = "addStockId") String addStockId) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws-factory", "root", "");
            Statement stmt = conn.createStatement();
            String query = String.format("update addStock set status = 'Delivered' where id_addstock = %s", addStockId);
            stmt.executeUpdate(query);

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
