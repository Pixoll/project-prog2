package udec.prog2.project.animales;

import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.habitats.TipoHabitat;

public class Jirafa extends Animal {
    public Jirafa() {
        super(TipoAnimal.JIRAFA);
        this.addAnimalesCompatibles(this.getTipo(), TipoAnimal.MONO);
        this.addHabitatsCompatibles(TipoHabitat.SABANA);
        this.addComidasCompatibles(TipoComida.VEGETALES);
    }
}
