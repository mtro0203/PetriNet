package oop.graphics.Modes;


import oop.graphics.Interface.Element;
import oop.graphics.Interface.NetCanvas;
import oop.petriNet.Interface.Net;

import java.awt.event.MouseEvent;

public class AddEdgeMode extends BaseMode {

    public AddEdgeMode(Net net, NetCanvas canvas) {
        super(net,canvas);
    }

    private Long firstId = null;

    //TODO: dorobit generovanie ideciek

    public void mouseClicked(MouseEvent e) {
       edgeHandler(e.getX(),e.getY());
    }

    private void edgeHandler(int x, int y){
        if (firstId == null){
            for (Element el: canvas.getElements()) {
                if(el.isClicked(x,y)){
                    firstId = el.getId();
                }
            }
        }
        else {
            for (Element el: canvas.getElements()) {
                if(el.isClicked(x,y)){
                    addEdge(firstId,el.getId());
                    break;
                }
            }
            firstId = null;
        }
    }

    private void addEdge(long startId, long endId){
        net.createEdge(startId,endId,1);
        net.createGraphics(canvas);
    }


}
