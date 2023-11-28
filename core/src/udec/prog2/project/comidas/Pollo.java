package udec.prog2.project.comidas;

import udec.prog2.project.animales.TipoAnimal;

public class Pollo extends Comida {
    public Pollo() {
        super(TipoComida.POLLO);
        this.addAnimalesCompatibles(TipoAnimal.LEON, TipoAnimal.ZORRO);
    }
}
