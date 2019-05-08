package oop.graphics.Elements;

import oop.graphics.Interface.Drawable;
import oop.graphics.Interface.Element;
import oop.graphics.Interface.NetCanvas;
import oop.petriNet.edges.BaseEdge;
import oop.petriNet.elements.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class ApplicationCanvas extends Canvas implements NetCanvas {

    public List<Element> getElements() {
        return elements;
    }

    private List<Element> elements;


    public ApplicationCanvas(){
        elements = new ArrayList<Element>();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        for (Drawable el : elements){
            el.draw((Graphics2D)g);
        }
    }

    public void addGraphicsElement(BaseElement element) {
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

    public void _addMouseListener(MouseListener listener){
        this.addMouseListener(listener);
    }

    public void _deleteMouseListener(){
        for(MouseListener listener : getMouseListeners()){
            this.removeMouseListener(listener);
        }

    }
    private void addGraphicsTransition(BaseElement element){
        Transition transition = (Transition)element;
        elements.add(new Transition2D(transition));
    }

    public void addGraphicsEdge(BaseEdge edge){
        elements.add(new OrientedEdge(edge));
    }



    public void clear(){
        elements.clear();
    }

    public void mouseClicked(MouseEvent e) {

    }

}
