package udec.prog2.project.animales;

import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.habitats.Habitat;
import udec.prog2.project.habitats.TipoHabitat;

public class OsoPolar extends Animal{
    public OsoPolar(Habitat habitat) {
        super(TipoAnimal.OSO_POLAR, 4 * 60_000, habitat);
        this.addAnimalesCompatibles(this.getTipo());
        this.addHabitatsCompatibles(TipoHabitat.TUNDRA);
        this.addComidasCompatibles(TipoComida.FRUTAS, TipoComida.FOCA, TipoComida.SALMON, TipoComida.VEGETALES);
    }
}
