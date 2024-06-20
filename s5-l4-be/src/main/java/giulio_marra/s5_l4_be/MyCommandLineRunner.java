package giulio_marra.s5_l4_be;


import giulio_marra.s5_l4_be.entities.*;
import giulio_marra.s5_l4_be.service.IngredientiService;
import giulio_marra.s5_l4_be.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    private Menu menu;

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private IngredientiService ingredientiService;

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(S5L4BeApplication.class);

        Double coperto = ctx.getBean("coperto", double.class);

        Tavoli tavolo = ctx.getBean("tavolo3", Tavoli.class);

        List<Pizze> pizzeSelezionate = new ArrayList<>();
        pizzeSelezionate.add(ctx.getBean("margherita", Pizze.class));
        pizzeSelezionate.add(ctx.getBean("margherita", Pizze.class));
        pizzeSelezionate.add(ctx.getBean("funghiPizza", Pizze.class));

        List<Bevande> bevandeSelezionate = new ArrayList<>();
        bevandeSelezionate.add(ctx.getBean("coca", Bevande.class));
        bevandeSelezionate.add(ctx.getBean("acqua", Bevande.class));
        bevandeSelezionate.add(ctx.getBean("coca", Bevande.class));

        List<Ingredienti> tuttiGliIngredienti = new ArrayList<>();
        tuttiGliIngredienti.add((ctx.getBean("mozzarella", Ingredienti.class)));
        tuttiGliIngredienti.add((ctx.getBean("pomodoro", Ingredienti.class)));
        tuttiGliIngredienti.add((ctx.getBean("funghi", Ingredienti.class)));
        tuttiGliIngredienti.add((ctx.getBean("prosciutto", Ingredienti.class)));
        tuttiGliIngredienti.add((ctx.getBean("ananas", Ingredienti.class)));

        Ordini ordine = new Ordini(1, 3, tavolo, LocalDate.now(), pizzeSelezionate, bevandeSelezionate);


        menu.stampaMenu();
        ordine.stampaOrdine(coperto);

        Pizze margherita = ctx.getBean("margherita", Pizze.class);
        Pizze funghiPizza = ctx.getBean("funghiPizza", Pizze.class);
        Pizze prosciuttoPizza = ctx.getBean("prosciuttoPizza", Pizze.class);

        try {
            //ingredientiService.saveIngredienti(tuttiGliIngredienti);
            pizzaService.savePizza(funghiPizza);
            pizzaService.savePizza(prosciuttoPizza);
            pizzaService.savePizza(margherita);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }
}
