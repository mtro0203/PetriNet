package oop.generated;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.InputStream;

public class FileChooser {

    private String path;


    public FileChooser(Canvas canvas){
        JButton confirm = new JButton();
        JFileChooser fileChooser = new JFileChooser();
        if(fileChooser.showOpenDialog(confirm) == JFileChooser.APPROVE_OPTION){
            path = fileChooser.getSelectedFile().getAbsolutePath();
        }
    }


    public String getPathToSelectedFile()
    {
        return path;
    }
}
