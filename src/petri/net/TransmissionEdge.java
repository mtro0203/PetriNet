package petri.net;

public class TransmissionEdge extends Edge<Transmission,Place> {

    protected TransmissionEdge(Transmission startElement, Place endElement, int multiplicity) {
        super(startElement, endElement, multiplicity);
    }

    @Override
    public void run() {
        getEndElement().receiveTokens(this.getMultiplicity());
    }
}
