package udec.prog2.project.animales;

import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.habitats.Habitat;
import udec.prog2.project.habitats.TipoHabitat;

import java.util.*;

public abstract class Animal {
    private final TipoAnimal tipo;
    private final HashSet<TipoAnimal> animalesCompatibles;
    private final HashSet<TipoHabitat> habitatsCompatibles;
    private final HashSet<TipoComida> comidasCompatibles;
    private final Habitat habitat;
    private final int intervaloAlimentacion;
    private long ultimaAlimentacion;

    public Animal(TipoAnimal tipo, int intervaloAlimentacion, Habitat habitat) {
        this.tipo = tipo;
        this.animalesCompatibles = new HashSet<>();
        this.habitatsCompatibles = new HashSet<>();
        this.comidasCompatibles = new HashSet<>();
        this.habitat = habitat;
        this.intervaloAlimentacion = intervaloAlimentacion;
        this.ultimaAlimentacion = new Date().getTime();
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

    public int getIntervaloAlimentacion() {
        return this.intervaloAlimentacion;
    }

    public boolean debeComer() {
        return new Date().getTime() - this.ultimaAlimentacion >= this.intervaloAlimentacion;
    }

    public boolean comerComida() {
        if (this.habitat == null) return false;

        final int cantidadComidas = this.comidasCompatibles.size();
        final ArrayList<TipoComida> tipoComidas = new ArrayList<>();
        Collections.addAll(tipoComidas, this.comidasCompatibles.toArray(new TipoComida[cantidadComidas]));
        Collections.shuffle(tipoComidas);

        boolean puedeComer = false;
        for (TipoComida tipoComida : tipoComidas) {
            puedeComer = this.habitat.consumirComida(tipoComida);
            if (puedeComer) break;
        }
        if (!puedeComer) return false;

        this.ultimaAlimentacion = new Date().getTime();
        return true;
    }
}
