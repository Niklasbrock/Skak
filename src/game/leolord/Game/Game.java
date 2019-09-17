package game.leolord.Game;

import game.leolord.Board.GameBoard;
import game.leolord.GUI.BoardGrid;
import game.leolord.GUI.BoardScene;
import game.leolord.GUI.GameStage;

import java.util.Scanner;


public class Game implements Runnable {
    boolean gameOver;
    GameBoard gameBoard;
    BoardGrid boardGrid;
    Scanner input;

    public void start(){
//        Start of game
        System.out.println("\n---CHESS---\nPlay by entering start move + end move");
        gameBoard = new GameBoard();
        GameStage gameStage = new GameStage();
        gameStage.setScene(new BoardScene(boardGrid = new BoardGrid().updateGrid(gameBoard.getStartPiecePositionMap())));
        input = new Scanner(System.in);
        gameOver = false;
//        run();
    }
    public void run(){
//        Run main game loop
        gameBoard.startMove();
        gameBoard.endMove();
        boardGrid.updateGrid(gameBoard.getPieceMap());
//        while (!gameOver){
//            System.out.println("White Turn: ");
//            gameBoard.movePiece(input.nextInt(), input.nextInt());
//            gameBoard.printBoard();
//            System.out.println("Black Turn: ");
//            gameBoard.movePiece(input.nextInt(), input.nextInt());
//            gameBoard.printBoard();
//        }
    }

    public void stop(){
    }
}
