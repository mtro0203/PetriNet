package oop.graphics.ButtonListeners;

import oop.generated.Exceptions.UnableCreatePetriNetException;
import oop.generated.FileChooser;
import oop.generated.Transform;
import oop.graphics.Interface.NetCanvas;
import oop.petriNet.Interface.Net;
import java.awt.event.ActionEvent;


public class ImportListener extends BaseListener {

    public ImportListener(NetCanvas canvas, Net net) {
        super(canvas,net);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            net.clearNet();
            net = importNet();
            net.createGraphics(canvas);
            canvas.repaint();
        }
        catch (NullPointerException ex){
            System.out.println("Siet neexistuje");

        }
    }

    private Net importNet(){
        Transform tr = new Transform(new FileChooser().getPathToSelectedFile(),net);
        try {
            return tr.xml2PetriNet();
        }
        catch (UnableCreatePetriNetException e) {
            System.out.println(e.getErrorMessage());
            return null;
        }
    }
}
