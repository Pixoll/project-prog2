package udec.prog2.project.animales;
import udec.prog2.project.habitats.TipoHabitat;

public class Tigre extends Animal {
    public Tigre() {
        super(TipoAnimal.TIGRE);
        this.addHabitatsCompatibles(TipoHabitat.JUNGLA);
    }
}
