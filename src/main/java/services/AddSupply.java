package services;

import java.sql.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
//import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

@WebService()
public class AddSupply {
    @WebMethod
    public String AddSupply(@XmlElement (name = "id") int id,
                            @XmlElement (name = "amount") int amount) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws-factory", "root", "");
            conn.setAutoCommit(true);

            java.util.Date today = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String stringDate = dateFormat.format(today);
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
//            StringWriter errors = new StringWriter();
//            e.printStackTrace(new PrintWriter(errors));
//            String result = errors.toString();
//            return result;
            return "500";
        } catch (Exception e) {
//            StringWriter errors = new StringWriter();
//            e.printStackTrace(new PrintWriter(errors));
//            String result = errors.toString();
//            return result;
            return "400";
        } finally {
            String result = "200";
            return result;
        }
    }
}
