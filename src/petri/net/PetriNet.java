package petri.net;

import java.util.ArrayList;
import java.util.List;

public class PetriNet {

    private List<Transmission> transmissions = new ArrayList<>();
    private List<Place> places = new ArrayList<>();

    public void createTransmission(int id, String name){
            transmissions.add(new Transmission(id, name));
        }


    public void createPlace(long id, String name, int startTokens){
        places.add(new Place(id,name,startTokens));
    }

    public void createPlaceToTransmissionEdge(long startPlaceId, long endTransmissionId,int multiplicity){
        try {
            Transmission transmission = findTransmission(endTransmissionId);
            transmission.addPlaceEdge(new PlaceEdge(findPlace(startPlaceId),transmission,multiplicity));
        }
        catch (ElementDoNotExistException ex){
            System.out.println(ex.getErrorMessage());
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void createTransmissionsToPlaceEdge(long startTransmissionId, long endPlaceId, int multiplicity){
        try {
           Transmission transmission = findTransmission(startTransmissionId);
            transmission.addTransmissionEdge(new TransmissionEdge(transmission,findPlace(endPlaceId),multiplicity));
        }
        catch (ElementDoNotExistException ex) {
            System.out.println(ex.getErrorMessage());
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void createRessetEdge(long startTransmissionId, long endPlaceId){
        try {
            Transmission transmission = findTransmission(startTransmissionId);
            transmission.addResetEdge(new ResetEdge(findPlace(endPlaceId),transmission));
        }

        catch (ElementDoNotExistException ex){
            System.out.println(ex.getErrorMessage());
        }
    }


    public void run (long id){
        try {
            findTransmission(id).run();
        }
        catch(IllegalTransmissionLaunchedException ex){
            System.out.println(ex.getErrorMessage());
            }

         catch (ElementDoNotExistException ex) {
            System.out.println(ex.getErrorMessage());
        }
    }


    private Transmission findTransmission(long id) throws ElementDoNotExistException {

        for (Transmission trans: transmissions) {

            if(trans.getId() == id)
                return trans;
        }

        throw new ElementDoNotExistException("Prechod s id " + id +" neexistuje");
    }

    private Place findPlace(long id) throws ElementDoNotExistException {
        for (Place p: places) {

            if(p.getId() == id)
                return p;
        }
        throw new ElementDoNotExistException("Miesto s id " + id +" neexistuje");
    }





}
