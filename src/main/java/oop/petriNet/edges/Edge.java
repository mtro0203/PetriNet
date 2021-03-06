package oop.petriNet.edges;

import oop.petriNet.elements.BaseElement;


public abstract class Edge<T extends BaseElement, V extends BaseElement> extends BaseEdge<T,V> {

    private int multiplicity;

    public int getMultiplicity() {
        return multiplicity;
    }

    public void setMultiplicity(int multiplicity) {

        if (multiplicity < 1)
            throw new IllegalArgumentException("Hrana nesmie mat nasobnost menisiu ako 1");

        this.multiplicity = multiplicity;
    }

    protected Edge(T startElement, V endElement, int multiplicity,long id) {
        super(startElement, endElement, id);
        this.setMultiplicity(multiplicity);
    }

}
