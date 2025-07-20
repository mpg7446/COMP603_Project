/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package aut.mpg7446.chess.gui;

import aut.mpg7446.chess.gui.component.ButtonComponent;
import aut.mpg7446.chess.gui.component.TextComponent;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mpg7446
 */
public class ScreenManager {
    public static Screen mainScreen;
    public static Screen loadScreen;
    
    private static LinkedList<Screen> openScreens = new LinkedList<Screen>();
    
    public ScreenManager() {
        setScreens();
        openScreen(mainScreen);
    }
    
    public void setScreens(Screen board, Screen load) {
        mainScreen = board;
        loadScreen = load;
    }
    public void setScreens() {
        LinkedList<JComponent> boardComp = new LinkedList<JComponent>();
        boardComp.add(new TextComponent("this is where the board will go", 10, 10));
        mainScreen = new Screen("Chess", 1000, 500, JFrame.EXIT_ON_CLOSE, boardComp);
        
        LinkedList<JComponent> loadComp = new LinkedList<JComponent>();
        JPanel layout = new JPanel();
        loadComp.add(layout);
        layout.setLayout(new BorderLayout());
        layout.add(new TextComponent("Found saved file..\nContinue from previous save?", 10, 10), BorderLayout.SOUTH);
        
        buttonListener bl = new buttonListener();
        ButtonComponent confirm = new ButtonComponent("Yes", bl);
        ButtonComponent deny = new ButtonComponent("No", bl);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirm);
        buttonPanel.add(deny);
        layout.add(buttonPanel, BorderLayout.NORTH);
        loadScreen = new Screen("Chess", 500, 300, JFrame.DISPOSE_ON_CLOSE, loadComp);
    }
    
    public static void openScreen(Screen screen) {
        screen.show();
    }
    public static void setScreen(Screen screen) {
        // close existing screens
        for (Screen open : openScreens) {
            open.hide();
        }
        
        openScreen(screen);
    }
    
    class buttonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    
}
