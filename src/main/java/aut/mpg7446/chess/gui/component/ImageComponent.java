/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aut.mpg7446.chess.gui.component;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;

/**
 *
 * @author mpg7446
 */
public class ImageComponent extends JComponent {
    protected Image image;
    protected int x, y;
    
    public ImageComponent(Image image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, x, y, null);
    }
}
