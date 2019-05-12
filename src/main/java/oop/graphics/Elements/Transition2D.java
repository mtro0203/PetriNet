package oop.graphics.Elements;
import oop.graphics.Interface.Element;
import oop.petriNet.elements.Transition;
import oop.petriNet.exceptions.IllegalTransitionLaunchedException;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Transition2D extends Rectangle2D.Float implements Element {

    private Transition transition;

    private boolean runMode = false;
    private boolean highlighted = false;

    public Transition2D(Transition transition){
        super(transition.getX(),transition.getY(),40,40);
        this.transition = transition;
    }




    public void draw(Graphics2D graphics2D) {
        graphics2D.setPaint(Color.BLACK);
        graphics2D.draw(this);
        graphics2D.drawString(""+transition.getName(),(int) getCenterX()-30,(int)getCenterY()+30);

        if(highlighted){
            graphics2D.setPaint(Color.GREEN);
            graphics2D.draw(this);
            graphics2D.drawString(""+transition.getName(),(int) getCenterX()-30,(int)getCenterY()+30);
        }

        if(runMode){
            try {
                transition.checker();
                graphics2D.setPaint(Color.green);
                graphics2D.fill(this);
            }
            catch (IllegalTransitionLaunchedException e) {

            }
        }

    }


    public long getId() {
        return transition.getId();
    }

    public void runMode(boolean param) {
        this.runMode = param;
    }

    public boolean isClicked(float x, float y) {
        return contains(x,y);
    }

    @Override
    public void clicked(boolean param) {
            highlighted = param;
    }

}
