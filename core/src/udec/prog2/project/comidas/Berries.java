package udec.prog2.project.comidas;

import udec.prog2.project.animales.TipoAnimal;

public class Berries extends Comida {
    public Berries() {
        super(TipoComida.BERRIES);
        this.addAnimalesCompatibles(TipoAnimal.ZORRO, TipoAnimal.OSO_PARDO);
    }
}
