package oop.graphics.Elements;


import oop.graphics.Interface.Element;
import oop.petriNet.edges.BaseEdge;
import oop.petriNet.edges.Edge;

import java.awt.*;

public class OrientedEdge extends Arrow implements Element {

    private BaseEdge edge;

    public OrientedEdge(BaseEdge edge) {
        super((int) edge.getStartElement().getX(),(int)edge.getStartElement().getY(),(int)edge.getEndElement().getX(),(int)edge.getEndElement().getY());
        this.edge = edge;
    }


    public void draw(Graphics2D graphics2D) {
        graphics2D.setPaint(Color.BLACK);
        drawArrow(graphics2D);
        graphics2D.drawString(getMultiplicity(),getCenterX(),getCenterY());
    }

    private String getMultiplicity() {
        try {
            Edge edge1 = (Edge)edge;
            return ""+edge1.getMultiplicity();
        }
        catch (ClassCastException ex){
            return "Resset";
        }
    }

    public long getId() {
        return edge.getId();
    }

    public boolean isClicked(float x, float y) {
        return intersects(x-7,y-7,15,15);
    }


    public void runMode(boolean param) {

    }

    public void clicked(boolean param) {

    }


}
