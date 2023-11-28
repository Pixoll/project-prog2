package udec.prog2.project.animales;

import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.habitats.TipoHabitat;

public class Pinguino extends Animal{
    public Pinguino() {
        super(TipoAnimal.PINGUINO);
        this.addAnimalesCompatibles(this.getTipo());
        this.addHabitatsCompatibles(TipoHabitat.TUNDRA);
        this.addComidasCompatibles(TipoComida.CALAMAR, TipoComida.KRILL, TipoComida.SARDINAS);
    }
}
