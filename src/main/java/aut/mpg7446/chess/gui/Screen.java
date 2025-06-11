/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aut.mpg7446.chess.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author mpg7446
 */
public class Screen extends JComponent {
    private JFrame frame;
    
    public Screen(String title, int width, int height, int x, int y, int behaviour) {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setLocation(x,y);
        frame.setDefaultCloseOperation(behaviour);
        frame.setVisible(true);
    }
    public Screen(String title, int width, int height, int behaviour) {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(behaviour);
        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        frame.setLocation(screenSize.width/2, screenSize.height/2);
        frame.setVisible(true);
    }
    
    @Override
    public void show() {
        frame.setVisible(true);
    }
    @Override
    public void hide() {
        frame.setVisible(false);
    }
    
    @Override
    public void paintComponent(Graphics G) {
        
    }
}
