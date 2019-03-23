package petri.net;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	 PetriNet net = new PetriNet();

	net.createTransmission(1,"t");
	net.run(1);

	net.createTransmission(2,"t");
	net.createPlace(3,"p",0);
	net.createTransitionToPlaceEdge(2,3,5);
	net.run(2);

	net.createPlace(4,"p",0);
	net.createTransmission(5,"t");
	net.createPlaceToTransitionEdge(4,5,1);
	net.run(5);

	net.createPlace(6,"p",1);
	net.createTransmission(7,"t");
	net.createPlaceToTransitionEdge(6,7,1);
	net.createTransitionToPlaceEdge(7,6,2);
	net.run(7);


	net.createPlace(8,"p",1);
	net.createPlace(9,"p",5);
	net.createPlace(10,"p",0);
	net.createPlace(11,"p",0);
	net.createTransmission(12,"t");
	net.createPlaceToTransitionEdge(8,12,1);
	net.createRessetEdge(9,12);
	net.createTransitionToPlaceEdge(12,10,1);
	net.createTransitionToPlaceEdge(12,11,1);
	net.run(12);
    }
}

