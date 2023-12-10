package udec.prog2.project.screens;

import com.badlogic.gdx.math.Vector2;
import udec.prog2.project.ZooSimulator;
import udec.prog2.project.animales.Animal;
import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.habitats.Habitat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuComidaScreen extends MenuScreen<TipoComida> {
    public MenuComidaScreen(ZooSimulator juego, JuegoScreen juegoScreen) {
        super(juego, juegoScreen, "Comprar Comida",
                TipoComida.values(), TipoComida::getTextura, TipoComida::getNombre);
    }

    @Override
    public boolean draw(Vector2 mousePos, boolean ignorarClick) {
        if (!super.draw(mousePos, ignorarClick)) return false;

        Habitat habitatSeleccionado = this.juegoScreen.getHabitatSeleccionado();
        final List<Animal> animalesEnHabitat = habitatSeleccionado.getAnimales();

        final Set<TipoComida> comidasSeleccionables = new HashSet<>();
        for (Animal animal : animalesEnHabitat) {
            comidasSeleccionables.addAll(animal.getComidasCompatibles());
        }

        TipoComida tipoSeleccionado = this.seleccionarTipo(mousePos, ignorarClick, comidasSeleccionables);
        return tipoSeleccionado == null;
    }
}
