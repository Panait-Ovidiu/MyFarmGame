package game.Gui.InterfaceIntro;

import engine.GameItem;
import engine.MouseInput;
import engine.Window;
import engine.graph.Camera;
import game.Gui.GuiInterface;
import game.MyFarmGame;

import java.util.ArrayList;

public class IntroGuiInterface extends GuiInterface {

    private IntroWindow introWindow;

    public IntroGuiInterface(String statusText, Window window, MyFarmGame myFarmGame) throws Exception {
        super(statusText, window, myFarmGame);
        ArrayList<GameItem> items = new ArrayList<>();

        introWindow = new IntroWindow(window, items);

        gameItems = items.toArray(new GameItem[items.size()]);
    }

    public void update(MouseInput mouseInput, Camera camera) {
        introWindow.update();
    }

    public void updateSize(Window window) {
        introWindow.updateSize();
    }

    public void input(Window window, MouseInput mouseInput, Camera camera) {

    }

    @Override
    public void cleanUp() {
        GameItem[] gameItems = getGameItems();
        for (GameItem gameItem : gameItems) {
            gameItem.getMesh().cleanUp();
        }
    }
}
