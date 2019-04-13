package oop.petri.net.edges;

import oop.petri.net.elements.*;
import oop.petri.net.exceptions.*;



public class ResetEdge extends BaseEdge<Place,Transition> {


    public ResetEdge(Place startElement, Transition endElement) {
        super(startElement, endElement);
    }

    @Override
    public void run() throws IllegalTransitionLaunchedException {

        int tokens = getStartElement().getTokens();
        getStartElement().takeTokens(tokens);
        System.out.println(getStartElement().getInfo());
    }
}
