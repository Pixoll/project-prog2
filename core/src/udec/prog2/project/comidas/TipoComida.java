package udec.prog2.project.comidas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public enum TipoComida {
    BERRIES(Berries.class, "berries.png"),
    CALAMAR(Calamar.class, "calamar.png"),
    CONEJO(Conejo.class, "conejo.png"),
    FOCA(Foca.class, "foca.png"),
    FRUTAS(Frutas.class, "frutas.png"),
    KRILL(Krill.class, "krill.png"),
    POLLO(Pollo.class, "pollo.png"),
    RES(Res.class, "res.png"),
    SALMON(Salmon.class, "salmon.png"),
    SARDINAS(Sardinas.class, "sardinas.png"),
    VEGETALES(Vegetales.class, "vegetales.png");

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
