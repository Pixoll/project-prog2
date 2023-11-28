package udec.prog2.project.comidas;

import udec.prog2.project.animales.TipoAnimal;

public class Foca extends Comida {
    public Foca() {
        super(TipoComida.FOCA);
        this.addAnimalesCompatibles(TipoAnimal.OSO_POLAR, TipoAnimal.ORCA);
    }
}
