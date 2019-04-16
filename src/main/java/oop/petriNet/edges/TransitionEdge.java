package oop.petriNet.edges;

import oop.petriNet.elements.Place;
import oop.petriNet.elements.Transition;


public class TransitionEdge extends Edge<Transition, Place> {

    public TransitionEdge(Transition startElement, Place endElement, int multiplicity,long id) {
        super(startElement, endElement, multiplicity,id);
    }

    @Override
    public void run() {
        getEndElement().receiveTokens(this.getMultiplicity());
        System.out.println(getEndElement().getInfo());
    }
}
