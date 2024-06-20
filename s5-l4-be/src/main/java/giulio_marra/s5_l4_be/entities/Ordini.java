package giulio_marra.s5_l4_be.entities;

import java.time.LocalDate;
import java.util.List;


public class Ordini {

    private int numeroOrdine;
    private int numeroCoperti;
    private Tavoli tavolo;
    private LocalDate dataAcquisizione;
    private List<Pizze> pizzeOrdinate;
    private List<Bevande> bevandeOrdinate;
    private List<Ingredienti> ingredientiOrdinati;


    public Ordini(int numeroOrdine, int numeroCoperti, Tavoli tavolo, LocalDate dataAcquisizione, List<Pizze> pizzeOrdinate, List<Bevande> bevandeOrdinate) {
        this.numeroOrdine = numeroOrdine;
        this.numeroCoperti = numeroCoperti;
        this.tavolo = tavolo;
        this.dataAcquisizione = dataAcquisizione;
        this.pizzeOrdinate = pizzeOrdinate;
        this.bevandeOrdinate = bevandeOrdinate;
    }

    public void stampaOrdine(double costoCoperto) {
        System.out.println("Ordine del tavolo :" + tavolo);
        System.out.println("Pizze ordinate:");
        for (Pizze pizza : pizzeOrdinate) {
            System.out.println(pizza.getNome() + " " + pizza.getPrezzoBase() + " £");
        }
        System.out.println("Bevande ordinate:");
        for (Bevande bevanda : bevandeOrdinate) {
            System.out.println(bevanda.getName() + " " + bevanda.getPrezzo() + " £");
        }

        double totaleCosto = 0.0;
        for (Pizze pizze : pizzeOrdinate) {
            totaleCosto += pizze.getPrezzoBase();
        }
        for (Bevande bevande : bevandeOrdinate) {
            totaleCosto += bevande.getPrezzo();
        }

        System.out.println("Costo coperto a persona: " + costoCoperto);

        double totaleCostoCoperto = costoCoperto * numeroCoperti;
        totaleCosto += totaleCostoCoperto;

        System.out.println("Costo totale (incluso coperto): " + totaleCosto + " £");
    }
}
