package udec.prog2.project.habitats;

import udec.prog2.project.animales.TipoAnimal;

public class Acuatico extends Habitat {
    public Acuatico() {
        super(TipoHabitat.ACUATICO, 2);
        this.addAnimalesCompatibles(TipoAnimal.ORCA);
    }
}
