package petri.net;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	 PetriNet petriNet = new PetriNet();

	 Transmission transmission = petriNet.createTransmission(5,"neeviem");

	 Place place = petriNet.createPlace(1,"a",4);

	 petriNet.createPlaceToTransmissionEdge(place,transmission,6);

	 petriNet.run();






    }
}
