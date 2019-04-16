package shape;
import java.awt.*;

public class Shape {
    public Dimension widthHeight;
    public String name;
    public Point xy;
    private final int NUM_OF_PORT = 4;
    public boolean isSelected;
    private final int PORT_WIDTH = 10;
    private final int PORT_HEIGHT = 10;

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
}

