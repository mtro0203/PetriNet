package oop.graphics.Interface;

import oop.petriNet.edges.BaseEdge;
import oop.petriNet.elements.BaseElement;


public interface NetCanvas {

    void addGraphicsElement(BaseElement element);
    void addGraphicsEdge(BaseEdge edge);

}
