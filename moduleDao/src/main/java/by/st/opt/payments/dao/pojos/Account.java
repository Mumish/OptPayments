package by.st.opt.payments.dao.pojos;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author Mumish
 */
public class Account {

    private long accountId;

    private String num;

    private double balance;

    private Date dateOpen;

    private int statusId;

    private Set<Client> clients;

    public Account() {
        clients = new LinkedHashSet<>();
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
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

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "accountId=" + this.getAccountId() + ", num=" + this.getNum() + ", balance=" + this.getBalance() + ", dateOpen=" + this.getDateOpen() + ", statusId=" + this.getStatusId();
    }

}
