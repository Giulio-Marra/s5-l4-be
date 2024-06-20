package giulio_marra.s5_l4_be.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "pizze")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Pizze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    private String nome;
    private double prezzoBase;
    @ManyToMany
    @JoinTable(
            name = "pizza_ingredienti",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )
    private List<Ingredienti> ingredienti;

    public Pizze(String nome, double prezzoBase, List<Ingredienti> ingredienti) {
        this.nome = nome;
        this.prezzoBase = prezzoBase;
        this.ingredienti = ingredienti;
    }

}
