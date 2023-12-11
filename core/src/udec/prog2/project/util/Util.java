package udec.prog2.project.util;

import com.badlogic.gdx.graphics.Color;

public class Util {
    public static Color color(String hexColor, float alpha) {
        final int offset = hexColor.startsWith("#") ? 1 : 0;
        final float r = Integer.parseInt(hexColor.substring(offset, offset + 2), 16);
        final float g = Integer.parseInt(hexColor.substring(offset + 2, offset + 4), 16);
        final float b = Integer.parseInt(hexColor.substring(offset + 4, offset + 6), 16);
        return new Color(r / 255, g / 255, b / 255, alpha);
    }

    public static Color color(String hexColor) {
        return Util.color(hexColor, 1);
    }

    public static Thread setTimeout(Runnable funcion, long delay) {
        final Thread thread = new Thread(() -> {
            try {
                Thread.sleep(delay);
            } catch (Exception error) {
                error.printStackTrace();
            }

            funcion.run();
        });
        thread.start();
        return thread;
    }

    public static float getRandomNumber(float min, float max) {
        return (float) Math.random() * (max - min) + min;
    }
}
