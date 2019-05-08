package oop.graphics.Modes;


import oop.graphics.Interface.NetCanvas;
import oop.petriNet.Interface.Net;

import java.awt.event.MouseEvent;

public class AddTrasitionMode extends BaseMode {

    public AddTrasitionMode(Net net, NetCanvas canvas) {
        super(net,canvas);
    }


    //TODO: dorobit generovanie ideciek

    public void mouseClicked(MouseEvent e) {
        net.createTransition(2115161,"",e.getX(),e.getY());
        net.createGraphics(canvas);
    }
}