package by.st.optpaymentsdao.pojos;

/**
 *
 * @author Mumish
 */
public class Client {

    /**
     * ИД клиента
     */
    public long id;

    /**
     * ФИО клиента
     */
    public String fio;

    /**
     * Логин клиента
     */
    public String login;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
