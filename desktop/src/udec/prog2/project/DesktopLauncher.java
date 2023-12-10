package udec.prog2.project;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.useVsync(true);
        config.setForegroundFPS(120);
        config.setTitle("Zoo Simulator");
        config.setMaximized(true);
        config.setWindowIcon("ui/icono.png");
        new Lwjgl3Application(new ZooSimulator(), config);
    }
}
