package game.Gui.Items;

import engine.GameItem;
import game.Assets.AssetManager;
import org.joml.Vector3f;

import java.util.ArrayList;

import static game.Assets.GuiData.GuiTextures.BLACK_BACKGROUND_TEXTURE;

public class GuiContainer {

    protected float xLeftPos;
    protected float xCenterPos;
    protected float xRightPos;

    protected float yTopPos;
    protected float yCenterPos;
    protected float yBottomPos;

    protected float width;
    protected float height;

    protected Vector3f position;

    protected boolean backgroundShow;

    protected GuiBackground containerBackground;

    public GuiContainer(float width, float height, ArrayList<GameItem> parentItems) throws Exception {
        this.width = width;
        this.height = height;
        this.position = new Vector3f(0.0f, 0.0f, 0.0f);
        backgroundShow = false; // set to false
        makeContainer(parentItems);
    }

    private void makeContainer(ArrayList<GameItem> parentItems) throws Exception {
        containerBackground = new GuiBackground(width, height, AssetManager.getGuiTextures(BLACK_BACKGROUND_TEXTURE.getName()));
        containerBackground.setTransparency(0.5f);
        containerBackground.setShow(backgroundShow);
        parentItems.add(containerBackground);
    }

    public float getXLeftPos() {
        return xLeftPos;
    }

    public float getXCenterPos() {
        return xCenterPos;
    }

    public float getXRightPos() {
        return xRightPos;
    }

    public float getYTopPos() {
        return yTopPos;
    }

    public float getYCenterPos() {
        return yCenterPos;
    }

    public float getYBottomPos() {
        return yBottomPos;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        if (this.width != width) {
            this.width = width;
            containerBackground.rebuildMesh(this.width, height);
            containerBackground.setTransparency(0.5f);
            updateBackgroundSize();
        }
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        if (this.height != height) {
            this.height = height;
            containerBackground.rebuildMesh(width, this.height);
            containerBackground.setTransparency(0.5f);
            updateBackgroundSize();
        }
    }

    public void setWidthAndHeight(float width, float height) {
        if (this.width != width || this.height != height) {
            this.width = width;
            this.height = height;
            containerBackground.rebuildMesh(this.width, this.height);
            containerBackground.setTransparency(0.5f);
            updateBackgroundSize();
        }
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(float x, float y, float z) {
        if (position.x != x || position.y != y || position.z != z) {
            this.position.x = x;
            this.position.y = y;
            this.position.z = z;
        }
        updateBackgroundSize();
    }

    protected boolean isBackgroundShow() {
        return backgroundShow;
    }

    public void setBackgroundShow(boolean backgroundShow) {
        this.backgroundShow = backgroundShow;
        containerBackground.setShow(backgroundShow);
    }

    protected void updateBackgroundSize() {
        containerBackground.setPosition(position.x, position.y, position.z);

        xLeftPos = position.x;
        xCenterPos = position.x + (width / 2);
        xRightPos = position.x + width;

        yTopPos = position.y;
        yCenterPos = position.y + (height / 2);
        yBottomPos = position.y + height;
    }
}
