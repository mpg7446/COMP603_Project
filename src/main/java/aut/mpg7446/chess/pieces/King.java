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
public class King extends CheckablePiece {
    
    public King(Board.Team team, int[] coords) {
        super(1, team, coords, 't', new int[]{1,1}, false);
    }
    
    @Override
    protected boolean isValid(int x, int y, Board.Team team) {
        if (this.team != team || (x == coords[0] && y == coords[1]))
            return false;
        
        boolean canMoveX = false;
        boolean canMoveY = false;
        
        if (Math.abs(x - coords[0]) == move_x)
            canMoveX = true;
        if (Math.abs(y - coords[1]) == move_y)
            canMoveY = true;
        
        if (canMoveX || canMoveY) {
            Piece piece = Chess.board.getPiece(x, y);
            if (piece != null && piece.getTeam() == this.team)
                return false;
            return true;
        }
        
        return false;
    }
}
