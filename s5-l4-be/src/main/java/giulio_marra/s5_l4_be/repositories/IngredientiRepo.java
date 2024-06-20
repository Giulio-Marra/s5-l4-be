package giulio_marra.s5_l4_be.repositories;

import giulio_marra.s5_l4_be.entities.Ingredienti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientiRepo extends JpaRepository<Ingredienti, Long> {
    Optional<Ingredienti> findByIngrediente(String ingrediente);
}
