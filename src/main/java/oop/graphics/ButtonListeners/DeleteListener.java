package oop.graphics.ButtonListeners;

import oop.graphics.Interface.NetCanvas;
import oop.graphics.Modes.AddTransitionMode;
import oop.graphics.Modes.DeleteMode;
import oop.petriNet.Interface.Net;

import java.awt.event.ActionEvent;


public class DeleteListener extends BaseListener {


    public DeleteListener(NetCanvas canvas, Net net) {
        super(canvas,net);
    }

    public void actionPerformed(ActionEvent e) {
        canvas._deleteMouseListener();
        canvas._addMouseListener(new DeleteMode(net,canvas));
    }
}
