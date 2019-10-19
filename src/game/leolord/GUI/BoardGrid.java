package game.leolord.GUI;

import game.leolord.Pieces.Piece;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.Map;

public class BoardGrid extends GridPane {

    public BoardGrid(){
        setHgap(10);
        setVgap(10);
        setAlignment(Pos.CENTER);
    }

    public BoardGrid updateGrid(Map<Integer, Piece> pieceMap){
        int row = 0;
        int column = 0;
        for (int i = 0; i < 64; i++){
            if (i % 8 == 0){
                column++;
                row = 0;
            }
            getChildren().remove(pieceMap.get(i).getPieceButton());
            add(pieceMap.get(i).getPieceButton(), row, column);
            setBoardColor(i, row, column, pieceMap);
            row++;
            }
        return this;
    }

    public void setBoardColor(int i, int row, int column, Map<Integer, Piece> pieceMap){
        pieceMap.get(i).getPieceButton().setStyle("-fx-background-color: white; -fx-focus-color: transparent;");
        if (row % 2 != 0 && column % 2 != 0 ){
            pieceMap.get(i).getPieceButton().setStyle("-fx-background-color: #110e0d; -fx-focus-color: transparent;");
        } else if (row % 2 == 0 && column % 2 == 0){
            pieceMap.get(i).getPieceButton().setStyle("-fx-background-color: #110e0d; -fx-focus-color: transparent;");
        }
    }


//    public BoardGrid setStartGrid(Map<Integer, Piece> pieceMap){
//        int row = 0;
//        int column = 0;
//        for (int i = 0; i < 64; i++){
//            pieceMap.get(i).getPieceButton().setText("" + pieceMap.get(i).getCoordinate());
//            if (i % 8 == 0){
//                column++;
//                row = 0;
//            }
//            add(pieceMap.get(i).getPieceButton(), row, column);
//            setBoardColor(i, row, column, pieceMap);
////            if (row % 2 != 0 && column % 2 != 0 ){
////                pieceMap.get(i).getPieceButton().setStyle("-fx-background-color: grey");
////            } else if (row % 2 == 0 && column % 2 == 0){
////                pieceMap.get(i).getPieceButton().setStyle("-fx-background-color: grey");
////            }
//            row++;
//        }
//        return this;

//    }
}
