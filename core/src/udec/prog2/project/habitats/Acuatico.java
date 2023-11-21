package udec.prog2.project.habitats;

import udec.prog2.project.animales.TipoAnimal;

public class Acuatico extends Habitat {
    public Acuatico() {
        super(TipoHabitat.ACUATICO);
        this.addAnimalesCompatibles(TipoAnimal.ORCA);
    }
}
