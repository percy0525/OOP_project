package gui;

import shape.ClassObject;
import shape.Port;
import shape.Shape;
import shape.UseCaseObject;

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
    private ArrayList<Port> portContainer = new ArrayList<Port>();
    public UMLCanvas(){
        super();
        this.addMouseListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
//
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (mode == "class"){
            Graphics g = this.getGraphics();
            ClassObject class_object = new ClassObject(e.getPoint(), new Dimension(W,H), "new class", false);
            objContainer.add(class_object);
            for (Shape object : objContainer){
                object.paint(g);
                //System.out.println("obj location:" + object.xy);
            }
        }
        else if (mode == "select"){

            /* TODO replace dimension */
            checkObject(objContainer, e.getPoint(), new Dimension(W,H));
            for (Shape object : objContainer){
                //System.out.println(object.isSelected);
                if(object.isSelected){
                    Graphics g = this.getGraphics();
                    Port portObj = new Port(e.getPoint());
//                    portContainer.add(portObj);
                    portObj.paint(object, g);
                }
                else{
                    Graphics g = this.getGraphics();
                    Port portObj = new Port(e.getPoint());
                    portObj.clear(object, g);
                }
                Graphics g = this.getGraphics();
                object.paint(g);
            }
        }
        else if(mode == "use_case"){
            Graphics g = this.getGraphics();
            UseCaseObject use_case_object = new UseCaseObject("use_case", e.getPoint(), new Dimension(H,W), false);
            objContainer.add(use_case_object);
            for (Shape object : objContainer){
                object.paint(g);
                //System.out.println("obj location:" + object.xy);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {    }

    @Override
    public void mouseEntered(MouseEvent e) {    }

    @Override
    public void mouseExited(MouseEvent e) {    }

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
