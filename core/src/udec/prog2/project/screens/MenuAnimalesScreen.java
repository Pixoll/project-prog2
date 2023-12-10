package udec.prog2.project.screens;

import com.badlogic.gdx.math.Vector2;
import udec.prog2.project.ZooSimulator;

public class MenuAnimalesScreen extends MenuScreen {
    public MenuAnimalesScreen(ZooSimulator juego) {
        super(juego, "Comprar Animal");
    }

    @Override
    public boolean draw(Vector2 mousePos, boolean ignorarClick) {
        if (!super.draw(mousePos, ignorarClick)) return false;

        return true;
    }
}
