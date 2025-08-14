import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementListener implements KeyListener {
    private ScenePanel scenePanel;
    private boolean right;
    private boolean left;
    private boolean up;
    private boolean down;


    public MovementListener (ScenePanel scenePanel) {
        this.scenePanel = scenePanel;
        this.right = false;
        this.left = false;
        this.up = false;
        this.down = false;
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT -> this.right = true;
            case KeyEvent.VK_LEFT -> this.left = true;
            case KeyEvent.VK_UP -> this.up = true;
            case KeyEvent.VK_DOWN -> this.down = true;
        }
        if (this.right) {
            this.scenePanel.getPlayer().moveRight();
        }
        if (this.left) {
            this.scenePanel.getPlayer().moveLeft();
        }
        if (this.up) {
            this.scenePanel.getPlayer().moveUp();
        }
        if (this.down) {
            this.scenePanel.getPlayer().moveDown();
        }

    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT -> this.right = false;
            case KeyEvent.VK_LEFT -> this.left = false;
            case KeyEvent.VK_UP -> this.up = false;
            case KeyEvent.VK_DOWN -> this.down = false;
        }
    }
}
