package shape;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class ClassObject extends Shape {
    public ClassObject(Point xy, Dimension widthHeight, String name, boolean isSelected){
        this.xy = xy;
        this.widthHeight = widthHeight;
        this.name = name;
        this.isSelected = false;
    }

    public void paint(Graphics g) {
        //super.paint(g);
        g.setColor(Color.BLACK);
        g.drawRect((int)xy.getX(),(int) xy.getY(), (int)widthHeight.getWidth(), (int)widthHeight.getHeight());
        g.drawLine((int)xy.getX(), (int)xy.getY() + (int)widthHeight.getHeight() / 3, (int)xy.getX() + (int)widthHeight.getWidth(), (int)xy.getY() + (int)widthHeight.getHeight() / 3);
        g.drawLine((int)xy.getX(), (int)xy.getY() + (int)widthHeight.getHeight() * 2 / 3, (int)xy.getX() + (int)widthHeight.getWidth(), (int)xy.getY() + (int)widthHeight.getHeight() * 2 / 3);
        g.drawString(name, (int)xy.getX() + (int)widthHeight.getWidth() / 3, (int)xy.getY() + 10);
    }
    //public ArrayList<Point> getPortPoint()

}
