package by.st.opt.payments.dao.pojos;

import by.st.opt.payments.dao.main.Main;
import java.util.Collection;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mumish
 */
@Service
public class AddressForFilter1 implements IAddress, InitializingBean {

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

    public static AddressForFilter1 getInstance() {
        AddressForFilter1 adrInst = new AddressForFilter1();

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
