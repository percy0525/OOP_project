package gui;

import shape.*;
import shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.*;
import java.util.ArrayList;


public class UMLCanvas extends JPanel implements MouseListener, MouseMotionListener {
    public static String mode = "";
    private final int W = 100;
    private final int H = 200;
    private ArrayList<Shape> objContainer = new ArrayList<Shape>();
    private ArrayList<Port> portContainer = new ArrayList<Port>();
    private Point mousePress;
    private Point mouseMove;
    private Point mouseRelease;
    int depth = 99;

    public UMLCanvas(){
        super();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.mousePress = new Point();
        this.mouseMove = new Point();
        this.mouseRelease = new Point();
    }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) {
        if (mode == "class"){
            depth = 99 - objContainer.size();
            ClassObject class_object = new ClassObject(e.getPoint(), new Dimension(W,H), "new class", false, depth);
            objContainer.add(class_object);
            this.repaint();
        }
        else if (mode == "select"){
            this.mousePress.setLocation(e.getPoint());
            this.mouseMove.setLocation(e.getPoint());
            /* TODO replace dimension */
            checkObject(objContainer, e.getPoint(), new Dimension(W,H));

            this.repaint();
        }
        else if(mode == "use_case"){
            depth = 99 - objContainer.size();
            UseCaseObject use_case_object = new UseCaseObject("use_case", e.getPoint(), new Dimension(H,W), false, depth);
            objContainer.add(use_case_object);
            this.repaint();
        }
        //System.out.println(depth);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.mouseRelease.setLocation(e.getPoint());

        for(Shape object : objContainer) {
            if(object.xy.getX() > this.mousePress.getX() && object.xy.getY() >  this.mousePress.getY()
                    && object.xy.getX() < this.mouseRelease.getX() && object.xy.getY() < this.mouseRelease.getY()) {
                object.isSelected = true;
            }
        }

        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {    }
    @Override
    public void mouseExited(MouseEvent e) {    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //System.out.println(this.mouseMove);
        if (mode == "select") {
            int offsetX = e.getX() - (int) this.mouseMove.getX();
            int offsetY = e.getY() - (int) this.mouseMove.getY();
            this.mouseMove.setLocation(e.getPoint());
            //checkObject(objContainer, e.getPoint(), new Dimension(W, H));

            for (Shape object : this.objContainer) {
                if (object.isSelected) {
                    object.translate(offsetX, offsetY);
                }
            }
            this.repaint();
        }
        else if (mode == "association_line"){
        }
    }
    @Override
    public void mouseMoved(MouseEvent e) {

    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(Shape shape : objContainer) {
            shape.paint(g);
            if (shape.isSelected && mode == "select"){
                shape.paintPort(g);
            }
        }
    }
    private void checkObject(ArrayList<Shape> objContainer, Point now, Dimension wh){
        //boolean hasObject = false;
        for (Shape object : objContainer){
            if((now.getY() > object.xy.getY()) && (now.getY() < object.xy.getY() + wh.getHeight()) && (now.getX() > object.xy.getX()) && (now.getX() < object.xy.getX() + wh.getWidth())){
                object.isSelected = true;
            }
            else{
                object.isSelected = false;
            }
        }
    }
}
