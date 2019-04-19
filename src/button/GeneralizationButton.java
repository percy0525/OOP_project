package button;

import gui.UMLCanvas;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GeneralizationButton extends Button{
    public GeneralizationButton(String button_name, JPanel button_panel){
        super(button_name, button_panel);
        this.setIcon(resizeIcon("res/generalization_line.png"));
    }
    public void actionPerformed(ActionEvent e) {

        super.actionPerformed(e);
        UMLCanvas.mode = "generalization_line";
    }
}
