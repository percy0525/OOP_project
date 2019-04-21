package menu;
import gui.UMLCanvas;
import shape.Composite;
import shape.Shape;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GroupMenu extends Menu{
    private ArrayList<Shape> groupContainer;
    public static int composite_cnt;
    private Point init_port[] = new Point[4];
    //private Point top_left, top_right, bottom_left, bottom_right;
    private int max_x, max_y, min_x, min_y;
    public GroupMenu(UMLCanvas canvas, String name){
        super(canvas, name);
        this.groupContainer = canvas.getGroupContainer();
        this.composite_cnt = canvas.composite_cnt;
    }
    public void actionPerformed(ActionEvent e){
        for(Shape object : canvas.getObjContainer()){
            if(object.isSelected){
                groupContainer.add(object);
            }
        }
        init_port = groupContainer.get(0).getPortArray();
        min_y = (int)init_port[0].getY();
        max_x = (int)init_port[1].getX();
        max_y = (int)init_port[2].getY();
        min_x = (int)init_port[3].getX();
        for (Shape object : groupContainer){
            Point portArray[] = object.getPortArray();
            if(portArray[0].getY() < min_y){
                min_y = (int)portArray[0].getY();
            }
            if(portArray[1].getX() > max_x){
                max_x = (int)portArray[1].getX();
            }
            if(portArray[2].getY() > max_y){
                max_y = (int)portArray[2].getY();
            }
            if(portArray[3].getX() < min_x){
                min_x = (int)portArray[3].getX();
            }
        }
        Point xy = new Point(min_x, min_y);
        Dimension widthHeight = new Dimension(max_x - min_x, max_y - min_y);
        int depth = UMLCanvas.MAX_DEPTH - canvas.getObjContainer().size();
        if(groupContainer.size() > 1){
            Composite composite = new Composite(canvas, xy, widthHeight, true, depth);
            canvas.getObjContainer().add(composite);
            composite.compositeContainer.addAll(groupContainer);
            composite.updateDepth();
            groupContainer.clear();
            composite_cnt++;

            canvas.repaint();
        }
    }
}
