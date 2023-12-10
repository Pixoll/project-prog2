package udec.prog2.project.screens;

import com.badlogic.gdx.math.Vector2;
import udec.prog2.project.ZooSimulator;
import udec.prog2.project.animales.Animal;
import udec.prog2.project.animales.TipoAnimal;
import udec.prog2.project.habitats.Habitat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuAnimalesScreen extends MenuScreen<TipoAnimal> {
    public MenuAnimalesScreen(ZooSimulator juego, JuegoScreen juegoScreen) {
        super(juego, juegoScreen, "Comprar Animal",
                TipoAnimal.values(), TipoAnimal::getTexturaIcono, TipoAnimal::getNombre);
    }

    @Override
    public boolean draw(Vector2 mousePos, boolean ignorarClick) {
        if (!super.draw(mousePos, ignorarClick)) return false;

        Habitat habitatSeleccionado = this.juegoScreen.getHabitatSeleccionado();
        final Set<TipoAnimal> animalesSeleccionables = new HashSet<>();

        if (!habitatSeleccionado.isFull()) {
            final Set<TipoAnimal> animalesCompatibles = habitatSeleccionado.getAnimalesCompatibles();
            final List<Animal> animalesEnHabitat = habitatSeleccionado.getAnimales();

            final HashSet<TipoAnimal> animalesIncompatibles = new HashSet<>();
            for (Animal animal1 : animalesEnHabitat) {
                for (TipoAnimal tipoAnimal2 : animalesCompatibles) {
                    if (tipoAnimal2 == animal1.getTipo()) continue;
                    if (animal1.getAnimalesCompatibles().contains(tipoAnimal2)) continue;
                    animalesIncompatibles.add(tipoAnimal2);
                }
            }

            for (TipoAnimal animal : animalesCompatibles) {
                if (animalesIncompatibles.contains(animal)) continue;
                animalesSeleccionables.add(animal);
            }
        }

        TipoAnimal tipoSeleccionado = this.seleccionarTipo(mousePos, ignorarClick, animalesSeleccionables);
        if (tipoSeleccionado != null) {
            this.juegoScreen.addAnimalToHabitat(tipoSeleccionado);
            return false;
        }

        return true;
    }
}
