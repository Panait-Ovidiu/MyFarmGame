package game.Gui.InterfaceGamePlay.SettingsWindow;

import engine.GameItem;
import engine.Window;
import game.Gui.Items.GuiWindow;

import java.util.ArrayList;

public class SettingsWindow extends GuiWindow {

    private Window window;

    public SettingsWindow(Window window, ArrayList<GameItem> parentItems) throws Exception {
        super(625.0f, 500.0f, parentItems);
        this.window = window;
        show = false;

        addItems(parentItems);
        setShow(show);
    }

    protected void addItems(ArrayList<GameItem> parentItems) throws Exception {
        windowTitleGuiText.setText("Settings");
        closeButton.setNameID("closeButton (Settings Menu)");

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
        position.set(
                (window.getWidth() / 2.0f) - (width / 2.0f),
                (window.getHeight() / 2.0f) - (height / 2.0f),
                0.0f
        );

    }
}
