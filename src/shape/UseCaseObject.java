package shape;

import java.awt.*;

public class UseCaseObject extends Shape{
    public UseCaseObject(String name, Point xy, Dimension weightHeight, boolean isSelected) {
        this.name = name;
        this.xy = xy;
        this.widthHeight = weightHeight;
        this.isSelected = false;
    }
    public void paint(Graphics g) {
        //super.paint(g);  //draw ports
        //System.out.println("UseCaseObject Paint!");
        g.drawOval((int)this.xy.getX(), (int)this.xy.getY(), (int)this.widthHeight.getWidth(), (int)this.widthHeight.getHeight());
        g.drawString(this.name, (int)this.xy.getX() + (int)this.widthHeight.getWidth() / 4, (int)this.xy.getY() + (int)this.widthHeight.getHeight() / 2);
    }
}
