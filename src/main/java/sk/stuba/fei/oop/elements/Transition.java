package petri.net;

import java.util.ArrayList;
import java.util.List;

public class Transition extends BaseElement {



    protected Transition(long id, String name) {
        super(id, name);
    }


    private List<BaseEdge> edges = new ArrayList<>();
    private int countOfPlaceEdges = 0;

    private void incrementCountOfPlaceEdges() {
        this.countOfPlaceEdges ++;
    }

    public void addPlaceEdge (BaseEdge edge){
        edges.add(0,edge);
        incrementCountOfPlaceEdges();
    }

    public void addTransmissionEdge (BaseEdge edge){ edges.add(edge); }

    public void addResetEdge(BaseEdge edge){ edges.add(edge); }


    public void run() throws IllegalTransitionLaunchedException {

        checker();
        for (BaseEdge edge: edges) {
            edge.run();
        }
    }

    private void checker() throws IllegalTransitionLaunchedException {
        PlaceEdge placeEdge;
        for (int i = 0; i<countOfPlaceEdges; i++) {

            try {
                placeEdge = (PlaceEdge)edges.get(i);
                placeEdge.check();
            }

            catch (ClassCastException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

}
