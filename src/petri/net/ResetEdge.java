package petri.net;

public class ResetEdge extends BaseEdge<Place,Transmission> {


    protected ResetEdge(Place startElement, Transmission endElement) {
        super(startElement, endElement);
    }

    @Override
    public void run() throws IllegalTransmissionLaunchedException {

        int tokens = getStartElement().getTokens();
        getStartElement().takeTokens(tokens);
    }
}
