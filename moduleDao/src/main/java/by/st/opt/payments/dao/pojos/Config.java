package by.st.opt.payments.dao.pojos;

import by.st.opt.payments.dao.main.Main;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public AddressForFilter addressForFilter() {
        Main.helpMethodSpting(this.getClass().getCanonicalName(), "config-factory");
        AddressForFilter adr = new AddressForFilter();
        adr.setAddress("AddressForFilert from config init");

        Set<String> flats = new HashSet<>();
        flats.add("1");
        flats.add("3");
        flats.add("5");

        adr.setFlats(flats);
        return adr;
    }

}
