package services;
import java.sql.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService()
public class GetApprovalStatus {
    @WebMethod
    public String GetApprovalStatus(@XmlElement (name = "addStockId") String addStockId) {
        String result = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws-factory", "root", "");
            Statement stmt = conn.createStatement();
            String query = String.format("select status from addStock where id_addstock = %s", addStockId);
            ResultSet res = stmt.executeQuery(query);

            if (res.next()) {
                result = (res.getString("status"));
            } else {
                result = "300";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = "500";
        } catch (Exception e) {
            e.printStackTrace();
            result =  "400";
        } finally {
            return result;
        }
    }
}
