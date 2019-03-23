package petri.net;

public class ResetEdge extends BaseEdge<Place,Transition> {


    protected ResetEdge(Place startElement, Transition endElement) {
        super(startElement, endElement);
    }

    @Override
    public void run() throws IllegalTransitionLaunchedException {

        int tokens = getStartElement().getTokens();
        getStartElement().takeTokens(tokens);
        System.out.println(getStartElement().getInfo());
    }
}
