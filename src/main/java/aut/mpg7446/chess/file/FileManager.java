/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aut.mpg7446.chess.file;

import aut.mpg7446.chess.Board;
import aut.mpg7446.chess.Chess;
import aut.mpg7446.chess.pieces.Piece;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author mpg7446
 */
public class FileManager {
        private Piece[][] internalLayout; // holds saved board starting layout (read from file)
        private Piece[][] internalBoard; // holds last saved board (read from file) - might not impliment saving feature
        private Board.Team internalLayoutTeam;
        private Board.Team internalBoardTeam;
        
        private String layoutFileLocation;
        private String boardFileLocation;
        
        public Piece[][] getInternalLayout() {
            return internalLayout;
        }
        
        public Piece[][] getInternalBoard() {
            return internalBoard;
        }
        
        public Board.Team getInternalLayoutTeam() {
            return internalLayoutTeam;
        }
        
        public Board.Team getInternalBoardTeam() {
            return internalBoardTeam;
        }
        
        public FileManager(String layoutFileLocation, String boardFileLocation) throws IOException {
            this.boardFileLocation = boardFileLocation;
            this.layoutFileLocation = layoutFileLocation;
            ReadLayout();
            ReadBoard();
        }
        
        public void ReadLayout() throws IOException {
            BoardFileReader fr = new BoardFileReader(layoutFileLocation);
            internalLayoutTeam = fr.ReadLastTeam();
            internalLayout = fr.ReadBoard();
            fr.close();
        }
        
        public void ReadBoard() {
            try {
                BoardFileReader fr = new BoardFileReader(boardFileLocation);
                internalBoardTeam = fr.ReadLastTeam();
                internalBoard = fr.ReadBoard();
                
                if (Chess.consoleInputs.askForChar("Found previously saved game, load save?", new char[]{'y','n'}) == 'n') {
                    System.out.println("Starting new game!");
                internalBoardTeam = internalLayoutTeam;
                    internalBoard = internalLayout;
                } else {
                    System.out.println("Loading saved game!");
                }
                fr.close();
            } catch (Exception ignore) {
                System.out.println("No saved board found, starting new game!");
                internalBoardTeam = internalLayoutTeam;
                internalBoard = internalLayout;
            }
        }
        
        public void WriteBoard() throws FileNotFoundException {
            BoardFileWriter fr = new BoardFileWriter(boardFileLocation);
            fr.WriteBoard(Chess.board.getBoard());
            fr.close();
        }
        
        public void resetInternalBoard() {
            internalBoard = internalLayout;
        }
}
