package udec.prog2.project.comidas;

import udec.prog2.project.util.Textura;

public enum TipoComida {
    BERRIES(Berries.class, "Berries", "comidas/berries.png"),
    CALAMAR(Calamar.class, "Calamar", "comidas/calamar.png"),
    CONEJO(Conejo.class, "Conejo", "comidas/conejo.png"),
    FOCA(Foca.class, "Foca", "comidas/foca.png"),
    FRUTAS(Frutas.class, "Frutas", "comidas/frutas.png"),
    KRILL(Krill.class, "Krill", "comidas/krill.png"),
    POLLO(Pollo.class, "Pollo", "comidas/pollo.png"),
    RES(Res.class, "Res", "comidas/res.png"),
    SALMON(Salmon.class, "Salmon", "comidas/salmon.png"),
    SARDINAS(Sardinas.class, "Sardinas", "comidas/sardinas.png"),
    VEGETALES(Vegetales.class, "Vegetales", "comidas/vegetales.png");

    private final Class<? extends Comida> clase;
    private final String nombre;
    private final Textura textura;

    TipoComida(Class<? extends Comida> clase, String nombre, String archivoTextura) {
        this.clase = clase;
        this.nombre = nombre;
        this.textura = new Textura(archivoTextura);
    }

    public Comida crearComida() {
        try {
            return this.clase.getDeclaredConstructor().newInstance();
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
}
