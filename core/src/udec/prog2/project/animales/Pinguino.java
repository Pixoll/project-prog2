package udec.prog2.project.animales;

import udec.prog2.project.habitats.TipoHabitat;

public class Pinguino extends Animal{
    public Pinguino() {
        super(TipoAnimal.PINGUINO);
        this.addHabitatsCompatibles(TipoHabitat.TUNDRA);
    }
}
