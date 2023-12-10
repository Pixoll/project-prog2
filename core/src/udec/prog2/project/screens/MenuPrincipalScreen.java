package udec.prog2.project.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import udec.prog2.project.util.Rectangulo;
import udec.prog2.project.util.Textura;
import udec.prog2.project.util.Util;
import udec.prog2.project.ZooSimulator;

public class MenuPrincipalScreen implements Screen {
    private final ZooSimulator juego;
    private final Textura texturaTitulo;
    private final Rectangle bordesTextoInicio;
    private final BitmapFont fuente;
    private final Rectangulo bordesFondo;
    private long timerTextoAnimacion;
    private String textoAnimacion;

    public MenuPrincipalScreen(ZooSimulator juego) {
        this.juego = juego;

        this.texturaTitulo = new Textura("ui/titulo.png");
        this.texturaTitulo.bordes.setPosition(
                (ZooSimulator.WIDTH - this.texturaTitulo.getWidth()) / 2f,
                (ZooSimulator.HEIGHT - this.texturaTitulo.getHeight()) * 0.7f
        );

        this.bordesFondo = new Rectangulo(juego.texturaPasto.getWidth(), juego.texturaPasto.getHeight());
        final float escalaFondo = (float) ZooSimulator.WIDTH / juego.texturaPasto.getWidth();
        this.bordesFondo.scaleBy(escalaFondo);
        this.bordesFondo.y = ZooSimulator.HEIGHT - this.bordesFondo.height;

        this.bordesTextoInicio = new Rectangle();
        this.bordesTextoInicio.width = ZooSimulator.WIDTH / 2f;
        this.bordesTextoInicio.x = ZooSimulator.WIDTH / 4f;
        this.bordesTextoInicio.y = ZooSimulator.HEIGHT * 0.15f;

        FreeTypeFontParameter configFuente = new FreeTypeFontParameter();
        configFuente.size = 50;
        configFuente.borderColor = Util.color("#000000");
        configFuente.borderWidth = 3;
        this.fuente = this.juego.generadorFuente.generateFont(configFuente);

        this.timerTextoAnimacion = 0;
        this.textoAnimacion = ">> Haz click para iniciar <<";
    }

    @Override
    public void render(float delta) {
        this.juego.camara.update();
        this.juego.batch.setProjectionMatrix(juego.camara.combined);

        this.juego.batch.begin();
        this.juego.batch.draw(this.juego.texturaPasto, this.bordesFondo);
        this.juego.batch.draw(this.texturaTitulo);

        if (TimeUtils.timeSinceMillis(this.timerTextoAnimacion) >= 500) {
            this.textoAnimacion = this.textoAnimacion.equals(">> Haz click para iniciar <<")
                    ? "Haz click para iniciar"
                    : ">> Haz click para iniciar <<";

            this.timerTextoAnimacion = TimeUtils.millis();
        }

        this.fuente.draw(this.juego.batch, this.textoAnimacion,
                this.bordesTextoInicio.x, this.bordesTextoInicio.y, this.bordesTextoInicio.width,
                Align.center, false);

        this.juego.batch.end();

        if (Gdx.input.isTouched()) {
            this.juego.setScreen(new JuegoScreen(this.juego));
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
        this.texturaTitulo.dispose();
        this.fuente.dispose();
    }
}
