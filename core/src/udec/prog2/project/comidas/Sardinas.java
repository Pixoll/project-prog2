package udec.prog2.project.comidas;

import udec.prog2.project.animales.TipoAnimal;

public class Sardinas extends Comida {
    public Sardinas() {
        super(TipoComida.SARDINAS);
        this.addAnimalesCompatibles(TipoAnimal.PINGUINO);
    }
}
