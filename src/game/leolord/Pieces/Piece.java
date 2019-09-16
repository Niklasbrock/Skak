package game.leolord.Pieces;

public abstract class Piece {
    private int coordinate;
    private char identifier;
    private Alliance pieceAlliance;

    public Piece(char identifier, int coordinate, Alliance pieceAlliance){
        this.identifier = identifier;
        this.coordinate = coordinate;
        this.pieceAlliance = pieceAlliance;
    }
    public Piece(char identifier, int coordinate){
        this.identifier = identifier;
        this.coordinate = coordinate;
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

    @Override
    public String toString() {
        return ""+identifier;
    }
}
