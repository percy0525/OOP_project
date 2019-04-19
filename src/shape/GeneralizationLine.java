package shape;

import java.awt.*;

public class GeneralizationLine extends Line{
    private Point start_point;
    private Point end_point;
    private int port1;
    private int port2;
    public GeneralizationLine(Shape object1, Shape object2, int port1, int port2){
        super(object1, object2);
        this.port1 = port1;
        this.port2 = port2;
    }
    public void paint(Graphics g){
        Point[] portArray1 = object1.getPortArray();
        Point[] portArray2 = object2.getPortArray();
        start_point = portArray1[port1-1];
        end_point = portArray2[port2-1];
        paintTriangle(g);
        g.drawLine((int)start_point.getX(), (int)start_point.getY(), (int)end_point.getX(), (int)end_point.getY());
    }
    public void paintTriangle(Graphics g){
        Point[] portArray1 = object1.getPortArray();
        Point[] portArray2 = object2.getPortArray();
        start_point = portArray1[port1-1];
        end_point = portArray2[port2-1];

        int v_x, v_y;
        double unit_x, unit_y, unit_nx, unit_ny, bottom_x, bottom_y, corner_x1, corner_x2, corner_y1, corner_y2;
        double vector_length;
        final int TRIANGLE_LENGTH = 20;
        final int N_POINT = 3;
        final double ANGLE = 30.0;
        v_x = (int)(end_point.getX() - start_point.getX());
        v_y = (int)(end_point.getY() - start_point.getY());
        vector_length = Math.sqrt(Math.pow(v_x, 2) + Math.pow(v_y, 2));
        unit_x = v_x / vector_length;
        unit_y = v_y / vector_length;
        //System.out.println(Math.sqrt(Math.pow(unit_x, 2) + Math.pow(unit_y, 2)));
        double radians = Math.toRadians(ANGLE);
        bottom_x =  end_point.getX() - (unit_x * TRIANGLE_LENGTH * Math.cos(radians));
        bottom_y =  end_point.getY() - (unit_y * TRIANGLE_LENGTH * Math.cos(radians));
        unit_nx = unit_y;
        unit_ny = unit_x * (-1.0);
        corner_x1 = bottom_x + unit_nx * TRIANGLE_LENGTH/2;
        corner_y1 = bottom_y + unit_ny * TRIANGLE_LENGTH/2;
        corner_x2 = bottom_x - unit_nx * TRIANGLE_LENGTH/2;
        corner_y2 = bottom_y - unit_ny * TRIANGLE_LENGTH/2;
        int x_points[] = {(int)end_point.getX(), (int)corner_x1, (int)corner_x2};
        int y_points[] = {(int)end_point.getY(), (int)corner_y1, (int)corner_y2};

        g.fillPolygon(x_points, y_points, N_POINT);
    }
}
