package udec.prog2.project.animales;

import udec.prog2.project.habitats.TipoHabitat;

public class Jirafa extends Animal {
    public Jirafa() {
        super(TipoAnimal.JIRAFA);
        this.addHabitatsCompatibles(TipoHabitat.SABANA);
    }
}
