package udec.prog2.project.comidas;

import udec.prog2.project.animales.TipoAnimal;

public class Krill extends Comida {
    public Krill() {
        super(TipoComida.KRILL);
        this.addAnimalesCompatibles(TipoAnimal.PINGUINO);
    }
}
