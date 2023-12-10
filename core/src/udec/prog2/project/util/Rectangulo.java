package udec.prog2.project.util;

import com.badlogic.gdx.math.Rectangle;

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

    public Rectangulo scaleBy(float scale) {
        this.width *= scale;
        this.height *= scale;
        this.x *= scale;
        this.y *= scale;
        return this;
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
