package services;
import data.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class GetProduct {
    @WebMethod
    public Product GetProduct() {
        Product result = new Product();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws-factory", "root", "");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = String.format("select * from product");
            ResultSet res = stmt.executeQuery(query);

            if (res.next()) {
                res.beforeFirst();

                List<String> dataId = new ArrayList<String>();
                List<String> dataName = new ArrayList<String>();
                List<String> dataStock = new ArrayList<String>();

                result.setStatus(200);

                while (res.next()) {
                    dataId.add(res.getString("id_product"));
                    dataName.add(res.getString("name"));
                    dataStock.add(res.getString("stock"));
                }

                result.setProductId(dataId);
                result.setProductName(dataName);
                result.setStock(dataStock);
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
