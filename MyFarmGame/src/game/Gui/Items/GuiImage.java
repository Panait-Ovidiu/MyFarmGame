package game.Gui.Items;

import engine.GameItem;
import engine.graph.Texture;

import java.util.ArrayList;

public class GuiImage extends GuiContainer {

    protected boolean show;

    private GuiBackground imageBackground;

    public GuiImage(float width, float height, Texture backgroundTexture, ArrayList<GameItem> parentItems) throws Exception {
        super(width, height, parentItems);
        show = true;

        makeImage(backgroundTexture, parentItems);
        setShow(show);
    }

    public GuiImage(float size, Texture backgroundTexture, ArrayList<GameItem> parentItems) throws Exception {
        super(size, size, parentItems);
        show = true;

        makeImage(backgroundTexture, parentItems);
        setShow(show);
    }

    private void makeImage(Texture backgroundTexture, ArrayList<GameItem> parentItems) throws Exception {
        imageBackground = new GuiBackground(width, height, backgroundTexture);
        parentItems.add(imageBackground);
    }

    public void setImage(Texture backgroundTexture) {
        imageBackground.setTexture(backgroundTexture);
    }

    public void setTransparency(float value) {
        imageBackground.setTransparency(value);
    }

    public void setShow(boolean show) {
        this.show = show;
        imageBackground.setShow(show);
        if (isBackgroundShow()) {
            containerBackground.setShow(show);
        }
    }

    @Override
    public void setWidth(float width) {
        if (this.width != width || this.height != height) {
            super.setWidth(width);
            imageBackground.rebuildMesh(width, height);
            updateBackgroundSize();
        }
    }

    @Override
    public void setHeight(float height) {
        if (this.height != height) {
            super.setHeight(height);
            imageBackground.rebuildMesh(width, height);
            updateImageSize();
        }
    }

    @Override
    public void setWidthAndHeight(float width, float height) {
        if (this.width != width || this.height != height) {
            super.setWidthAndHeight(width, height);
            imageBackground.rebuildMesh(width, height);
            updateImageSize();
        }
    }

    @Override
    public void setPosition(float x, float y, float z) {
        if (position.x != x || position.y != y || position.z != z) {
            this.position.x = x;
            this.position.y = y;
            this.position.z = z;
        }
        updateImageSize();
    }

    public void updateImageSize() {
        updateBackgroundSize();

        imageBackground.setPosition(position.x, position.y, position.z);

    }
}
