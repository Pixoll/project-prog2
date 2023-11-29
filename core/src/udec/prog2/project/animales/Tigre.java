package udec.prog2.project.animales;
import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.habitats.Habitat;
import udec.prog2.project.habitats.TipoHabitat;

public class Tigre extends Animal {
    public Tigre(Habitat habitat) {
        super(TipoAnimal.TIGRE, 4 * 60_000, habitat);
        this.addAnimalesCompatibles(this.getTipo(), TipoAnimal.LEON);
        this.addHabitatsCompatibles(TipoHabitat.JUNGLA, TipoHabitat.TROPICAL);
        this.addComidasCompatibles(TipoComida.CONEJO, TipoComida.RES);
    }
}
