package data;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlType(name = "", propOrder = {
        "id",
        "amount",
})

@XmlRootElement(name = "getArrResponse")
public class Supply {
    private final static long serialVersionUID = 1L;
    @XmlElement(name = "id", required = true)
    private int id;
    @XmlElement(name = "amount", required = true)
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
