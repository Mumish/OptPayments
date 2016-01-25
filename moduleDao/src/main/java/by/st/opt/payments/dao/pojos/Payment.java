package by.st.opt.payments.dao.pojos;

import java.util.Date;

/**
 *
 * @author Mumish
 */
public class Payment {

    private long id;

    private long clientId;

    private long accountId;

    private long orderId;

    private double amount;

    private Date datePayment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    @Override
    public String toString() {
        return "id=" + this.getId() + ", clientId=" + this.getClientId() + ", accountId=" + this.getAccountId() + ", orderId=" + this.getOrderId() + ", amount=" + this.getAmount() + ", datePayment=" + this.getDatePayment();
    }

}
