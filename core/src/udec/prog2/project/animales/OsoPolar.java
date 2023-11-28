package udec.prog2.project.animales;

import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.habitats.TipoHabitat;

public class OsoPolar extends Animal{
    public OsoPolar() {
        super(TipoAnimal.OSO_POLAR);
        this.addAnimalesCompatibles(this.getTipo());
        this.addHabitatsCompatibles(TipoHabitat.TUNDRA);
        this.addComidasCompatibles(TipoComida.FRUTAS, TipoComida.FOCA, TipoComida.SALMON, TipoComida.VEGETALES);
    }
}
