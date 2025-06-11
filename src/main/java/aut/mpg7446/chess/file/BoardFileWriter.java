/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aut.mpg7446.chess.file;

import aut.mpg7446.chess.Board;
import aut.mpg7446.chess.Chess;
import aut.mpg7446.chess.pieces.Piece;
import aut.mpg7446.chess.pieces.SpecialStartPiece;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author mpg7446
 */
public class BoardFileWriter {
    private PrintWriter output;
    
    public BoardFileWriter(String file) throws FileNotFoundException {
        output = new PrintWriter(new FileOutputStream(file));
    }
    
    public void WriteBoard(Piece[][] board) {
        output.println(Chess.playingTeam == Board.Team.BLACK ? 2 : 1);
        for (int y = 0; y < 8; y++) {
            String line = "";
            for (int x = 0; x < 8; x++) {
                Piece piece = board[x][y];
                char id = (char) (piece.getID() + 48);
                int team = piece.getTeam().getValue();
                line += id + "" + team;
                
                if (piece instanceof SpecialStartPiece) 
                    line += ((SpecialStartPiece) piece).hasMoved() ? 1 : 0;
                line += " ";
            }
            output.println(line);
        }
    }
    
    public void close() {
        output.close();
    }
}
