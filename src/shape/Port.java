package shape;

import java.awt.*;

public class Port {
    private Point xy;
    private Dimension widthHeight;
    private final int PORT_WIDTH = 10;
    private final int PORT_HEIGHT = 10;

    public Port(Point xy) {
        this.xy = xy;
        widthHeight = new Dimension(PORT_WIDTH, PORT_HEIGHT);
    }
    public void paint(Shape obj, Graphics g) {
        g.fillRect((int)obj.xy.getX() + (int)(obj.widthHeight.getWidth()/2), (int)obj.xy.getY(), PORT_WIDTH, PORT_HEIGHT);
        g.fillRect((int)obj.xy.getX(), (int)(obj.xy.getY() + obj.widthHeight.getHeight()/2), PORT_WIDTH, PORT_HEIGHT);
        g.fillRect((int)(obj.xy.getX() + obj.widthHeight.getWidth()/2), (int)(obj.xy.getY() + obj.widthHeight.getHeight()), PORT_WIDTH, PORT_HEIGHT);
        g.fillRect((int)obj.xy.getX() + (int)(obj.widthHeight.getWidth()), (int)(obj.xy.getY() + obj.widthHeight.getHeight()/2), PORT_WIDTH, PORT_HEIGHT);
    }
    public void clear(Shape obj, Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect((int)obj.xy.getX() + (int)(obj.widthHeight.getWidth()/2), (int)obj.xy.getY(), PORT_WIDTH, PORT_HEIGHT);
        g.fillRect((int)obj.xy.getX(), (int)(obj.xy.getY() + obj.widthHeight.getHeight()/2), PORT_WIDTH, PORT_HEIGHT);
        g.fillRect((int)(obj.xy.getX() + obj.widthHeight.getWidth()/2), (int)(obj.xy.getY() + obj.widthHeight.getHeight()), PORT_WIDTH, PORT_HEIGHT);
        g.fillRect((int)obj.xy.getX() + (int)(obj.widthHeight.getWidth()), (int)(obj.xy.getY() + obj.widthHeight.getHeight()/2), PORT_WIDTH, PORT_HEIGHT);
    }
}
