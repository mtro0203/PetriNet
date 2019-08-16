package oop.graphics.ButtonListeners;


import oop.graphics.Interface.NetCanvas;
import oop.petriNet.Interface.Net;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class BaseListener implements ActionListener {

    protected NetCanvas canvas;
    protected Net net;


    public BaseListener(NetCanvas canvas, Net net) {
        this.net = net;
        this.canvas = canvas;
    }

    public abstract void actionPerformed(ActionEvent e);
}
