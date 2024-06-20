package giulio_marra.s5_l4_be.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bevande")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Bevande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    private String name;
    private double prezzo;

    public Bevande(double prezzo, String name) {
        this.prezzo = prezzo;
        this.name = name;
    }


}
