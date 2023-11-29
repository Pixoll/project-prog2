package udec.prog2.project.animales;

import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.habitats.Habitat;
import udec.prog2.project.habitats.TipoHabitat;

public class Jirafa extends Animal {
    public Jirafa(Habitat habitat) {
        super(TipoAnimal.JIRAFA, 3 * 60_000, habitat);
        this.addAnimalesCompatibles(this.getTipo(), TipoAnimal.MONO);
        this.addHabitatsCompatibles(TipoHabitat.SABANA);
        this.addComidasCompatibles(TipoComida.VEGETALES);
    }
}
