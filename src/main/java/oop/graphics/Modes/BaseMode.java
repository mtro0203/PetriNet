package oop.graphics.Modes;

import oop.graphics.Interface.NetCanvas;
import oop.petriNet.Interface.Net;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class BaseMode implements MouseListener {



    protected Net net;
    protected NetCanvas canvas;


    public BaseMode(Net net, NetCanvas canvas) {
        this.net = net;
        this.canvas = canvas;
    }

    public abstract void mouseClicked(MouseEvent e);

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
