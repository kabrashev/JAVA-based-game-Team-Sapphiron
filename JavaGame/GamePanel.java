import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    //Fields running is true, when the game is running, image is what we show, g is drawing on the image 
    boolean running;
    private BufferedImage image;
    private Graphics2D g;
    //add the ball and the paddle 
    private Ball ball;
    private Paddle paddle;

    public GamePanel(){

        ball = new Ball();

        paddle = new Paddle();

        running = true;

        image = new BufferedImage(BBMain.WIDTH, BBMain.HEIGHT, BufferedImage.TYPE_INT_RGB);

        g = (Graphics2D) image.getGraphics();

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    }


    public void playGame(){
        //Game Loop

        while(running){
            //Update
            update();
            //Draw
            draw();
            //displayImage
            repaint();

            try{
                Thread.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void update(){
      //Update
    }

    public void draw(){
        //Basckground
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, BBMain.WIDTH, BBMain.HEIGHT);

        ball.draw(g);
        paddle.draw(g);
    }


     @Override
    public void paintComponent(Graphics g){

        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(image, 0, 0, BBMain.WIDTH, BBMain.HEIGHT, null);

        g2.dispose();

    }
  }
