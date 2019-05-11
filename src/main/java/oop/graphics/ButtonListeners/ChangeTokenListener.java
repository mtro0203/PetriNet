package oop.graphics.ButtonListeners;

import oop.graphics.Interface.NetCanvas;
import oop.graphics.Modes.AddPlaceMode;
import oop.graphics.Modes.ChangeTokenMode;
import oop.petriNet.Interface.Net;

import java.awt.event.ActionEvent;


public class ChangeTokenListener extends BaseListener {


    public ChangeTokenListener(NetCanvas canvas, Net net) {
        super(canvas,net);
    }

    public void actionPerformed(ActionEvent e) {
        canvas._deleteMouseListener();
        canvas._addMouseListener(new ChangeTokenMode(net,canvas));
    }
}
