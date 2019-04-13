package button;

import gui.UMLCanvas;

import javax.swing.*;

import java.awt.event.ActionEvent;


public class SelectButton extends Button {

    public SelectButton(String button_name, JPanel button_panel){
        super(button_name, button_panel);
        //this.imgage = new ImageIcon("res/select.png");
        this.setIcon(resizeIcon("res/select.png"));
    }
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        UMLCanvas.mode = "select";
    }
}
