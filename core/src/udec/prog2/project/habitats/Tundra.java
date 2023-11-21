package udec.prog2.project.habitats;

import udec.prog2.project.animales.TipoAnimal;

public class Tundra extends Habitat {
    public Tundra() {
        super(TipoHabitat.TUNDRA);
        this.addAnimalesCompatibles(TipoAnimal.OSO_POLAR, TipoAnimal.PINGUINO);
    }
}
