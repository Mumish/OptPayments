package by.st.opt.payments.dao.pojos;

import java.util.Date;

/**
 *
 * @author Mumish
 */
public class Account {

    private long id;

    private long clientId;

    private String num;

    private double balance;

    private Date dateOpen;

    private int statusId;

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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(Date dateOpen) {
        this.dateOpen = dateOpen;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "id=" + this.getId() + ", clientId=" + this.getClientId() + ", num=" + this.getNum() + ", balance=" + this.getBalance() + ", dateOpen=" + this.getDateOpen() + ", statusId=" + this.getStatusId();
    }

}
