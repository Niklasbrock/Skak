package game.leolord.Board;

import game.leolord.GUI.BoardGrid;

import game.leolord.Pieces.*;
import java.util.HashMap;
import java.util.Map;

public class GameBoard {

    private static Map<Integer, Piece> pieceMap;
    private int startMove;
    private int endMove;
    private boolean selectingStartMove;
    private boolean selectingEndMove;

    public void printBoard(){
        System.out.printf("\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", "--a-b-c-d-e-f-g-h--",
                "8-" + pieceMap.get(56).getIdentifier() + "-" + pieceMap.get(57).getIdentifier() + "-" + pieceMap.get(58).getIdentifier() + "-" + pieceMap.get(59).getIdentifier() + "-" + pieceMap.get(60).getIdentifier() + "-" + pieceMap.get(61).getIdentifier() + "-" + pieceMap.get(62).getIdentifier() + "-" + pieceMap.get(63).getIdentifier() + "-8",
                "7-" + pieceMap.get(48).getIdentifier() + "-" + pieceMap.get(49).getIdentifier() + "-" + pieceMap.get(50).getIdentifier() + "-" + pieceMap.get(51).getIdentifier() + "-" + pieceMap.get(52).getIdentifier() + "-" + pieceMap.get(53).getIdentifier() + "-" + pieceMap.get(54).getIdentifier() + "-" + pieceMap.get(55).getIdentifier() + "-7",
        "6-" + pieceMap.get(40).getIdentifier() + "-" + pieceMap.get(41).getIdentifier() + "-" + pieceMap.get(42).getIdentifier() + "-" + pieceMap.get(43).getIdentifier() + "-" + pieceMap.get(44).getIdentifier() + "-" + pieceMap.get(45).getIdentifier() + "-" + pieceMap.get(46).getIdentifier() + "-" + pieceMap.get(47).getIdentifier() + "-6",
        "5-" + pieceMap.get(32).getIdentifier() + "-" + pieceMap.get(33).getIdentifier() + "-" + pieceMap.get(34).getIdentifier() + "-" + pieceMap.get(35).getIdentifier() + "-" + pieceMap.get(36).getIdentifier() + "-" + pieceMap.get(37).getIdentifier() + "-" + pieceMap.get(38).getIdentifier() + "-" + pieceMap.get(39).getIdentifier() + "-5",
        "4-" + pieceMap.get(24).getIdentifier() + "-" + pieceMap.get(25).getIdentifier() + "-" + pieceMap.get(26).getIdentifier() + "-" + pieceMap.get(27).getIdentifier() + "-" + pieceMap.get(28).getIdentifier() + "-" + pieceMap.get(29).getIdentifier() + "-" + pieceMap.get(30).getIdentifier() + "-" + pieceMap.get(31).getIdentifier() + "-4",
        "3-" + pieceMap.get(16).getIdentifier() + "-" + pieceMap.get(17).getIdentifier() + "-" + pieceMap.get(18).getIdentifier() + "-" + pieceMap.get(19).getIdentifier() + "-" + pieceMap.get(20).getIdentifier() + "-" + pieceMap.get(21).getIdentifier() + "-" + pieceMap.get(22).getIdentifier() + "-" + pieceMap.get(23).getIdentifier() + "-3",
        "2-" + pieceMap.get(8).getIdentifier() + "-" + pieceMap.get(9).getIdentifier() + "-" + pieceMap.get(10).getIdentifier() + "-" + pieceMap.get(11).getIdentifier() + "-" + pieceMap.get(12).getIdentifier() + "-" + pieceMap.get(13).getIdentifier() + "-" + pieceMap.get(14).getIdentifier() + "-" + pieceMap.get(15).getIdentifier() + "-2",
        "1-" + pieceMap.get(0).getIdentifier() + "-" + pieceMap.get(1).getIdentifier() + "-" + pieceMap.get(2).getIdentifier() + "-" + pieceMap.get(3).getIdentifier() + "-" + pieceMap.get(4).getIdentifier() + "-" + pieceMap.get(5).getIdentifier() + "-" + pieceMap.get(6).getIdentifier() + "-" + pieceMap.get(7).getIdentifier() + "-1",
        "--a-b-c-d-e-f-g-h--");
    }

