package udec.prog2.project.habitats;

import udec.prog2.project.animales.TipoAnimal;

public class Jungla extends Habitat {
    public Jungla() {
        super(TipoHabitat.JUNGLA);
        this.addAnimalesCompatibles(TipoAnimal.TIGRE);
    }
}
