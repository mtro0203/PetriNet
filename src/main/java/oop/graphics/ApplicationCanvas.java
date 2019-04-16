package oop.graphics;

import oop.generated.FileChooser;
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

public class ApplicationCanvas extends Canvas implements NetCanvas, MouseListener {

    private List<Element> elements;


    public ApplicationCanvas(){
        elements = new ArrayList<Element>();
        addMouseListener(this);
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
        for (Element el :elements) {
            el.onClick(e.getX(),e.getY());
        }
        repaint();
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
