package oop.petriNet.edges;

import oop.petriNet.elements.BaseElement;
import oop.petriNet.exceptions.IllegalTransitionLaunchedException;


public abstract class BaseEdge<T extends BaseElement, V extends BaseElement> {

    protected BaseEdge(T startElement,V endElement) {

        this.setStartElement(startElement);
        this.setEndElement(endElement);
    }

    private  T startElement;

    public T getStartElement() { return startElement; }

    public void setStartElement(T startElement) {
        if(startElement == null)
            throw new IllegalArgumentException("Zaciatok hrany nemoze byt null");
       this.startElement = startElement;
    }

    private V endElement;

    public V getEndElement() {
        return endElement;
    }

    public void setEndElement(V endElement)  {

        if(endElement == null)
            throw new IllegalArgumentException("Koniec hrany nemoze byt null");

        if (getStartElement().getClass() == endElement.getClass())
            throw new IllegalArgumentException("Hrana sa neda vytvorit medzi dvoma vyrcholmi rovnakeho typu");

        this.endElement = endElement;
    }

    public abstract void run() throws IllegalTransitionLaunchedException;


}
