package oop.graphics.ButtonListeners;

import oop.graphics.Interface.Element;
import oop.graphics.Interface.NetCanvas;
import oop.graphics.Modes.RunMode;
import oop.petriNet.Interface.Net;

import java.awt.event.ActionEvent;

public class RunListener extends BaseListener {

    public RunListener(NetCanvas canvas, Net net) {
        super(canvas, net);
    }

    public void actionPerformed(ActionEvent e) {
        run();
        canvas._deleteMouseListener();
        canvas._addMouseListener(new RunMode(net,canvas));
    }


    private void run(){
        for (Element el :canvas.getElements()) {
            el.onRun();
        }
        canvas.repaint();
    }


}
