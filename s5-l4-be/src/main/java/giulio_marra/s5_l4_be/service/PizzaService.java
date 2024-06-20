package giulio_marra.s5_l4_be.service;

import giulio_marra.s5_l4_be.entities.Ingredienti;
import giulio_marra.s5_l4_be.entities.Pizze;
import giulio_marra.s5_l4_be.repositories.IngredientiRepo;
import giulio_marra.s5_l4_be.repositories.PizzaRepo;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepo pizzaRepo;

    @Autowired
    private IngredientiRepo ingredientiRepo;

    public void savePizza(Pizze pizza) {
        if (pizzaRepo.existsByNome(pizza.getNome())) {
            throw new EntityExistsException("La pizza " + pizza.getNome() + " è già nel database");
        }

        List<Ingredienti> ingredientiSpecifici = new ArrayList<>();
        for (Ingredienti ingrediente : pizza.getIngredienti()) {
            Ingredienti ingredientiTrovati = ingredientiRepo.findByNome(ingrediente.getNome());
            if (ingredientiTrovati != null) {
                ingredientiSpecifici.add(ingredientiTrovati);
            } else {
                throw new RuntimeException("Ingrediente non trovato con nome: " + ingrediente.getNome());
            }
        }

        pizzaRepo.save(pizza);
        System.out.println("La pizza " + pizza.getNome() + " è stata salvata nel database");
    }
}
