import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ScenePanel extends JPanel {
    public static final int BALLS_AMOUNT = 3;
    private Player player;
    private Ball[] balls;
    private boolean stop;

    public ScenePanel (int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        this.player = new Player(this);
        this.balls = new Ball[BALLS_AMOUNT];
        Random random = new Random();
        for (int i = 0; i < this.balls.length; i++) {
            this.balls[i] = new Ball(random.nextInt(width), 0);
        }
        this.stop = false;
        this.mainGameLoop();
    }

    private void mainGameLoop () {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            this.setFocusable(true);
            this.requestFocus();
            this.addKeyListener(new MovementListener(this));
            while (true) {
                for (Ball ball : this.balls) {
                    if (!this.stop) {
                        ball.fall();
                    }
                    if (this.checkCollision(ball)) {
                        this.player.die();
                    }
                }
                this.repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }).start();

    }

    public void paintComponent (Graphics graphics) {
        super.paintComponent(graphics);
        if (this.player.isAlive()) {
            this.player.paint(graphics);
        }
        for (Ball ball : this.balls) {
            ball.paint(graphics);
        }
    }

    public Player getPlayer () {
        return this.player;
    }

    private boolean checkCollision (Ball ball) {
        Rectangle ballRect = new Rectangle(ball.getX(), ball.getY(), Ball.SIZE, Ball.SIZE);
        Rectangle playerRect = new Rectangle(this.player.getX(), this.player.getY(), Player.SIZE, Player.SIZE);
        if (ballRect.intersects(playerRect)) {
            return true;
        } else {
            return false;
        }
    }

    public void stopBalls () {
        this.stop = !this.stop;
    }
}
