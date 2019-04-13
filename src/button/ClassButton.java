package button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import gui.UMLCanvas;

public class ClassButton extends Button{
    public ClassButton(String button_name, JPanel button_panel){
        super(button_name, button_panel);
        this.setIcon(resizeIcon("res/class.png"));
    }
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        UMLCanvas.mode = "class";
    }
}
