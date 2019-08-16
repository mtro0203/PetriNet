package oop.graphics.Elements;

import oop.graphics.Interface.Element;
import oop.petriNet.elements.Place;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Place2D extends Ellipse2D.Float implements Element {

    Place place;
    private boolean highlighted = false;

    public Place2D(Place place){
       super(place.getX(),place.getY(),40,40);
        this.place = place;
    }

    public void draw(Graphics2D graphics2D){
        graphics2D.setPaint(Color.BLACK);
        graphics2D.draw(this);

        if(highlighted){
            graphics2D.setPaint(Color.GREEN);
            graphics2D.draw(this);

        }

        graphics2D.drawString(""+place.getTokens(),(int) getCenterX(),(int)getCenterY());
        graphics2D.drawString(place.getName(),(int) getCenterX(),(int)getCenterY()+35);
    }


    public long getId() {
       return place.getId();

    }

    @Override
    public void runMode(boolean param) {

    }

    @Override
    public void clicked(boolean param) {
        highlighted = param;
    }


    public boolean isClicked(float x, float y) {
        return contains(x,y);
    }
}
