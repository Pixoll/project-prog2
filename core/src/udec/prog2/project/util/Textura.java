package udec.prog2.project.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Textura extends Texture {
    private final String archivoTextura;
    public final Rectangulo bordes;

    public Textura(String archivoTextura) {
        super(Gdx.files.internal(archivoTextura));

        this.archivoTextura = archivoTextura;
        this.bordes = new Rectangulo(this.getWidth(), this.getHeight());
    }

    public String getArchivoTextura() {
        return this.archivoTextura;
    }

    public Textura clonar() {
        final Textura clonada = new Textura(this.archivoTextura);
        clonada.bordes.set(this.bordes);
        return clonada;
    }
}
