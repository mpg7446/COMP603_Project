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
public class Queen extends ExtendablePiece {
    
    public Queen(Board.Team team, int[] coords) {
        super(2, team, coords, 'q', Direction.COMBINED);
    }
    
}
