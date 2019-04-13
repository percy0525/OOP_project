package button;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AssociationButton extends Button{
    public AssociationButton(String button_name, JPanel button_panel){
        super(button_name, button_panel);
        this.setIcon(resizeIcon("res/association_line.png"));
    }
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
    }
}
