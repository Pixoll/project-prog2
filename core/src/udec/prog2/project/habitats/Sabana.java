package udec.prog2.project.habitats;

import udec.prog2.project.animales.TipoAnimal;

public class Sabana extends Habitat {
    public Sabana() {
        super(TipoHabitat.SABANA, 3);
        this.addAnimalesCompatibles(TipoAnimal.LEON, TipoAnimal.JIRAFA, TipoAnimal.MONO);
    }
}
