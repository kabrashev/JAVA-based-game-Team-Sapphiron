package JavaGame;

import java.awt.*;

public class Ball {

    private int x;
    private int y;
    private int directionX;
    private int directionY;

    private int ballSize = 30;

    public Ball(){

        x = 200;
        y = 200;
        directionX = 1;
        directionY = 1;
    }
    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getDirectionX(){
        return directionX;
    }

    public void setDirectionX(int direction){
        directionX = direction;
    }

    public int getDirectionY(){
        return directionY;
    }

    public void setDirectionY(int direction){
        directionY = direction;
    }

    public void update(){
        setPosition();
    }

    public void setPosition(){
        x += directionX;
        y += directionY;

        //if it hit a wall, inverse direction
        if(x < 0){
            directionX = -directionX;
        }

        if(y < 0){
            directionY = -directionY;
        }

        if(x > Main.WIDTH -  ballSize){
            directionX =  -directionX;
        }

        if(y > Main.HEIGHT - ballSize){
            directionY = -directionY;
        }
    }

    public void draw(Graphics2D g){
        g.setColor(Color.DARK_GRAY);
        g.fillOval((int)x,(int) y, ballSize, ballSize);
    }

    public void reset() {
        x = 245;
        y = 245;
        directionX = 1;
        directionY = 1;
    }

    public  Rectangle getRect(){
        return new Rectangle((int)x, (int)y, ballSize, ballSize);
    }

}
