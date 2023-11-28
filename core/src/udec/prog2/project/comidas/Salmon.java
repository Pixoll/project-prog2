package udec.prog2.project.comidas;

import udec.prog2.project.animales.TipoAnimal;

public class Salmon extends Comida {
    public Salmon() {
        super(TipoComida.SALMON);
        this.addAnimalesCompatibles(TipoAnimal.OSO_PARDO, TipoAnimal.OSO_PARDO, TipoAnimal.ORCA);
    }
}
