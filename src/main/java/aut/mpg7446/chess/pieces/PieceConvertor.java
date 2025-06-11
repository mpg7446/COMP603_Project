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
public class PieceConvertor {
    public static Piece IndexPiece(int id, Board.Team team, int[] coords) {
        switch(id) {
            case 0:
                return new Pawn(team, coords, false);
            case 1:
                return new King(team, coords);
            case 2:
                return new Queen(team, coords);
            case 3:
                return new Rook(team, coords);
            case 4:
                return new Bishop(team, coords);
            case 5:
                return new Knight(team, coords);
            default:
                return new Piece(coords);
        }
    }
}
