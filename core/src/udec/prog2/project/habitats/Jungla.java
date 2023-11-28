package udec.prog2.project.habitats;

import udec.prog2.project.animales.TipoAnimal;

public class Jungla extends Habitat {
    public Jungla(int maxAnimales) {
        super(TipoHabitat.JUNGLA, maxAnimales);
        this.addAnimalesCompatibles(TipoAnimal.TIGRE, TipoAnimal.MONO);
    }
}
