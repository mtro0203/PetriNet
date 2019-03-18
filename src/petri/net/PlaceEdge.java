package petri.net;

public class PlaceEdge extends Edge<Place> {


    protected PlaceEdge(Place startElement, BaseElement endElement, int multiplicity) {
        super(startElement, endElement, multiplicity);
    }

    @Override
    public void run() throws IllegalTransmissionLaunched {
        getStartElement().takeTokens(this.getMultiplicity());
    }
}
