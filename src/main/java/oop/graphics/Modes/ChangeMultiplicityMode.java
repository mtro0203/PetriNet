package oop.graphics.Modes;


import oop.graphics.Interface.Element;
import oop.graphics.Interface.NetCanvas;
import oop.petriNet.Interface.Net;

import java.awt.event.MouseEvent;

public class ChangeMultiplicityMode extends BaseMode {

    public ChangeMultiplicityMode(Net net, NetCanvas canvas) {
        super(net,canvas);
    }

    public void mouseClicked(MouseEvent e) {
        for (Element el: canvas.getElements()) {
            if (el.isClicked(e.getX(), e.getY())) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                   net.setMultiplicity(el.getId(),1);
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    net.setMultiplicity(el.getId(),-1);
                }
            }
        }
        canvas.repaint();
    }




}
