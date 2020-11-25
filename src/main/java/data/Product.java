package data;
import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlType(name = "", propOrder = {
        "status",
        "productId",
        "productName",
        "stock"
})

@XmlRootElement(name = "getArrResponse")
public class Product {
    private final static long serialVersionUID = 1L;
    @XmlElement(name = "status", required = true)
    private int status;
    @XmlElement(name = "productId", required = true)
    private List<String> productId;
    @XmlElement(name = "productName", required = true)
    private List<String> productName;
    @XmlElement(name = "stock", required = true)
    private List<String> stock;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getProductId() {
        return productId;
    }

    public void setProductId(List<String> productId) {
        this.productId = productId;
    }

    public List<String> getProductName() {
        return productName;
    }

    public void setProductName(List<String> productName) {
        this.productName = productName;
    }

    public List<String> getStock() {
        return stock;
    }

    public void setStock(List<String> stock) {
        this.stock = stock;
    }
}