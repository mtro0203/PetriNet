package oop.graphics.Modes;


import oop.graphics.Interface.Element;
import oop.graphics.Interface.NetCanvas;
import oop.petriNet.Interface.Net;

import java.awt.event.MouseEvent;

public class AddRessetEdgeMode extends EdgeHandler {

    public AddRessetEdgeMode(Net net, NetCanvas canvas) {
        super(net,canvas);
    }

    public void mouseClicked(MouseEvent e) {
        edgeHandler(e.getX(),e.getY());
    }

    @Override
    void addEdge(long startId, long endId) {
        net.createRessetEdge(startId,endId);
        net.createGraphics(canvas);
    }


}
