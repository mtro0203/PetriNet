package oop.graphics.Modes;


import oop.graphics.Interface.Element;
import oop.graphics.Interface.NetCanvas;
import oop.petriNet.Interface.Net;

import java.awt.event.MouseEvent;

public class AddEdgeMode extends EdgeHandler {

    public AddEdgeMode(Net net, NetCanvas canvas) {
        super(net,canvas);
    }

    //TODO: dorobit generovanie ideciek

    public void mouseClicked(MouseEvent e) {
      edgeHandler(e.getX(),e.getY());
    }

    @Override
    void addEdge(long startId, long endId) {
        net.createEdge(startId,endId,1);
        net.createGraphics(canvas);
    }




}
