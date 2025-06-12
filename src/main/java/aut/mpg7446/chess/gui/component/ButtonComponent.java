/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aut.mpg7446.chess.gui.component;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.JComponent;

/**
 *
 * @author mpg7446
 */
public class ButtonComponent extends JComponent {
    protected String text;
    protected int x, y;
    
    public ButtonComponent(String text, int x, int y) {
        this.text = text;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
    }
    
    public void actionPerformed(ActionEvent e) {
        
    }
}
