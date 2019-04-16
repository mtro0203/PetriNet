package oop.graphics;

import oop.generated.FileChooser;
import oop.graphics.Interface.Drawable;
import oop.graphics.Interface.NetCanvas;
import oop.petriNet.elements.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class ApplicationCanvas extends Canvas implements NetCanvas {

    private List<Drawable> elements;


    public ApplicationCanvas(){

        elements = new ArrayList<Drawable>();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        for (Drawable el : elements){
            el.draw((Graphics2D)g);
        }

    }

    public void addElement(BaseElement element) {
        try {
            addGraphicsPlace(element);
        }

        catch (ClassCastException e ){
            addGraphicsTransition(element);
        }
    }

    private void addGraphicsPlace(BaseElement element){
       Place place = (Place)element;
        elements.add(new Place2D(place));
    }

    private void addGraphicsTransition(BaseElement element){
        Transition transition = (Transition)element;
        elements.add(new Transition2D(transition));
    }



}
