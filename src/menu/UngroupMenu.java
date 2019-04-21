package menu;
import gui.UMLCanvas;
import shape.Composite;
import shape.Line;
import shape.Shape;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class UngroupMenu extends Menu{
   // private Point init_port[] = new Point[4];
    private int min_x, min_y;
    private boolean hasComposite = false;
    private ArrayList<Shape> groupContainer = new ArrayList<Shape>();
    private ArrayList<Shape> objContainer;
    public UngroupMenu(UMLCanvas canvas, String name){
        super(canvas, name);
        this.objContainer = canvas.getObjContainer();
    }
    public void actionPerformed(ActionEvent e){
        groupContainer.clear();
        int location = 0;
        int size = 1;
        for(Shape object : objContainer){
            if (object.isSelected){
                groupContainer.add(object);
            }
            if (object.getClass().toString().equals("class shape.Composite")){
                hasComposite = true;
            }
        }
        min_x = (int)groupContainer.get(0).xy.getX();
        min_y = (int)groupContainer.get(0).xy.getY();
        for(Shape object : groupContainer){
            if(object.xy.getX() < min_x){
                min_x = (int)object.xy.getX();
            }
            if(object.xy.getY() < min_y){
                min_y = (int)object.xy.getY();
            }
        }
//        for (int i=0; i < objContainer.size(); i++){
//            if((objContainer.get(i).xy.getX() == min_x) && (objContainer.get(i).xy.getY() == min_y)){
//                location = i;
//            }
//        }
        for (Shape object : objContainer){
            if(object.xy.getX() == min_x && object.xy.getY() == min_y && object.getClass().toString().equals("class shape.Composite")){
                location = objContainer.indexOf(object);
                System.out.println("find object");
            }
        }
        //if(hasComposite(objContainer.get(location).compositeContainer)){
            for(Shape object : objContainer.get(location).compositeContainer){
                if (object.getClass().toString().equals("class shape.Composite")){
                    object.setDepth(objContainer.get(location).depth + size);
                    object.updateDepth();
                    size += object.compositeContainer.size() + 1;
                }
                else{
                    object.setDepth(UMLCanvas.MAX_DEPTH - canvas.getObjContainer().indexOf(object));
                }
            }

        //objContainer.get(location).compositeContainer
        if(objContainer.get(location).getClass().toString().equals("class shape.Composite")){
            for(Line line : objContainer.get(location).getConnectedLine()){
                objContainer.remove(line);
            }
            objContainer.remove(location);
            System.out.println("removed!");
        }
        for(Shape o : objContainer){
//            if(o.object1 == null || o.object2 == null){
//                objContainer.remove(o);
//            }
            System.out.println(o.getClass().toString() + o.depth);
        }

        canvas.repaint();
    }
    public boolean hasComposite(ArrayList<Shape> container){
        boolean tag = false;
        for(Shape object : container){
            if (object.getClass().toString().equals("class shape.Composite")){
                tag = true;
            }
        }
        return tag;
    }

}
