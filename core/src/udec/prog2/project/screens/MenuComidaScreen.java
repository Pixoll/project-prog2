package udec.prog2.project.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import udec.prog2.project.ZooSimulator;
import udec.prog2.project.comidas.TipoComida;
import udec.prog2.project.util.Rectangulo;

public class MenuComidaScreen extends MenuScreen {
    public MenuComidaScreen(ZooSimulator juego, JuegoScreen juegoScreen) {
        super(juego, juegoScreen, "Comprar Comida", TipoComida.values(), TipoComida::getTextura);
    }

    @Override
    public boolean draw(Vector2 mousePos, boolean ignorarClick) {
        if (!super.draw(mousePos, ignorarClick)) return false;

        final int cantidadComidas = TipoComida.values().length;

        this.juego.batch.begin();
        for (TipoComida tipoComida : TipoComida.values()) {
            this.juego.batch.draw(tipoComida.getTextura());
        }
        for (int i = 0; i < cantidadComidas; i++) {
            final Rectangulo bordeTituloComida = this.bordesTituloTipo[i];
            this.fuenteTituloTipo.draw(this.juego.batch, TipoComida.values()[i].getNombre(),
                    bordeTituloComida.x, bordeTituloComida.y, bordeTituloComida.width,
                    Align.center, false);
        }
        this.juego.batch.end();

        final boolean click = Gdx.input.justTouched();
        TipoComida tipoComidaSeleccionado = null;

        this.juego.shape.begin();
        this.juego.shape.setColor(this.colorSeleccionarTipo);
        for (int i = 0; i < cantidadComidas; i++) {
            final Rectangulo bordeTipoComida = this.bordesTipo[i];
            if (!bordeTipoComida.contains(mousePos)) continue;

            this.juego.shape.rect(bordeTipoComida, this.seleccionarTipoHoverWidth);

            if (!ignorarClick && click) {
                tipoComidaSeleccionado = TipoComida.values()[i];
            }
        }
        this.juego.shape.end();

        return tipoComidaSeleccionado == null;
    }
}
