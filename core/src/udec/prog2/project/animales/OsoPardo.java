package udec.prog2.project.animales;

import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.habitats.Habitat;
import udec.prog2.project.habitats.TipoHabitat;

public class OsoPardo extends Animal {
    public OsoPardo(Habitat habitat) {
        super(TipoAnimal.OSO_PARDO, 4 * 60_000, habitat);
        this.addAnimalesCompatibles(this.getTipo());
        this.addHabitatsCompatibles(TipoHabitat.TAIGA);
        this.addComidasCompatibles(TipoComida.BERRIES, TipoComida.FRUTAS, TipoComida.SALMON);
    }
}
