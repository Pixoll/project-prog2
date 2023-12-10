package udec.prog2.project.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import udec.prog2.project.ZooSimulator;
import udec.prog2.project.habitats.TipoHabitat;
import udec.prog2.project.util.Rectangulo;

public class MenuHabitatScreen extends MenuScreen {
    public MenuHabitatScreen(ZooSimulator juego, JuegoScreen juegoScreen) {
        super(juego, juegoScreen, "Comprar Habitat", TipoHabitat.values(), TipoHabitat::getTexturaIcono);
    }

    @Override
    public boolean draw(Vector2 mousePos, boolean ignorarClick) {
        if (!super.draw(mousePos, ignorarClick)) return false;

        final int cantidadHabitats = TipoHabitat.values().length;

        this.juego.batch.begin();
        for (TipoHabitat tipoHabitat : TipoHabitat.values()) {
            this.juego.batch.draw(tipoHabitat.getTexturaIcono());
        }
        for (int i = 0; i < cantidadHabitats; i++) {
            final Rectangulo bordeTituloHabitat = this.bordesTituloTipo[i];
            this.fuenteTituloTipo.draw(this.juego.batch, TipoHabitat.values()[i].getNombre(),
                    bordeTituloHabitat.x, bordeTituloHabitat.y, bordeTituloHabitat.width,
                    Align.center, false);
        }
        this.juego.batch.end();

        final boolean click = Gdx.input.justTouched();
        TipoHabitat tipoHabitatSeleccionado = null;

        this.juego.shape.begin();
        this.juego.shape.setColor(this.colorSeleccionarTipo);
        for (int i = 0; i < cantidadHabitats; i++) {
            final Rectangulo bordeTipoHabitat = this.bordesTipo[i];
            if (!bordeTipoHabitat.contains(mousePos)) continue;

            this.juego.shape.rect(bordeTipoHabitat, this.seleccionarTipoHoverWidth);

            if (!ignorarClick && click) {
                tipoHabitatSeleccionado = TipoHabitat.values()[i];
            }
        }
        this.juego.shape.end();

        if (tipoHabitatSeleccionado != null) {
            this.juegoScreen.crearHabitat(tipoHabitatSeleccionado);
            return false;
        }

        return true;
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
