package by.st.opt.payments.dao.pojos;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Mumish
 */
public class Client {

//    public Client() {
//        employees = new LinkedHashSet<>();
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 47 * hash + Objects.hashCode(this.fio);
        hash = 47 * hash + Objects.hashCode(this.login);
        hash = 47 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.fio, other.fio)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    /**
     * ИД клиента
     */
    private long id;

    /**
     * ФИО клиента
     */
    private String fio;

    /**
     * Логин клиента
     */
    private String login;
    /**
     * Пароль клиента
     */
    private String password;

    Set<Empl> employees;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Empl> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Empl> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "id=" + this.getId() + ", fio=" + this.getFio() + ", login=" + this.getLogin() + ", password=" + this.getPassword();
    }

}
