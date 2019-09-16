package game.leolord.Board;

import game.leolord.Pieces.Piece;


public class Tile {
    private String tileCoordinate;
    private boolean tileVacancy;
    private Piece tilePiece;

    public boolean isTileOccupied(){
        return tileVacancy;
    }

    public Tile(boolean tileVacancy, String tileCoordinate) {
        this.tileVacancy = tileVacancy;
        this.tileCoordinate = tileCoordinate;
    }
    public Tile(){}

    public String getTileCoordinate() {
        return tileCoordinate;
    }

    public void setTileCoordinate(String tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }

    public boolean isTileVacancy() {
        return tileVacancy;
    }

    public void setTileVacancy(boolean tileVacancy) {
        this.tileVacancy = tileVacancy;
    }

    public Piece getTilePiece() {
        return tilePiece;
    }

    public void setTilePiece(Piece tilePiece) {
        this.tilePiece = tilePiece;
    }
}
