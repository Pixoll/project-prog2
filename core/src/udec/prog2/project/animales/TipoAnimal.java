package udec.prog2.project.animales;

import udec.prog2.project.habitats.Habitat;

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

    public Animal crearAnimal(Habitat habitat) {
        try {
            return this.clase.getDeclaredConstructor(Habitat.class).newInstance(habitat);
        } catch (Exception ignored) {
        }
        return null;
    }
}
