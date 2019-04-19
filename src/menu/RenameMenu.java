package menu;

import gui.UMLCanvas;
import shape.Shape;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RenameMenu extends Menu{
    public RenameMenu(UMLCanvas canvas, String name) {
        super(canvas, name);
    }
    public void actionPerformed(ActionEvent e){
        String objectName = JOptionPane.showInputDialog("Please input a new name!");
        if(objectName != null) {
            for(Shape object : canvas.getObjContainer()) {
                if(object.isSelected) {
                    object.setName(objectName);
                }
            }
        }
        canvas.repaint();
    }
}
