package oop.graphics;
import oop.graphics.Interface.Element;
import oop.petriNet.elements.Transition;
import oop.petriNet.exceptions.IllegalTransitionLaunchedException;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Transition2D extends Rectangle2D.Float implements Element {

    private Transition transition;


    public Transition2D(Transition transition){
        super(transition.getX(),transition.getY(),40,40);
        this.transition = transition;
    }



    public void draw(Graphics2D graphics2D) {
        graphics2D.setPaint(Color.BLACK);
        graphics2D.draw(this);
        graphics2D.drawString(""+transition.getName(),(int) getCenterX()-30,(int)getCenterY()+30);

        try {
            transition.checker();
            graphics2D.setPaint(Color.green);
            graphics2D.fill(this);
        }
        catch (IllegalTransitionLaunchedException e) {

        }

    }


    public long getId() {
        return transition.getId();
    }

    public void onClick(float x, float y) {
        if(this.contains(x,y))
        run();
    }

    private void run(){
        try {
            transition.run();
        }
        catch (IllegalTransitionLaunchedException e) {
            e.getErrorMessage();
        }
    }

}
