package udec.prog2.project.animales;

import udec.prog2.project.habitats.TipoHabitat;

public class Orca extends Animal {
    public Orca() {
        super(TipoAnimal.ORCA);
        this.addHabitatsCompatibles(TipoHabitat.ACUATICO);
    }
}
