import java.awt.*;

public class Paddle {

    private double x;
    private final int POSITIONY = Constants.HEIGHT - 100;
    private int width, height;

    public Paddle(){
        width = 100;
        height = 20;
        x = Constants.WIDTH/2 - width/2;
    }

    public void update(){
    }

    public void draw(Graphics2D g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect((int) x, POSITIONY, width, height);
    }

    public Rectangle getRect(){
        return new Rectangle((int) x, POSITIONY, width, height);
    }
}
