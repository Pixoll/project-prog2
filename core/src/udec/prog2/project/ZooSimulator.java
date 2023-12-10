package udec.prog2.project;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import udec.prog2.project.screens.MenuPrincipalScreen;
import udec.prog2.project.util.CustomShapeRenderer;
import udec.prog2.project.util.CustomSpriteBatch;
import udec.prog2.project.util.Rectangulo;

public class ZooSimulator extends Game {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    public CustomSpriteBatch batch;
    public CustomShapeRenderer shape;
    public FreeTypeFontGenerator generadorFuente;
    public Texture texturaPasto;
    public OrthographicCamera camara;
    public Rectangulo bordesJuego;

    public void create() {
        this.batch = new CustomSpriteBatch();
        this.shape = new CustomShapeRenderer();

        this.camara = new OrthographicCamera();
        this.camara.setToOrtho(false, ZooSimulator.WIDTH, ZooSimulator.HEIGHT);

        this.bordesJuego = new Rectangulo(ZooSimulator.WIDTH, ZooSimulator.HEIGHT);

        this.generadorFuente = new FreeTypeFontGenerator(Gdx.files.internal("ui/PixeloidSans.ttf"));
        this.texturaPasto = new Texture(Gdx.files.internal("ui/pasto.png"));

        this.setScreen(new MenuPrincipalScreen(this));
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        this.batch.dispose();
        this.shape.dispose();
        this.generadorFuente.dispose();
        this.texturaPasto.dispose();
    }
}
