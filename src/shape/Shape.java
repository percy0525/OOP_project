package shape;
import java.awt.*;

public class Shape {
    public Dimension widthHeight;
    public String name;
    public Point xy;
    private final int NUM_OF_PORT = 4;
    protected Port [] portArray;
    public boolean isSelected;

    public void paint(Graphics g){}
}
