package udec.prog2.project.comidas;

import udec.prog2.project.animales.TipoAnimal;

public class Calamar extends Comida {
    public Calamar() {
        super(TipoComida.CALAMAR);
        this.addAnimalesCompatibles(TipoAnimal.PINGUINO);
    }
}
