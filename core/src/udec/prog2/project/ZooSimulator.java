package udec.prog2.project;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class ZooSimulator extends Game {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    public CustomSpriteBatch batch;
    public FreeTypeFontGenerator generadorFuente;

    public void create() {
        this.batch = new CustomSpriteBatch();
        this.generadorFuente = new FreeTypeFontGenerator(Gdx.files.internal("otros/PixeloidSans.ttf"));

        this.setScreen(new MainMenuScreen(this));
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        this.batch.dispose();
        this.generadorFuente.dispose();
    }
}
