package udec.prog2.project.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import udec.prog2.project.ZooSimulator;
import udec.prog2.project.animales.TipoAnimal;
import udec.prog2.project.util.Rectangulo;

public class MenuAnimalesScreen extends MenuScreen {
    public MenuAnimalesScreen(ZooSimulator juego, JuegoScreen juegoScreen) {
        super(juego, juegoScreen, "Comprar Animal", TipoAnimal.values(), TipoAnimal::getTexturaIcono);
    }

    @Override
    public boolean draw(Vector2 mousePos, boolean ignorarClick) {
        if (!super.draw(mousePos, ignorarClick)) return false;

        final int cantidadAnimales = TipoAnimal.values().length;

        this.juego.batch.begin();
        for (TipoAnimal tipoAnimal : TipoAnimal.values()) {
            this.juego.batch.draw(tipoAnimal.getTexturaIcono());
        }
        for (int i = 0; i < cantidadAnimales; i++) {
            final Rectangulo bordeTituloAnimal = this.bordesTituloTipo[i];
            this.fuenteTituloTipo.draw(this.juego.batch, TipoAnimal.values()[i].getNombre(),
                    bordeTituloAnimal.x, bordeTituloAnimal.y, bordeTituloAnimal.width,
                    Align.center, false);
        }
        this.juego.batch.end();

        final boolean click = Gdx.input.justTouched();
        TipoAnimal tipoAnimalSeleccionado = null;

        this.juego.shape.begin();
        this.juego.shape.setColor(this.colorSeleccionarTipo);
        for (int i = 0; i < cantidadAnimales; i++) {
            final Rectangulo bordeTipoHabitat = this.bordesTipo[i];
            if (!bordeTipoHabitat.contains(mousePos)) continue;

            this.juego.shape.rect(bordeTipoHabitat, this.seleccionarTipoHoverWidth);

            if (!ignorarClick && click) {
                tipoAnimalSeleccionado = TipoAnimal.values()[i];
            }
        }
        this.juego.shape.end();

        return tipoAnimalSeleccionado == null;
    }

    @Override
    public void dispose() {
        super.dispose();;
    }
}
