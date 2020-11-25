package services;
import data.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class GetOrder {
    @WebMethod
    public Order GetOrder() {
        Order result = new Order();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws-factory", "root", "");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select * from addStock join product using (id_product)";
            ResultSet res = stmt.executeQuery(query);

            if (res.next()) {
                res.beforeFirst();

                List<String> dataId = new ArrayList<String>();
                List<String> dataName = new ArrayList<String>();
                List<String> dataAmount = new ArrayList<String>();
                List<String> dataStatus = new ArrayList<String>();


                result.setStatus(200);

                while (res.next()) {
                    dataId.add(res.getString("id_addstock"));
                    dataName.add(res.getString("name"));
                    dataAmount.add(res.getString("amount"));
                    dataStatus.add(res.getString("status"));
                }

                result.setOrderId(dataId);
                result.setProductName(dataName);
                result.setAmount(dataAmount);
                result.setOrderStatus(dataStatus);

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
