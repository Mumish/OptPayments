package by.st.opt.payments.dao.pojos;

/**
 *
 * @author Mumish
 */
public class Empl {

    private Client client;
    /**
     * ИД клиента
     */
    private long emplId;

    /**
     * Логин клиента
     */
    private String log;
    /**
     * Пароль клиента
     */
    private String pass;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public long getEmplId() {
        return emplId;
    }

    public void setEmplId(long emplId) {
        this.emplId = emplId;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
