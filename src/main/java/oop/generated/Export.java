package oop.generated;

import oop.generated.Exceptions.UnableCreatePetriNetException;
import oop.petriNet.Interface.Net;

import javax.xml.bind.JAXBContext;

import oop.petriNet.edges.BaseEdge;
import oop.petriNet.edges.Edge;
import oop.petriNet.edges.ResetEdge;
import oop.petriNet.elements.*;
import javax.xml.bind.Marshaller;
import java.io.File;


public class Export {

    private String path;
    private Net net;

    public Export(Net net) {
        this.net = net;
    }


    public void exportToXml(String path){
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            ObjectFactory of = new ObjectFactory();
            Document document = of.createDocument();
            marshalTransition(document,of);
            marshalPlaces(document,of);

            File file = new File(path+ ".xml");


            marshaller.marshal(document,file);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    private void marshalTransition(Document document, ObjectFactory of){
        for (oop.petriNet.elements.Transition tr : net.getElements(oop.petriNet.elements.Transition.class)) {
            Transition transition =of.createTransition();
            transition.setId((int)tr.getId());
            transition.setX((int)tr.getX());
            transition.setY((int)tr.getY());
            transition.setLabel(tr.getName());
            document.getTransition().add(transition);
            marshalEdges(document,of,tr);
        }
    }

    private void marshalEdges(Document document, ObjectFactory of, oop.petriNet.elements.Transition transition){

        for (Edge edge : transition.getEdges(Edge.class)){
            Arc arc = of.createArc();
            arc.setId((int)edge.getId());
            arc.setSourceId((int)(edge.getStartElement().getId()));
            arc.setDestinationId((int)(edge.getEndElement().getId()));
            arc.setMultiplicity(edge.getMultiplicity());
            arc.setType(ArcType.REGULAR);
            document.getArc().add(arc);
        }

        for (ResetEdge resetEdge : transition.getEdges(ResetEdge.class)) {
            Arc arc = of.createArc();
            arc.setId((int)resetEdge.getId());
            arc.setSourceId((int)(resetEdge.getStartElement().getId()));
            arc.setDestinationId((int)(resetEdge.getEndElement().getId()));
            arc.setType(ArcType.RESET);
            document.getArc().add(arc);

        }

    }

    private void marshalPlaces(Document document, ObjectFactory of){
        for (oop.petriNet.elements.Place pl : net.getElements(oop.petriNet.elements.Place.class)) {
             Place place =of.createPlace();
            place.setId((int)pl.getId());
            place.setX((int)pl.getX());
            place.setY((int)pl.getY());
            place.setLabel(pl.getName());
            document.getPlace().add(place);
        }
    }
}







