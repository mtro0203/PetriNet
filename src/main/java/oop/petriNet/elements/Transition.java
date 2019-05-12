package oop.petriNet.elements;

import java.util.ArrayList;
import java.util.List;

import oop.petriNet.edges.BaseEdge;
import oop.petriNet.edges.PlaceEdge;
import oop.petriNet.exceptions.DuplicateException;
import oop.petriNet.exceptions.IllegalTransitionLaunchedException;

public class Transition extends BaseElement {



    public Transition(long id, String name) {
        super(id, name);
    }

    public Transition(long id, String name, float x, float y) {
        super(id, name, x, y);
    }

    public List<BaseEdge> getEdges() {
        return edges;
    }

    private List<BaseEdge> edges = new ArrayList<BaseEdge>();
    private int countOfPlaceEdges = 0;

    public BaseEdge getEdge(long id)  {
        for (BaseEdge edge :edges) {
            if(edge.getId() == id)
                return edge;
        }
        return null;
    }

    private void incrementCountOfPlaceEdges() {
        this.countOfPlaceEdges ++;
    }

    public void addPlaceEdge (BaseEdge edge){
        try {
            edgeAlreadyExist(edge.getStartElement().getId(),edge.getEndElement().getId());
            edges.add(0,edge);
            incrementCountOfPlaceEdges();
        }

        catch (DuplicateException ex){
            System.out.println(ex.getErrorMessage());
        }

    }

    public <T extends BaseEdge> List<T> getEdges(Class<T> type){
        List<T>  tElements = new ArrayList<T>();
        for (BaseEdge el: edges) {
            try {
                tElements.add(type.cast(el));
            }
            catch (ClassCastException ex){
            }
        }
        return tElements;
    }

    public void addTransmissionEdge (BaseEdge edge){
        try {
            edgeAlreadyExist(edge.getStartElement().getId(),edge.getEndElement().getId());
            edges.add(edge);
        } catch (DuplicateException ex) {
            System.out.println(ex.getErrorMessage());
        }

    }

    public void addResetEdge(BaseEdge edge){
        try {
            edgeAlreadyExist(edge.getStartElement().getId(),edge.getEndElement().getId());
            edges.add(edge);
        } catch (DuplicateException ex) {
            System.out.println(ex.getErrorMessage());
        }

    }

    public void edgeAlreadyExist(long start, long end) throws DuplicateException {
        for (BaseEdge edge: edges) {
            if(edge.getStartElement().getId() == start && edge.getEndElement().getId() == end)
                throw new DuplicateException("Hrana uz exsituje");
        }
    }


    public void run() throws IllegalTransitionLaunchedException {

        checker();
        System.out.println("Prechod s id " + getId() + " spusteny");
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
