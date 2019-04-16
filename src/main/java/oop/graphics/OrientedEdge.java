package oop.graphics;


import oop.graphics.Interface.Element;
import oop.petriNet.edges.BaseEdge;

import java.awt.*;

public class OrientedEdge extends Arrow implements Element {

    private BaseEdge edge;

    public OrientedEdge(BaseEdge edge) {
        super((int) edge.getStartElement().getX()+40,(int)edge.getStartElement().getY()+20,(int)edge.getEndElement().getX()+20,(int)edge.getEndElement().getY()+25);
        this.edge = edge;
    }


    public void draw(Graphics2D graphics2D) {
        graphics2D.setPaint(Color.BLACK);
        drawArrow(graphics2D);
    }

    public long getId() {
        return edge.getId();
    }

    public void onClick(float x, float y) {

    }
}
