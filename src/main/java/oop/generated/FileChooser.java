package oop.generated;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;


public class FileChooser {

    private String path;


    public FileChooser(Canvas canvas){
        JButton confirm = new JButton();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileFilter() {

            public String getDescription() {
                return "xml Documents (*.xml)";
            }

            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".xml");
                }
            }
        });

        if(fileChooser.showOpenDialog(confirm) == JFileChooser.APPROVE_OPTION){
            path = fileChooser.getSelectedFile().getAbsolutePath();
        }
    }


    public String getPathToSelectedFile()
    {
        return path;
    }
}
