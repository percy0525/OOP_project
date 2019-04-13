package gui;

import java.awt.*;
import javax.swing.*;

import button.*;

import static java.awt.BorderLayout.*;

public class Frame extends JFrame{
    public Frame(String title) {
        super(title);
    }
    public void showGUI(){
        //BorderLayout panelLayout = new BorderLayout();
        //this.setLayout(panelLayout);

        Container contentPane = this.getContentPane();

        JMenuBar menuBar = new JMenuBar();
        JPanel action_panel = new JPanel();
        UMLCanvas canvas_panel = new UMLCanvas();

        canvas_panel.setBackground(Color.WHITE);

        //action_panel.setBounds(0, 0, 300, 600);

        //this.add(action_panel, WEST);
        //this.add(canvas_panel, BorderLayout.CENTER);

        SelectButton select_button = new SelectButton("select", action_panel);
        AssociationButton association_line_button = new AssociationButton("association_line", action_panel);
        GeneralizationButton generalization_line_button = new GeneralizationButton("generalization_line", action_panel);
        CompositionButton composition_line_button = new CompositionButton("composition_line", action_panel);
        ClassButton class_button = new ClassButton("class", action_panel);
        UseCaseButton use_case_button = new UseCaseButton("use_case", action_panel);

        action_panel.add(select_button);
        action_panel.add(association_line_button);
        action_panel.add(generalization_line_button);
        action_panel.add(composition_line_button);
        action_panel.add(class_button);
        action_panel.add(use_case_button);

        JMenu file_menu = new JMenu("File");
        JMenu edit_menu = new JMenu("Edit");
        menuBar.add(file_menu);
        menuBar.add(edit_menu);

        action_panel.setLayout(new GridLayout(6, 1));

        contentPane.add(menuBar, NORTH);
        contentPane.add(action_panel, WEST);
        //contentPane.add(select_button, WEST);
        contentPane.add(canvas_panel, CENTER);
    }
}
