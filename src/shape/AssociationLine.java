package shape;

import java.awt.*;

public class AssociationLine extends Line{
    private Point start_point;
    private Point end_point;
    private int port1;
    private int port2;
    public AssociationLine(Shape object1, Shape object2, int port1, int port2){
        super(object1, object2);
        this.port1 = port1;
        this.port2 = port2;
    }

    public void paint(Graphics g){
        super.paint(g);
        Point[] portArray1 = object1.getPortArray();
        Point[] portArray2 = object2.getPortArray();
        start_point = portArray1[port1-1];
        end_point = portArray2[port2-1];

        g.drawLine((int)start_point.getX(), (int)start_point.getY(), (int)end_point.getX(), (int)end_point.getY());
    }
}
