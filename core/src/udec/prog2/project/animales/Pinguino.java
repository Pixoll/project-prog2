package udec.prog2.project.animales;

import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.habitats.Habitat;
import udec.prog2.project.habitats.TipoHabitat;

public class Pinguino extends Animal{
    public Pinguino(Habitat habitat) {
        super(TipoAnimal.PINGUINO, 2 * 60_000, habitat);
        this.addAnimalesCompatibles(this.getTipo());
        this.addHabitatsCompatibles(TipoHabitat.TUNDRA);
        this.addComidasCompatibles(TipoComida.CALAMAR, TipoComida.KRILL, TipoComida.SARDINAS);
    }
}
