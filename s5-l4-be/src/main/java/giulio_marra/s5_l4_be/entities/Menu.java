package giulio_marra.s5_l4_be.entities;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class Menu {


    private List<Pizze> pizze;
    private List<Bevande> bevande;
    private List<Ingredienti> ingredienti;

    public List<Pizze> getPizze() {
        return pizze;
    }

    public void setPizze(List<Pizze> pizze) {
        this.pizze = pizze;
    }

    public List<Bevande> getBevande() {
        return bevande;
    }

    public void setBevande(List<Bevande> bevande) {
        this.bevande = bevande;
    }

    public List<Ingredienti> getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(List<Ingredienti> ingredienti) {
        this.ingredienti = ingredienti;
    }

    public void stampaMenu() {
        System.out.println("Menu Pizze:");
        for (Pizze pizza : pizze) {
            System.out.println(pizza);
        }
        System.out.println("Menu Bevande:");
        for (Bevande bevanda : bevande) {
            System.out.println(bevanda);
        }
        System.out.println("Menu Ingredienti:");
        for (Ingredienti ingrediente : ingredienti) {
            System.out.println(ingrediente);
        }
    }
}
