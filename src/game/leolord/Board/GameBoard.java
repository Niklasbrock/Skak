package game.leolord.Board;

import game.leolord.GUI.BoardGrid;
import game.leolord.GUI.GameGrid;
import game.leolord.Pieces.*;
import javafx.scene.media.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class GameBoard {

    private static Map<Integer, Piece> pieceMap;
    private int startMove;
    private int endMove;
    private boolean selectingStartMove;
    private boolean selectingEndMove;
    private boolean muted = false;
    private Media musicMedia = new Media(new File("src/resources/tavern.mp3").toURI().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(musicMedia);


    public void movePiece(int startMove, int endMove){

        Piece bufferPiece = pieceMap.get(endMove);
        pieceMap.put(endMove, pieceMap.get(startMove));
        pieceMap.get(endMove).setCoordinate(endMove);
//        if player moves to empty tile
        if (bufferPiece.getPieceAlliance() == null){
            pieceMap.replace(startMove, bufferPiece);
            pieceMap.get(startMove).setCoordinate(startMove);
//            if player moves to non empty tile
        } else {
            pieceMap.replace(startMove, new Filler(startMove));
        }
    }

    public void select(int selection){
        if (selectingStartMove){
            if (pieceMap.get(selection).getPieceAlliance() != null) {
                System.out.println("First Move: " + selection + " " + pieceMap.get(selection).getIdentifier() + pieceMap.get(selection).getPieceAlliance());
                startMove = selection;
                selectingStartMove = false;
                selectingEndMove = true;
            }
        }else if (selectingEndMove){
            if (pieceMap.get(selection).getPieceAlliance() != pieceMap.get(startMove).getPieceAlliance()){
                System.out.println("Second Move: " + selection + " " + pieceMap.get(selection).getIdentifier() + pieceMap.get(selection).getPieceAlliance());
                endMove = selection;
                selectingEndMove = false;
                selectingStartMove = true;
                movePiece(startMove, endMove);
            }
        }
    }
    public void setupGameListeners(GameGrid gameGrid){
        for (int i = 0; i < 64; i++){
            Piece pieceBuffer = pieceMap.get(i);
            pieceMap.get(i).getPieceButton().setOnMouseClicked(event -> {
                    select(pieceBuffer.getCoordinate());
                    pieceBuffer.getPieceButton().setStyle("-fx-background-color: #eab47d");
                if (selectingStartMove){
                    gameGrid.getBoardGrid().updateGrid(pieceMap);
                    setupGameListeners(gameGrid);
                    checkWinState(gameGrid);
                }
            });
        }
        gameGrid.getMenuGrid().getMute().setOnMouseClicked(event -> {
            if (!muted){
                mediaPlayer.setMute(true);
                muted = true;
                gameGrid.getMenuGrid().getMute().setText("Unmute");
            } else{
                mediaPlayer.setMute(false);
                muted = false;
                gameGrid.getMenuGrid().getMute().setText("Mute");
            }
        });
        gameGrid.getMenuGrid().getExitGame().setOnMouseClicked(event -> System.exit(0));
        gameGrid.getMenuGrid().getRestart().setOnMouseClicked(event -> {
            gameGrid.setBoardGrid(gameGrid.getBoardGrid().updateGrid(getStartPiecePositionMap()));
            gameGrid.getBlackWonLabel().setVisible(false);
            gameGrid.getWhiteWonLabel().setVisible(false);
            setupGameListeners(gameGrid);
        });
    }


    public void checkWinState(GameGrid gameGrid){
        boolean whiteHasKing = false;
        boolean blackHasKing = false;
        for (int i = 0; i < 64; i++){
            if (pieceMap.get(i).getIdentifier() == 'K' && pieceMap.get(i).getPieceAlliance() == Alliance.WHITE){
                whiteHasKing = true;
            } else if (pieceMap.get(i).getIdentifier() == 'K' && pieceMap.get(i).getPieceAlliance() == Alliance.BLACK){
                blackHasKing = true;
            }
        }
        if (!whiteHasKing){
            gameGrid.showWinner(false);
        } else if (!blackHasKing){
            gameGrid.showWinner(true);
        }
    }
    public GameBoard(){
        selectingStartMove = true;
        selectingEndMove = false;
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
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
