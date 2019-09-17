package game.leolord.Game;

import javafx.application.Application;
import javafx.stage.Stage;

public class GUIMain extends Application {

    @Override
    public void start(Stage primaryStage){
        Game newGame = new Game();
        newGame.start();
    }
    public static void main(String[] args) {
        launch(args);
    }
}