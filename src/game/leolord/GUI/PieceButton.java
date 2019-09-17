package game.leolord.GUI;

import game.leolord.Pieces.Piece;
import javafx.scene.control.Button;

public class PieceButton extends Button {

    public PieceButton(Piece piece) {
        if (piece.getPieceAlliance() != null) {
            setText(piece.getPieceAlliance().name() + "\n" + piece.getIdentifier());
        }
        setPrefSize(60, 60);

    }

}
