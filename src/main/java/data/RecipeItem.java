package data;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlType(name = "", propOrder = {
        "ingredientId",
        "amountNeed"
})

@XmlRootElement(name = "getArrResponse")
public class RecipeItem {
    private final static long serialVersionUID = 1L;
    @XmlElement(name = "ingredientId", required = true)
    private String ingredientId;
    @XmlElement(name = "amountNeed", required = true)
    private String amountNeed;

    public String getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(String ingredientName) {
        this.ingredientId = ingredientId;
    }

    public String getAmountNeed() {
        return amountNeed;
    }

    public void setAmountNeed(String amountNeed) {
        this.amountNeed = amountNeed;
    }
}

