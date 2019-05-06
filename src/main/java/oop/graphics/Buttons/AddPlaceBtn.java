package oop.graphics.Buttons;

import oop.graphics.ApplicationCanvas;

import java.awt.*;
import java.awt.event.ActionListener;

public class AddPlaceBtn extends BaseBtn {
    public AddPlaceBtn(String label, ApplicationCanvas canvas) throws HeadlessException {
        super(label, canvas);
    }

    @Override
    public synchronized void addActionListener(ActionListener listener) {
        super.addActionListener(listener);
    }
}
