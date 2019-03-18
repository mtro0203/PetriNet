package petri.net;

import java.util.ArrayList;
import java.util.List;

public class Transmission extends BaseElement {


    protected Transmission(long id, String name) {
        super(id, name);
    }

    private List<PlaceEdge> placeEdges = new ArrayList<>();
    private List<TransmissionEdge> transEdges = new ArrayList<>();


    public void addPlaceEdge (PlaceEdge edge){
        placeEdges.add(edge);
    }
    public void addTransmissionEdge (TransmissionEdge edge){ transEdges.add(edge); }

    public void run() throws IllegalTransmissionLaunchedException {
        checker();
        for (PlaceEdge p : placeEdges) {
            p.run();
        }

        for (TransmissionEdge tr : transEdges) {
            tr.run();
        }
    }


    private void checker() throws IllegalTransmissionLaunchedException {
        for (PlaceEdge p : placeEdges) {
            p.check();
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
    public void takeTokens(int count) throws IllegalTransmissionLaunchedException {

    }
}
