package udec.prog2.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {
    private final ZooSimulator juego;
    private final Texture imagenTitulo;
    private final Rectangle bordesTitulo;
    private final Rectangle bordesTextoInicio;
    private final OrthographicCamera camara;
    private final BitmapFont fuente;
    private final Texture imagenFondo;
    private final Rectangle bordesFondo;

    public MainMenuScreen(ZooSimulator juego) {
        this.juego = juego;

        this.camara = new OrthographicCamera();
        this.camara.setToOrtho(false, ZooSimulator.WIDTH, ZooSimulator.HEIGHT);

        this.imagenTitulo = new Texture(Gdx.files.internal("titulo.png"));
        this.imagenFondo = new Texture(Gdx.files.internal("pasto.png"));

        this.bordesFondo = new Rectangle();
        final float escalaFondo = (float) ZooSimulator.WIDTH / this.imagenFondo.getWidth();
        this.bordesFondo.width = this.imagenFondo.getWidth() * escalaFondo;
        this.bordesFondo.height = this.imagenFondo.getHeight() * escalaFondo;
        this.bordesFondo.y = ZooSimulator.HEIGHT - this.bordesFondo.height;

        this.bordesTitulo = new Rectangle();
        this.bordesTitulo.width = this.imagenTitulo.getWidth();
        this.bordesTitulo.height = this.imagenTitulo.getHeight();
        this.bordesTitulo.x = (ZooSimulator.WIDTH - this.bordesTitulo.width) / 2;
        this.bordesTitulo.y = (ZooSimulator.HEIGHT - this.bordesTitulo.height) * 0.7f;

        this.bordesTextoInicio = new Rectangle();
        this.bordesTextoInicio.width = ZooSimulator.WIDTH / 2f;
        this.bordesTextoInicio.x = ZooSimulator.WIDTH / 4f;
        this.bordesTextoInicio.y = ZooSimulator.HEIGHT * 0.15f;

        FreeTypeFontGenerator.FreeTypeFontParameter configFuente = new FreeTypeFontGenerator.FreeTypeFontParameter();
        configFuente.size = 50;
        configFuente.borderColor = new Color(0, 0, 0, 1);
        configFuente.borderWidth = 3;
        this.fuente = this.juego.generadorFuente.generateFont(configFuente);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        this.camara.update();
        this.juego.batch.setProjectionMatrix(camara.combined);

        this.juego.batch.begin();
        this.juego.batch.draw(this.imagenFondo, this.bordesFondo);
        this.juego.batch.draw(this.imagenTitulo, this.bordesTitulo);
        this.fuente.draw(this.juego.batch, ">> Haz click para iniciar <<",
                this.bordesTextoInicio.x, this.bordesTextoInicio.y, this.bordesTextoInicio.width,
                Align.center, false);
        this.juego.batch.end();

        if (Gdx.input.isTouched()) {
            this.juego.setScreen(new GameScreen(this.juego));
            this.dispose();
        }
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
        this.imagenTitulo.dispose();
        this.fuente.dispose();
    }
}
