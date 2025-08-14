import java.awt.*;

public class Ball {
    public static final int SIZE = 30;
    private int x, y;

    public Ball (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void fall () {
        this.y++;
    }

    public void paint (Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillOval(this.x, this.y, SIZE, SIZE);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
