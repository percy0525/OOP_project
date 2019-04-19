package shape;

import java.awt.*;

public class SelectArea extends Polygon{
    private Point press;
    private Point now;

    public SelectArea(Point press, Point now) {
        this.press = press;
        this.now = now;
    }
    public void updatePolygon(){
        int x_points[] = {(int)press.getX(), (int)press.getX(), (int)now.getX(), (int)now.getX()};
        int y_points[] = {(int)press.getY(), (int)now.getY(), (int)now.getY(), (int)press.getY()};
        this.xpoints = x_points;
        this.ypoints = y_points;
        this.npoints = 4;
    }
    public void paint(Graphics g) {
        Color content = new Color(0, 150, 220, 80);
        Color border = new Color(80, 255, 240, 255);
        g.setColor(border);
        g.drawPolygon(this.xpoints, this.ypoints, this.npoints);
        g.setColor(content);
        g.fillPolygon(this.xpoints, this.ypoints, this.npoints);
    }
    public boolean containObject(Shape object){
        Point p1 = object.xy;
        Point p2 = new Point((int)object.xy.getX(), (int)object.xy.getY() + (int)object.widthHeight.getHeight());
        Point p3 = new Point((int)object.xy.getX() + (int)object.widthHeight.getWidth(), (int)object.xy.getY() + (int)object.widthHeight.getHeight());
        Point p4 = new Point((int)object.xy.getX() + (int)object.widthHeight.getWidth(), (int)object.xy.getY());
        if(this.contains(p1) && this.contains(p2) && this.contains(p3) && this.contains(p4)){
            return true;
        }
        else {
            return false;
        }
    }
}
