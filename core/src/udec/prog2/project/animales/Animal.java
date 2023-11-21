package udec.prog2.project.animales;

import udec.prog2.project.habitats.TipoHabitat;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class Animal {
    private final TipoAnimal tipo;
    private final HashSet<TipoHabitat> habitatsCompatibles;

    public Animal(TipoAnimal tipo) {
        this.tipo = tipo;
        this.habitatsCompatibles = new HashSet<>();
    }

    public TipoAnimal getTipo() {
        return this.tipo;
    }

    protected void addHabitatsCompatibles(TipoHabitat ...habitats) {
        this.habitatsCompatibles.addAll(Arrays.asList(habitats));
    }

    public Set<TipoHabitat> getHabitatsCompatibles() {
        return Collections.unmodifiableSet(this.habitatsCompatibles);
    }
}
