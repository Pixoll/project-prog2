package udec.prog2.project.comidas;

import udec.prog2.project.animales.TipoAnimal;

public class Vegetales extends Comida {
    public Vegetales() {
        super(TipoComida.VEGETALES);
        this.addAnimalesCompatibles(TipoAnimal.JIRAFA, TipoAnimal.OSO_POLAR, TipoAnimal.MONO);
    }
}
