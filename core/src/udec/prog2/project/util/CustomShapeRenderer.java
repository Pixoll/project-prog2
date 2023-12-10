package udec.prog2.project.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class CustomShapeRenderer extends ShapeRenderer {
    @Override
    public void begin() {
        super.begin(ShapeType.Filled);
    }

    public void rect(Rectangle rectangle) {
        super.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public void rect(Rectangle rectangle, float lineWidth) {
        final float y1 = rectangle.y + rectangle.height - lineWidth / 2;
        super.rectLine(rectangle.x, y1, rectangle.x + rectangle.width, y1, lineWidth);
        final float y2 = rectangle.y + lineWidth / 2;
        super.rectLine(rectangle.x, y2, rectangle.x + rectangle.width, y2, lineWidth);
        final float x1 = rectangle.x + lineWidth / 2;
        super.rectLine(x1, rectangle.y + rectangle.height, x1, rectangle.y, lineWidth);
        final float x2 = rectangle.x + rectangle.width - lineWidth / 2;
        super.rectLine(x2, rectangle.y + rectangle.height, x2, rectangle.y, lineWidth);
    }
}
