package udec.prog2.project.habitats;

import udec.prog2.project.animales.Animal;
import udec.prog2.project.animales.TipoAnimal;
import udec.prog2.project.comidas.Comida;
import udec.prog2.project.comidas.TipoComida;

import java.util.*;

public abstract class Habitat {
    private final TipoHabitat tipo;
    private final HashSet<TipoAnimal> animalesCompatibles;
    private final ArrayList<Comida> depositoComida;
    private final int maxAnimales;
    private final ArrayList<Animal> animales;

    public Habitat(TipoHabitat tipo, int maxAnimales) {
        this.tipo = tipo;
        this.animalesCompatibles = new HashSet<>();
        this.depositoComida = new ArrayList<>();
        this.maxAnimales = maxAnimales;
        this.animales = new ArrayList<>();
    }

    public TipoHabitat getTipo() {
        return this.tipo;
    }

    protected void addAnimalesCompatibles(TipoAnimal... animales) {
        this.animalesCompatibles.addAll(Arrays.asList(animales));
    }

    public Set<TipoAnimal> getAnimalesCompatibles() {
        return Collections.unmodifiableSet(this.animalesCompatibles);
    }

    public boolean depositarComida(TipoComida tipoComida) {
        if (this.animales.isEmpty()) return false;

        boolean esCompatible = false;
        for (Animal animal : this.animales)
            if (animal.getComidasCompatibles().contains(tipoComida)) {
                esCompatible = true;
                break;
            }
        if (!esCompatible) return false;

        final Comida comida = tipoComida.crearComida();
        if (comida == null) {
            // TODO throw
            return false;
        }

        this.depositoComida.add(comida);
        return true;
    }

    public boolean consumirComida(TipoComida tipoComida) {
        if (this.depositoComida.isEmpty()) return false;
        boolean consumioComida = false;
        for (Comida comida : this.depositoComida)
            if (comida.getTipo() == tipoComida) {
                this.depositoComida.remove(comida);
                consumioComida = true;
                break;
            }
        return consumioComida;
    }

    public boolean addAnimal(TipoAnimal tipoAnimal) {
        if (!this.animalesCompatibles.contains(tipoAnimal)
                || this.animales.size() == this.maxAnimales) return false;

        final Animal animal = tipoAnimal.crearAnimal();
        if (animal == null) {
            // TODO throw
            return false;
        }

        this.animales.add(animal);
        animal.setHabitat(this);
        return true;
    }

    public boolean removerAnimal(Animal animal) {
        if (this.animales.isEmpty()) return false;
        this.animales.remove(animal);
        return true;
    }
}
