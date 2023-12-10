package udec.prog2.project.habitats;

import udec.prog2.project.animales.TipoAnimal;

public class Tropical extends Habitat {
    public Tropical() {
        super(TipoHabitat.TROPICAL, 2);
        this.addAnimalesCompatibles(TipoAnimal.TIGRE, TipoAnimal.MONO);
    }
}
