package oop.graphics.Interface;

import oop.petriNet.PetriNet;
import oop.petriNet.edges.BaseEdge;
import oop.petriNet.elements.BaseElement;

import java.awt.event.MouseListener;
import java.util.List;


public interface NetCanvas {

    void addGraphicsElement(BaseElement element);
    void addGraphicsEdge(BaseEdge edge);

    void repaint();
    void clear();

    void _addMouseListener(MouseListener listener);
    void _deleteMouseListener();

    List<Element> getElements();
}
