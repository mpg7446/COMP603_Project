/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aut.mpg7446.chess.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.LinkedList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import aut.mpg7446.chess.gui.component.ScreenComponent;

/**
 *
 * @author mpg7446
 */
public class Screen {
    private JFrame frame;
//    private LinkedList<JComponent> components;
    
    public Screen(String title, int width, int height, int x, int y, int behaviour, LinkedList<JComponent> components) {
        // set frame settings
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setLocation(x,y);
        frame.setDefaultCloseOperation(behaviour);
        
        // set frame components
        setComponents(components);
        show();
    }
    public Screen(String title, int width, int height, int behaviour, LinkedList<JComponent> components) {
        // set frame settings
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(behaviour);
        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        frame.setLocation(screenSize.width/2, screenSize.height/2);
        
        // set frame components
        setComponents(components);
        show();
    }
    
    public void setComponents(LinkedList<JComponent> components) {
        // set list of components
//        this.components = components;
        // add components to frame
        for (JComponent comp : components) {
            if (comp != null)
                frame.add(comp);
        }
    }
    
    public void show() {
        frame.setVisible(true);
    }
    public void hide() {
        frame.setVisible(false);
    }
}
