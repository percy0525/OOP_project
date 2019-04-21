package shape;

import gui.UMLCanvas;

import java.awt.*;
import java.util.ArrayList;

public class Composite extends Shape {
    private UMLCanvas canvas;
    public Composite(UMLCanvas canvas, Point xy, Dimension weightHeight, boolean isSelected, int depth){
        this.canvas = canvas;
        //this.name = name;
        this.xy = xy;
        this.widthHeight = weightHeight;
        this.isSelected = isSelected;
        this.depth = depth;
    }
    public void paint(Graphics g){
        int x_points[] = {(int)this.xy.getX(), (int)this.xy.getX(), (int)this.xy.getX() + (int)this.widthHeight.getWidth(), (int)this.xy.getX() + (int)this.widthHeight.getWidth()};
        int y_points[] = {(int)this.xy.getY(), (int)this.xy.getY() + (int)this.widthHeight.getHeight(), (int)this.xy.getY() + (int)this.widthHeight.getHeight(), (int)this.xy.getY()};
        //g.drawRect((int)this.xy.getX(), (int)this.xy.getY(), (int)this.widthHeight.getWidth(), (int)this.widthHeight.getHeight());
        //g.drawString(this.name, (int)this.xy.getX() + (int)this.widthHeight.getWidth() / 3, (int)this.xy.getY() + 10);
        g.drawPolygon(x_points, y_points, 4);
    }
//    public ArrayList<Shape> getCompositeContainer(){
//        return this.compositeContainer;
//    }
    public void updateDepth(){
        super.updateDepth();
    }
    public ArrayList<Line> getConnectedLine(){
        Point portArray[] = getPortArray();
        ArrayList<Line> connected_lines = new ArrayList<Line>();
        ArrayList<Line> lineContainer = canvas.getLineContainer();
        for(Line line : lineContainer){
            if(line.object1 == this || line.object2 == this){
                connected_lines.add(line);
            }
        }
        return connected_lines;
    }
}

