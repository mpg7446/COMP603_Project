/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package aut.mpg7446.chess;

import aut.mpg7446.chess.file.FileManager;
import aut.mpg7446.chess.pieces.PieceConvertor;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author mpg7446
 */
public class Chess {
    
    public static Board board;
    public static PieceConvertor pieceConvertor = new PieceConvertor();
    public static ConsoleInputs consoleInputs = new ConsoleInputs();
    public static Renderer renderer;
    public static FileManager fileManager;
    
    public static Board.Team playingTeam;
    public static boolean playing;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        fileManager = new FileManager("resources/layout.txt","resources/saved_board.txt");
        startGame();
    }
    
    public static void startGame() {
        board = new Board(fileManager.getInternalBoard());
        playingTeam = fileManager.getInternalBoardTeam();
        renderer = new Renderer(board);
        
        playing = true;
        while (playing) {
            renderer.Render();
            consoleInputs.askForMove(playingTeam);
            
            if (playingTeam == Board.Team.WHITE)
                playingTeam = Board.Team.BLACK;
            else 
                playingTeam = Board.Team.WHITE;
        }
        // start new game after game has been played & has not been exited
        startGame();
    }
    
    public static void quitGame(boolean save) {
        if (save)
            try {
            fileManager.WriteBoard();
            } catch (Exception ignore) {
                System.out.println("ERROR: failed to save current board state, file not accessible.");
            }
        System.exit(0);
    }
}
