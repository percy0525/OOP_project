package shape;

import java.awt.*;

public class Line extends Shape{

    public Line(Shape object1, Shape object2){
        this.object1 = object1;
        this.object2 = object2;
        super.xy = new Point(0,0);
        super.widthHeight = new Dimension(0,0);
        super.depth = -1;
    }
    public void paint(Graphics g){
        if(object1 != null && object2 != null){
            super.paint(g);
        }
    }
}
