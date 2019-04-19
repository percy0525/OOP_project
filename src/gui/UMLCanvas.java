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
import java.util.Collections;


public class UMLCanvas extends JPanel implements MouseListener, MouseMotionListener {
    public static String mode = "";
    private final int W = 100;
    private final int H = 200;
    private ArrayList<Shape> objContainer = new ArrayList<Shape>();
    private ArrayList<Integer> selectedObjContainer = new ArrayList<Integer>();
    private Point mousePress;
    private Point mouseMove;
    private Point mouseRelease;
    private Shape start_obj;
    private Shape end_obj;
    private Point start_point;
    private Point end_point;
    int MAX_DEPTH = 99;

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
            int depth = MAX_DEPTH - objContainer.size();
            ClassObject class_object = new ClassObject(e.getPoint(), new Dimension(W,H), "new class", false, depth);
            objContainer.add(class_object);
            this.repaint();
        }
        else if (mode == "select"){
            this.mousePress.setLocation(e.getPoint());
            this.mouseMove.setLocation(e.getPoint());
            /* TODO replace dimension */
            selectObject(objContainer, e.getPoint());

            this.repaint();
        }
        else if(mode == "use_case"){
            int depth = 99 - objContainer.size();
            UseCaseObject use_case_object = new UseCaseObject("use_case", e.getPoint(), new Dimension(H,W), false, depth);
            objContainer.add(use_case_object);
            this.repaint();
        }

        else if((mode == "generalization_line") || (mode == "composition_line") || (mode == "association_line")){
            this.mousePress.setLocation(e.getPoint());
            start_point = null;
            start_obj = null;

            for(Shape object : objContainer) {
                if(isInObject(object, this.mousePress)){
                    start_obj = object;
                    //object.isSelected = true;
                    start_point = new Point(mousePress);
                }
            }
            this.repaint();
        }
        else{
            System.out.println("no selected mode");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.mouseRelease.setLocation(e.getPoint());
        if(mode =="association_line"){
            end_point = null;
            end_obj = null;
            for(Shape object : objContainer) {
                if(isInObject(object, this.mouseRelease)){
                    end_point = new Point(mouseRelease);
                    end_obj = object;
                    //object.isSelected = true;
                }
            }
            if (start_obj != null && end_obj != null && start_point != null && end_point != null && start_obj != end_obj){
                int port1 = getPortLocation(start_point, start_obj);
                int port2 = getPortLocation(end_point, end_obj);
                AssociationLine association_line = new AssociationLine(start_obj, end_obj, port1, port2);
                //l.updatePort();
                objContainer.add(association_line);
            }
            else{
                System.out.println("null pointer");
            }
            this.repaint();
        }
        else if(mode =="generalization_line"){
            end_point = null;
            end_obj = null;
            for(Shape object : objContainer) {
                if(isInObject(object, this.mouseRelease)){
                    end_point = new Point(mouseRelease);
                    end_obj = object;
                    //object.isSelected = true;
                }
            }
            if (start_obj != null && end_obj != null && start_point != null && end_point != null && start_obj != end_obj){
                int port1 = getPortLocation(start_point, start_obj);
                int port2 = getPortLocation(end_point, end_obj);
                GeneralizationLine generalization_line = new GeneralizationLine(start_obj, end_obj, port1, port2);
                //l.updatePort();
                objContainer.add(generalization_line);
            }
            else{
                System.out.println("null pointer");
            }
            this.repaint();
        }
        else if(mode =="composition_line"){
            end_point = null;
            end_obj = null;
            for(Shape object : objContainer) {
                if(isInObject(object, this.mouseRelease)){
                    end_point = new Point(mouseRelease);
                    end_obj = object;
                    //object.isSelected = true;
                }
            }
            if (start_obj != null && end_obj != null && start_point != null && end_point != null && start_obj != end_obj){
                int port1 = getPortLocation(start_point, start_obj);
                int port2 = getPortLocation(end_point, end_obj);
                CompositionLine composition_line = new CompositionLine(start_obj, end_obj, port1, port2);
                //l.updatePort();
                objContainer.add(composition_line);
            }
            else{
                System.out.println("null pointer");
            }
            this.repaint();
        }
        else if (mode == "select"){
            //selectObject(objContainer, this.mouseRelease);
            this.repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {    }
    @Override
    public void mouseExited(MouseEvent e) {    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (mode == "select") {
            int offsetX = e.getX() - (int) this.mouseMove.getX();
            int offsetY = e.getY() - (int) this.mouseMove.getY();
            this.mouseMove.setLocation(e.getPoint());

            for (Shape object : objContainer) {
                if (object.isSelected) {
                    object.translate(offsetX, offsetY);
                }
            }
            this.repaint();
        }
    }
    @Override
    public void mouseMoved(MouseEvent e) { }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Shape shape : objContainer) {
            shape.paint(g);
            if (shape.isSelected ){
                shape.paintPort(g);
            }
        }
    }
    private void selectObject(ArrayList<Shape> objContainer, Point now){
        selectedObjContainer.clear();
        //boolean hasObject = false;
        for (Shape object : objContainer){
            if((now.getY() > object.xy.getY()) && (now.getY() < object.xy.getY() + object.widthHeight.getHeight())
                    && (now.getX() > object.xy.getX()) && (now.getX() < object.xy.getX() + object.widthHeight.getWidth())){
                object.isSelected = true;
                selectedObjContainer.add(object.depth);
            }
            else{
                object.isSelected = false;
            }
        }
        try {
            Collections.sort(selectedObjContainer);
            for (Shape object : objContainer){
                if(object.depth == selectedObjContainer.get(0)){
                    object.isSelected = true;
                }
                else{
                    object.isSelected = false;
                }
            }
        } catch (Exception e) {
            System.out.println("no selected object");
        }
    }
    private boolean isInObject(Shape object, Point now){
        if((now.getY() > object.xy.getY()) && (now.getY() < object.xy.getY() + object.widthHeight.getHeight())
                && (now.getX() > object.xy.getX()) && (now.getX() < object.xy.getX() + object.widthHeight.getWidth())){
            return true;
        }
        else {
            return false;
        }
    }
    public int getPortLocation(Point point, Shape object){
        Point center = new Point((int)object.xy.getX() + (int)(object.widthHeight.getWidth()/2), (int)object.xy.getY() + (int)(object.widthHeight.getHeight()/2));
        Point trans_point = new Point((int)center.getX() - (int)point.getX(), (int)center.getY() - (int)point.getY());
        double v1 = trans_point.getY() - getDiagonalVector1(object)*trans_point.getX();
        double v2 = trans_point.getY() - getDiagonalVector2(object)*trans_point.getX();
        if (v1 > 0 && v2 > 0){
            return 1;
        }
        else if (v1 < 0 && v2 > 0){
            return 2;
        }
        else if(v1 < 0 && v2 < 0){
            return 3;
        }
        else{
            return 4;
        }
    }
    public double getDiagonalVector1(Shape object){
        Point center = new Point((int)object.xy.getX() + (int)(object.widthHeight.getWidth()/2), (int)object.xy.getY() + (int)(object.widthHeight.getHeight()/2));
        double slope = (object.xy.getY() - center.getY()) / (object.xy.getX() + object.widthHeight.getWidth() - center.getX());
//        System.out.println(center);
        return slope;
    }
    public double getDiagonalVector2(Shape object){
        Point center = new Point((int)object.xy.getX() + (int)(object.widthHeight.getWidth()/2), (int)object.xy.getY() + (int)(object.widthHeight.getHeight()/2));
        double slope = (object.xy.getY() + object.widthHeight.getHeight() - center.getY()) / (object.xy.getX() + object.widthHeight.getWidth() - center.getX());
//        System.out.println(center);
        return slope;
    }
}