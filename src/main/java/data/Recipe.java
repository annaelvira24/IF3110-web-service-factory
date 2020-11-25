package data;
import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlType(name = "", propOrder = {
        "status",
        "productName",
        "ingredientName",
        "amountNeed"
})

@XmlRootElement(name = "getArrResponse")
public class Recipe {
    private final static long serialVersionUID = 1L;
    @XmlElement(name = "status", required = true)
    private int status;
    @XmlElement(name = "productName", required = true)
    private String productName;
    @XmlElement(name = "ingredientName", required = true)
    private List<String> ingredientName;
    @XmlElement(name = "amountNeed", required = true)
    private List<String> amountNeed;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<String> getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(List<String> ingredientName) {
        this.ingredientName = ingredientName;
    }

    public List<String> getAmountNeed() {
        return amountNeed;
    }

    public void setAmountNeed(List<String> amountNeed) {
        this.amountNeed = amountNeed;
    }
}

