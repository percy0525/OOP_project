package button;

import gui.UMLCanvas;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UseCaseButton extends Button{
    public UseCaseButton(String button_name, JPanel button_panel){
        super(button_name, button_panel);
        this.setIcon(resizeIcon("res/use_case.png"));
    }
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        UMLCanvas.mode = "use_case";
    }
}
