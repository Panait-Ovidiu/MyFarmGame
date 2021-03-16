package game.Gui.Items;

import engine.GameItem;
import engine.graph.Texture;
import game.Assets.AssetManager;

import java.util.ArrayList;

import static game.Assets.GuiData.GuiTextures.PANEL_BACKGROUND_TEXTURE;

public abstract class GuiPanel extends GuiContainer {

    public static final int PAGE_EMPTY = 0;

    protected int page;
    protected boolean show;
    protected boolean isPaused;

    protected boolean panelBackgroundShow;
    protected GuiImage panelBackground;

    public GuiPanel(float width, float height, ArrayList<GameItem> parentItems) throws Exception {
        super(width, height,parentItems);
        page = PAGE_EMPTY;
        show = true;
        isPaused = false;
        panelBackgroundShow = true;

        makePanel(parentItems);
        panelShow(show);
    }

    private void makePanel(ArrayList<GameItem> parentItems) throws Exception {
        panelBackground = new GuiImage(width, height, AssetManager.getGuiTextures(PANEL_BACKGROUND_TEXTURE.getName()),parentItems);
    }

    public boolean isShow() {
        return show;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean isPaused) {
        this.isPaused = isPaused;
    }

    public void setPanelBackgroundShow(boolean panelBackgroundShow) {
        this.panelBackgroundShow = panelBackgroundShow;
        panelBackground.setShow(panelBackgroundShow);
    }

    public void setPanelBackground(Texture imageTexture) {
        panelBackground.setImage(imageTexture);
    }

    public boolean isPage(int page) {
        return this.page == page;
    }

    protected abstract void addItems(ArrayList<GameItem> parentItems) throws Exception;

    public abstract void setPageEmpty();

    public abstract void setShow(boolean show);

    public abstract void updateSize();

    protected void panelShow(boolean show) {
        this.show = show;
        setPaused(!this.show);
        if (panelBackgroundShow) {
            panelBackground.setShow(show);
        }

        if (isBackgroundShow()) {
            containerBackground.setShow(show);
        }
    }

    @Override
    public void setWidth(float width) {
        if (this.width != width) {
            super.setWidth(width);
            panelBackground.setWidth(width);
            updatePanelSize();
        }
    }

    @Override
    public void setHeight(float height) {
        if (this.height != height) {
            super.setHeight(height);
            panelBackground.setHeight(height);
            updatePanelSize();
        }
    }

    @Override
    public void setWidthAndHeight(float width, float height) {
        if (this.width != width || this.height != height) {
            super.setWidthAndHeight(width, height);
            panelBackground.setWidthAndHeight(width, height);
            updatePanelSize();
        }
    }

    @Override
    public void setPosition(float x, float y, float z) {
        if (position.x != x || position.y != y || position.z != z) {
            this.position.x = x;
            this.position.y = y;
            this.position.z = z;
        }
        updatePanelSize();
    }

    protected void updatePanelSize() {
        updateBackgroundSize();

        panelBackground.setPosition(position.x, position.y, position.z);

    }
}
