package udec.prog2.project.animales;

import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.habitats.Habitat;
import udec.prog2.project.habitats.TipoHabitat;

public class Leon extends Animal {
    public Leon(Habitat habitat) {
        super(TipoAnimal.LEON, 4 * 60_000, habitat);
        this.addAnimalesCompatibles(this.getTipo(), TipoAnimal.TIGRE);
        this.addHabitatsCompatibles(TipoHabitat.SABANA);
        this.addComidasCompatibles(TipoComida.CONEJO, TipoComida.POLLO, TipoComida.RES);
    }
}
