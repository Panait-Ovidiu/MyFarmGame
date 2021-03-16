package game.Gui.InterfaceGamePlay.UpgradeMenuWindow;

import engine.GameItem;
import engine.Window;
import game.Data.PlayerData;
import game.Gui.Items.GuiContainer;
import game.Gui.Items.GuiWindow;

import java.util.ArrayList;

public class UpgradeMenuWindow extends GuiWindow {

    private Window window;
    private PlayerData playerData;

    public UpgradeMenuWindow(Window window, GuiContainer parent, PlayerData playerData, ArrayList<GameItem> parentItems) throws Exception {
        super(500.0f, 400.0f,parentItems);
        setPosition(parent.getXRightPos() + 5.0f, parent.getYTopPos(), 0.0f);
        this.window = window;
        this.playerData = playerData;
        show = false;

        addItems(parentItems);
        setShow(show);
    }

    protected void addItems(ArrayList<GameItem> parentItems) throws Exception {
        windowTitleGuiText.setText("Upgrades Menu");
        closeButton.setNameID("closeButton (Upgrade Menu)");

    }

    @Override
    public void setPageEmpty() {

    }

    public void setShow(boolean show) {
        windowShow(show);
    }

    public void update() {

    }

    public void updateSize() {
        updateWindowSize();

    }
}