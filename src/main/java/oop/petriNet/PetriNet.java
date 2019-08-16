package oop.petriNet;

import oop.graphics.Interface.NetCanvas;
import oop.petriNet.Interface.Net;
import oop.petriNet.edges.*;
import oop.petriNet.elements.BaseElement;
import oop.petriNet.elements.Place;
import oop.petriNet.elements.Transition;
import oop.petriNet.exceptions.DuplicateException;
import oop.petriNet.exceptions.ElementDoNotExistException;
import oop.petriNet.exceptions.GraphicsExeption;
import oop.petriNet.exceptions.IllegalTransitionLaunchedException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


//TODO spravit funckiu na vymazanie elementu podla ?? (id), pridat ju do interfacu

public class PetriNet implements Net {

    private List<BaseElement> elements = new ArrayList<BaseElement>();
    private long idHelper = 0;

    public void createTransition(long id, String name) {
        try {
            checkIdies(id);
            elements.add(new Transition(id, name));
        } catch (DuplicateException ex) {
            System.out.println(ex.getErrorMessage());
        }
    }
    public void createTransition(String name){
        createTransition(getId(),name);
    }

    public void createTransition(long id, String name,float x , float y) {
        try {
            checkIdies(id);
            elements.add(new Transition(id, name,x,y));
        } catch (DuplicateException ex) {
            System.out.println(ex.getErrorMessage());
        }
    }

    public void createTransition(String name,float x , float y){
        createTransition(getId(),name,x,y);
    }


    public void createPlace(long id, String name, int startTokens){
        try {
            checkIdies(id);
            elements.add(new Place(id,name,startTokens));
        } catch (DuplicateException ex) {
            System.out.println(ex.getErrorMessage());
        }
    }

    public void createPlace(String name, int startTokens){
        createPlace(getId(),name,startTokens);
    }
    public void createPlace(long id, String name, int startTokens,float x, float y){
        try {
            checkIdies(id);
            elements.add(new Place(id,name,startTokens,x,y));
        } catch (DuplicateException ex) {
            System.out.println(ex.getErrorMessage());
        }
    }

    public void createPlace(String name, int startTokens,float x, float y){
        createPlace(getId(),name,startTokens,x,y);
    }

    public void createPlaceToTransitionEdge(long startPlaceId, long endTransition,int multiplicity,long id){
        try {
            checkIdies(id);
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
        catch (DuplicateException ex) {
            System.out.println(ex.getErrorMessage());
        }
    }

    public void createPlaceToTransitionEdge(long startPlaceId, long endTransition,int multiplicity){
        createPlaceToTransitionEdge(startPlaceId,endTransition,multiplicity,getId());
    }

    public void createTransitionToPlaceEdge(long startTransitionId, long endPlaceId, int multiplicity,long id){
        try {
            checkIdies(id);
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
        catch (DuplicateException ex) {
            System.out.println(ex.getErrorMessage());
        }
    }

    public void createTransitionToPlaceEdge(long startTransitionId, long endPlaceId, int multiplicity){
        createTransitionToPlaceEdge(startTransitionId,endPlaceId,multiplicity,getId());
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

    public void createEdge(long startId, long endId, int multiplicity){
        createEdge(startId,endId,multiplicity,getId());
    }

    public void createRessetEdge(long startPlaceId, long endTransitionId,long id){

        try {
            checkIdies(id);
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
            System.out.println("Nieje mozne vytvorit takuto hranu");
        }
        catch (DuplicateException ex) {
            System.out.println(ex.getErrorMessage());
        }
    }

    public void createRessetEdge(long startPlaceId, long endTransitionId){
        createRessetEdge(startPlaceId,endTransitionId,getId());
    }


    public <T extends BaseElement> List<T> getElements(Class<T> type){

        List<T>  tElements = new ArrayList<T>();

        for (BaseElement el: elements) {
            try {
                tElements.add(type.cast(el));
            }
            catch (ClassCastException ex){

            }
        }
        return tElements;
    }

    public void setMultiplicity(long id, int multi){
        for (Transition tr: getElements(Transition.class)) {
           Edge edge_ = tr.getEdges(Edge.class).stream().filter(edge -> edge.getId() == id)
                    .findAny()
                    .orElse(null);

            if (edge_ == null)
                continue;
            else {
                try {
                    edge_.setMultiplicity(edge_.getMultiplicity()+multi);
                }

                catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
            }
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

    private void checkIdies(long id) throws DuplicateException {

        try {
           checkEdgeIdies(id);
           findElement(id);
           throw new DuplicateException("Objekt s id " +id + " nazvom uz existuje");
        }
        catch (ElementDoNotExistException ex) {

        }
    }

    private void checkEdgeIdies(long id) throws DuplicateException {

        for (Transition tr : getElements(Transition.class)) {
            if (tr.getEdge(id) != null) {
                throw new DuplicateException("Objekt s id " + id + " nazvom uz existuje");
            }
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

        canvas.clear();
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
        canvas.repaint();
    }


    private void checkCoordinates() throws GraphicsExeption {
        for (BaseElement element: elements){
            if(element.getX() == -1 || element.getY() == -1){
                throw new GraphicsExeption("Nieje mozne vytvorit grafiku pre tuto siet. Elementy nemaju nastavene suradnice");
            }
        }
    }

    public void clearNet(){
        idHelper = 0;
        elements.clear();
    }

    //TODO GENEROVANIE IDECIEK
    private long idGenerator(long id)  {
        idHelper++;
        try {
            checkIdies(idHelper);
            return idHelper;
        } catch (DuplicateException e) {
            return idGenerator(idHelper);
        }
    }

    private long getId(){
       return idGenerator(idHelper);
    }


    public void addToken(long id, int count){
        try {
            Place place = getPlace(findElement(id));
            place.setTokens(place.getTokens()+count);
        }
        catch (ClassCastException ex){
            System.out.println("Tokeny je mozne pridavat iba miestam");
        }

        catch (IllegalArgumentException ex){
            ex.getMessage();
        }

        catch (ElementDoNotExistException ex) {
            System.out.println(ex.getErrorMessage());
        }
    }

    public void removeElement(long id){

        for( BaseElement el : elements){
            if(el.getId() == id){
                //ak to co najdem je prechod mozem ho zmazat
                try {
                    getTransition(findElement(id));
                    elements.remove(el);
                    return;
                }
                //ak je to miesto musim zmaza aj vsetky hrany ktore s mim suvisia
                catch (ClassCastException ex){
                    removeEdge(edge -> (edge.getEndElement().getId() == id || edge.getStartElement().getId() == id));
                    elements.remove(el);
                    return;
                }

                catch (ElementDoNotExistException ex) {
                    System.out.println(ex.getErrorMessage());
                }
            }
        }

        //ak sa to dostane az sem treba vymazat hranu
        removeEdge(edge -> edge.getId() == id);
    }

    private void removeEdge(Predicate<BaseEdge> predicate){
        for (Transition tr : getElements(Transition.class)) {
            tr.getEdges().removeIf(predicate);
        }
    }


}
