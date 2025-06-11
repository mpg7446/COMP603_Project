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
public class ExtendablePiece extends Piece {
    
    protected Direction direction;
    public enum Direction{
        STRAIGHT,
        DIAGONAL,
        COMBINED
    }
    
    public ExtendablePiece(int ID, Board.Team team, int[] coords, char icon, Direction direction) {
        super(ID, team, coords, icon, new int[]{0,0}, true);
        this.direction = direction;
    }
    
    @Override
    protected boolean isValid(int x, int y, Board.Team team) {
        if (this.team != team || (x == coords[0] && y == coords[1]))
            return false;
        
        boolean canMoveStraight = false;
        boolean canMoveDiagonal = false;
        
        // check diagonal
        if (direction == Direction.STRAIGHT || direction == Direction.COMBINED)
            if ((x == coords[0]) ^ (y == coords[1])) 
                canMoveStraight = true;
        
        // check straight
        if (direction == Direction.DIAGONAL || direction == Direction.COMBINED) {
            int copyX = Math.abs(x - coords[0]);
            int copyY = Math.abs(y - coords[1]);
            if (copyX == copyY)
                canMoveDiagonal = true;
        }
        
        if (canMoveStraight || canMoveDiagonal) {
            // check if piece isnt moving to same team piece
            Piece piece = Chess.board.getPiece(x, y);
            if (piece != null && piece.getTeam() == this.team)
                return false;
            
            // check pieces in between
            int dirX = 0;
            if (x > coords[0])
                dirX = 1;
            else if (x < coords[0])
                dirX = -1;
            
            int dirY = 0;
            if (y > coords[1])
                dirY = 1;
            else if (y < coords[1])
                dirY = -1;
            
            return isValidBetween(x, y, dirX, dirY);
        }
        return false;
    }
    
    // loop through values between current destination and location to check for validity
    private boolean isValidBetween(int x, int y, int dirX, int dirY) {
        x -= dirX;
        y -= dirY;
        if (coords[0] == x && coords[1] == y)
            return true;
        
        Piece piece = Chess.board.getPiece(x, y);
        if (piece != null && piece.getTeam() != Board.Team.NULL)
            return false;
        
        return isValidBetween(x, y, dirX, dirY);
    }
    
}
