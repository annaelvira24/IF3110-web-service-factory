package services;

import java.sql.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService()
public class ReduceBalance {
    @WebMethod
    public String ReduceBalance(@XmlElement (name = "money") int money) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws-factory", "root", "");
            conn.setAutoCommit(true);

            String queryBalance;
            String stringMoney = Integer.toString(money);
            queryBalance = "UPDATE balance SET balance_amount = ?";
            PreparedStatement preparedStmtBalance = conn.prepareStatement(queryBalance);
            preparedStmtBalance.setString(1, stringMoney);
            preparedStmtBalance.execute();

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

