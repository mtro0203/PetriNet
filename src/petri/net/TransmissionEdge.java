package petri.net;

public class TransmissionEdge extends Edge<Transmission> {

    protected TransmissionEdge(Transmission startElement, BaseElement endElement, int multiplicity) {
        super(startElement, endElement, multiplicity);
    }

    @Override
    public void run() {
         getEndElement().receiveTokens(this.getMultiplicity());
    }
}
