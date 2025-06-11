/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aut.mpg7446.chess;

/**
 *
 * @author mpg7446
 */
public class Renderer {
    private static Board renderTarget;
    
    public Renderer(Board board) {
        renderTarget = board;
    }
    
    public void Render() {
        System.out.println("\n\nExit game by entering 'q'\nWhite: lowecase letters\nBlack: uppercase letters");
        System.out.println("   A B C D E F G H");
        System.out.println("   _______________");
        for (int y = 0; y < 8; y++) {
            System.out.print(y+1 + " |");
            for (int x = 0; x < 8; x++) {
                System.out.print(renderTarget.getPiece(x, y) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    private void Clear() {
        System.out.flush();
    }
}
