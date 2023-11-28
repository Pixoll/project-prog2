package udec.prog2.project.habitats;

import udec.prog2.project.animales.TipoAnimal;

public class Tundra extends Habitat {
    public Tundra(int maxAnimales) {
        super(TipoHabitat.TUNDRA, maxAnimales);
        this.addAnimalesCompatibles(TipoAnimal.OSO_POLAR, TipoAnimal.PINGUINO);
    }
}
