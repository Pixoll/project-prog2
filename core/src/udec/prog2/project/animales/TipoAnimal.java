package udec.prog2.project.animales;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import udec.prog2.project.habitats.Habitat;

public enum TipoAnimal {
    JIRAFA(Jirafa.class, "animales/jirafa.png", "animales/jirafa_icono.png"),
    LEON(Leon.class, "animales/leon.png", "animales/leon_icono.png"),
    MONO(Mono.class, "animales/mono.png", "animales/mono_icono.png"),
    ORCA(Orca.class, "animales/orca.png","animales/orca_icono.png"),
    OSO_PARDO(OsoPardo.class, "animales/oso_pardo.png", "animales/oso_pardo_icono.png"),
    OSO_POLAR(OsoPolar.class, "animales/oso_polar.png", "animales/oso_polar_icono.png"),
    PINGUINO(Pinguino.class, "animales/pinguino.png", "animales/pinguino_icono.png"),
    TIGRE(Tigre.class, "animales/tigre.png", "animales/tigre_icono.png"),
    ZORRO(Zorro.class, "animales/zorro.png", "animales/zorro_icono.png");

    private final Class<? extends Animal> clase;
    private final Texture textura;
    private final Texture texturaIcono;

    TipoAnimal(Class<? extends Animal> clase, String archivoTextura, String archivoTexturaIcono) {
        this.clase = clase;
        this.textura = new Texture(Gdx.files.internal(archivoTextura));
        this.texturaIcono = new Texture(Gdx.files.internal(archivoTexturaIcono));
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
