package oop.graphics.ButtonListeners;

import oop.graphics.Interface.NetCanvas;
import oop.graphics.Modes.AddEdgeMode;
import oop.graphics.Modes.AddPlaceMode;
import oop.petriNet.Interface.Net;

import java.awt.event.ActionEvent;


public class AddEdgeListener extends BaseListener {


    public AddEdgeListener(NetCanvas canvas, Net net) {
        super(canvas,net);
    }

    public void actionPerformed(ActionEvent e) {
        canvas._deleteMouseListener();
        canvas._addMouseListener(new AddEdgeMode(net,canvas));
    }
}
