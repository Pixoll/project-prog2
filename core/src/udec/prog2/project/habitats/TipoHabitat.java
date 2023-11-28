package udec.prog2.project.habitats;

public enum TipoHabitat {
    JUNGLA(Jungla.class),
    ACUATICO(Acuatico.class),
    SABANA(Sabana.class),
    TAIGA(Taiga.class),
    TROPICAL(Tropical.class),
    TUNDRA(Taiga.class);

    private final Class<? extends Habitat> clase;

    TipoHabitat(Class<? extends Habitat> clase) {
        this.clase = clase;
    }

    public Habitat crearHabitat() {
        try {
            return this.clase.getDeclaredConstructor().newInstance();
        } catch (Exception ignored) {
        }
        return null;
    }
}
