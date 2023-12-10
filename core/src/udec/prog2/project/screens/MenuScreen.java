package udec.prog2.project.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import udec.prog2.project.ZooSimulator;
import udec.prog2.project.util.GrayscaleShader;
import udec.prog2.project.util.Rectangulo;
import udec.prog2.project.util.Textura;
import udec.prog2.project.util.Util;

import java.util.Set;
import java.util.function.Function;

public class MenuScreen<T> {
    protected final ZooSimulator juego;
    protected final JuegoScreen juegoScreen;
    protected final Rectangulo bordesContenidos;
    protected final T[] tipos;
    private final Rectangulo bordesMenu;
    private final Texture texturaMenu;
    private final Color colorFondo;
    private final Rectangulo bordesCerrarMenu;
    private final String tituloMenu;
    private final BitmapFont fuenteTituloMenu;
    private final Rectangle bordesTituloMenu;
    private final Color colorFondoContenidos;
    private final Function<T, Textura> tipoTexturaGetter;
    private final Function<T, String> tipoNombreGetter;
    private final Rectangulo[] bordesTipo;
    private final BitmapFont fuenteTituloTipo;
    private final Rectangulo[] bordesTituloTipo;
    private final Color colorTipoSeleccionable;
    private final Color colorTipoNoSeleccionable;
    private final float seleccionarTipoHoverWidth;

