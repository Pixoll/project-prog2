package udec.prog2.project.habitats;

import udec.prog2.project.animales.TipoAnimal;

public class Tropical extends Habitat {
    public Tropical(int maxAnimales) {
        super(TipoHabitat.TROPICAL, maxAnimales);
        this.addAnimalesCompatibles(TipoAnimal.TIGRE, TipoAnimal.MONO);
    }
}
