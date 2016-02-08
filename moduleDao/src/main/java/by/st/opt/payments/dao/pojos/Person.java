package by.st.opt.payments.dao.pojos;

import java.io.Serializable;

/**
 *
 * @author Mumish
 */
public class Person implements Serializable {

    private String name;

    private IAddress address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IAddress getAddress() {
        return address;
    }

    public void setAddress(IAddress address) {
        this.address = address;
    }

}
