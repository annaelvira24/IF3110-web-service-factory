package services;
import data.User;

import java.sql.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService()
public class Login {
    @WebMethod
    public User Login(@XmlElement(name = "username") String username, @XmlElement(name = "password") String password) {
        User result = new User();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws-factory", "root", "");
            Statement stmt = conn.createStatement();
            String query = "select * from users where username = " + username + "and password = " + password;
            ResultSet res = stmt.executeQuery(query);

            if (res.next()) {
                result.setStatus(200);

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
