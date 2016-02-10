package by.st.opt.payments.dao.pojos;

import by.st.opt.payments.dao.main.Main;
import java.io.Serializable;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 *
 * @author Mumish
 */
public class Person implements Serializable, InitializingBean, DisposableBean {

    private String name;
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void destroy() {
        Main.helpMethodSpting(this.getClass().getCanonicalName(), "interface-destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Main.helpMethodSpting(this.getClass().getCanonicalName(), "interface-init");
    }
}
