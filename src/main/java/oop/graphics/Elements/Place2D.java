package oop.graphics.Elements;


import oop.graphics.Interface.Drawable;
import oop.graphics.Interface.Element;
import oop.petriNet.elements.Place;
import oop.petriNet.exceptions.ElementDoNotExistException;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Place2D extends Ellipse2D.Float implements Element {

    Place place;

    public Place2D(Place place){
       super(place.getX(),place.getY(),40,40);
        this.place = place;
    }

    public void draw(Graphics2D graphics2D){
        graphics2D.setPaint(Color.BLACK);
        graphics2D.draw(this);
        graphics2D.drawString(""+place.getTokens(),(int) getCenterX(),(int)getCenterY());
        graphics2D.drawString(place.getName(),(int) getCenterX(),(int)getCenterY()+35);
    }


    public long getId() {
       return place.getId();

    }

    public void runMode() {

    }

    public void run() {

    }


    public boolean isClicked(float x, float y) {
        return contains(x,y);
    }
}
