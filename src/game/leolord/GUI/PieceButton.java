package game.leolord.GUI;

import game.leolord.Pieces.Piece;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class PieceButton extends Button {
    private boolean selected;

    public PieceButton(Piece piece) {
        setPrefSize(75, 75);
        setOnMouseClicked(event -> selected = true);
        if (piece.getPieceAlliance() != null){
            String fileName = piece.getPieceAlliance().name() + piece.getIdentifier() + ".gif";
            System.out.println(fileName);
            Image image = new Image(getClass().getResourceAsStream("textures/"+fileName));
            setGraphic(new ImageView(image));
        }
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
