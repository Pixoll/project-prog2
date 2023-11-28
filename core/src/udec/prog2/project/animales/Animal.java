package udec.prog2.project.animales;

import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.habitats.Habitat;
import udec.prog2.project.habitats.TipoHabitat;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class Animal {
    private final TipoAnimal tipo;
    private final HashSet<TipoAnimal> animalesCompatibles;
    private final HashSet<TipoHabitat> habitatsCompatibles;
    private final HashSet<TipoComida> comidasCompatibles;
    private Habitat habitat;

    public Animal(TipoAnimal tipo) {
        this.tipo = tipo;
        this.animalesCompatibles = new HashSet<>();
        this.habitatsCompatibles = new HashSet<>();
        this.comidasCompatibles = new HashSet<>();
        this.habitat = null;
    }

    public TipoAnimal getTipo() {
        return this.tipo;
    }

    protected void addAnimalesCompatibles(TipoAnimal... animales) {
        this.animalesCompatibles.addAll(Arrays.asList(animales));
    }

    public Set<TipoAnimal> getAnimalesCompatibles() {
        return Collections.unmodifiableSet(this.animalesCompatibles);
    }

    protected void addHabitatsCompatibles(TipoHabitat... habitats) {
        this.habitatsCompatibles.addAll(Arrays.asList(habitats));
    }

    public Set<TipoHabitat> getHabitatsCompatibles() {
        return Collections.unmodifiableSet(this.habitatsCompatibles);
    }

    protected void addComidasCompatibles(TipoComida... comidas) {
        this.comidasCompatibles.addAll(Arrays.asList(comidas));
    }

    public Set<TipoComida> getComidasCompatibles() {
        return Collections.unmodifiableSet(this.comidasCompatibles);
    }

    public Habitat getHabitat() {
        return this.habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public boolean comerComida(TipoComida tipoComida) {
        if (this.habitat == null) return false;
        return this.habitat.consumirComida(tipoComida);
    }
}
