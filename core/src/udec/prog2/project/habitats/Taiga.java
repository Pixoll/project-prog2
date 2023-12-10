package udec.prog2.project.habitats;

import udec.prog2.project.animales.TipoAnimal;

public class Taiga extends Habitat {
    public Taiga() {
        super(TipoHabitat.TAIGA, 3);
        this.addAnimalesCompatibles(TipoAnimal.OSO_PARDO, TipoAnimal.ZORRO);
    }
}
