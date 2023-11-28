package udec.prog2.project.comidas;

import udec.prog2.project.animales.TipoAnimal;

public class Frutas extends Comida {
    public Frutas() {
        super(TipoComida.FRUTAS);
        this.addAnimalesCompatibles(TipoAnimal.OSO_POLAR, TipoAnimal.OSO_PARDO, TipoAnimal.MONO);
    }
}
