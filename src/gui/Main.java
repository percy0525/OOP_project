package gui;

import javax.swing.JFrame;
import gui.Frame;

public class Main {
    public static void main(String[] args){
        Frame frame = new Frame("Jay's UML Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.showGUI();
        //frame.pack();
        frame.setVisible(true);
    }
}