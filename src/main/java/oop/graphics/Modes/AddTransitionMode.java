package oop.graphics.Modes;


import oop.graphics.Interface.NetCanvas;
import oop.petriNet.Interface.Net;

import java.awt.event.MouseEvent;

public class AddTransitionMode extends BaseMode {

    public AddTransitionMode(Net net, NetCanvas canvas) {
        super(net,canvas);
    }


    //TODO: dorobit generovanie ideciek

    public void mouseClicked(MouseEvent e) {
        net.createTransition("",e.getX(),e.getY());
        net.createGraphics(canvas);
    }
}