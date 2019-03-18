package petri.net;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	 PetriNet net = new PetriNet();
	net.createTransmission(1,"t");
	net.createTransmission(2,"t");
	net.createPlace(1,"p",0);
	net.createTransmissionsToPlaceEdge(1,1,5);

	net.createPlace(2,"p",0);
	net.createTransmission(3,"t");
	net.createPlaceToTransmissionEdge(2,3,1);

	net.createPlace(3,"p",1);
	net.createTransmission(4,"t");
	net.createPlaceToTransmissionEdge(3,4,1);
	net.createTransmissionsToPlaceEdge(4,3,2);
	net.run(4);



    }
}
