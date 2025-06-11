/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aut.mpg7446.chess.pieces;

import aut.mpg7446.chess.Board;

/**
 *
 * @author mpg7446
 */
public class SpecialStartPiece extends Piece {
    protected boolean moved = false;
    
    protected int start_move_x;
    protected int start_move_y;

    public SpecialStartPiece(int ID, Board.Team team, int[] coords, char icon, int[] move, int[] firstMove, boolean directional, boolean moved) {
        super(ID, team, coords, icon, move, directional);
        start_move_x = firstMove[0];
        start_move_y = firstMove[1];
        this.moved = moved;
    }
    
    public boolean hasMoved() {
        return moved;
    }
    
    @Override
    protected boolean isValid(int x, int y, Board.Team team) {
        if (this.team != team || (x == coords[0] && y == coords[1]))
            return false;
        
        if (super.isValid(x, y, team)) {
            moved = true;
            return true;
        }
        
        // piece has already used first move, cannot continue with move
        if (moved)
            return false;
        
        boolean canMoveX = false;
        boolean canMoveY = false;
        
        if (directional) {
            y -= coords[1];
            if (this.team == Board.Team.BLACK)
                y *= -1;
        } else
            y = Math.abs(x - coords[1]);
        x = Math.abs(x - coords[0]);
        
        if (x == start_move_x)
            canMoveX = true;
        if (y == start_move_y)
            canMoveY = true;
        
        if (canMoveX && canMoveY) {
            moved = true;
            return true;
        }
        return false;
    }
}
