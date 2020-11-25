package services;
import data.Balance;
import java.sql.*;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class GetBalance {
    @WebMethod
    public Balance GetBalance() {
        Balance result = new Balance();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws-factory", "root", "");
            Statement stmt = conn.createStatement();
            String query = "select * from balance";
            ResultSet res = stmt.executeQuery(query);

            if (res.next()) {
                result.setStatus(200);
                result.setBalance(res.getString("balance_amount"));
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
