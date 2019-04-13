package gui;

import shape.ClassObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UMLCanvas extends Canvas implements MouseListener {
    public static String mode = "";
    public UMLCanvas(){
        super();
        this.addMouseListener(this);
    }
    public void paintComponent(Graphics g, int x, int y) {
        int width = 100;
        int height = 200;
        g.drawOval(x, y, width, height);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(mode == "class"){
            Dimension wh = new Dimension(100, 200);
            ClassObject o = new ClassObject(e.getPoint(), wh, "class");
            //this.add(instanceof o);
            System.out.println(e.getX() + "," + e.getY());
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
