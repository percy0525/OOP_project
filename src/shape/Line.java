package shape;

import java.awt.*;

public class Line extends Shape{
    protected Shape object1;
    protected Shape object2;
    protected Port selectedPort1;
    protected Port selectedPort2;

//    public Line(Shape object1, Shape object2){
////        this.object1 = object1;
////        this.object2 = object2;
////    }

    public double getDiagonalVector1(Shape object){
        Point center = new Point((int)object.xy.getX() + (int)(object.widthHeight.getWidth()/2), (int)object.xy.getY() + (int)(object.widthHeight.getHeight()/2));
        double slope = (object.xy.getY() - center.getY()) / (object.xy.getX() + object.widthHeight.getWidth() - center.getX());
//        System.out.println(center);
        return slope;
    }
    public double getDiagonalVector2(Shape object){
        Point center = new Point((int)object.xy.getX() + (int)(object.widthHeight.getWidth()/2), (int)object.xy.getY() + (int)(object.widthHeight.getHeight()/2));
        double slope = (object.xy.getY() + object.widthHeight.getHeight() - center.getY()) / (object.xy.getX() + object.widthHeight.getWidth() - center.getX());
//        System.out.println(center);
        return slope;
    }
    public int getPortLocation(Point point, Shape object){
        Point center = new Point((int)object.xy.getX() + (int)(object.widthHeight.getWidth()/2), (int)object.xy.getY() + (int)(object.widthHeight.getHeight()/2));
        Point trans_point = new Point((int)center.getX() - (int)point.getX(), (int)center.getY() - (int)point.getY());
        double v1 = trans_point.getY() - getDiagonalVector1(object)*trans_point.getX();
        double v2 = trans_point.getY() - getDiagonalVector2(object)*trans_point.getX();
        if (v1 > 0 && v2 > 0){
            return 1;
        }
        else if (v1 < 0 && v2 > 0){
            return 2;
        }
        else if(v1 < 0 && v2 < 0){
            return 3;
        }
        else{
            return 4;
        }
    }
}
