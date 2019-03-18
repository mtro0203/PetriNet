package petri.net;

public class ResetEdge extends BaseEdge<Place> {


    protected ResetEdge(Place startElement, BaseElement endElement) {
        super(startElement, endElement);
    }

    @Override
    public void run() throws IllegalTransmissionLaunchedException {

        int tokens = getEndElement().getTokens();

        getEndElement().takeTokens(tokens);
    }
}