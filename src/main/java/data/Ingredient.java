package data;
import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlType(name = "", propOrder = {
        "status",
        "ingredientId",
        "ingredientName",
        "stock",
        "expiryDate"

})

@XmlRootElement(name = "getArrResponse")
public class Ingredient {
    private final static long serialVersionUID = 1L;
    @XmlElement(name = "status", required = true)
    private int status;
    @XmlElement(name = "ingredientId", required = true)
    private List<String> ingredientId;
    @XmlElement(name = "ingredientName", required = true)
    private List<String> ingredientName;
    @XmlElement(name = "stock", required = true)
    private List<String> stock;
    @XmlElement(name = "expiryDate", required = true)
    private List<String> expiryDate;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(List<String> ingredientName) {
        this.ingredientName = ingredientName;
    }

    public List<String> getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(List<String> ingredientId) {
        this.ingredientId = ingredientId;
    }

    public List<String> getStock() {
        return stock;
    }

    public void setStock(List<String> stock) {
        this.stock = stock;
    }

    public List<String> getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(List<String> expiryDate) {
        this.expiryDate = expiryDate;
    }
}
