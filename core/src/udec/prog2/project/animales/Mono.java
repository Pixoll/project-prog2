package udec.prog2.project.animales;

import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.habitats.Habitat;
import udec.prog2.project.habitats.TipoHabitat;

public class Mono extends Animal {
    public Mono(Habitat habitat) {
        super(TipoAnimal.MONO, 3 * 60_000, habitat);
        this.addAnimalesCompatibles(this.getTipo(), TipoAnimal.JIRAFA);
        this.addHabitatsCompatibles(TipoHabitat.JUNGLA, TipoHabitat.SABANA, TipoHabitat.TROPICAL);
        this.addComidasCompatibles(TipoComida.VEGETALES, TipoComida.FRUTAS);
    }
}
