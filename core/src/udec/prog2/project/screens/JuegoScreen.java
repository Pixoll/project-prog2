package udec.prog2.project.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import udec.prog2.project.habitats.TipoHabitat;
import udec.prog2.project.util.Rectangulo;
import udec.prog2.project.util.Textura;
import udec.prog2.project.util.Util;
import udec.prog2.project.ZooSimulator;
import udec.prog2.project.habitats.Habitat;

import java.util.ArrayList;

public class JuegoScreen implements Screen {
    private static final int BOTON_SIDE_HABITATS = 0;
    private static final int BOTON_SIDE_ANIMALES = 1;
    private static final int BOTON_SIDE_COMIDAS = 2;
    private static final int BOTON_SIDE_MOVER = 3;
    private static final int BOTON_SIDE_REMOVER = 4;
    private static final int CANTIDAD_BOTONES_SIDE = 5;
    private static final int FILAS_HABITATS = 3;
    private static final int COLUMANS_HABITATS = 4;
    private final ZooSimulator juego;
    private final MenuScreen menuHabitatScreen;
    private final MenuScreen menuAnimalesScreen;
    private final MenuScreen menuComidaScreen;
    private final Rectangulo bordesFondoTile;
    private final Textura texturaMenuSide;
    private final ArrayList<Rectangle> bordesBotonesMenuSide;
    private final float botonMenuSideHoverWidth;
    private final Color colorBotonMenuSide;
    private int menuSideActivado;
    private final ArrayList<Textura> texturasHabitats;
    private final Habitat[] habitats;
    private final Textura texturaFlecha;
    private int indexHabitatSeleccionado;
    private boolean acabaDeSeleccionarHabitat;

    public JuegoScreen(ZooSimulator juego) {
        this.juego = juego;

        this.menuHabitatScreen = new MenuHabitatScreen(juego, this);
        this.menuAnimalesScreen = new MenuAnimalesScreen(juego, this);
        this.menuComidaScreen = new MenuComidaScreen(juego, this);

        this.bordesFondoTile = new Rectangulo(juego.texturaPasto.getWidth(), juego.texturaPasto.getHeight());
        final float escalaFondo = (float) ZooSimulator.WIDTH / juego.texturaPasto.getWidth() / 9;
        this.bordesFondoTile.scaleBy(escalaFondo);

        this.texturaMenuSide = new Textura("ui/menu_side.png");
        final float escalaMenuSide = ZooSimulator.HEIGHT * 0.6f / this.texturaMenuSide.getHeight();
        this.texturaMenuSide.bordes.scaleBy(escalaMenuSide);
        this.texturaMenuSide.bordes.y = (ZooSimulator.HEIGHT - this.texturaMenuSide.bordes.height) / 2;

        final Rectangle bordesBotonMenuSide = new Rectangle();
        bordesBotonMenuSide.width = this.texturaMenuSide.bordes.width * 6 / 11;
        bordesBotonMenuSide.height = bordesBotonMenuSide.width + 0;
        bordesBotonMenuSide.x = bordesBotonMenuSide.width / 3;
        bordesBotonMenuSide.y = this.texturaMenuSide.bordes.y + this.texturaMenuSide.bordes.height
                - bordesBotonMenuSide.height - this.texturaMenuSide.bordes.width * 12 / 55;
        final float bordesBotonMenuSideYOffset = bordesBotonMenuSide.width * 4 / 3;

        this.colorBotonMenuSide = Util.color("#689a24");

        this.bordesBotonesMenuSide = new ArrayList<>();
        for (int i = 0; i < CANTIDAD_BOTONES_SIDE; i++) {
            final Rectangle bordesBoton = new Rectangle(bordesBotonMenuSide);
            bordesBoton.y -= i * bordesBotonMenuSideYOffset;
            this.bordesBotonesMenuSide.add(bordesBoton);
        }

        this.botonMenuSideHoverWidth = bordesBotonMenuSide.width * 0.1f;
        this.menuSideActivado = -1;

        final Rectangle bordesSeccionHabitats = new Rectangle();
        bordesSeccionHabitats.height = ZooSimulator.HEIGHT * 0.9f;
        bordesSeccionHabitats.width = (ZooSimulator.WIDTH - this.texturaMenuSide.bordes.width) * 0.95f;
        bordesSeccionHabitats.y = (ZooSimulator.HEIGHT - bordesSeccionHabitats.height) / 2;
        bordesSeccionHabitats.x = (ZooSimulator.WIDTH - bordesSeccionHabitats.width + this.texturaMenuSide.bordes.width) / 2;

        final Rectangle bordesHabitat = new Rectangle(bordesSeccionHabitats);
        bordesHabitat.height = bordesSeccionHabitats.height / FILAS_HABITATS * 0.9f;
        bordesHabitat.width = bordesHabitat.height * 4 / 3;

        final float xOffset = (bordesSeccionHabitats.width - bordesHabitat.width * COLUMANS_HABITATS) / (COLUMANS_HABITATS - 1);
        final float yOffset = (bordesSeccionHabitats.height - bordesHabitat.height * FILAS_HABITATS) / (FILAS_HABITATS - 1);

        this.texturasHabitats = new ArrayList<>();
        for (int i = 0; i < FILAS_HABITATS; i++) {
            for (int j = 0; j < COLUMANS_HABITATS; j++) {
                final Textura texturaHabitat = new Textura("habitats/vacio.png");
                texturaHabitat.bordes.set(bordesHabitat);
                texturaHabitat.bordes.x += (bordesHabitat.width + xOffset) * j;
                texturaHabitat.bordes.y += (bordesHabitat.height + yOffset) * i;
                this.texturasHabitats.add(texturaHabitat);
            }
        }

        this.habitats = new Habitat[FILAS_HABITATS * COLUMANS_HABITATS];
        this.indexHabitatSeleccionado = -1;
        this.acabaDeSeleccionarHabitat = false;
        this.texturaFlecha = new Textura("ui/flecha.png");
    }

