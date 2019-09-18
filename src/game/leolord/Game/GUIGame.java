package game.leolord.Game;

import game.leolord.Board.GameBoard;
import game.leolord.GUI.BoardGrid;
import game.leolord.GUI.GameStage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIGame extends Application {
    boolean gameOver;
    GameBoard gameBoard;
    BoardGrid boardGrid;


    @Override
    public void start(Stage primaryStage){
        GameStage gameStage = new GameStage();
        gameBoard = new GameBoard();
        gameStage.setScene(new Scene(boardGrid = new BoardGrid().setStartGrid(gameBoard.getStartPiecePositionMap())));

        gameBoard.startGame(boardGrid);

        gameOver = false;

    }

    public static void main(String[] args) {
        launch(args);
    }
}