package JavaGame;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;

    // Tези 2те ще се вземат от CONSTANTS!
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    public Display(){
        this.frame = new JFrame("Brick Breaker Game version 1.1.1");
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.frame.setLocationRelativeTo(null);
        this.frame.setIconImage(Toolkit.getDefaultToolkit().getImage("JavaGame/Images/Icon.png"));

    }
}
