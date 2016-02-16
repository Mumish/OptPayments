package by.st.opt.payments.dao.pojos;

import by.st.opt.payments.dao.main.Main;
import java.util.Collection;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mumish
 */
@Component("addressForFilter")
public class AddressForFilter implements IAddress, InitializingBean {

    String addr;

    private Collection<String> flats;

    public Collection<String> getFlats() {
        return flats;
    }

    public void setFlats(Collection<String> flats) {
        this.flats = flats;
    }

    @Override
    public String getAddress() {

        StringBuilder flatt = new StringBuilder();

        if (flats != null) {
            for (String fla : flats) {
                flatt.append(" ").append(fla);
            }
        }

        return addr + ". flats: " + flatt.toString();
    }

    public static AddressForFilter getInstance() {
        AddressForFilter adrInst = new AddressForFilter();

        adrInst.addr = "AddressForFilter: this is instance addres";
        return adrInst;

    }

    @Override
    public void setAddress(String address) {
        this.addr = address;
    }

    public void init() {
        Main.helpMethodSpting(this.getClass().getCanonicalName(), "xml-init");
    }

    public void destroy() {
        Main.helpMethodSpting(this.getClass().getCanonicalName(), "xml-destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Main.helpMethodSpting(this.getClass().getCanonicalName(), "interface-init");
    }

}
