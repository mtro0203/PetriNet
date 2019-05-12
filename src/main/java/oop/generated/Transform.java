package oop.generated;

import oop.generated.Exceptions.UnableCreatePetriNetException;
import oop.petriNet.Interface.Net;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class Transform {

    private String path;
    private Net net;

    public Transform(String path, Net net) {
        this.path = path;
        this.net = net;
    }


    public Net xml2PetriNet() throws UnableCreatePetriNetException {
        try {
           return createNet(getXmlDocument(path));
        }
        catch (JAXBException e) {
            System.out.println("Nebolo mozne importovat vybrany dokument");
        }
        catch (FileNotFoundException e) {
            System.out.println("Subor nenajdeny");
        }

        throw new UnableCreatePetriNetException("Nebolo mozne vytvorit Petri siet");
    }


    private Document getXmlDocument(String path) throws JAXBException, FileNotFoundException {

        InputStream resource = new FileInputStream(path);
        JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Document) jaxbUnmarshaller.unmarshal(resource);
    }


    private Net createNet(Document document) {

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
                net.createRessetEdge(edge.getSourceId(),edge.getDestinationId(),edge.getId());
            }
            else{
                net.createEdge(edge.getSourceId(),edge.getDestinationId(),edge.getMultiplicity(),edge.getId());
            }
        }
        return net;
    }
}







