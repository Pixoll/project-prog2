package udec.prog2.project.screens;

import com.badlogic.gdx.math.Vector2;
import udec.prog2.project.ZooSimulator;
import udec.prog2.project.habitats.TipoHabitat;

public class MenuHabitatScreen extends MenuScreen<TipoHabitat> {
    public MenuHabitatScreen(ZooSimulator juego, JuegoScreen juegoScreen) {
        super(juego, juegoScreen, "Comprar Habitat",
                TipoHabitat.values(), TipoHabitat::getTexturaIcono, TipoHabitat::getNombre);
    }

    @Override
    public boolean draw(Vector2 mousePos, boolean ignorarClick) {
        if (!super.draw(mousePos, ignorarClick)) return false;

        TipoHabitat tipoSeleccionado = this.seleccionarTipo(mousePos, ignorarClick);
        if (tipoSeleccionado != null) {
            this.juegoScreen.crearHabitat(tipoSeleccionado);
            return false;
        }

        return true;
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
