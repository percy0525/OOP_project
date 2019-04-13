package gui;

import shape.ClassObject;
import shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import java.util.ArrayList;


public class UMLCanvas extends JPanel implements MouseListener {
    public static String mode = "";
    private final int W = 100;
    private final int H = 200;
    private ArrayList<Shape> objContainer = new ArrayList<Shape>();
    public UMLCanvas(){
        super();
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (mode == "class"){
            Graphics g = this.getGraphics();
            ClassObject class_object = new ClassObject(e.getPoint(), new Dimension(W,H), "new class");
            System.out.println("click");
            objContainer.add(class_object);
            for (Shape object : objContainer){
                object.paint(g, e.getPoint(), new Dimension(W,H), "new class");
                System.out.println("print obj");
            }
        }
        else if (mode == "select"){

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (mode == "class"){
            Graphics g = this.getGraphics();
            ClassObject class_object = new ClassObject(e.getPoint(), new Dimension(100,200), "new class");
            System.out.println("click");
            objContainer.add(class_object);
            for (Shape object : objContainer){
                object.paint(g, e.getPoint(), new Dimension(100,200), "new class");
                System.out.println("print obj");
            }
        }
        else if (mode == "select"){

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {    }

    @Override
    public void mouseEntered(MouseEvent e) {    }

    @Override
    public void mouseExited(MouseEvent e) {    }

//    public boolean checkObject(ArrayList<Shape> objContainer, Point now, Dimension wh){
//        boolean hasObject = false;
//        for (Shape object : objContainer){
//            if((now.getX() + wh.getWidth() < object.xy.getX()) && (now.getY() + wh.getWidth() < object.xy.getX())){
//
//            }
//        }
//        return hasObject;
//    }
}
