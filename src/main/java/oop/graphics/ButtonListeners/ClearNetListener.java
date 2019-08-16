package oop.graphics.ButtonListeners;

import oop.graphics.Interface.Element;
import oop.graphics.Interface.NetCanvas;
import oop.graphics.Modes.RunMode;
import oop.petriNet.Interface.Net;

import java.awt.event.ActionEvent;

public class ClearNetListener extends BaseListener {

    public ClearNetListener(NetCanvas canvas, Net net) {
        super(canvas, net);
    }

    public void actionPerformed(ActionEvent e) {
       net.clearNet();
       net.createGraphics(canvas);
    }
}
