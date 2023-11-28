package udec.prog2.project.comidas;

import udec.prog2.project.animales.TipoAnimal;

public class Conejo extends Comida {
    public Conejo() {
        super(TipoComida.CONEJO);
        this.addAnimalesCompatibles(TipoAnimal.LEON, TipoAnimal.TIGRE, TipoAnimal.ZORRO);
    }
}
