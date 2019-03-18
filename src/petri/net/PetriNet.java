package petri.net;

import java.util.ArrayList;
import java.util.List;

public class PetriNet {

    private List<Transmission> transmissions = new ArrayList<>();

    public Transmission createTransmission(int id, String name){
        Transmission transmission = new Transmission(id, name);
        transmissions.add(transmission);

        return  transmission;
    }

    public Place createPlace(long id, String name, int startTokens){
        return new Place(id,name,startTokens);
    }

    public void createResetEdge(Place startPlace, Transmission endTransmission){
        ResetEdge resetEdge = new ResetEdge(startPlace,endTransmission);
        endTransmission.addPlaceEdge(resetEdge);
    }

    public void createPlaceToTransmissionEdge(Place startPlace, Transmission endTransmission,int multiplicity){
        PlaceEdge placeEdge = new PlaceEdge(startPlace,endTransmission,multiplicity);
        endTransmission.addPlaceEdge(placeEdge);
    }

    public void createTransMissionsToPlaceEdge(Transmission starTransmission, Place endPlace, int multiplicity){
        TransmissionEdge transmissionEdge = new TransmissionEdge(starTransmission,endPlace,multiplicity);
        starTransmission.addTransmissionEdge(transmissionEdge);
    }


    public void run (){
        try {
            transmissions.get(0).run();


        } catch (IllegalTransmissionLaunched ex) {
          System.out.println(ex.getErrorMessage());

        }
    }





}
