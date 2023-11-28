package udec.prog2.project.animales;

import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.habitats.TipoHabitat;

public class Leon extends Animal {
    public Leon() {
        super(TipoAnimal.LEON);
        this.addAnimalesCompatibles(this.getTipo(), TipoAnimal.TIGRE);
        this.addHabitatsCompatibles(TipoHabitat.SABANA);
        this.addComidasCompatibles(TipoComida.CONEJO, TipoComida.POLLO, TipoComida.RES);
    }
}
