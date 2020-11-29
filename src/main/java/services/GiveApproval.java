package services;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService()
public class GiveApproval {
    @WebMethod
    public String GiveApproval(@XmlElement (name = "addStockId") String addStockId) {

        String result = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws-factory", "root", "");
            Statement stmt = conn.createStatement();
            String query = String.format("select id_product, amount from addStock where id_addstock = %s", addStockId);
            ResultSet res = stmt.executeQuery(query);

            res.next();
            String productId = res.getString("id_product");
            int amount = res.getInt("amount");

            String query1 = String.format("select stock from product where id_product = %s", productId);
            ResultSet res2 = stmt.executeQuery(query1);

            res2.next();
            int stock = res2.getInt("stock");

            if (stock >= amount) {
                String query2 = String.format("update addStock set status = 'Delivered' where id_addstock = %s", addStockId);
                stmt.executeUpdate(query2);
                query2 = String.format("update product set stock = stock - %s where id_product = %s", amount, productId);
                stmt.executeUpdate(query2);

                result = "200";
            } else {
                result = "300";
            }

        } catch (SQLException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            result = errors.toString();
        } catch (Exception e) {
            e.printStackTrace();
            result = "400";
        } finally {
            return result;
        }
    }
}
