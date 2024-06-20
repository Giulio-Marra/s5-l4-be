package giulio_marra.s5_l4_be.service;

import giulio_marra.s5_l4_be.entities.Ingredienti;
import giulio_marra.s5_l4_be.repositories.IngredientiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientiService {

    @Autowired
    private IngredientiRepo ingredientiRepo;

    public void saveIngredienti(List<Ingredienti> ingredienti) {
        ingredientiRepo.saveAll(ingredienti);
        System.out.println("Gli ingredienti sono stati salvati nel database");
    }
}
