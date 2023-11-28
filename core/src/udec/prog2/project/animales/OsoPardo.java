package udec.prog2.project.animales;

import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.habitats.TipoHabitat;

public class OsoPardo extends Animal {
    public OsoPardo() {
        super(TipoAnimal.OSO_PARDO);
        this.addAnimalesCompatibles(this.getTipo());
        this.addHabitatsCompatibles(TipoHabitat.TAIGA);
        this.addComidasCompatibles(TipoComida.BERRIES, TipoComida.FRUTAS, TipoComida.SALMON);
    }
}
