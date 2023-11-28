package udec.prog2.project.comidas;

import udec.prog2.project.animales.TipoAnimal;

public class Res extends Comida {
    public Res() {
        super(TipoComida.RES);
        this.addAnimalesCompatibles(TipoAnimal.LEON, TipoAnimal.TIGRE);
    }
}
