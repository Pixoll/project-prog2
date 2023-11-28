package udec.prog2.project.habitats;

import udec.prog2.project.animales.TipoAnimal;

public class Sabana extends Habitat {
    public Sabana(int maxAnimales) {
        super(TipoHabitat.SABANA, maxAnimales);
        this.addAnimalesCompatibles(TipoAnimal.LEON, TipoAnimal.JIRAFA, TipoAnimal.MONO);
    }
}