    public void movePiece(int startMove, int endMove){
        Piece bufferPiece = pieceMap.get(endMove);
        pieceMap.put(endMove, pieceMap.get(startMove));
        pieceMap.get(endMove).setCoordinate(endMove);
        if (bufferPiece.getPieceAlliance() == null){
            pieceMap.put(startMove, bufferPiece);
            pieceMap.get(startMove).setCoordinate(startMove);
        } else{
            pieceMap.put(startMove, new Filler(startMove));
        }
    }

    public void select(int selection){
        if (selectingStartMove){
            System.out.println("First Move: " + selection + " " + pieceMap.get(selection).getIdentifier() + pieceMap.get(selection).getPieceAlliance());
            startMove = selection;
            selectingStartMove = false;
            selectingEndMove = true;
        }else if (selectingEndMove){
            System.out.println("Second Move: " + selection + " " + pieceMap.get(selection).getIdentifier() + pieceMap.get(selection).getPieceAlliance());
            endMove = selection;
            selectingEndMove = false;
            selectingStartMove = true;
            movePiece(startMove, endMove);
        }
    }
    public void startGame(BoardGrid gameBoard){
        for (int i = 0; i < 64; i++){
            Piece pieceBuffer = pieceMap.get(i);
            pieceMap.get(i).getPieceButton().setOnMouseClicked(event -> {
                select(pieceBuffer.getCoordinate());
                if (selectingStartMove){
                    gameBoard.updateGrid(pieceMap);
                }
            });
        }
    }

    public boolean checkWinState(){
//        if either alliance king is absent return true
        return false;
    }
    public GameBoard(){
        selectingStartMove = true;
        selectingEndMove = false;
    }

    public Map<Integer, Piece> getStartPiecePositionMap(){
        Map<Integer, Piece> startMap = new HashMap<>();
        startMap.put(0, new Rook(0, Alliance.WHITE));
        startMap.put(1, new Knight(1, Alliance.WHITE));
        startMap.put(2, new Bishop(2, Alliance.WHITE));
        startMap.put(3, new Queen(3, Alliance.WHITE));
        startMap.put(4, new King(4, Alliance.WHITE));
        startMap.put(5, new Bishop(5, Alliance.WHITE));
        startMap.put(6, new Knight(6, Alliance.WHITE));
        startMap.put(7, new Rook(7, Alliance.WHITE));
        for (int i = 8; i < 16; i++){
            startMap.put(i, new Pawn(i, Alliance.WHITE));
        }
        for (int i = 16; i < 55; i++){
            startMap.put(i, new Filler(i));
        }

        startMap.put(63, new Rook(63, Alliance.BLACK));
        startMap.put(62, new Knight(62, Alliance.BLACK));
        startMap.put(61, new Bishop(61, Alliance.BLACK));
        startMap.put(60, new King(60, Alliance.BLACK));
        startMap.put(59, new Queen(59, Alliance.BLACK));
        startMap.put(58, new Bishop(58, Alliance.BLACK));
        startMap.put(57, new Knight(57, Alliance.BLACK));
        startMap.put(56, new Rook(56, Alliance.BLACK));
        for (int i = 55; i > 47; i--){
            startMap.put(i, new Pawn(i, Alliance.BLACK));
        }
        pieceMap = startMap;
        return startMap;
    }


    public Map<Integer, Piece> getPieceMap() {
        return pieceMap;
    }

    public void setPieceMap(Map<Integer, Piece> pieceMap) {
        this.pieceMap = pieceMap;
    }
}
