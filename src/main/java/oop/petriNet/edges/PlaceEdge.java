package oop.petriNet.edges;


import oop.petriNet.elements.Place;
import oop.petriNet.elements.Transition;
import oop.petriNet.exceptions.IllegalTransitionLaunchedException;


public class PlaceEdge extends Edge<Place, Transition> {


    public  PlaceEdge(Place startElement, Transition endElement, int multiplicity) {
        super(startElement, endElement, multiplicity);
    }

    @Override
    public void run() throws IllegalTransitionLaunchedException {
        getStartElement().takeTokens(this.getMultiplicity());
        System.out.println(getStartElement().getInfo());
    }

    public void check() throws IllegalTransitionLaunchedException {
        if(getStartElement().getTokens() < this.getMultiplicity())
            throw new IllegalTransitionLaunchedException("Tento prechod nieje mozne spustit",getEndElement().getId());
    }
}
