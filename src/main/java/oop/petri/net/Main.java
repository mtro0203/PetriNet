package oop.petri.net;

import oop.petri.net.generated.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        PetriNet net = new PetriNet();

        net.createTransition(101,"t");



        net.createTransition(202,"t");
        net.createPlace(201,"p",0);
        net.createTransitionToPlaceEdge(202,201,5);


        net.createPlace(302,"p",0);
        net.createTransition(303,"t");
        net.createPlaceToTransitionEdge(302,303,1);


        net.createPlace(403,"p",1);
        net.createTransition(404,"t");
        net.createPlaceToTransitionEdge(403,404,1);
        net.createTransitionToPlaceEdge(404,403,2);



        net.createPlace(504,"p",1);
        net.createPlace(505,"p",5);
        net.createPlace(506,"p",0);
        net.createPlace(507,"p",0);
        net.createTransition(508,"t");
        net.createPlaceToTransitionEdge(504,508,1);
        net.createRessetEdge(505,508);
        net.createTransitionToPlaceEdge(508,506,1);
        net.createTransitionToPlaceEdge(508,507,1);
        net.run(404);



        try {

            File file = new File("C:/Users/marti/Desktop/zadanie.xml"); //todo: from file chooser
            JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Document document = (Document) jaxbUnmarshaller.unmarshal(file);


            System.out.println(document);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }
}
