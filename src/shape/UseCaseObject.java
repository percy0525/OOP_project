package shape;

import java.awt.*;

public class UseCaseObject extends Shape{
    public UseCaseObject(String name, Point xy, Dimension weightHeight, boolean isSelected, int depth) {
        this.name = name;
        this.xy = xy;
        this.widthHeight = weightHeight;
        this.isSelected = false;
        this.depth = depth;
    }
    public void paint(Graphics g) {
        //super.paint(g);  //draw ports
        //System.out.println("UseCaseObject Paint!");
        g.setColor(Color.YELLOW);
        g.fillOval((int)this.xy.getX(), (int)this.xy.getY(), (int)this.widthHeight.getWidth(), (int)this.widthHeight.getHeight());
        g.setColor(Color.BLACK);
        g.drawOval((int)this.xy.getX(), (int)this.xy.getY(), (int)this.widthHeight.getWidth(), (int)this.widthHeight.getHeight());
        g.drawString(this.name, (int)this.xy.getX() + (int)this.widthHeight.getWidth() / 4, (int)this.xy.getY() + (int)this.widthHeight.getHeight() / 2);
    }
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
