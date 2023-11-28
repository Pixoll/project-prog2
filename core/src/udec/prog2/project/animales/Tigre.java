package udec.prog2.project.animales;
import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.habitats.TipoHabitat;

public class Tigre extends Animal {
    public Tigre() {
        super(TipoAnimal.TIGRE);
        this.addAnimalesCompatibles(this.getTipo(), TipoAnimal.LEON);
        this.addHabitatsCompatibles(TipoHabitat.JUNGLA, TipoHabitat.TROPICAL);
        this.addComidasCompatibles(TipoComida.CONEJO, TipoComida.RES);
    }
}
