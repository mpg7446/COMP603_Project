/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aut.mpg7446.chess.pieces;

import aut.mpg7446.chess.Board;
import aut.mpg7446.chess.Chess;

/**
 *
 * @author mpg7446
 */
public class Piece {
    // rendering and parsing data for identifying piece
    protected char icon = '.'; // default value for rendering white space
    protected int intID = -1; // default value for rendering white space
    protected Board.Team team = Board.Team.NULL; // default value for rendering white space
    
    // coords on board
    protected int[] coords;
    
    // how far can piece move in directions
    protected int move_x = 0;
    protected int move_y = 0;
    
    // can move in any direction (default: false)
    protected boolean directional = false;
    
    public int getID() {
        return intID;
    }
    
    public Board.Team getTeam() {
        return team;
    }
    
    public Piece(int ID, Board.Team team, int[] coords, char icon, int[] move, boolean directional) {
        intID = ID;
        this.team = team;
        this.coords = coords;
        this.icon = icon;
        move_x = move[0];
        move_y = move[1];
        this.directional = directional;
    }
    
    public Piece(int[] coords) {
        this.coords = coords;
    }
    
    @Override
    public String toString() {
        if (team == Board.Team.WHITE)
            return icon+"";
        return Character.toUpperCase(icon)+"";
    }
    
    protected boolean isValid(int x, int y, Board.Team team) {
        if (this.team != team || (x == coords[0] && y == coords[1]))
            return false;
        
        boolean canMoveX = false;
        boolean canMoveY = false;
        
        if (directional) {
            y -= coords[1];
            if (this.team == Board.Team.BLACK)
                y *= -1;
        } else
            y = Math.abs(x - coords[1]);
        x = Math.abs(x - coords[0]);
        
        if (x == move_x)
            canMoveX = true;
        if (y == move_y)
            canMoveY = true;
        
        return canMoveX && canMoveY;
    }
    
    public boolean Move(int[] move, Board.Team team) {
//        System.out.println("//attempting to move " + this.team.getName() + " piece " + icon);
        if (!isValid(move[0], move[1], team))
            return false;
        
        Chess.board.move(coords, move);
        coords = move;
        return true;
    }
}
