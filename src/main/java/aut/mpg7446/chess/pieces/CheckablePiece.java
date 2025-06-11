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
public class CheckablePiece extends Piece {
    
    public CheckablePiece(int ID, Board.Team team, int[] coords, char icon, int[] move, boolean directional) {
        super(ID, team, coords, icon, move, directional);
    }
    
}
