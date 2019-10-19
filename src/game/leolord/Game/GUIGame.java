package game.leolord.Game;

import game.leolord.Board.GameBoard;
import game.leolord.GUI.BoardGrid;
import game.leolord.GUI.GameGrid;
import game.leolord.GUI.GameStage;
import game.leolord.GUI.MenuGrid;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIGame extends Application {

    @Override
    public void start(Stage primaryStage){
        GameBoard gameBoard = new GameBoard();
        GameGrid gameGrid = new GameGrid(new BoardGrid().updateGrid(gameBoard.getStartPiecePositionMap()), new MenuGrid());
        GameStage gameStage = new GameStage(gameGrid);
        gameStage.setScene(new Scene(gameGrid));
        gameBoard.setupGameListeners(gameGrid);
    }

    public static void main(String[] args) {
        launch(args);
    }
}