    @Override
    public void render(float delta) {
        this.juego.camara.update();
        this.juego.shape.setProjectionMatrix(this.juego.camara.combined);
        this.juego.batch.setProjectionMatrix(this.juego.camara.combined);

        this.juego.batch.begin();
        // Fondo
        for (float x = 0; x < ZooSimulator.WIDTH; x += this.bordesFondoTile.width) {
            for (float y = 0; y < ZooSimulator.HEIGHT; y += this.bordesFondoTile.height) {
                this.bordesFondoTile.setPosition(x, y);
                this.juego.batch.draw(this.juego.texturaPasto, this.bordesFondoTile);
            }
        }
        this.juego.batch.draw(this.texturaMenuSide);
        // Habitats
        for (Textura texturaHabitat : this.texturasHabitats) {
            this.juego.batch.draw(texturaHabitat);
        }
        this.juego.batch.end();

        this.juego.shape.begin();
        this.juego.shape.setColor(this.colorBotonMenuSide);
        final Vector2 mousePos = this.getMousePos();
        for (int i = 0; i < CANTIDAD_BOTONES_SIDE; i++) {
            final Rectangle bordesBoton = this.bordesBotonesMenuSide.get(i);
            if (!bordesBoton.contains(mousePos) && this.menuSideActivado != i) continue;

            this.juego.shape.rect(bordesBoton, this.botonMenuSideHoverWidth);

            if (bordesBoton.contains(mousePos) && Gdx.input.justTouched()) {
                this.menuSideActivado = this.menuSideActivado == i ? -1 : i;
            }
        }
        this.juego.shape.end();

        if (this.menuSideActivado == -1) {
            this.indexHabitatSeleccionado = -1;
            return;
        }

        if (this.menuSideActivado < 0 || this.menuSideActivado >= CANTIDAD_BOTONES_SIDE) return;

        if (this.indexHabitatSeleccionado == -1) {
            this.seleccionarHabitat(mousePos);
        } else {
            this.acabaDeSeleccionarHabitat = false;
        }

        if (this.indexHabitatSeleccionado == -1) return;

        this.drawFlecha(this.indexHabitatSeleccionado);

        boolean mantenerMenuAbierto = false;
        switch (this.menuSideActivado) {
            case BOTON_SIDE_HABITATS -> mantenerMenuAbierto = this.menuHabitatScreen.draw(mousePos, this.acabaDeSeleccionarHabitat);
            case BOTON_SIDE_ANIMALES -> mantenerMenuAbierto = this.menuAnimalesScreen.draw(mousePos, this.acabaDeSeleccionarHabitat);
            case BOTON_SIDE_COMIDAS -> mantenerMenuAbierto = this.menuComidaScreen.draw(mousePos, this.acabaDeSeleccionarHabitat);
            default -> System.out.println(this.menuSideActivado + " not implemented");
//            case BOTON_SIDE_MOVER -> this.menuMover(mousePos);
//            case BOTON_SIDE_REMOVER -> this.menuRemover(mousePos);
        }

        if (!mantenerMenuAbierto) {
            this.indexHabitatSeleccionado = -1;
        }
    }

    private void seleccionarHabitat(Vector2 mousePos) {
        final boolean click = Gdx.input.justTouched();

        for (Textura texturaHabitat : this.texturasHabitats) {
            final int index = this.texturasHabitats.indexOf(texturaHabitat);
            if (!texturaHabitat.bordes.contains(mousePos) || this.habitats[index] != null) continue;

            this.drawFlecha(index);

            if (click) {
                this.indexHabitatSeleccionado = index;
                this.acabaDeSeleccionarHabitat = true;
            }

            break;
        }

        if (this.indexHabitatSeleccionado == -1) return;

        this.drawFlecha(this.indexHabitatSeleccionado);
    }

    public void crearHabitat(TipoHabitat tipo) {
        final int index = this.indexHabitatSeleccionado;
        this.habitats[index] = tipo.crearHabitat(3);
        Textura texturaHabitat = tipo.getTextura().clonar();
        texturaHabitat.bordes.set(this.texturasHabitats.get(index).bordes);
        this.texturasHabitats.get(index).dispose();
        this.texturasHabitats.set(index, texturaHabitat);
    }

    private void drawFlecha(int indexHabitat) {
        final Rectangle bordesHabitat = this.texturasHabitats.get(indexHabitat).bordes;

        this.texturaFlecha.bordes.x = bordesHabitat.x + (bordesHabitat.width - this.texturaFlecha.bordes.width) / 2;
        this.texturaFlecha.bordes.y = bordesHabitat.y + bordesHabitat.height / 2;

        this.juego.batch.begin();
        this.juego.batch.draw(this.texturaFlecha);
        this.juego.batch.end();
    }

    private Vector2 getMousePos() {
        final Vector3 mouseCoords = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        this.juego.camara.unproject(mouseCoords);
        return new Vector2(mouseCoords.x, mouseCoords.y);
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
        this.texturaFlecha.dispose();
        this.texturasHabitats.forEach(Textura::dispose);
        this.texturaMenuSide.dispose();
        this.menuComidaScreen.dispose();
        this.menuAnimalesScreen.dispose();
        this.menuHabitatScreen.dispose();
    }
}
