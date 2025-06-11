/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aut.mpg7446.chess;

import aut.mpg7446.chess.pieces.Piece;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author mpg7446
 */
public class ConsoleInputs {
    private static Scanner scanner;
    
    public ConsoleInputs() {
        scanner = new Scanner(System.in);
    }
    
    private char nextChar() {
        return scanner.next().charAt(0);
    }
    
    public char askForChar(String question, char[] validChars) {
        String validList = " (";
        for (char i : validChars) 
            validList += Character.toUpperCase(i) + "/";
        validList = validList.substring(0, validList.length() - 1) + ")";
        
        boolean valid = false;
        char next = 0;
        
        while (!valid) {
            System.out.println(question + validList);
            next = Character.toLowerCase(nextChar());
            confirmQuit(next);
            
            for (char ref : validChars) {
                if (ref == next) {
                    valid = true;
                    break;
                }
            }
            if (!valid)
                System.out.println("Incorrent input type.");
        }
        return next;
    }
    
    public void askForMove(Board.Team team) {
        boolean valid = false;
        while (!valid) {
            // retrieve moves starting position
            System.out.print(team.getName() + " select piece to move (e.g. H2): ");
            String start = scanner.next().toLowerCase();
            if (!validMove(start)) {
                continue;
            }
            
            // retrieve moves destination
            System.out.print(team.getName() + " select destination (e.g. H2): ");
            String destination = scanner.next().toLowerCase();
            if (!validMove(destination)) {
                continue;
            }
            
            // check if piece at starting position is valid
            Piece piece = Chess.board.getPiece(new int[]{start.charAt(0) - 'a', start.charAt(1) - '1'});
            if (piece == null || piece.getTeam() == Board.Team.NULL) {
                System.out.println("Could not find piece");
                continue;
            }
            
            // attempt to move piece to destination
            valid = piece.Move(new int[]{destination.charAt(0) - 'a', destination.charAt(1) - '1'}, team);
            if (!valid) {
                System.out.println("Invalid move for piece " + piece);
            }
        }
    }
    
    private boolean validMove(String move) {
        char[] moveArray = move.toCharArray();
        // check if move is a quite request (q)
        confirmQuit(moveArray[0]);
//        if (moveArray[0] == 'q'){
//            char quit = askForChar("Are you sure you want to quit?", new char[]{'y','n'});
//            if (quit == 'y') {
//                char save = askForChar("Would you like to save current game?", new char[]{'y','n'});
//                if (save == 'y')
//                    Chess.quitGame(true);
//                Chess.quitGame(false);
//            }
//            return false;
//        }
        
        // check if move matches "A1" format
        if (moveArray.length != 2 || moveArray[0] < 'a' || moveArray[0] > 'h' || moveArray[1] < '1' || moveArray[1] > '8') {
            System.out.println("Invalid move, couild not recognise input.");
            return false;
        }
        return true;
    }
    
    public void askForNewGame(Board.Team winningTeam) {
        // King was taken, ask player if they want to start a new game?
        char input = askForChar(winningTeam.getName() + " Won!\nStart a new game?",new char[]{'y','n'});
        if (input == 'n')
            System.exit(0);
        
        Chess.fileManager.resetInternalBoard();
    }
    
    private void confirmQuit(char input) {
        if (input == 'q' || input == 'Q') {
            char quit = askForChar("Are you sure you want to quit?", new char[]{'y','n'});
            if (quit == 'y') {
                char save = askForChar("Would you like to save current game?", new char[]{'y','n'});
                if (save == 'y')
                    Chess.quitGame(true);
                Chess.quitGame(false);
            }
        }
    }
}
