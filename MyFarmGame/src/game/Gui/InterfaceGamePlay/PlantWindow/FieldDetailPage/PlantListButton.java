package game.Gui.InterfaceGamePlay.PlantWindow.FieldDetailPage;

import engine.GameItem;
import game.Assets.AssetManager;
import game.Data.Planted;
import game.Data.Time;
import game.Gui.Items.*;

import java.util.ArrayList;

import static game.Assets.GuiData.GuiTextures.BUTTON_PLANTS_TEXTURE;
import static game.Assets.GuiData.GuiTextures.STAR_ICON_TEXTURE;

public class PlantListButton extends GuiPanel {

    // TODO: implement pages Locked / Unlocked
    public static final int PAGE_UNLOCKED = 2;
    public static final int PAGE_LOCKED = 1;

    // ====== Main Items ======
    public GuiButton selectPlantButton;

    // ====== All Pages Panel Items ======
    private GuiText plantNameGuiText;
    private GuiImage plantImage;
    private GuiText productionGuiText;
    private GuiImage experienceImage;
    private GuiText experienceGuiText;
    private GuiText timeGuiText;

    // ====== Locked Panel Items ======
    public GuiText lockedLabelGuiText;
    public GuiImage lockedImage;

    public PlantListButton(float width, float height, ArrayList<GameItem> parentItems) throws Exception {
        super(width, height, parentItems);

        setBackgroundShow(false);

        addItems(parentItems);
        setButtonPanelShow(false);
        setShow(show);
    }

    protected void addItems(ArrayList<GameItem> parentItems) throws Exception {
        // ====== Main Items ======
        selectPlantButton = new GuiButton(50.0f, AssetManager.getGuiTextures(BUTTON_PLANTS_TEXTURE.getName()), "plantsMenuButton (Main Buttons)",parentItems);

        // ====== All Pages Panel Items ======
        plantNameGuiText = new GuiText("Tomato", GuiText.SIZE_SMALL,parentItems);

        plantImage = new GuiImage(25.0f, AssetManager.getGuiTextures(BUTTON_PLANTS_TEXTURE.getName()),parentItems);

        productionGuiText = new GuiText("+5", GuiText.SIZE_SMALL,parentItems);

        experienceImage = new GuiImage(25.0f, AssetManager.getGuiTextures(STAR_ICON_TEXTURE.getName()),parentItems);

        experienceGuiText = new GuiText("+10", GuiText.SIZE_SMALL,parentItems);

        timeGuiText = new GuiText("Time: 2m", GuiText.SIZE_SMALL,parentItems);

        // ====== Locked Panel Items ======

    }

    public String getPlantNameGuiText() {
        return plantNameGuiText.getText();
    }

    @Override
    public void setPageEmpty() {

    }

    @Override
    public void setShow(boolean show) {
        panelShow(show);

        selectPlantButton.setShow(show);
    }

    public void setButtonPanelShow(boolean show) {
        setPanelBackgroundShow(show);
        plantNameGuiText.setShow(show);
        plantImage.setShow(show);
        productionGuiText.setShow(show);
        experienceImage.setShow(show);
        experienceGuiText.setShow(show);
        timeGuiText.setShow(show);
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

    public void update(Planted plant) {
        plantNameGuiText.setText(plant.getPlantName());
        // productionGuiText;
        experienceGuiText.setText("" + plant.getExperienceFromHarvest());
        timeGuiText.setText(Time.getTimeLeft(plant.getSecondsToHarvest() * 1000));

        // TODO: Add page check
    }

    @Override
    public void updateSize() {
        updatePanelSize();

        // ====== Main Items ======
        selectPlantButton.setPosition(
                xLeftPos + 5.0f,
                yTopPos + 5.0f,
                0.0f
        );

        // ====== All Pages Panel Items ======
        plantNameGuiText.setPosition(
                selectPlantButton.getXRightPos() + 5.0f,
                yTopPos + 5.0f,
                0.0f
        );
        plantImage.setPosition(
                plantNameGuiText.getXLeftPos(),
                plantNameGuiText.getYBottomPos() + 5.0f,
                0.0f
        );
        productionGuiText.setPosition(
                plantImage.getXRightPos() + 2.5f,
                plantImage.getYCenterPos() - (productionGuiText.getHeight() / 2),
                0.0f
        );
        experienceImage.setPosition(
                productionGuiText.getXRightPos() + 10.0f,
                plantNameGuiText.getYBottomPos() + 5.0f,
                0.0f
        );
        experienceGuiText.setPosition(
                experienceImage.getXRightPos() + 2.5f,
                experienceImage.getYCenterPos() - (experienceGuiText.getHeight() / 2),
                0.0f
        );
        timeGuiText.setPosition(
                plantNameGuiText.getXLeftPos(),
                plantImage.getYBottomPos() + 5.0f,
                0.0f
        );

        // ====== Locked Panel Items ======

    }
}
