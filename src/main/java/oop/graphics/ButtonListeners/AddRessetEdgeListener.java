package oop.graphics.ButtonListeners;

import oop.graphics.Interface.NetCanvas;
import oop.graphics.Modes.AddEdgeMode;
import oop.graphics.Modes.AddRessetEdgeMode;
import oop.petriNet.Interface.Net;

import java.awt.event.ActionEvent;


public class AddRessetEdgeListener extends BaseListener {


    public AddRessetEdgeListener(NetCanvas canvas, Net net) {
        super(canvas,net);
    }

    public void actionPerformed(ActionEvent e) {
        canvas._deleteMouseListener();
        canvas._addMouseListener(new AddRessetEdgeMode(net,canvas));
    }
}
