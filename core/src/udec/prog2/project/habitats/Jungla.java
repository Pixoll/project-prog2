package udec.prog2.project.habitats;

import udec.prog2.project.animales.TipoAnimal;

public class Jungla extends Habitat {
    public Jungla() {
        super(TipoHabitat.JUNGLA, 3);
        this.addAnimalesCompatibles(TipoAnimal.TIGRE, TipoAnimal.MONO, TipoAnimal.LEON);
    }
}
