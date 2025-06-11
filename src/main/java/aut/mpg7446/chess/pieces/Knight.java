/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aut.mpg7446.chess.pieces;

import aut.mpg7446.chess.Board;
import aut.mpg7446.chess.Chess;

/**
 *
 * @author mpg7446
 */
public class Knight extends Piece {
    
    public Knight(Board.Team team, int[] coords) {
        super(5, team, coords, 'k', new int[]{0,0}, true);
    }
    
    @Override
    protected boolean isValid(int x, int y, Board.Team team) {
        if (this.team != team || (x == coords[0] && y == coords[1]))
            return false;
        
        int copyX = Math.abs(x - coords[0]);
        int copyY = Math.abs(y - coords[1]);
        
        boolean canMoveX = false;
        boolean canMoveY = false;
        
        if (copyX == 2 && copyY == 1)
            canMoveX = true;
        if (copyY == 2 && copyX == 1) 
            canMoveY = true;
        
        Piece piece = Chess.board.getPiece(x,y);
        if (piece != null && piece.getTeam() == this.team)
            return false;
        
        return canMoveX ^ canMoveY;
    }
    
}
