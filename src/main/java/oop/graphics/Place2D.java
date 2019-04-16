package oop.graphics;


import oop.graphics.Interface.Drawable;
import oop.graphics.Interface.Element;
import oop.petriNet.elements.Place;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Place2D extends Ellipse2D.Float implements Element {

    Place place;

    public Place2D(Place place){
       super(place.getX(),place.getY(),40,40);
        this.place = place;
    }

    public void draw(Graphics2D graphics2D){
        graphics2D.draw(this);
    }

    public long getId(){return place.getId();}







}
