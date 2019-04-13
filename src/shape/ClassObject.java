package shape;

import javax.swing.*;
import java.awt.*;

public class ClassObject extends Shape {
    public ClassObject(Point xy, Dimension widthHeight, String name){
        this.xy = xy;
        this.name = name;
        this.widthHeight = widthHeight;
    }
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.drawRect((int)this.xy.getX(),(int) this.xy.getY(), (int)this.widthHeight.getWidth(), (int)this.widthHeight.getHeight());
        g.drawLine((int)this.xy.getX(), (int)this.xy.getY() + (int)this.widthHeight.getHeight() / 3, (int)this.xy.getX() + (int)this.widthHeight.getWidth(), (int)this.xy.getY() + (int)this.widthHeight.getHeight() / 3);
        g.drawLine((int)this.xy.getX(), (int)this.xy.getY() + (int)this.widthHeight.getHeight() * 2 / 3, (int)this.xy.getX() + (int)this.widthHeight.getWidth(), (int)this.xy.getY() + (int)this.widthHeight.getHeight() * 2 / 3);
        g.drawString(this.name, (int)this.xy.getX() + (int)this.widthHeight.getWidth() / 3, (int)this.xy.getY() + 10);
    }
}
