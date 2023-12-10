package udec.prog2.project.animales;

import udec.prog2.project.util.Textura;
import udec.prog2.project.habitats.Habitat;

public enum TipoAnimal {
    JIRAFA(Jirafa.class, "Jirafa", "animales/jirafa.png", "animales/jirafa_icono.png"),
    LEON(Leon.class, "Leon", "animales/leon.png", "animales/leon_icono.png"),
    MONO(Mono.class, "Mono", "animales/mono.png", "animales/mono_icono.png"),
    ORCA(Orca.class, "Orca", "animales/orca.png","animales/orca_icono.png"),
    OSO_PARDO(OsoPardo.class, "Oso Pardo", "animales/oso_pardo.png", "animales/oso_pardo_icono.png"),
    OSO_POLAR(OsoPolar.class, "Oso Polar", "animales/oso_polar.png", "animales/oso_polar_icono.png"),
    PINGUINO(Pinguino.class, "Pingüino", "animales/pinguino.png", "animales/pinguino_icono.png"),
    TIGRE(Tigre.class, "Tigre", "animales/tigre.png", "animales/tigre_icono.png"),
    ZORRO(Zorro.class, "Zorro", "animales/zorro.png", "animales/zorro_icono.png");

    private final Class<? extends Animal> clase;
    private final String nombre;
    private final Textura textura;
    private final Textura texturaIcono;

    TipoAnimal(Class<? extends Animal> clase, String nombre, String archivoTextura, String archivoTexturaIcono) {
        this.clase = clase;
        this.nombre = nombre;
        this.textura = new Textura(archivoTextura);
        this.texturaIcono = new Textura(archivoTexturaIcono);
    }

    public Animal crearAnimal(Habitat habitat) {
        try {
            return this.clase.getDeclaredConstructor(Habitat.class).newInstance(habitat);
        } catch (Exception error) {
            error.printStackTrace();
        }
        return null;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Textura getTextura() {
        return this.textura;
    }

    public Textura getTexturaIcono() {
        return this.texturaIcono;
    }
}
