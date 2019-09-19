package game.leolord.Pieces;


import game.leolord.GUI.PieceButton;
import javafx.scene.image.Image;

public abstract class Piece {
    private int coordinate;
    private char identifier;
    private Alliance pieceAlliance;
    private PieceButton pieceButton;
    private Image texture;

    public Piece(char identifier, int coordinate, Alliance pieceAlliance){
        this.identifier = identifier;
        this.coordinate = coordinate;
        this.pieceAlliance = pieceAlliance;
        this.pieceButton = new PieceButton(this);
    }
    public Piece(char identifier, int coordinate){
        this.identifier = identifier;
        this.coordinate = coordinate;
        this.pieceButton = new PieceButton(this);
    }

    public int getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int coordinate) {
        this.coordinate = coordinate;
    }

    public Alliance getPieceAlliance() {
        return pieceAlliance;
    }

    public void setPieceAlliance(Alliance pieceAlliance) {
        this.pieceAlliance = pieceAlliance;
    }

    public char getIdentifier() {
        return identifier;
    }

    public void setIdentifier(char identifier) {
        this.identifier = identifier;
    }

    public PieceButton getPieceButton() {
        return pieceButton;
    }

    public void setPieceButton(PieceButton pieceButton) {
        this.pieceButton = pieceButton;
    }

    public Image getTexture() {
        return texture;
    }

    public void setTexture(Image texture) {
        this.texture = texture;
    }

    @Override
    public String toString() {
        return ""+identifier;
    }
}
