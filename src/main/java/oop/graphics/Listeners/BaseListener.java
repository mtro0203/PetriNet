package oop.graphics.Listeners;

import oop.graphics.ApplicationCanvas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class BaseListener implements ActionListener {

    private ApplicationCanvas canvas;

    public ApplicationCanvas getCanvas() {
        return canvas;
    }

    public void setCanvas(ApplicationCanvas canvas) {
        this.canvas = canvas;
    }

    public abstract void actionPerformed(ActionEvent e);
}
