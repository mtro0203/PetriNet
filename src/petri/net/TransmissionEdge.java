package petri.net;

public class TransmissionEdge extends Edge<Transmission> {

    protected TransmissionEdge(Transmission startElement, BaseElement endElement, int multiplicity) {
        super(startElement, endElement, multiplicity);
    }

    @Override
    public void run() {

        try {
            Place place = (Place)getEndElement();
            place.receiveTokens(this.getMultiplicity());
        }

        catch (ClassCastException ex){
            System.out.println(ex.getMessage());
        }



    }
}
