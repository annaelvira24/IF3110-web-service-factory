package services;

import java.sql.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import java.text.SimpleDateFormat;
import java.util.*;

@WebService()
public class AddSupply {
    @WebMethod
    public String AddSupply(@XmlElement (name = "id") int id,
                            @XmlElement (name = "amount") int amount) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws-factory", "root", "");
            conn.setAutoCommit(true);

            Calendar cal = Calendar.getInstance();
            java.util.Date today = cal.getTime();
            cal.add(Calendar.YEAR, 1);
            java.util.Date nextYear = cal.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String stringDate = dateFormat.format(nextYear);
            java.sql.Date sqlDate =  java.sql.Date.valueOf(stringDate);

            String query;
            String added;
            String querySelect = "SELECT stock FROM ingredient_details WHERE id_ingredient = ? AND expiry_date = ?";
            PreparedStatement stmt = conn.prepareStatement(querySelect);
            stmt.setInt(1, id);
            stmt.setDate(2, sqlDate);
            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                added = Integer.toString(amount);
                query = "UPDATE ingredient_details SET stock = stock + ? WHERE id_ingredient = ? AND expiry_date = ?";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, added);
                preparedStmt.setInt(2, id);
                preparedStmt.setDate(3, sqlDate);
                preparedStmt.executeUpdate();
            } else {
                int added1 = amount;
                query = "INSERT INTO ingredient_details (id_ingredient, expiry_date, stock) VALUES(?,?,?)";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, id);
                preparedStmt.setDate(2, sqlDate);
                preparedStmt.setInt(3, added1);
                preparedStmt.executeUpdate();
            }

        } catch (SQLException e) {
            return "500";
        } catch (Exception e) {
            return "400";
        } finally {
            String result = "200";
            return result;
        }
    }
}
