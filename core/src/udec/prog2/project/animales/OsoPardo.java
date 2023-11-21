package udec.prog2.project.animales;

import udec.prog2.project.habitats.TipoHabitat;

public class OsoPardo extends Animal {
    public OsoPardo() {
        super(TipoAnimal.OSO_PARDO);
        this.addHabitatsCompatibles(TipoHabitat.TAIGA);
    }
}
