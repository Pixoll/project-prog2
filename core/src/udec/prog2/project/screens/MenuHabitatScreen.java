package udec.prog2.project.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import udec.prog2.project.ZooSimulator;
import udec.prog2.project.habitats.TipoHabitat;
import udec.prog2.project.util.Rectangulo;
import udec.prog2.project.util.Textura;
import udec.prog2.project.util.Util;

public class MenuHabitatScreen extends MenuScreen {
    private final Rectangulo[] bordesTipoHabitat;
    private final Rectangulo[] bordesTituloHabitat;
    private final BitmapFont fuenteTituloHabitat;
    private final Color colorSeleccionarHabitat;
    private final float seleccionarHabitatHoverWidth;

    public MenuHabitatScreen(ZooSimulator juego, JuegoScreen juegoScreen) {
        super(juego, juegoScreen, "Comprar Habitat");

        final TipoHabitat[] tipoHabitats = TipoHabitat.values();

        final int cantidadHabitats = TipoHabitat.values().length;
        final double sqrtCantidadHabitats = Math.sqrt(cantidadHabitats);
        final int filas = (int) (Math.floor(sqrtCantidadHabitats) == sqrtCantidadHabitats
                ? sqrtCantidadHabitats / 2
                : Math.floor(sqrtCantidadHabitats));
        final int columnas = cantidadHabitats / filas;

        final Rectangulo bordeTipoHabitat = this.bordesContenidos.clone();
        bordeTipoHabitat.width /= columnas;
        bordeTipoHabitat.height /= filas;
        bordeTipoHabitat.y += this.bordesContenidos.height - bordeTipoHabitat.height;

        this.bordesTipoHabitat = new Rectangulo[cantidadHabitats];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                final int k = i * columnas + j;
                final Rectangulo kBordeTipoHabitat = bordeTipoHabitat.clone();
                kBordeTipoHabitat.x += j * bordeTipoHabitat.width;
                kBordeTipoHabitat.y -= i * bordeTipoHabitat.height;
                this.bordesTipoHabitat[k] = kBordeTipoHabitat;
            }
        }

        final Rectangulo bordesIconoHabitat = bordeTipoHabitat.clone().toSquare().scaleBy(0.5f);
        bordesIconoHabitat.x = bordeTipoHabitat.x + (bordeTipoHabitat.width - bordesIconoHabitat.width) / 2;
        bordesIconoHabitat.y = bordeTipoHabitat.y + bordeTipoHabitat.height * 0.85f - bordesIconoHabitat.height;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                final int k = i * columnas + j;
                final Textura texturaHabitat = tipoHabitats[k].getTexturaIcono();
                texturaHabitat.bordes.set(bordesIconoHabitat);

                texturaHabitat.bordes.x += j * bordeTipoHabitat.width;
                texturaHabitat.bordes.y -= i * bordeTipoHabitat.height;
            }
        }

        FreeTypeFontGenerator.FreeTypeFontParameter configFuente = new FreeTypeFontGenerator.FreeTypeFontParameter();
        configFuente.size = 20;
        configFuente.borderColor = Util.color("#000000", 0.5f);
        configFuente.borderWidth = 1;
        this.fuenteTituloHabitat = this.juego.generadorFuente.generateFont(configFuente);

        final Rectangulo templateBordeTituloHabitat = bordeTipoHabitat.clone();
        templateBordeTituloHabitat.width *= 0.9f;
        templateBordeTituloHabitat.x += bordeTipoHabitat.width * 0.05f;
        templateBordeTituloHabitat.y -= (bordesIconoHabitat.height - bordeTipoHabitat.height) / 2;

        this.bordesTituloHabitat = new Rectangulo[cantidadHabitats];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                final int k = i * columnas + j;
                final Rectangulo bordeTituloHabitat = templateBordeTituloHabitat.clone();
                bordeTituloHabitat.x += j * bordeTipoHabitat.width;
                bordeTituloHabitat.y -= i * bordeTipoHabitat.height;
                this.bordesTituloHabitat[k] = bordeTituloHabitat;
            }
        }

        this.colorSeleccionarHabitat = Util.color("#689a24");
        this.seleccionarHabitatHoverWidth = bordeTipoHabitat.width * 0.025f;
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
            final Rectangulo bordeTituloHabitat = this.bordesTituloHabitat[i];
            this.fuenteTituloHabitat.draw(this.juego.batch, TipoHabitat.values()[i].getNombre(),
                    bordeTituloHabitat.x, bordeTituloHabitat.y, bordeTituloHabitat.width,
                    Align.center, false);
        }
        this.juego.batch.end();

        final boolean click = Gdx.input.justTouched();
        TipoHabitat tipoHabitatSeleccionado = null;

        this.juego.shape.begin();
        this.juego.shape.setColor(this.colorSeleccionarHabitat);
        for (int i = 0; i < cantidadHabitats; i++) {
            final Rectangulo bordeTipoHabitat = this.bordesTipoHabitat[i];
            if (!bordeTipoHabitat.contains(mousePos)) continue;

            this.juego.shape.rect(bordeTipoHabitat, this.seleccionarHabitatHoverWidth);

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
        this.fuenteTituloHabitat.dispose();
    }
}
