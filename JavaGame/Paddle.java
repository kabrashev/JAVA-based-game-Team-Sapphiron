package OurGAME;
import java.awt.*;

public class Paddle extends Structure implements OurGAME.Constants {

    private double x;
    private final int POSITIONY = Constants.HEIGHT - 100;
    private int width, height;
    private Color color;

    public Paddle(int x, int y, int width, int height, Color color ){
        super(x, y, width, height, color);
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