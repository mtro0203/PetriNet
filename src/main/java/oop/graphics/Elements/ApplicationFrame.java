package oop.graphics.Elements;

import oop.graphics.ButtonListeners.*;
import oop.graphics.Buttons.*;
import oop.petriNet.PetriNet;


import java.awt.*;
import java.awt.event.*;

public class ApplicationFrame extends Frame {

    private ApplicationCanvas canvas;
    private PetriNet net = new PetriNet();


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

        canvas = new ApplicationCanvas();

        Panel buttonPanel = new Panel();

        ImportBtn importBtn = new ImportBtn("Import");
        ExportBtn exportBtn = new ExportBtn("Export");
        ClearNetBtn clearNetBtn = new ClearNetBtn("Delete net");
        AddPlaceBtn addPlaceBtn = new AddPlaceBtn("Add Place");
        AddTransitionBtn addTransitionBtn = new AddTransitionBtn("Add Transition");
        AddEdgeBtn addEdgeBtn = new AddEdgeBtn("Add edge");
        AddRessetEdgeBtn addRessetEdgeBtn = new AddRessetEdgeBtn("Add resset edge");
        TokenBtn tokenBtn = new TokenBtn("Tokens");
        ChangeMultiplicityBtn changeMultiplicityBtn = new ChangeMultiplicityBtn("Multiplicity");
        DeleteButton deleteButton = new DeleteButton("Delete");
        RunBtn runBtn = new RunBtn("Run");


        importBtn.addActionListener(new ImportListener(canvas,net));
        exportBtn.addActionListener(new ExportListener(canvas,net));
        clearNetBtn.addActionListener(new ClearNetListener(canvas,net));
        addPlaceBtn.addActionListener(new AddPlaceListener(canvas,net));
        addTransitionBtn.addActionListener(new AddTransitionListener(canvas,net));
        addEdgeBtn.addActionListener(new AddEdgeListener(canvas,net));
        addRessetEdgeBtn.addActionListener(new AddRessetEdgeListener(canvas,net));
        tokenBtn.addActionListener(new ChangeTokenListener(canvas,net));
        changeMultiplicityBtn.addActionListener(new ChangeMultiplicityListener(canvas,net));
        deleteButton.addActionListener(new DeleteListener(canvas,net));
        runBtn.addActionListener(new RunListener(canvas,net));

        buttonPanel.add(importBtn);
        buttonPanel.add(exportBtn);
        buttonPanel.add(clearNetBtn);
        buttonPanel.add(addPlaceBtn);
        buttonPanel.add(addTransitionBtn);
        buttonPanel.add(addEdgeBtn);
        buttonPanel.add(addRessetEdgeBtn);
        buttonPanel.add(tokenBtn);
        buttonPanel.add(changeMultiplicityBtn);
        buttonPanel.add(deleteButton);
        buttonPanel.add(runBtn);

        setBackground(new Color(255, 255, 255));
        setLayout(new BorderLayout());
        add(canvas,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.NORTH);
        setVisible(true);

    }

}
