package udec.prog2.project.habitats;

import udec.prog2.project.util.Textura;

public enum TipoHabitat {
    ACUATICO(Acuatico.class, "Acuático", "habitats/acuatico.png", "habitats/acuatico_icono.png"),
    JUNGLA(Jungla.class, "Jungla", "habitats/jungla.png", "habitats/jungla_icono.png"),
    SABANA(Sabana.class, "Sabana", "habitats/sabana.png", "habitats/sabana_icono.png"),
    TAIGA(Taiga.class, "Taiga", "habitats/taiga.png", "habitats/taiga_icono.png"),
    TROPICAL(Tropical.class, "Tropical", "habitats/tropical.png", "habitats/tropical_icono.png"),
    TUNDRA(Tundra.class, "Tundra", "habitats/tundra.png", "habitats/tundra_icono.png");

    private final Class<? extends Habitat> clase;
    private final String nombre;
    private final Textura textura;
    private final Textura texturaIcono;

    TipoHabitat(Class<? extends Habitat> clase, String nombre, String archivoTextura, String archivoTexturaIcono) {
        this.clase = clase;
        this.nombre = nombre;
        this.textura = new Textura(archivoTextura);
        this.texturaIcono = new Textura(archivoTexturaIcono);
    }

    public Habitat crearHabitat(int maxAnimales) {
        try {
            return this.clase.getDeclaredConstructor(int.class).newInstance(maxAnimales);
        } catch (Exception ignored) {
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
