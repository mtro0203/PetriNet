package petri.net;

public class PlaceEdge extends Edge<Place> {


    protected PlaceEdge(Place startElement, BaseElement endElement, int multiplicity) {
        super(startElement, endElement, multiplicity);
    }

    @Override
    public void run() throws IllegalTransmissionLaunchedException {
        getStartElement().takeTokens(this.getMultiplicity());
    }

    public void check() throws IllegalTransmissionLaunchedException {
        if(getStartElement().getTokens() < this.getMultiplicity())
            throw new IllegalTransmissionLaunchedException("Tento prechod nieje mozne spustit",getEndElement().getId());
    }


}
