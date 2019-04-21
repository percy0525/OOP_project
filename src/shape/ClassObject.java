package shape;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class ClassObject extends Shape {
    public ClassObject(Point xy, Dimension widthHeight, String name, boolean isSelected, int depth){
        this.xy = xy;
        this.widthHeight = widthHeight;
        this.name = name;
        this.isSelected = false;
        this.depth = depth;
    }

    public void paint(Graphics g) {
        //super.paint(g);
        g.setColor(Color.PINK);
        g.fillRect((int)xy.getX(),(int) xy.getY(), (int)widthHeight.getWidth(), (int)widthHeight.getHeight());
        g.setColor(Color.BLACK);
        g.drawRect((int)xy.getX(),(int) xy.getY(), (int)widthHeight.getWidth(), (int)widthHeight.getHeight());
        g.drawLine((int)xy.getX(), (int)xy.getY() + (int)widthHeight.getHeight() / 3, (int)xy.getX() + (int)widthHeight.getWidth(), (int)xy.getY() + (int)widthHeight.getHeight() / 3);
        g.drawLine((int)xy.getX(), (int)xy.getY() + (int)widthHeight.getHeight() * 2 / 3, (int)xy.getX() + (int)widthHeight.getWidth(), (int)xy.getY() + (int)widthHeight.getHeight() * 2 / 3);
        g.drawString(name, (int)xy.getX() + (int)widthHeight.getWidth() / 3, (int)xy.getY() + 10);
    }
    //public ArrayList<Point> getPortPoint()
    public boolean isInComposite(Composite c){
        Point c_right_bottom = new Point((int)c.xy.getX() + (int)c.widthHeight.getWidth(), (int)c.xy.getY() + (int)c.widthHeight.getHeight());
        Point this_right_bottom = new Point((int)this.xy.getX() + (int)this.widthHeight.getWidth(), (int)this.xy.getY() + (int)this.widthHeight.getHeight());
        if(c.xy.getX() <= this.xy.getX() && c.xy.getY() <= this.xy.getY()
                && c_right_bottom.getX() >= this_right_bottom.getX() && c_right_bottom.getY() >= this_right_bottom.getY()){
            return true;
        }
        else {
            return false;
        }
    }
}
