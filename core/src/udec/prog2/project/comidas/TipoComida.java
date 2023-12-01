package udec.prog2.project.comidas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public enum TipoComida {
    BERRIES(Berries.class, "comidas/berries.png"),
    CALAMAR(Calamar.class, "comidas/calamar.png"),
    CONEJO(Conejo.class, "comidas/conejo.png"),
    FOCA(Foca.class, "comidas/foca.png"),
    FRUTAS(Frutas.class, "comidas/frutas.png"),
    KRILL(Krill.class, "comidas/krill.png"),
    POLLO(Pollo.class, "comidas/pollo.png"),
    RES(Res.class, "comidas/res.png"),
    SALMON(Salmon.class, "comidas/salmon.png"),
    SARDINAS(Sardinas.class, "comidas/sardinas.png"),
    VEGETALES(Vegetales.class, "comidas/vegetales.png");

    private final Class<? extends Comida> clase;
    private final Texture textura;

    TipoComida(Class<? extends Comida> clase, String archivoTextura) {
        this.clase = clase;
        this.textura = new Texture(Gdx.files.internal(archivoTextura));
    }

    public Comida crearComida() {
        try {
            return this.clase.getDeclaredConstructor().newInstance();
        } catch (Exception ignored) {
        }
        return null;
    }

    public Texture getTextura() {
        return this.textura;
    }
}
