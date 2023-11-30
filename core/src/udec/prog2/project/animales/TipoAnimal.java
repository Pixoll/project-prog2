package udec.prog2.project.animales;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import udec.prog2.project.habitats.Habitat;

public enum TipoAnimal {
    JIRAFA(Jirafa.class, "jirafa.png"),
    LEON(Leon.class, "leon.png"),
    MONO(Mono.class, "mono.png"),
    ORCA(Orca.class, "orca.png"),
    OSO_PARDO(OsoPardo.class, "oso_pardo.png"),
    OSO_POLAR(OsoPolar.class, "oso_polar.png"),
    PINGUINO(Pinguino.class, "pinguino.png"),
    TIGRE(Tigre.class, "tigre.png"),
    ZORRO(Zorro.class, "zorro.png");

    private final Class<? extends Animal> clase;
    private final Texture textura;

    TipoAnimal(Class<? extends Animal> clase, String archivoTextura) {
        this.clase = clase;
        this.textura = new Texture(Gdx.files.internal(archivoTextura));
    }

    public Animal crearAnimal(Habitat habitat) {
        try {
            return this.clase.getDeclaredConstructor(Habitat.class).newInstance(habitat);
        } catch (Exception ignored) {
        }
        return null;
    }

    public Texture getTextura() {
        return this.textura;
    }
}
