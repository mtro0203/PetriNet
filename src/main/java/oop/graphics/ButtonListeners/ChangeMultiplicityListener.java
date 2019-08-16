package oop.graphics.ButtonListeners;

import oop.graphics.Interface.NetCanvas;
import oop.graphics.Modes.ChangeMultiplicityMode;
import oop.graphics.Modes.DeleteMode;
import oop.petriNet.Interface.Net;

import java.awt.event.ActionEvent;


public class ChangeMultiplicityListener extends BaseListener {


    public ChangeMultiplicityListener(NetCanvas canvas, Net net) {
        super(canvas,net);
    }

    public void actionPerformed(ActionEvent e) {
        canvas._deleteMouseListener();
        canvas._addMouseListener(new ChangeMultiplicityMode(net,canvas));
    }
}
