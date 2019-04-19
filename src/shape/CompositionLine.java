package shape;

import java.awt.*;

public class CompositionLine extends Line{
    private Point start_point;
    private Point end_point;
    private int port1;
    private int port2;
    private Point bottom_point;
    public CompositionLine(Shape object1, Shape object2, int port1, int port2) {
        super(object1, object2);
        this.port1 = port1;
        this.port2 = port2;
    }
    public void paint(Graphics g){
        Point[] portArray1 = object1.getPortArray();
        Point[] portArray2 = object2.getPortArray();
        start_point = portArray1[port1-1];
        end_point = portArray2[port2-1];
        paintRectangle(g);
        g.drawLine((int)start_point.getX(), (int)start_point.getY(), (int)bottom_point.getX(), (int)bottom_point.getY());
    }
    public void paintRectangle(Graphics g){
        Point[] portArray1 = object1.getPortArray();
        Point[] portArray2 = object2.getPortArray();
        start_point = portArray1[port1-1];
        end_point = portArray2[port2-1];

        int v_x, v_y;
        double unit_x, unit_y, unit_nx, unit_ny, center_x, center_y, bottom_x, bottom_y, corner_x1, corner_x2, corner_y1, corner_y2;
        double vector_length;
        final double TRIANGLE_LENGTH = 20.0;
        final int N_POINT = 4;
        final double ANGLE = 45.0;
        double radians = Math.toRadians(ANGLE);

        v_x = (int)(end_point.getX() - start_point.getX());
        v_y = (int)(end_point.getY() - start_point.getY());
        vector_length = Math.sqrt(Math.pow(v_x, 2) + Math.pow(v_y, 2));
        unit_x = v_x / vector_length;
        unit_y = v_y / vector_length;
        //System.out.println(Math.sqrt(Math.pow(unit_x, 2) + Math.pow(unit_y, 2)));

        center_x =  end_point.getX() - (unit_x * TRIANGLE_LENGTH * Math.cos(radians));
        center_y =  end_point.getY() - (unit_y * TRIANGLE_LENGTH * Math.cos(radians));
        bottom_x =  end_point.getX() - (unit_x * 2 * TRIANGLE_LENGTH * Math.cos(radians));
        bottom_y =  end_point.getY() - (unit_y * 2 * TRIANGLE_LENGTH * Math.cos(radians));
        bottom_point = new Point((int)bottom_x, (int)bottom_y);
        unit_nx = unit_y;
        unit_ny = unit_x * (-1.0);
        corner_x1 = center_x - unit_nx * TRIANGLE_LENGTH * Math.cos(radians);
        corner_y1 = center_y - unit_ny * TRIANGLE_LENGTH * Math.cos(radians);
        corner_x2 = center_x + unit_nx * TRIANGLE_LENGTH * Math.cos(radians);
        corner_y2 = center_y + unit_ny * TRIANGLE_LENGTH * Math.cos(radians);
        int x_points[] = {(int)end_point.getX(), (int)corner_x1, (int)bottom_x, (int)corner_x2};
        int y_points[] = {(int)end_point.getY(), (int)corner_y1, (int)bottom_y, (int)corner_y2};

        g.drawPolygon(x_points, y_points, N_POINT);
    }
}
