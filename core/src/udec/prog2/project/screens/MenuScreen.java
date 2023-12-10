package udec.prog2.project.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import udec.prog2.project.ZooSimulator;
import udec.prog2.project.util.Rectangulo;
import udec.prog2.project.util.Util;

public class MenuScreen {
    protected final ZooSimulator juego;
    protected final Rectangulo bordesContenidos;
    private final Rectangulo bordesMenu;
    private final Texture texturaMenu;
    private final Color colorFondo;
    private final Rectangulo bordesCerrarMenu;
    private final String tituloMenu;
    private final BitmapFont fuente;
    private final Rectangle bordesTituloMenu;
    private final Color colorFondoContenidos;

    public MenuScreen(ZooSimulator juego, String tituloMenu) {
        this.juego = juego;
        this.tituloMenu = tituloMenu;
        this.texturaMenu = new Texture(Gdx.files.internal("otros/menu.png"));

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

        FreeTypeFontGenerator.FreeTypeFontParameter configFuente = new FreeTypeFontGenerator.FreeTypeFontParameter();
        configFuente.size = 30;
        configFuente.borderColor = this.colorFondo;
        configFuente.borderWidth = 2;
        this.fuente = this.juego.generadorFuente.generateFont(configFuente);

        this.bordesTituloMenu = new Rectangle();
        this.bordesTituloMenu.width = ZooSimulator.WIDTH / 2f;
        this.bordesTituloMenu.x = ZooSimulator.WIDTH / 4f;
        this.bordesTituloMenu.y = this.bordesMenu.y + this.bordesMenu.height * 0.925f;
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
        this.fuente.draw(this.juego.batch, this.tituloMenu,
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

    public void dispose() {
        this.texturaMenu.dispose();
        this.fuente.dispose();
    }
}
