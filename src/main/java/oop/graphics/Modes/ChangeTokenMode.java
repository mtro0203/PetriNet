package oop.graphics.Modes;

import oop.graphics.Interface.Element;
import oop.graphics.Interface.NetCanvas;
import oop.petriNet.Interface.Net;

import java.awt.event.MouseEvent;

public class ChangeTokenMode extends BaseMode {

    public ChangeTokenMode(Net net, NetCanvas canvas) {
        super(net, canvas);
    }

    Element element;

    public void mouseClicked(MouseEvent e) {
        for (Element el: canvas.getElements()) {
            if(el.isClicked(e.getX(),e.getY())){
                element = el;
                break;
            }
        }
      if(e.getButton() == MouseEvent.BUTTON1){
          net.addToken(element.getId(),1);
      }

      else if (e.getButton() == MouseEvent.BUTTON3){
          net.addToken(element.getId(),-1);
      }

      canvas.repaint();
    }
}
