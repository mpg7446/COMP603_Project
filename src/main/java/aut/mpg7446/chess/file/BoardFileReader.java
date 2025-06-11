/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aut.mpg7446.chess.file;

import aut.mpg7446.chess.Board;
import aut.mpg7446.chess.Chess;
import aut.mpg7446.chess.pieces.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author mpg7446
 */
public class BoardFileReader {
    private BufferedReader input;
    
    public BoardFileReader(String file) throws FileNotFoundException {
        input = new BufferedReader(new FileReader(file));
    }
    
    public Board.Team ReadLastTeam() {
        try {
            StringTokenizer tokenizer = new StringTokenizer(input.readLine());
            switch (tokenizer.nextToken().charAt(0)) {
                case '2':
                    return Board.Team.BLACK;
                default:
                    return Board.Team.WHITE;
            }
        } catch (Exception ignore) {
            return Board.Team.WHITE;
        }
    }
    
    public Piece[][] ReadBoard() throws IOException { // TODO shit ass fuck 
        Piece[][] pieces = new Piece[8][8];
        
        for (int y = 0; y < 8; y++) {
            StringTokenizer tokenizer = new StringTokenizer(input.readLine());
            
            for (int x = 0; x < 8; x++) {
                String token = tokenizer.nextToken();
                if (validTokenLength(token)) {
                    int id = token.charAt(0) - 48;
                    Board.Team team = Board.Team.values()[token.charAt(1)-48];
                    pieces[x][y] = Chess.pieceConvertor.IndexPiece(id, team, new int[]{x,y});
                    
                    Boolean moved = false;
                    if (id == 0) {
                        try {
                            moved = token.charAt(2) - 48 == 1 ? true : false;
                        } catch (Exception ignore) { };
                        pieces[x][y] = new Pawn(team, new int[]{x,y}, moved);
                    } 
                }
            }
        }
        return pieces;
    }
    
    private boolean validTokenLength(String token) {
        if (token.length() == 2 || token.length() == 3)
            return true;
        return false;
    }
    
    public void close() throws IOException {
        input.close();
    }
}
