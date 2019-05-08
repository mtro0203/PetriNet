package oop.graphics.Elements;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.lang.Object;
public class Arrow extends Line2D.Float {

    private final int ARR_SIZE = 6;

    private int x1;
    private int y1;
    private int x2;
    private int y2;


    public Arrow(int x1, int y1, int x2, int y2) {
        this.x1 = x1+20;
        this.y1 = y1+20;
        this.x2 = x2+20;
        this.y2 = y2+20;

        setPoints();

    }

    public int getCenterX(){
        return (x1+x2)/2;
    }

    public int getCenterY(){
        return (y1+y2)/2;
    }

    private void setPoints(){
        double dx = x2 - x1, dy = y2 - y1;

        double angle = Math.atan2(dy, dx);
        double degrees =  Math.toDegrees(angle);

        if(degrees < 0.0){
            degrees += 360;
        }

        if(degrees>=45 && degrees <135){
            moveY(20);
        }

        else if(degrees>=135 && degrees <225){
            moveX(-20);
        }

        else if(degrees>=225 && degrees <315){
            moveY(-20);
        }

        else if(degrees>=315 || degrees <=45){
            moveX(20);
        }


    }

    void moveX(int n){this.x1 +=n;}
    void moveY(int n){this.y1 +=n;}


    void drawArrow(Graphics g1) {
        Graphics2D g = (Graphics2D) g1.create();

        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy, dx);
        int len = (int) Math.sqrt(dx*dx + dy*dy)-20;
        AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
        at.concatenate(AffineTransform.getRotateInstance(angle));
        g.transform(at);
        g.drawLine(0, 0, len, 0);
        g.fillPolygon(new int[] {len, len-ARR_SIZE, len-ARR_SIZE, len},
                new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);
    }


}

