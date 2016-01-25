package by.st.opt.payments.dao.pojos;

import java.util.Date;

/**
 *
 * @author Mumish
 */
public class Order {

    private long id;

    private long clientId;

    private String num;

    private double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        return "id=" + this.getId() + ", clientId=" + this.getClientId() + ", num=" + this.getNum() + ", price=" + this.getPrice() + ", dateOpen=" + this.getDateOpen() + ", statusId=" + this.getStatusId();
    }

}
