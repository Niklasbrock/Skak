package game.leolord.GUI;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class MenuGrid extends GridPane {

    private MenuButton mute;
    private MenuButton restart;
    private MenuButton exitGame;


    public MenuGrid(){
        add(mute = new MenuButton("Mute"), 0, 0);
        add(restart = new MenuButton("Restart"), 0, 1);
        add(exitGame = new MenuButton("Exit Game"), 0, 2);
        setAlignment(Pos.CENTER);
        setVgap(10);
    }


    public MenuButton getRestart() {
        return restart;
    }

    public void setRestart(MenuButton restart) {
        this.restart = restart;
    }

    public MenuButton getExitGame() {
        return exitGame;
    }

    public void setExitGame(MenuButton exitGame) {
        this.exitGame = exitGame;
    }

    public MenuButton getMute() {
        return mute;
    }
    public void setMute(MenuButton mute) {
        this.mute = mute;
    }
}
