package giulio_marra.s5_l4_be.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ingredienti")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Ingredienti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    private String ingrediente;

    public Ingredienti(String ingrediente) {
        this.ingrediente = ingrediente;
    }

}
