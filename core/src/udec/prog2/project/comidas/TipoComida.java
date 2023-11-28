package udec.prog2.project.comidas;

public enum TipoComida {
    BERRIES(Berries.class),
    CALAMAR(Calamar.class),
    CONEJO(Conejo.class),
    FOCA(Foca.class),
    FRUTAS(Frutas.class),
    KRILL(Krill.class),
    POLLO(Pollo.class),
    RES(Res.class),
    SALMON(Salmon.class),
    SARDINAS(Sardinas.class),
    VEGETALES(Vegetales.class);

    private final Class<? extends Comida> clase;

    TipoComida(Class<? extends Comida> clase) {
        this.clase = clase;
    }

    public Comida crearComida() {
        try {
            return this.clase.getDeclaredConstructor().newInstance();
        } catch (Exception ignored) {
        }
        return null;
    }
}
