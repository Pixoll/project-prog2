package udec.prog2.project.habitats;

import udec.prog2.project.animales.TipoAnimal;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class Habitat {
    private final TipoHabitat tipo;
    private final HashSet<TipoAnimal> animalesCompatibles;

    public Habitat(TipoHabitat tipo) {
        this.tipo = tipo;
        this.animalesCompatibles = new HashSet<>();
    }

    public TipoHabitat getTipo() {
        return this.tipo;
    }

    protected void addAnimalesCompatibles(TipoAnimal ...animales) {
        this.animalesCompatibles.addAll(Arrays.asList(animales));
    }

    public Set<TipoAnimal> getAnimalesCompatibles() {
        return Collections.unmodifiableSet(this.animalesCompatibles);
    }
}
