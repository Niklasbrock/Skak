package game.leolord.GUI;

import game.leolord.Pieces.Piece;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

import java.util.Map;

public class BoardGrid extends GridPane {

    public BoardGrid(){
        setHgap(10);
        setVgap(10);
        setAlignment(Pos.CENTER);
    }

    public BoardGrid setStartGrid(Map<Integer, Piece> pieceMap){
        int row = 0;
        int column = 0;
        for (int i = 0; i < 64; i++){
            if (i % 8 == 0){
                row++;
                column = 0;
            }
            add(pieceMap.get(i).getPieceButton(), column, row);
            column++;
        }
        return this;
    }
}
