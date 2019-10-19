package game.leolord.GUI;


import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class GameStage extends Stage {
    double xOffset;
    double yOffset;

    public GameStage(GameGrid gameGrid){

        setResizable(false);
        initStyle(StageStyle.UNDECORATED);
        
        gameGrid.setOnMousePressed(event -> {
            xOffset = getX() - event.getScreenX();
            yOffset = getY() - event.getScreenY();
        });
        gameGrid.setOnMouseDragged(event -> {
            setX(event.getScreenX() + xOffset);
            setY(event.getScreenY() + yOffset);
        });

        show();
    }


}
