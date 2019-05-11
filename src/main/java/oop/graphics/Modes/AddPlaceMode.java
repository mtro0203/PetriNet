package oop.graphics.Modes;


import oop.graphics.Interface.NetCanvas;
import oop.petriNet.Interface.Net;

import java.awt.event.MouseEvent;

public class AddPlaceMode extends BaseMode {

    public AddPlaceMode(Net net, NetCanvas canvas) {
        super(net,canvas);
    }

    public void mouseClicked(MouseEvent e) {
        net.createPlace("",0,e.getX(),e.getY());
        net.createGraphics(canvas);
    }
}
