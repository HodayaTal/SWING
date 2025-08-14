import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private ScenePanel scenePanel;

    public void setScenePanel (ScenePanel scenePanel) {
        this.scenePanel = scenePanel;
    }

    public MenuPanel (int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        GridLayout gridLayout = new GridLayout(4, 1);
        this.setLayout(gridLayout);
        JLabel text = new JLabel("Press a button");
        JButton button1 = new JButton("Stop");
        button1.addActionListener((event) -> {
            if (this.scenePanel != null) {
                this.scenePanel.stopBalls();
            }
        });
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        this.add(text);
        this.add(button1);
        this.add(button2);
        this.add(button3);
    }




}
