package udec.prog2.project.animales;

import udec.prog2.project.habitats.TipoHabitat;

public class Leon extends Animal {
    public Leon() {
        super(TipoAnimal.LEON);
        this.addHabitatsCompatibles(TipoHabitat.SABANA);
    }
}
