package petri.net;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	 PetriNet net = new PetriNet();

	net.createTransmission(1,"t");
	net.run(1);

	net.createTransmission(2,"t");
	net.createPlace(1,"p",0);
	net.createTransmissionsToPlaceEdge(1,1,1);
	net.run(2);

	net.createPlace(2,"p",0);
	net.createTransmission(3,"t");
	net.createPlaceToTransmissionEdge(2,3,1);
	net.run(3);

	net.createPlace(3,"p",1);
	net.createTransmission(4,"t");
	net.createPlaceToTransmissionEdge(3,4,1);
	net.createTransmissionsToPlaceEdge(4,3,2);
	net.run(4);


	net.createPlace(4,"p",1);
	net.createPlace(5,"p",5);
	net.createPlace(6,"p",0);
	net.createPlace(7,"p",0);
	net.createTransmission(5,"t");
	net.createPlaceToTransmissionEdge(4,5,1);
	net.createRessetEdge(5,5);
	net.createTransmissionsToPlaceEdge(5,6,1);
	net.createTransmissionsToPlaceEdge(5,7,1);
	net.run(5);








    }
}
