import javax.swing.*;

public class Main {
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setLayout(null);

        MenuPanel menuPanel = new MenuPanel(0, 0, WINDOW_WIDTH / 4, WINDOW_HEIGHT);
        window.add(menuPanel);

        ScenePanel scenePanel = new ScenePanel(menuPanel.getWidth(), 0, WINDOW_WIDTH * 3 / 4, WINDOW_HEIGHT);
        menuPanel.setScenePanel(scenePanel);
        window.add(scenePanel);
        window.setVisible(true);
    }
}
