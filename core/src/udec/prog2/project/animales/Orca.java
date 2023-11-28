package udec.prog2.project.animales;

import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.habitats.TipoHabitat;

public class Orca extends Animal {
    public Orca() {
        super(TipoAnimal.ORCA);
        this.addAnimalesCompatibles(this.getTipo());
        this.addHabitatsCompatibles(TipoHabitat.ACUATICO);
        this.addComidasCompatibles(TipoComida.FOCA, TipoComida.SALMON);
    }
}
