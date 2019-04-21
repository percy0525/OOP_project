package shape;
import java.awt.*;
import java.util.ArrayList;

public class Shape {
    public ArrayList<Shape> compositeContainer = new ArrayList<Shape>();
    public Dimension widthHeight;
    public String name;
    public Point xy;
    Point [] portArray = new Point[4];
    public int depth;
    private final int NUM_OF_PORT = 4;
    public boolean isSelected;
    private final int PORT_WIDTH = 10;
    private final int PORT_HEIGHT = 10;
    public Shape object1;
    public Shape object2;


    public void paint(Graphics g){}
    public void translate(int dx, int dy) {
        this.xy.setLocation(xy.getX() + dx, xy.getY() + dy);
    }
    public void paintPort(Graphics g){
        g.fillRect((int)this.xy.getX() + (int)(this.widthHeight.getWidth()/2), (int)this.xy.getY(), PORT_WIDTH, PORT_HEIGHT);
        g.fillRect((int)this.xy.getX(), (int)(this.xy.getY() + this.widthHeight.getHeight()/2), PORT_WIDTH, PORT_HEIGHT);
        g.fillRect((int)(this.xy.getX() + this.widthHeight.getWidth()/2), (int)(this.xy.getY() + this.widthHeight.getHeight()), PORT_WIDTH, PORT_HEIGHT);
        g.fillRect((int)this.xy.getX() + (int)(this.widthHeight.getWidth()), (int)(this.xy.getY() + this.widthHeight.getHeight()/2), PORT_WIDTH, PORT_HEIGHT);
    }
    public Point[] getPortArray(){

        portArray[0] = new Point((int)this.xy.getX() + (int)(this.widthHeight.getWidth()/2), (int)this.xy.getY());
        portArray[1] = new Point((int)this.xy.getX() + (int)(this.widthHeight.getWidth()), (int)(this.xy.getY() + this.widthHeight.getHeight()/2));
        portArray[2] = new Point((int)(this.xy.getX() + this.widthHeight.getWidth()/2), (int)(this.xy.getY() + this.widthHeight.getHeight()));
        portArray[3] = new Point((int)this.xy.getX(), (int)(this.xy.getY() + this.widthHeight.getHeight()/2));
        return this.portArray;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDepth(int d){
        this.depth = d;
    }
    public boolean isInComposite(Composite c){
        return false;
    }
//    public ArrayList<Shape> getCompositeContainer(){
//        return this.compositeContainer;
//    }
    public void updateDepth(){
        for (Shape object : compositeContainer){
            object.setDepth(this.depth);
        }
    }
    public ArrayList<Line> getConnectedLine(){
        return null;
    }
}

