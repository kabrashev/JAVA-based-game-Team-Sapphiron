package JavaGame;

import javax.swing.*;

public class Main implements Constants {
    private static JFrame frame;
    private static GamePanel gamePanel;

    public static void main(String[] args) {

        // Show a image in the center of the screen for certain amount of time
        showSplash(1000, "images/splash.jpg");

        // Display a JFrame instance
        createFrame("Brick Breaker Game version 1.1.1");

        // Adds the gamePanel to the frame
        gamePanel = new GamePanel();
        frame.add(gamePanel);
        gamePanel.run();

    }

    private static void showSplash(int duration, String imagePath) {
        // Build the splash screen
        JWindow window = new JWindow();
        window.getContentPane().add(new JLabel(new ImageIcon(imagePath), SwingConstants.CENTER));
        window.pack();
        window.setLocationRelativeTo(null);

        // Display it
        window.setVisible(true);

        // Wait a little while, maybe while loading resources
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Close it
        window.setVisible(false);
    }

    private static void createFrame(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(Constants.WIDTH, Constants.HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(new ImageIcon("images/icon.png").getImage());
        frame.setVisible(true);

    }

}