import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.GameCanvas;

public class GameCanvas extends GameCanvas implements Runnable {

    private boolean running = true;
    private Thread thread;
    private Player player;

    public GameCanvas() {
        super(true);
        player = new Player(50, 600);
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        Graphics g = getGraphics();

        while (running) {
            update();
            render(g);
            flushGraphics();

            try { Thread.sleep(33); } catch (Exception e) {}
        }
    }

    private void update() {
        int key = getKeyStates();
        player.update(key);
    }

    private void render(Graphics g) {
        g.setColor(0x000000);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(0x003366);
        g.fillRect(0, 500, getWidth(), 300);

        player.draw(g);
    }
}
