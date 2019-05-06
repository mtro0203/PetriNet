package oop.graphics;

import oop.generated.Exceptions.UnableCreatePetriNetException;
import oop.generated.FileChooser;
import oop.generated.Transform;
import oop.petriNet.PetriNet;


import java.awt.*;
import java.awt.event.*;

public class ApplicationFrame extends Frame implements ActionListener {

    private ApplicationCanvas canvas;
    private PetriNet net;


    public ApplicationFrame(){


        setLayout(new BorderLayout());

        addWindowListener(
                new WindowAdapter(){
                    public void windowClosing (WindowEvent e){
                        dispose(); System.exit(0);
                    }
                }
        );

        setSize(700,400);

        Panel ButtonPanel = new Panel();
        Button impo = new Button("Import");
        impo.addActionListener(this);
        ButtonPanel.add(impo);

        canvas = new ApplicationCanvas();

        setBackground(new Color(255, 255, 255));
        setLayout(new BorderLayout());
        add(canvas,BorderLayout.CENTER);
        add(ButtonPanel,BorderLayout.NORTH);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Import")){

            try {
                net = importNet();
                net.createGraphics(canvas);
                canvas.repaint();
            }
           catch (NullPointerException ex){

           }

        }
    }

    private PetriNet importNet(){
        FileChooser fc = new FileChooser(canvas);
        Transform tr = new Transform(fc.getPathToSelectedFile());
        try {
            canvas.clear();
            return tr.xml2PetriNet();
        }
        catch (UnableCreatePetriNetException e) {
            System.out.println(e.getErrorMessage());
            return null;
        }


    }
}
