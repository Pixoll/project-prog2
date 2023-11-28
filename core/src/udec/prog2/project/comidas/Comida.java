package udec.prog2.project.comidas;

import udec.prog2.project.animales.TipoAnimal;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class Comida {
    private final TipoComida tipo;
    private final HashSet<TipoAnimal> animalesCompatibles;

    public Comida(TipoComida tipo) {
        this.tipo = tipo;
        this.animalesCompatibles = new HashSet<>();
    }

    public TipoComida getTipo() {
        return this.tipo;
    }

    protected void addAnimalesCompatibles(TipoAnimal... animales) {
        this.animalesCompatibles.addAll(Arrays.asList(animales));
    }

    public Set<TipoAnimal> getAnimalesCompatibles() {
        return Collections.unmodifiableSet(this.animalesCompatibles);
    }
}
