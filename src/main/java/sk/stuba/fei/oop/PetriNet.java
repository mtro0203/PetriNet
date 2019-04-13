package petri.net;

import java.util.ArrayList;
import java.util.List;

public class PetriNet {

    private List<BaseElement> elements = new ArrayList<>();


    public void createTransition(int id, String name) {
        try {
            checkNames(id);
            elements.add(new Transition(id, name));
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

    public void createPlaceToTransitionEdge(long startPlaceId, long endTransition,int multiplicity){
        try {
            Transition transition = getTransition(findElement(endTransition));
            transition.addPlaceEdge(new PlaceEdge(getPlace (getPlace(findElement(startPlaceId))),transition,multiplicity));
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

    public void createTransitionToPlaceEdge(long startTransitionId, long endPlaceId, int multiplicity){
        try {
           Transition transition = getTransition(findElement(startTransitionId));
            transition.addTransmissionEdge(new TransitionEdge(transition,getPlace (findElement(endPlaceId)),multiplicity));
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


    public void createRessetEdge(long startPlaceId, long endTransitionId){

        try {
            Transition transition = getTransition(findElement(endTransitionId));
            transition.addResetEdge(new ResetEdge(getPlace(findElement(startPlaceId)),transition));
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








}
