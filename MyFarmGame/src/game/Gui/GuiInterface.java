package game.Gui;

import engine.GameItem;
import engine.IGui;
import engine.MouseInput;
import engine.Window;
import engine.graph.Camera;
import game.Gui.Items.GuiContainer;
import game.MyFarmGame;

public class GuiInterface implements IGui {

    protected MyFarmGame myFarmGame;
    protected GameItem[] gameItems;

    public GuiInterface(String statusText, Window window, MyFarmGame myFarmGame) throws Exception {
        this.myFarmGame = myFarmGame;

    }

    @Override
    public GameItem[] getGameItems() {
        return gameItems;
    }

    public boolean isHovered(GuiContainer container, MouseInput mouseInput) {
        return mouseInput.getCurrentPos().x >= container.getXLeftPos()
                && mouseInput.getCurrentPos().x <= container.getXRightPos()
                && mouseInput.getCurrentPos().y >= container.getYTopPos()
                && mouseInput.getCurrentPos().y <= container.getYBottomPos();
    }

    public void update(MouseInput mouseInput, Camera camera) {

    }

    public void updateSize(Window window) {

    }

    public void input(Window window, MouseInput mouseInput, Camera camera) {

    }

    @Override
    public void cleanUp() {

    }
}
