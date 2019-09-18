package game.leolord.GUI;

import game.leolord.Pieces.Piece;
import javafx.scene.control.Button;

public class PieceButton extends Button {
    private boolean selected;

    public PieceButton(Piece piece) {
        if (piece.getPieceAlliance() != null) {
            setText(piece.getPieceAlliance().name() + "\n" + piece.getIdentifier());
        }
        setPrefSize(60, 60);
        setOnMouseClicked(event -> selected = true);
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
