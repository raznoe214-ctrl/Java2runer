import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.Display;

public class MainMidlet extends MIDlet {
    private GameCanvas game;

    public void startApp() {
        if (game == null) {
            game = new GameCanvas();
        }
        Display.getDisplay(this).setCurrent(game);
        game.start();
    }

    public void pauseApp() {}

    public void destroyApp(boolean unconditional) {}
}
