package JavaGame;

import java.awt.*;

public class Ball {

    private double x;
    private double y;
    private double directionX;
    private double directionY;

    private int ballSize = 30;

    public Ball(){

        x = 200;
        y = 200;
        directionX = 1;
        directionY = 3;
    }
    public double getX(){
        return x;
    }

    public void setX(double x){
        this.x = x;
    }

    public double getY(){
        return y;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getDirectionX(){
        return directionX;
    }

    public void setDirectionX(double direction){
        directionX = direction;
    }

    public double getDirectionY(){
        return directionY;
    }

    public void setDirectionY(double direction){
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

    public  Rectangle getRect(){
        return new Rectangle((int)x, (int)y, ballSize, ballSize);
    }

}
