package udec.prog2.project.habitats;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public enum TipoHabitat {
    JUNGLA(Jungla.class, "jungla.png"),
    ACUATICO(Acuatico.class, "acuatico.png"),
    SABANA(Sabana.class, "sabana.png"),
    TAIGA(Taiga.class, "taiga.png"),
    TROPICAL(Tropical.class, "tropical.png"),
    TUNDRA(Tundra.class, "tundra.png");

    private final Class<? extends Habitat> clase;
    private final Texture textura;

    TipoHabitat(Class<? extends Habitat> clase, String archivoTextura) {
        this.clase = clase;
        this.textura = new Texture(Gdx.files.internal(archivoTextura));
    }

    public Habitat crearHabitat(int maxAnimales) {
        try {
            return this.clase.getDeclaredConstructor(Integer.class).newInstance(maxAnimales);
        } catch (Exception ignored) {
        }
        return null;
    }

    public Texture getTextura() {
        return this.textura;
    }
}
