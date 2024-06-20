package giulio_marra.s5_l4_be;

import giulio_marra.s5_l4_be.entities.Bevande;
import giulio_marra.s5_l4_be.entities.Ingredienti;
import giulio_marra.s5_l4_be.entities.Pizze;
import giulio_marra.s5_l4_be.entities.Tavoli;
import giulio_marra.s5_l4_be.enums.StatoTavolo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("application.properties")
public class Beansconfig {

    @Bean
    public Ingredienti mozzarella() {
        return new Ingredienti("Mozzarella");
    }

    @Bean
    public Ingredienti pomodoro() {
        return new Ingredienti("Pomodoro");
    }

    @Bean
    public Ingredienti funghi() {
        return new Ingredienti("Funghi");
    }

    @Bean
    public Ingredienti prosciutto() {
        return new Ingredienti("Prosciutto");
    }

    @Bean
    public Ingredienti ananas() {
        return new Ingredienti("ananas");
    }

    @Bean
    public List<Ingredienti> ingredientiBase() {
        return Arrays.asList(mozzarella(), pomodoro());
    }

    @Bean
    public Pizze margherita() {
        return new Pizze("Margherita", 5.00, new ArrayList<>(ingredientiBase()));
    }

    @Bean
    public Pizze funghiPizza() {
        List<Ingredienti> ingredienti = new ArrayList<>(ingredientiBase());
        ingredienti.add(funghi());
        return new Pizze("Funghi", 6.50, ingredienti);
    }

    @Bean
    public Pizze prosciuttoPizza() {
        List<Ingredienti> ingredienti = new ArrayList<>(ingredientiBase());
        ingredienti.add(prosciutto());
        ingredienti.add(ananas());
        return new Pizze("Hawaiian Pizza", 7.00, ingredienti);
    }

    @Bean
    public Bevande coca() {
        return new Bevande(2.50, "coca-cola");
    }

    @Bean
    public Bevande acqua() {
        return new Bevande(1.50, "acqua");
    }

    @Bean
    public Bevande sprite() {
        return new Bevande(2.00, "sprite");
    }

    @Bean
    public Tavoli tavolo1() {
        return new Tavoli(1, 10, StatoTavolo.LIBERO);
    }

    @Bean
    public Tavoli tavolo2() {
        return new Tavoli(2, 8, StatoTavolo.OCCUPATO);
    }

    @Bean
    public Tavoli tavolo3() {
        return new Tavoli(3, 4, StatoTavolo.LIBERO);
    }

    @Bean
    public Tavoli tavolo4() {
        return new Tavoli(4, 2, StatoTavolo.LIBERO);
    }

    @Bean
    public Tavoli tavolo5() {
        return new Tavoli(5, 4, StatoTavolo.OCCUPATO);
    }

    @Bean
    public double coperto(@Value("${coperto.costo}") String copertoPersona) {
        return Double.parseDouble(copertoPersona);
    }

}
