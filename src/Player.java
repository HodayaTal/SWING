import java.awt.*;

public class Player {
    public static final int SIZE = 40;
    private ScenePanel scenePanel;

    private int x, y;
    private boolean alive;

    public Player (ScenePanel scenePanel) {
        this.scenePanel = scenePanel;
        this.x = scenePanel.getWidth() / 2;
        this.y = scenePanel.getHeight() / 2;
        this.alive = true;
    }

    public void die () {
        this.alive = false;
    }

    public void moveRight () {
        if (this.x < this.scenePanel.getWidth() - SIZE) {
            this.x++;
        }
    }

    public void moveLeft () {
        if (this.x > 0) {
            this.x--;
        }
    }

    public void moveUp () {
        if (this.y > 0) {
            this.y--;
        }
    }

    public void moveDown () {
        this.y++;
    }

    public void paint (Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(this.x, this.y, SIZE, SIZE);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isAlive() {
        return alive;
    }
}
