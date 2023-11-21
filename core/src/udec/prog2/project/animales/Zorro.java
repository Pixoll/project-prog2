package udec.prog2.project.animales;

import udec.prog2.project.habitats.TipoHabitat;

public class Zorro extends Animal {
    public Zorro() {
        super(TipoAnimal.ZORRO);
        this.addHabitatsCompatibles(TipoHabitat.TAIGA);
    }
}
