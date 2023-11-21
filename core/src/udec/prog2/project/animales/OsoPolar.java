package udec.prog2.project.animales;

import udec.prog2.project.habitats.TipoHabitat;

public class OsoPolar extends Animal{
    public OsoPolar() {
        super(TipoAnimal.OSO_POLAR);
        this.addHabitatsCompatibles(TipoHabitat.TUNDRA);
    }
}
