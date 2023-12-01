package udec.prog2.project.habitats;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public enum TipoHabitat {
    JUNGLA(Jungla.class, "habitats/jungla.png", "habitats/jungla_icono.png"),
    ACUATICO(Acuatico.class, "habitats/acuatico.png", "habitats/acuatico_icono.ong"),
    SABANA(Sabana.class, "habitats/sabana.png", "habitats/sabana_icono.png"),
    TAIGA(Taiga.class, "habitats/taiga.png", "habitats/taiga_icono.png"),
    TROPICAL(Tropical.class, "habitats/tropical.png", "habitats/tropical_icono.png"),
    TUNDRA(Tundra.class, "habitats/tundra.png", "habitats/tundra_icono.png");

    private final Class<? extends Habitat> clase;
    private final Texture textura;
    private final Texture texturaIcono;

    TipoHabitat(Class<? extends Habitat> clase, String archivoTextura, String archivoTexturaIcono) {
        this.clase = clase;
        this.textura = new Texture(Gdx.files.internal(archivoTextura));
        this.texturaIcono = new Texture(Gdx.files.internal(archivoTexturaIcono));
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

    public Texture getTexturaIcono() {
        return this.texturaIcono;
    }
}
