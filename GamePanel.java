import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

//Това тук е картината, която се добавя  Display класа. 

public class GamePanel extends JPanel {

  //Булева стойност, при която играта "тече". При инициализация на GamePanel running = true
    boolean running;
  //Това ще е картината, която постоянно се обновява
    private BufferedImage image;
  // С Graphics се рисува.
    private Graphics2D g;

  //Това са компонентите на играта - засега съм сложил paddle и ball 
    private Ball ball;
    private Paddle paddle;

  //Конструктор без параметри, който извиква init() т.е. инициализация
    public GamePanel(){
        init();
    }

  //Инициализация - инациализирате се компонентите на играта катo ball, paddle, картината по горе и running = true
    public void init(){
    
        ball = new Ball();
        paddle = new Paddle();

        running = true;
        
        image = new BufferedImage(Display.WIDTH, Display.HEIGHT, BufferedImage.TYPE_INT_RGB);

        g = (Graphics2D) image.getGraphics();
        //Това изчиства образа няма да е на пиксели 
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void playGame(){
        //това е GameLoop-а - докато running = true, се извиква update(), draw, repaint

        while(running){
            // променя параметрите - например кординатите на ball
            update();
            //рисува картината
            draw();
            //изобразява картината
            repaint();

            try{
                Thread.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void update(){
        // Трябва да се сложи какво ще се променя, например кординатите на ball
    }

    public void draw(){
        //Basckground - бял цвят и от и размерите на екрана
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Display.WIDTH, Dispay.HEIGHT);
        
        //Рисуване на компонентите 
        ball.draw(g);
        paddle.draw(g);
    }

 // Това обновява каритната
    public void paintComponent(Graphics g){

        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(image, 0, 0, Display.WIDTH, Display.HEIGHT, null);

        g2.dispose();

    }
}
