package oop.graphics.Modes;

import oop.graphics.Interface.Element;
import oop.graphics.Interface.NetCanvas;
import oop.petriNet.Interface.Net;
import java.awt.event.MouseEvent;

public class RunMode extends BaseMode {

    public RunMode(Net net, NetCanvas canvas) {
        super(net, canvas);
    }

    public void mouseClicked(MouseEvent e) {
        for (Element el: canvas.getElements()) {
            if(el.isClicked(e.getX(),e.getY())){
                net.run(el.getId());
                break;
            }
        }
        canvas.repaint();
    }
}
