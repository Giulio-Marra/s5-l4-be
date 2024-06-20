package giulio_marra.s5_l4_be.repositories;

import giulio_marra.s5_l4_be.entities.Pizze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepo extends JpaRepository<Pizze, Long> {
    boolean existsByNome(String nome);
}

