package udec.prog2.project.habitats;

import udec.prog2.project.animales.TipoAnimal;

public class Taiga extends Habitat {
    public Taiga() {
        super(TipoHabitat.TAIGA);
        this.addAnimalesCompatibles(TipoAnimal.OSO_PARDO, TipoAnimal.ZORRO);
    }
}
