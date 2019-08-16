package oop.petriNet.edges;

import oop.petriNet.elements.Place;
import oop.petriNet.elements.Transition;
import oop.petriNet.exceptions.IllegalTransitionLaunchedException;


public class ResetEdge extends BaseEdge<Place, Transition> {


    public ResetEdge(Place startElement, Transition endElement,long id) {
        super(startElement, endElement, id);
    }

    @Override
    public void run() throws IllegalTransitionLaunchedException {

        int tokens = getStartElement().getTokens();
        getStartElement().takeTokens(tokens);
        System.out.println(getStartElement().getInfo());
    }
}
