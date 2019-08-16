package oop.graphics.ButtonListeners;

import oop.generated.*;
import oop.generated.Exceptions.UnableCreatePetriNetException;
import oop.graphics.Interface.NetCanvas;
import oop.petriNet.Interface.Net;
import oop.petriNet.elements.Place;
import oop.petriNet.elements.Transition;


import java.awt.event.ActionEvent;
import java.util.List;


public class ExportListener extends BaseListener {

    public ExportListener(NetCanvas canvas, Net net) {
        super(canvas,net);
    }

    public void actionPerformed(ActionEvent e) {

        new Export(net).exportToXml(new FileChooser().choosePathtoDirectory());

    }






}
