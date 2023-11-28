package udec.prog2.project.habitats;

import udec.prog2.project.animales.TipoAnimal;

public class Acuatico extends Habitat {
    public Acuatico(int maxAnimales) {
        super(TipoHabitat.ACUATICO, maxAnimales);
        this.addAnimalesCompatibles(TipoAnimal.ORCA);
    }
}
