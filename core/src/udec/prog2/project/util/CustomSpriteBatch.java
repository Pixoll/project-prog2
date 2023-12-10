package udec.prog2.project.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class CustomSpriteBatch extends SpriteBatch {
    public void draw(Texture texture, Rectangle bordes) {
        super.draw(texture, bordes.x, bordes.y, bordes.width, bordes.height);
    }

    public void draw(Textura textura) {
        this.draw(textura, textura.bordes);
    }
}
