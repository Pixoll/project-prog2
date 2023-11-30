package udec.prog2.project;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
    private final ZooSimulator juego;
    private final OrthographicCamera camara;

    public GameScreen(ZooSimulator juego) {
        this.juego = juego;

        this.camara = new OrthographicCamera();
        this.camara.setToOrtho(false, ZooSimulator.WIDTH, ZooSimulator.HEIGHT);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Util.color("#8dc73f"));

        this.camara.update();
        this.juego.batch.setProjectionMatrix(this.camara.combined);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
