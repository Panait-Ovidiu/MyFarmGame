package game.Gui.Items;

import engine.GameItem;
import game.Assets.AssetManager;

import java.util.ArrayList;

import static game.Assets.GuiData.GuiTextures.*;

public class ProgressBar extends GuiContainer {

    // TODO: Make ProgressBar extend GuiPanel

    protected boolean show;

    private float percent;

    protected GuiImage progressBarMargin;
    protected GuiImage progressBarFill;
    protected GuiImage progressBarBackground;

    public ProgressBar(float width, float height, ArrayList<GameItem> parentItems) throws Exception {
        super(width, height, parentItems);
        show = true;
        percent = 0.0f;


        makeProgressBar(parentItems);
        progressBarMargin.setBackgroundShow(false); // delete
        setShow(show);
    }

    public void makeProgressBar(ArrayList<GameItem> parentItems) throws Exception {
        progressBarBackground = new GuiImage(width, height, AssetManager.getGuiTextures(PROGRESS_BAR_BACKGROUND_TEXTURE.getName()), parentItems);
        progressBarBackground.setTransparency(0.5f);

        progressBarFill = new GuiImage(percent, height, AssetManager.getGuiTextures(PROGRESS_BAR_FILL_TEXTURE.getName()), parentItems);

        progressBarMargin = new GuiImage(width, height, AssetManager.getGuiTextures(PROGRESS_BAR_MARGIN_TEXTURE.getName()), parentItems);

    }

    public void setShow(boolean show) {
        this.show = show;
        if (isBackgroundShow()) {
            containerBackground.setShow(show);
        }
        progressBarBackground.setShow(show);
        progressBarFill.setShow(show);
        progressBarMargin.setShow(show);
    }

    @Override
    public void setPosition(float x, float y, float z) {
        if (position.x != x || position.y != y || position.z != z) {
            this.position.x = x;
            this.position.y = y;
            this.position.z = z;
        }
        updateSize();
    }

    public void update(float percent) {
        /*
        if (this.percent  > 100.0f) {
            this.percent = 0.0f;
        }
        this.percent += 0.3f;
        */

        progressBarFill.setWidth(percent);
        //  System.out.println("Update Process Bar" + this.percent);
    }

    public void updateSize() {
        this.updateBackgroundSize();

        progressBarBackground.setPosition(position.x, position.y, position.z);
        progressBarFill.setPosition(position.x, position.y, position.z);
        progressBarMargin.setPosition(position.x, position.y, position.z);
    }
}
