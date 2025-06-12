/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package aut.mpg7446.chess.gui;

import aut.mpg7446.chess.gui.component.TextComponent;
import java.util.LinkedList;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author mpg7446
 */
public class ScreenManager {
    public static Screen boardScreen;
    public static Screen loadScreen;
    
    private static LinkedList<Screen> openScreens = new LinkedList<Screen>();
    
    public static void setScreens(Screen board, Screen load) {
        boardScreen = board;
        loadScreen = load;
    }
    public static void setScreens() {
        LinkedList<JComponent> boardComp = new LinkedList<JComponent>();
        boardComp.add(new TextComponent("this is where the board will go", 0, 0));
        boardScreen = new Screen("Chess", 500, 300, JFrame.EXIT_ON_CLOSE, boardComp);
        
        LinkedList<JComponent> loadComp = new LinkedList<JComponent>();
        loadComp.add(new TextComponent("Found saved file..\nContinue from previous save?", 0, 0));
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
    
}
