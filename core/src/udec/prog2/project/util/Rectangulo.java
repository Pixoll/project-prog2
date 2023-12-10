package udec.prog2.project.util;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Rectangulo extends Rectangle {
    public Rectangulo(float width, float height) {
        super(0, 0, width, height);
    }

    public Rectangulo(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    @Override
    public Rectangulo set(Rectangle rect) {
        return (Rectangulo) super.set(rect);
    }

    @Override
    public Rectangulo setPosition(Vector2 position) {
        return (Rectangulo) super.setPosition(position);
    }

    public Rectangulo setPosition(Rectangulo rectangulo) {
        this.x = rectangulo.x;
        this.y = rectangulo.y;
        return this;
    }

    public Rectangulo scaleBy(float scale, boolean scaleCoords) {
        this.width *= scale;
        this.height *= scale;
        if (scaleCoords) {
            this.x *= scale;
            this.y *= scale;
        }
        return this;
    }

    public Rectangulo scaleBy(float scale) {
        return this.scaleBy(scale, true);
    }

    public Rectangulo toSquare() {
        if (this.height > this.width) {
            this.height = this.width;
        } else {
            this.width = this.height;
        }
        return this;
    }

    @Override
    public Rectangulo clone() {
        return new Rectangulo(this.x, this.y, this.width, this.height);
    }
}
