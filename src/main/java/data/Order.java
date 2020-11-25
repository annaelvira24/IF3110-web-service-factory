package data;
import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlType(name = "", propOrder = {
        "status",
        "orderId",
        "productName",
        "amount",
        "orderStatus"
})

@XmlRootElement(name = "getArrResponse")
public class Order {
    private final static long serialVersionUID = 1L;
    @XmlElement(name = "status", required = true)
    private int status;
    @XmlElement(name = "orderId", required = true)
    private List<String> orderId;
    @XmlElement(name = "productName", required = true)
    private List<String> productName;
    @XmlElement(name = "amount", required = true)
    private List<String> amount;
    @XmlElement(name = "orderStatus", required = true)
    private List<String> orderStatus;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getOrderId() {
        return orderId;
    }

    public void setOrderId(List<String> orderId) {
        this.orderId = orderId;
    }

    public List<String> getProductName() {
        return productName;
    }

    public void setProductName(List<String> productName) {
        this.productName = productName;
    }

    public List<String> getAmount() {
        return amount;
    }

    public void setAmount(List<String> amount) {
        this.amount = amount;
    }

    public List<String> getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(List<String> orderStatus) {
        this.orderStatus = orderStatus;
    }
}