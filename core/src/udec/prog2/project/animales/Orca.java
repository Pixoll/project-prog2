package udec.prog2.project.animales;

import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.habitats.Habitat;
import udec.prog2.project.habitats.TipoHabitat;

public class Orca extends Animal {
    public Orca(Habitat habitat) {
        super(TipoAnimal.ORCA, 3 * 60_000, habitat);
        this.addAnimalesCompatibles(this.getTipo());
        this.addHabitatsCompatibles(TipoHabitat.ACUATICO);
        this.addComidasCompatibles(TipoComida.FOCA, TipoComida.SALMON);
    }
}
