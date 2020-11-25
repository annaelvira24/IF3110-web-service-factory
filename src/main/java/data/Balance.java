package data;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlType(name = "", propOrder = {
        "status",
        "balance"
})

@XmlRootElement(name = "getArrResponse")
public class Balance {
    private final static long serialVersionUID = 1L;
    @XmlElement(name = "status", required = true)
    private int status;
    @XmlElement(name = "balance", required = true)
    private String balance;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
