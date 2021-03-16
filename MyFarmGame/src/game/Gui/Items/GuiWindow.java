package game.Gui.Items;

import engine.GameItem;
import game.Assets.AssetManager;

import java.util.ArrayList;

import static game.Assets.GuiData.GuiTextures.WINDOW_BACKGROUND_TEXTURE;
import static game.Assets.GuiData.GuiTextures.BUTTON_CLOSE_TEXTURE;

public abstract class GuiWindow extends GuiPanel {

    public GuiText windowTitleGuiText;
    public GuiButton closeButton;

    public GuiWindow(float width, float height, ArrayList<GameItem> parentItems) throws Exception {
        super(width, height, parentItems);
        show = true;

        setPanelBackground(AssetManager.getGuiTextures(WINDOW_BACKGROUND_TEXTURE.getName()));

        makeWindow(parentItems);
        windowShow(show);
    }

    public void makeWindow(ArrayList<GameItem> parentItems) throws Exception {
        // Title TextItem
        this.windowTitleGuiText = new GuiText("Title", GuiText.SIZE_LARGE, parentItems);

        // Close Button
        closeButton = new GuiButton(30.0f, AssetManager.getGuiTextures(BUTTON_CLOSE_TEXTURE.getName()), "closeButton (Panel)",parentItems);

    }

    public void windowShow(boolean show) {
        panelShow(show);

        windowTitleGuiText.setShow(show);
        closeButton.setShow(show);
    }

    @Override
    public void setWidth(float width) {
        super.setWidth(width);
        updateWindowSize();
    }

    @Override
    public void setHeight(float height) {
        super.setHeight(height);
        updateWindowSize();
    }

    @Override
    public void setWidthAndHeight(float width, float height) {
        super.setWidthAndHeight(width, height);
        updateWindowSize();
    }

    @Override
    public void setPosition(float x, float y, float z) {
        if (position.x != x || position.y != y || position.z != z) {
            this.position.x = x;
            this.position.y = y;
            this.position.z = z;
        }
        updateWindowSize();
    }

    protected void updateWindowSize() {
        updatePanelSize();

        // Title TextItem
        windowTitleGuiText.setPosition(xCenterPos - (windowTitleGuiText.getWidth() / 2), yTopPos + 5.0f, 0.0f);

        // Close Button
        closeButton.setPosition(xRightPos - closeButton.getWidth(), yTopPos, 0.0f);

    }

}
