/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package aut.mpg7446.chess;

import aut.mpg7446.chess.file.FileManager;
import aut.mpg7446.chess.gui.Screen;
import aut.mpg7446.chess.gui.ScreenManager;
import aut.mpg7446.chess.gui.component.TextComponent;
import aut.mpg7446.chess.pieces.PieceConvertor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JComponent;
import javax.swing.JFrame;

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
    
    // Networking
    public static Connection conn;
    public static String url = "jdbc:derby://localhost:1527/ChessDB;create=true";
    public static String username = "root";
    public static String password = "123";

    public static void main(String[] args) throws FileNotFoundException, IOException {
//        if (!establishConnection()) {
//            return;
//        }
//        
//        // start Derby connection
//        Scanner scanner = new Scanner(System.in); // change this to GUI later
//        do {
//            System.out.print("Enter Database Username: ");
//            username = scanner.nextLine();
//            System.out.print("Enter Database Password: ");
//            password = scanner.nextLine();
//        } while (!establishConnection());
//        scanner.close();

        LinkedList<JComponent> components = new LinkedList<JComponent>();
        components.add(new TextComponent("ass", 150, 100));
        ScreenManager.setScreens(new Screen("Chess",300, 200, JFrame.EXIT_ON_CLOSE, components),
                new Screen("Load Save", 200, 150, JFrame.DISPOSE_ON_CLOSE, new LinkedList<JComponent>()));
        ScreenManager.setScreen(ScreenManager.boardScreen);
        
        fileManager = new FileManager("resources/layout.txt","resources/saved_board.txt");
        startGame();
    }
    
    // TODO move this into seperate connection manager class
    public static boolean establishConnection() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully to " + url);
            return true;
        } catch (SQLException e) {
            System.err.println("Failed to connect: " + e.getMessage());
            return false;
        }
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
