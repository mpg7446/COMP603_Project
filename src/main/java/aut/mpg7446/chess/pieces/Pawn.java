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
public class Pawn extends SpecialStartPiece {
    public Pawn(Board.Team team, int[] coords, boolean moved) {
        super(0, team, coords, 'o', new int[]{0, 1}, new int[]{0, 2}, true, moved);
    }
    
    @Override
    protected boolean isValid(int x, int y, Board.Team team) {
        if (this.team != team || (x == coords[0] && y == coords[1]))
            return false;
        
        // check if piece is already present at destination
        Piece piece = Chess.board.getPiece(x, y);
        if (piece != null && piece.getTeam() != Board.Team.NULL && x == coords[0]) {
            // check diagonal move
            if (!moved && Math.abs(x - coords[0]) == 1 && piece.getTeam() != this.team)
                return true;
            return false;
        }
        
        return super.isValid(x, y, team);
    }
    
    @Override
    public boolean Move(int[] move, Board.Team team) {
        boolean stored = super.Move(move, team);
        
        if (this.team == Board.Team.WHITE && coords[1] == 7)
            replaceQueen();
        else if (this.team == Board.Team.BLACK && coords[1] == 0)
            replaceQueen();
        
        return stored;
    }
    
    private void replaceQueen() {
        Chess.board.setPiece(new Queen(this.team, coords), coords);
    }
}
