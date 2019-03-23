package petri.net;

public class TransitionEdge extends Edge<Transition,Place> {

    protected TransitionEdge(Transition startElement, Place endElement, int multiplicity) {
        super(startElement, endElement, multiplicity);
    }

    @Override
    public void run() {
        getEndElement().receiveTokens(this.getMultiplicity());
        System.out.println(getEndElement().getInfo());
    }
}
