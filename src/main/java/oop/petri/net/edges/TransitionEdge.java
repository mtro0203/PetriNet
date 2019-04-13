package oop.petri.net.edges;

import oop.petri.net.elements.*;



public class TransitionEdge extends Edge<Transition,Place> {

    public TransitionEdge(Transition startElement, Place endElement, int multiplicity) {
        super(startElement, endElement, multiplicity);
    }

    @Override
    public void run() {
        getEndElement().receiveTokens(this.getMultiplicity());
        System.out.println(getEndElement().getInfo());
    }
}
