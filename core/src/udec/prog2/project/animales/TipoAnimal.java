package udec.prog2.project.animales;

public enum TipoAnimal {
    JIRAFA(Jirafa.class),
    LEON(Leon.class),
    MONO(Mono.class),
    ORCA(Orca.class),
    OSO_PARDO(OsoPardo.class),
    OSO_POLAR(OsoPolar.class),
    PINGUINO(Pinguino.class),
    TIGRE(Tigre.class),
    ZORRO(Zorro.class);

    private final Class<? extends Animal> clase;

    TipoAnimal(Class<? extends Animal> clase) {
        this.clase = clase;
    }

    public Animal crearAnimal() {
        try {
            return this.clase.getDeclaredConstructor().newInstance();
        } catch (Exception ignored) {
        }
        return null;
    }
}
