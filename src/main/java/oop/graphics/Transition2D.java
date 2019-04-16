package oop.graphics;

import oop.graphics.Interface.Drawable;
import oop.graphics.Interface.Element;
import oop.petriNet.elements.Transition;
import oop.petriNet.exceptions.IllegalTransitionLaunchedException;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

    private void run(){
        try {
            transition.run();
        }
        catch (IllegalTransitionLaunchedException e) {
            e.getErrorMessage();
        }
    }



}
