package button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import gui.UMLCanvas;

public class CompositionButton extends Button{
    public CompositionButton(String button_name, JPanel button_panel){
        super(button_name, button_panel);
        this.setIcon(resizeIcon("res/composition_line.png"));
    }
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        UMLCanvas.mode = "composition_line";
    }
}
