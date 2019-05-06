package oop.graphics.Buttons;

import oop.graphics.ApplicationCanvas;

import java.awt.*;

public class BaseBtn extends Button {

    private ApplicationCanvas canvas;

    public BaseBtn(String label, ApplicationCanvas canvas) throws HeadlessException {
        super(label);
        this.canvas = canvas;
    }
}
