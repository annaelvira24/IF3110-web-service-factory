package services;
import data.Recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;


@WebService()
public class GetRecipe {
    @WebMethod
    public Recipe GetRecipe(@XmlElement(name = "productId") String productId) {
        Recipe result = new Recipe();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws-factory", "root", "");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = String.format("select product.name, ingredient.name, amount_need from (recipe join product using (id_product)) join ingredient using (id_ingredient) where id_product = %s", productId);
            ResultSet res = stmt.executeQuery(query);

            if (res.next()) {
                result.setProductName(res.getString("product.name"));
                res.beforeFirst();

                List<String> dataIngredient = new ArrayList<String>();
                List<String> dataAmount = new ArrayList<String>();

                result.setStatus(200);

                while (res.next()) {
                    dataIngredient.add(res.getString("ingredient.name"));
                    dataAmount.add(res.getString("amount_need"));
                }

                result.setIngredientName(dataIngredient);
                result.setAmountNeed(dataAmount);
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
