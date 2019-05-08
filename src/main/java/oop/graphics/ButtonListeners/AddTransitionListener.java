package oop.graphics.ButtonListeners;

import oop.graphics.Interface.NetCanvas;
import oop.graphics.Modes.AddTrasitionMode;
import oop.petriNet.Interface.Net;

import java.awt.event.ActionEvent;


public class AddTransitionListener extends BaseListener {


    public AddTransitionListener(NetCanvas canvas, Net net) {
        super(canvas,net);
    }

    public void actionPerformed(ActionEvent e) {
        canvas._deleteMouseListener();
        canvas._addMouseListener(new AddTrasitionMode(net,canvas));
    }
}