    public MenuScreen(ZooSimulator juego, JuegoScreen juegoScreen, String tituloMenu,
                      T[] tipos, Function<T, Textura> tipoTexturaGetter, Function<T, String> tipoNombreGetter) {
        this.juego = juego;
        this.juegoScreen = juegoScreen;
        this.tituloMenu = tituloMenu;
        this.tipos = tipos;
        this.tipoTexturaGetter = tipoTexturaGetter;
        this.tipoNombreGetter = tipoNombreGetter;

        this.texturaMenu = new Texture(Gdx.files.internal("ui/menu.png"));

        final float escalaMenu = 0.75f;
        this.bordesMenu = new Rectangulo(this.texturaMenu.getWidth(), this.texturaMenu.getHeight()).scaleBy(escalaMenu);
        this.bordesMenu.x = (ZooSimulator.WIDTH - this.bordesMenu.width) / 2;
        this.bordesMenu.y = (ZooSimulator.HEIGHT - this.bordesMenu.height) / 2;

        this.colorFondoContenidos = Util.color("#000000", 0.1f);
        this.bordesContenidos = new Rectangulo(64, 64, 1152, 525).scaleBy(escalaMenu);
        this.bordesContenidos.x += this.bordesMenu.x;
        this.bordesContenidos.y += this.bordesMenu.y;

        this.bordesCerrarMenu = new Rectangulo(1182, 622, 66, 66).scaleBy(escalaMenu);
        this.bordesCerrarMenu.x += this.bordesMenu.x;
        this.bordesCerrarMenu.y += this.bordesMenu.y;

        this.colorFondo = Util.color("#000000", 0.5f);

        FreeTypeFontParameter configFuente = new FreeTypeFontParameter();
        configFuente.size = 30;
        configFuente.borderColor = this.colorFondo;
        configFuente.borderWidth = 2;
        this.fuenteTituloMenu = this.juego.generadorFuente.generateFont(configFuente);

        this.bordesTituloMenu = new Rectangle();
        this.bordesTituloMenu.width = ZooSimulator.WIDTH / 2f;
        this.bordesTituloMenu.x = ZooSimulator.WIDTH / 4f;
        this.bordesTituloMenu.y = this.bordesMenu.y + this.bordesMenu.height * 0.925f;

        final int cantidadTipos = tipos.length;
        final double sqrtCantidadTipos = Math.sqrt(cantidadTipos);
        final int filas = (int) (Math.floor(sqrtCantidadTipos) == sqrtCantidadTipos
                ? Math.ceil(sqrtCantidadTipos / 2)
                : Math.floor(sqrtCantidadTipos));
        int columnas = cantidadTipos / filas;
        if (filas * columnas < cantidadTipos) columnas++;

        final Rectangulo bordeTipo = this.bordesContenidos.clone();
        bordeTipo.width /= columnas;
        bordeTipo.height /= filas;
        bordeTipo.y += this.bordesContenidos.height - bordeTipo.height;

        this.bordesTipo = new Rectangulo[cantidadTipos];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                final int k = i * columnas + j;
                if (k >= cantidadTipos) continue;

                final Rectangulo kBordeTipo = bordeTipo.clone();
                kBordeTipo.x += j * bordeTipo.width;
                kBordeTipo.y -= i * bordeTipo.height;
                this.bordesTipo[k] = kBordeTipo;
            }
        }

        final Rectangulo bordesIconoTipo = bordeTipo.clone().toSquare().scaleBy(0.5f);
        bordesIconoTipo.x = bordeTipo.x + (bordeTipo.width - bordesIconoTipo.width) / 2;
        bordesIconoTipo.y = bordeTipo.y + bordeTipo.height * 0.85f - bordesIconoTipo.height;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                final int k = i * columnas + j;
                if (k >= cantidadTipos) continue;

                final Textura texturaTipo = tipoTexturaGetter.apply(tipos[k]);
                texturaTipo.bordes.set(bordesIconoTipo);

                texturaTipo.bordes.x += j * bordeTipo.width;
                texturaTipo.bordes.y -= i * bordeTipo.height;
            }
        }

        configFuente.size = 20;
        configFuente.borderColor = Util.color("#000000", 0.5f);
        configFuente.borderWidth = 1;
        this.fuenteTituloTipo = this.juego.generadorFuente.generateFont(configFuente);

        final Rectangulo templateBordeTituloTipo = bordeTipo.clone();
        templateBordeTituloTipo.width *= 0.9f;
        templateBordeTituloTipo.x += bordeTipo.width * 0.05f;
        templateBordeTituloTipo.y -= (bordesIconoTipo.height - bordeTipo.height) / 2;

        this.bordesTituloTipo = new Rectangulo[cantidadTipos];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                final int k = i * columnas + j;
                if (k >= cantidadTipos) continue;

                final Rectangulo bordeTituloHabitat = templateBordeTituloTipo.clone();
                bordeTituloHabitat.x += j * bordeTipo.width;
                bordeTituloHabitat.y -= i * bordeTipo.height;
                this.bordesTituloTipo[k] = bordeTituloHabitat;
            }
        }

        this.colorTipoSeleccionable = Util.color("#689a24");
        this.colorTipoNoSeleccionable = Util.color("#9a4e3c");
        this.seleccionarTipoHoverWidth = bordeTipo.width * 0.025f;
    }

    public boolean draw(Vector2 mousePos, boolean ignorarClick) {
        if (!ignorarClick && Gdx.input.justTouched()
                && (!this.bordesMenu.contains(mousePos) || this.bordesCerrarMenu.contains(mousePos))) return false;

        Gdx.gl20.glEnable(GL20.GL_BLEND);
        Gdx.gl20.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        this.juego.shape.begin();
        this.juego.shape.setColor(this.colorFondo);
        this.juego.shape.rect(this.juego.bordesJuego);
        this.juego.shape.end();

        this.juego.batch.begin();
        this.juego.batch.draw(this.texturaMenu, this.bordesMenu);
        this.fuenteTituloMenu.draw(this.juego.batch, this.tituloMenu,
                this.bordesTituloMenu.x, this.bordesTituloMenu.y, this.bordesTituloMenu.width,
                Align.center, false);
        this.juego.batch.end();

        Gdx.gl20.glEnable(GL20.GL_BLEND);
        Gdx.gl20.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        this.juego.shape.begin();
        this.juego.shape.setColor(this.colorFondoContenidos);
        this.juego.shape.rect(this.bordesContenidos);
        this.juego.shape.end();

        Gdx.gl20.glDisable(GL20.GL_BLEND);

        return true;
    }

    protected T seleccionarTipo(Vector2 mousePos, boolean ignorarClick, Set<T> seleccionables) {
        final int cantidadTipos = this.tipos.length;

        this.juego.batch.begin();
        for (T tipo : this.tipos) {
            if (seleccionables != null && !seleccionables.contains(tipo))
                this.juego.batch.setShader(GrayscaleShader.grayscaleShader);
            this.juego.batch.draw(this.tipoTexturaGetter.apply(tipo));
            if (seleccionables != null && !seleccionables.contains(tipo)) this.juego.batch.setShader(null);
        }
        for (int i = 0; i < cantidadTipos; i++) {
            final Rectangulo bordeTituloTipo = this.bordesTituloTipo[i];
            this.fuenteTituloTipo.draw(this.juego.batch, this.tipoNombreGetter.apply(this.tipos[i]),
                    bordeTituloTipo.x, bordeTituloTipo.y, bordeTituloTipo.width,
                    Align.center, false);
        }
        this.juego.batch.end();

        final boolean click = Gdx.input.justTouched();
        T tipoSeleccionado = null;

        this.juego.shape.begin();
        for (int i = 0; i < cantidadTipos; i++) {
            final Rectangulo bordeTipo = this.bordesTipo[i];
            if (!bordeTipo.contains(mousePos)) continue;

            final boolean seleccionable = !(seleccionables != null && !seleccionables.contains(this.tipos[i]));
            this.juego.shape.setColor(seleccionables != null && !seleccionables.contains(this.tipos[i])
                    ? this.colorTipoNoSeleccionable : this.colorTipoSeleccionable);
            this.juego.shape.rect(bordeTipo, this.seleccionarTipoHoverWidth);

            if (seleccionable && !ignorarClick && click) {
                tipoSeleccionado = this.tipos[i];
            }
        }
        this.juego.shape.end();

        return tipoSeleccionado;
    }

    protected T seleccionarTipo(Vector2 mousePos, boolean ignorarClick) {
        return this.seleccionarTipo(mousePos, ignorarClick, null);
    }

    public void dispose() {
        this.texturaMenu.dispose();
        this.fuenteTituloMenu.dispose();
        this.fuenteTituloTipo.dispose();
    }
}
