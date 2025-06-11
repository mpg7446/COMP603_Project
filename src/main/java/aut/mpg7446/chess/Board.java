/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aut.mpg7446.chess;

import aut.mpg7446.chess.pieces.*;

/**
 *
 * @author mpg7446
 */
public class Board {
    private Piece[][] board = new Piece[8][8];
    public static enum Team {
        NULL(0, "Empty Space"),
        WHITE(1, "White"),
        BLACK(2, "Black");
        
        private final int value;
        private final String name;
        private Team(int value, String name) {
            this.value = value;
            this.name = name;
        }
        
        public int getValue() {
            return value;
        }
        
        public String getName() {
            return name;
        }
    }
    
    public Piece[][] getBoard() {
        return board;
    }
    
    public Board(Piece[][] pieces) {
        if (pieces != null)
            board = pieces;
    }
    
    public Piece getPiece(int x, int y) {
        // return new empty space piece if null found in board - so that rendering doesnt spam "NULL NULL NULL" instead of rendering the board lmao
        if (board[x][y] == null)
            return new Piece(new int[]{x,y});
        return board[x][y];
    }
    
    public Piece getPiece(int[] pos) {
        return getPiece(pos[0],pos[1]);
    }
    
    public void setPiece(Piece piece, int[] coords) {
        int x = coords[0];
        int y = coords[1];
        
        board[x][y] = piece;
    }
    
    public void move(int[] a, int[] b) {
        // check for king
        if (getPiece(b) instanceof King) {
            Chess.consoleInputs.askForNewGame(getPiece(a).getTeam());
            Chess.playing = false;
            return;
        }
        
        Piece piece = getPiece(a);
        // move piece if destination is not over king
        setPiece(piece, b);
        setPiece(new Piece(a),a);
    }
}
