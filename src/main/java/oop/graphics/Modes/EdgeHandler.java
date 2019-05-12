package oop.graphics.Modes;

import oop.graphics.Elements.OrientedEdge;
import oop.graphics.Interface.Element;
import oop.graphics.Interface.NetCanvas;
import oop.petriNet.Interface.Net;

public abstract class EdgeHandler extends BaseMode{

    private Long firstId = null;
    private Element first ;

    public EdgeHandler(Net net, NetCanvas canvas) {
        super(net, canvas);
    }

    protected void edgeHandler(int x, int y){
        if (firstId == null){
            for (Element el: canvas.getElements()) {
                if(el.isClicked(x,y) && !(el instanceof OrientedEdge)){
                    first = el;
                    firstId = el.getId();
                    el.clicked(true);
                    canvas.repaint();
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
            first.clicked(false);
            canvas.repaint();
        }
    }

    abstract void addEdge(long startId, long endId);
}
