package petri.net;

import java.util.ArrayList;
import java.util.List;

public class Transmission extends BaseElement {


    protected Transmission(long id, String name) {
        super(id, name);
    }

    private List<BaseEdge> edges = new ArrayList<BaseEdge>();

    public void addTransmissionEdge (BaseEdge edge){
        edges.add(edge);
    }
    public void addPlaceEdge (BaseEdge edge){ edges.add(0,edge); }

    public void run() throws IllegalTransmissionLaunched {

        for ( BaseEdge edge : edges) {
            edge.run();
        }
    }

    @Override
    public int getTokens() {
        return 0;
    }

    @Override
    public void receiveTokens(int count) {

    }

    @Override
    public void takeTokens(int count) throws IllegalTransmissionLaunched {

    }
}
