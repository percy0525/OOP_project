package menu;

import gui.UMLCanvas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Menu extends JMenuItem implements ActionListener {
    protected UMLCanvas canvas;

    public Menu(UMLCanvas canvas, String name) {
        super(name);
        this.canvas = canvas;
        this.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {    }
}
