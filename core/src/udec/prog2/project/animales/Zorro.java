package udec.prog2.project.animales;

import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.habitats.Habitat;
import udec.prog2.project.habitats.TipoHabitat;

public class Zorro extends Animal {
    public Zorro(Habitat habitat) {
        super(TipoAnimal.ZORRO, 2 * 60_000, habitat);
        this.addAnimalesCompatibles(this.getTipo());
        this.addHabitatsCompatibles(TipoHabitat.TAIGA);
        this.addComidasCompatibles(TipoComida.BERRIES, TipoComida.CONEJO, TipoComida.POLLO);
    }
}
