package button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton implements ActionListener {
    protected JPanel button_panel;
    private ImageIcon image;
    private int width = 100;
    private int height = 100;

    public Button(String button_name, JPanel button_panel){
        super(button_name);
        this.button_panel = button_panel;
        this.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent e){
        Component[] component = button_panel.getComponents();
        for (int i=0; i<component.length; i++){
            component[i].setBackground(null);
            component[i].setForeground(Color.BLACK);
        }
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        //System.out.println("click");
    }
    public ImageIcon resizeIcon(String icon_path){
        image = new ImageIcon(icon_path);
        Image img = image.getImage();
        img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        image.setImage(img);
        return image;
    }
}
