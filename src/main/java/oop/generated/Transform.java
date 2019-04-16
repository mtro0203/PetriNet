package oop.generated;

import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import oop.generated.Exceptions.UnableCreatePetriNetException;
import oop.petriNet.PetriNet;

public class Transform {

    private String path;
    private PetriNet net;

    public Transform(String path) {
        this.path = path;
        net = new PetriNet();
    }


    public PetriNet xml2PetriNet() throws UnableCreatePetriNetException {
        try {
           return createNet(getXmlDocument(path));
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        throw new UnableCreatePetriNetException("Nebolo mozne vytvorit Petri siet");
    }

    public PetriNet getNet(){return  net;}

    private Document getXmlDocument(String path) throws JAXBException, FileNotFoundException {

        InputStream resource = new FileInputStream(path);
        JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Document) jaxbUnmarshaller.unmarshal(resource);
    }


    private PetriNet createNet(Document document) {

        List<Place> places = document.getPlace();
        List<Transition> transitions = document.getTransition();
        List<Arc> edges = document.getArc();


        for (Place place : places) {
            net.createPlace(place.getId(), place.getLabel(), place.getTokens(),place.getX(),place.getY());
        }

        for (Transition transition : transitions) {
            net.createTransition(transition.getId(), transition.getLabel(),transition.getX(),transition.getY());
        }

        for (Arc edge : edges){
            if (edge.getType() == ArcType.RESET){
                net.createRessetEdge(edge.getSourceId(),edge.getDestinationId());
            }
            else{
                net.createEdge(edge.getSourceId(),edge.getDestinationId(),edge.getMultiplicity());
            }
        }
        return net;
    }
}







