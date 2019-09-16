package game.leolord.Game;

import game.leolord.Board.GameBoard;

import java.util.Scanner;


public class Game implements Runnable {
    boolean gameOver;
    GameBoard gameBoard;
    Scanner input;

    public void start(){
//        Start of game
        System.out.println("\n---CHESS---\nPlay by entering start move + end move");
        gameBoard = new GameBoard();
        input = new Scanner(System.in);
        gameOver = false;
        run();
    }
    public void run(){
//        Run main game loop
        while (!gameOver){
            System.out.println("White Turn: ");
            gameBoard.movePiece(input.nextInt(), input.nextInt());
            gameBoard.printBoard();
            System.out.println("Black Turn: ");
            gameBoard.movePiece(input.nextInt(), input.nextInt());
            gameBoard.printBoard();
        }
    }

    public void stop(){
    }
}
