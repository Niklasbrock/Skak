package game.leolord.GUI;

import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GameGrid extends GridPane {
    private BoardGrid boardGrid;
    private MenuGrid menuGrid;
    private Label whiteWonLabel;
    private Label blackWonLabel;

    public GameGrid(BoardGrid boardGrid, MenuGrid menuGrid) {
        this.boardGrid = boardGrid;
        this.menuGrid = menuGrid;
        add(menuGrid, 0,0);
        add(boardGrid, 1,0);
        setAlignment(Pos.CENTER);
        setHgap(25);
        setStyle("-fx-background-image: url('file:src/resources/background.jpg')");
        setMinSize(1000, 900);

        whiteWonLabel = new Label("White Won!");
        whiteWonLabel.setStyle("-fx-text-fill: white; -fx-font-size: 18");
        add(whiteWonLabel, 0, 0);
        setValignment(whiteWonLabel, VPos.TOP);
        whiteWonLabel.setVisible(false);

        blackWonLabel = new Label("Black Won!");
        add(blackWonLabel, 0, 0);
        blackWonLabel.setStyle("-fx-text-fill: white; -fx-font-size: 18");
        setValignment(blackWonLabel, VPos.TOP);
        blackWonLabel.setVisible(false);
    }

    public void showWinner(boolean whiteWon){
        if (whiteWon){
            whiteWonLabel.setVisible(true);
        } else{
            blackWonLabel.setVisible(true);
        }
    }

    public BoardGrid getBoardGrid() {
        return boardGrid;
    }

    public void setBoardGrid(BoardGrid boardGrid) {
        this.boardGrid = boardGrid;
    }

    public MenuGrid getMenuGrid() {
        return menuGrid;
    }

    public void setMenuGrid(MenuGrid menuGrid) {
        this.menuGrid = menuGrid;
    }

    public Label getWhiteWonLabel() {
        return whiteWonLabel;
    }

    public void setWhiteWonLabel(Label whiteWonLabel) {
        this.whiteWonLabel = whiteWonLabel;
    }

    public Label getBlackWonLabel() {
        return blackWonLabel;
    }

    public void setBlackWonLabel(Label blackWonLabel) {
        this.blackWonLabel = blackWonLabel;
    }
}
