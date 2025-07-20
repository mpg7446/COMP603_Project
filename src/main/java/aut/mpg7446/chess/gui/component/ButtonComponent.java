/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aut.mpg7446.chess.gui.component;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author mpg7446
 */
public class ButtonComponent extends JButton {
    public ActionListener actionLister;
    public ButtonComponent(String text, ActionListener actionListener) {
        super(text);
        super.addActionListener(actionListener);
        this.actionListener = actionListener;
    }
    public ButtonComponent(String text) {
        super(text);
    }
}
