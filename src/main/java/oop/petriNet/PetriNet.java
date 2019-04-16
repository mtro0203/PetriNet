package oop.petriNet;

import java.util.ArrayList;
import java.util.List;

import oop.graphics.Interface.NetCanvas;
import oop.petriNet.edges.BaseEdge;
import oop.petriNet.edges.PlaceEdge;
import oop.petriNet.edges.ResetEdge;
import oop.petriNet.edges.TransitionEdge;
import oop.petriNet.elements.BaseElement;
import oop.petriNet.elements.Place;
import oop.petriNet.elements.Transition;
import oop.petriNet.exceptions.DuplicateException;
import oop.petriNet.exceptions.ElementDoNotExistException;
import oop.petriNet.exceptions.GraphicsExeption;
import oop.petriNet.exceptions.IllegalTransitionLaunchedException;


public class PetriNet {

    private List<BaseElement> elements = new ArrayList<BaseElement>();


    public void createTransition(int id, String name) {
        try {
            checkNames(id);
            elements.add(new Transition(id, name));
        } catch (DuplicateException ex) {
            System.out.println(ex.getErrorMessage());
        }
    }

    public void createTransition(int id, String name,float x , float y) {
        try {
            checkNames(id);
            elements.add(new Transition(id, name,x,y));
        } catch (DuplicateException ex) {
            System.out.println(ex.getErrorMessage());
        }
    }

    public void createPlace(long id, String name, int startTokens){
        try {
            checkNames(id);
            elements.add(new Place(id,name,startTokens));
        } catch (DuplicateException ex) {
            System.out.println(ex.getErrorMessage());
        }
    }

    public void createPlace(long id, String name, int startTokens,float x, float y){
        try {
            checkNames(id);
            elements.add(new Place(id,name,startTokens,x,y));
        } catch (DuplicateException ex) {
            System.out.println(ex.getErrorMessage());
        }
    }

    public void createPlaceToTransitionEdge(long startPlaceId, long endTransition,int multiplicity,long id){
        try {
            Transition transition = getTransition(findElement(endTransition));
            transition.addPlaceEdge(new PlaceEdge(getPlace (getPlace(findElement(startPlaceId))),transition,multiplicity,id));
        }
        catch (ElementDoNotExistException ex){
            System.out.println(ex.getErrorMessage());
        }

        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        catch (ClassCastException ex){
            System.out.println("Nespravne zadany zaciatok a koniec hrany");
        }
    }

    public void createTransitionToPlaceEdge(long startTransitionId, long endPlaceId, int multiplicity,long id){
        try {
           Transition transition = getTransition(findElement(startTransitionId));
            transition.addTransmissionEdge(new TransitionEdge(transition,getPlace (findElement(endPlaceId)),multiplicity,id));
        }
        catch (ElementDoNotExistException ex) {
            System.out.println(ex.getErrorMessage());
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        catch (ClassCastException ex){
            System.out.println("Nespravne zadany zaciatok a koniec hrany");
        }
    }

    public void createEdge(long startId, long endId, int multiplicity,long id){
        try {
            getPlace(findElement(startId));
            createPlaceToTransitionEdge(startId,endId,multiplicity,id);
        }
        catch (ClassCastException e){
            createTransitionToPlaceEdge(startId,endId,multiplicity,id);
        }
       catch (ElementDoNotExistException e) {
           System.out.println(e.getErrorMessage());
        }
    }

    public void createRessetEdge(long startPlaceId, long endTransitionId,long id){

        try {
            Transition transition = getTransition(findElement(endTransitionId));
            transition.addResetEdge(new ResetEdge(getPlace(findElement(startPlaceId)),transition,id));
        }

        catch (ElementDoNotExistException ex){
            System.out.println(ex.getErrorMessage());
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        catch (ClassCastException ex){
            System.out.println(ex.getMessage());
        }
    }


    public void run (long id){
        try {
            getTransition(findElement(id)).run();
        }
        catch(IllegalTransitionLaunchedException ex){
            System.out.println(ex.getErrorMessage());
            }
        catch (ElementDoNotExistException ex) {
            System.out.println(ex.getErrorMessage());
        }
        catch (ClassCastException ex){
            System.out.println("Je mozne spustat len prechod");
        }
    }

    private void checkNames(long id) throws DuplicateException {

        try {
           findElement(id);
           throw new DuplicateException("Objekt s id " +id + " nazvom uz existuje");
        }
        catch (ElementDoNotExistException ex) {

        }
    }

    private BaseElement findElement(long id) throws ElementDoNotExistException {
        for (BaseElement element: elements) {
            if(element.getId() == id)
                return element;
        }
        throw new ElementDoNotExistException("Objekt s id " + id + " neexistuje");
    }



    private Transition getTransition(BaseElement baseElement) throws ClassCastException  {
            return (Transition)baseElement;
    }


    private Place getPlace (BaseElement baseElement)throws ClassCastException {
            return (Place) baseElement;
    }


    public void createGraphics(NetCanvas canvas){

        for (BaseElement element :elements) {

            try {
                checkCoordinates();
                {
                    canvas.addGraphicsElement(element);

                    Transition tr = getTransition(element);
                    List<BaseEdge> edges = tr.getEdges();
                    for (BaseEdge edge : edges) {
                        canvas.addGraphicsEdge(edge);
                    }
                }

            } catch (GraphicsExeption e) {
                System.out.println(e.getErrorMessage());
            } catch (ClassCastException ex) {

            }

        }
    }


    private void checkCoordinates() throws GraphicsExeption {
        for (BaseElement element: elements){
            if(element.getX() == -1 || element.getY() == -1){
                throw new GraphicsExeption("Nieje mozne vytvorit grafiku pre tuto siet. Elementy nemaju nastavene suradnice");
            }
        }
    }









}
