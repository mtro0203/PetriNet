package oop.petriNet.elements;

import java.util.ArrayList;
import java.util.List;

import oop.petriNet.edges.BaseEdge;
import oop.petriNet.edges.PlaceEdge;
import oop.petriNet.exceptions.IllegalTransitionLaunchedException;

public class Transition extends BaseElement {



    public Transition(long id, String name) {
        super(id, name);
    }

    public Transition(long id, String name, float x, float y) {
        super(id, name, x, y);
    }

    private List<BaseEdge> edges = new ArrayList<BaseEdge>();
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
        System.out.println("Prechod s " + getId() + " spusteny");
        for (BaseEdge edge: edges) {
            edge.run();
        }
    }

    public void checker() throws IllegalTransitionLaunchedException {
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
