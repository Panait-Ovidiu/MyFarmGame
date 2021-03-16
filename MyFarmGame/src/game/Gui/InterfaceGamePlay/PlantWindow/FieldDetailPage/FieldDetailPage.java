package game.Gui.InterfaceGamePlay.PlantWindow.FieldDetailPage;

import engine.GameItem;
import engine.Window;
import game.Assets.AssetManager;
import game.Data.FieldData;
import game.Gui.Items.*;

import java.util.ArrayList;

import static game.Assets.GuiData.GuiTextures.BUTTON_ARROW_PREVIOUS_TEXTURE;
import static game.Assets.GuiData.GuiTextures.MAIN_BUTTON_SQUARE_TEXTURE;

public class FieldDetailPage extends GuiPanel {

    public static final int PAGE_FIELD_DETAIL = 1;
    public static final int PAGE_FIELD_DETAIL_PLANT = 2;
    public static final int PAGE_FIELD_DETAIL_HARVEST = 3;

    // ====== All Pages Items ======
    public GuiButton backToListButton;
    private GuiText fieldNameGuiText;

    // ====== Page Field Detail & Harvest Items ======
    private GuiText cropGuiText;

    // ====== Page Field Detail Items ======
    private GuiText timeLabelGuiText;
    private ProgressBar progressBar;
    private GuiText timeGuiText;

    // ====== Page Field Detail Plant Items ======
    private GuiText plantSomethingGuiText;
    public PlantListButtonPanel plantListButtonPanel;
    public GuiButton plantButton;

    // ====== Page Field Detail Harvest Items ======
    private GuiText completedGuiText;
    public GuiButton harvestButton;

    public FieldDetailPage(Window window, float width, float height, ArrayList<GameItem> parentItems) throws Exception {
        super(width, height, parentItems);

        addItems(parentItems);
        setShow(show);
    }

    protected void addItems(ArrayList<GameItem> parentItems) throws Exception {

        // ====== All Pages Items ======
        backToListButton = new GuiButton(30.0f, AssetManager.getGuiTextures(BUTTON_ARROW_PREVIOUS_TEXTURE.getName()), "backToCrops (Plant Menu)",parentItems);

        fieldNameGuiText = new GuiText("Field", GuiText.SIZE_NORMAL,parentItems);

        // ====== Page Field Detail & Harvest Items ======
        cropGuiText = new GuiText("Crop:", GuiText.SIZE_NORMAL,parentItems);

        // ====== Page Field Detail Items ======
        timeLabelGuiText = new GuiText("Time:", GuiText.SIZE_NORMAL,parentItems);

        progressBar = new ProgressBar(100.0f, 20.0f,parentItems);

        timeGuiText = new GuiText("2:15", GuiText.SIZE_SMALL,parentItems);

        // ====== Page Field Detail Plant Items ======
        plantSomethingGuiText = new GuiText("Plant Something !", GuiText.SIZE_NORMAL,parentItems);

        plantButton = new GuiButton(100.f, 30.0f, AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()), "plantButton (Plant Menu) )",parentItems);
        plantButton.setButtonText("Plant");

        plantListButtonPanel = new PlantListButtonPanel(280.0f, 120.0f,parentItems);

        // ====== Page Field Detail Harvest Items ======
        completedGuiText = new GuiText("Completed", GuiText.SIZE_NORMAL,parentItems);

        harvestButton = new GuiButton(100.f, 30.0f, AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()), "harvestButton (Plant Menu) )",parentItems);
        harvestButton.setButtonText("Harvest");

    }

    @Override
    public void setPageEmpty() {
        page = PAGE_EMPTY;
        setShow(show);
    }

    public void setPageFieldDetail() {
        page = PAGE_FIELD_DETAIL;
        setShow(show);
    }

    public void setPageFieldDetailPlant() {
        page = PAGE_FIELD_DETAIL_PLANT;
        setShow(show);
    }

    public void setPageFieldDetailHarvest() {
        page = PAGE_FIELD_DETAIL_HARVEST;
        setShow(show);
    }

    @Override
    public void setShow(boolean show) {
        panelShow(show);

        if (page == PAGE_EMPTY) {
            allPagesShow(false);
            cropGuiText.setShow(false);
            pageFieldDetailShow(false);
            pageFieldDetailPlantShow(false);
            pageFieldDetailHarvestShow(false);

        } else if (page == PAGE_FIELD_DETAIL) {
            allPagesShow(show);
            cropGuiText.setShow(show);
            pageFieldDetailShow(show);
            pageFieldDetailPlantShow(false);
            pageFieldDetailHarvestShow(false);

        } else if (page == PAGE_FIELD_DETAIL_PLANT) {
            allPagesShow(show);
            cropGuiText.setShow(false);
            pageFieldDetailShow(false);
            pageFieldDetailPlantShow(show);
            pageFieldDetailHarvestShow(false);

        } else if (page == PAGE_FIELD_DETAIL_HARVEST) {
            allPagesShow(show);
            cropGuiText.setShow(show);
            pageFieldDetailShow(false);
            pageFieldDetailPlantShow(false);
            pageFieldDetailHarvestShow(show);

        }
    }

    public void allPagesShow(boolean show) {
        backToListButton.setShow(show);
        fieldNameGuiText.setShow(show);
    }

    public void pageFieldDetailShow(boolean show) {
        timeLabelGuiText.setShow(show);
        progressBar.setShow(show);
        timeGuiText.setShow(show);
    }

    public void pageFieldDetailPlantShow(boolean show) {
        plantSomethingGuiText.setShow(show);
        plantListButtonPanel.setShow(show);
        plantButton.setShow(show);
    }

    public void pageFieldDetailHarvestShow(boolean show) {
        harvestButton.setShow(show);
        completedGuiText.setShow(show);
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

    public void update(FieldData fieldData) {  // TODO: Add playerData to get LEVEL
        // ====== Page Check ======
        if (fieldData.getPlanted().plantedNotEmpty()) {
            if (fieldData.isCompleted()) {
                setPageFieldDetailHarvest();
            } else {
                setPageFieldDetail();
            }
        } else {
            setPageFieldDetailPlant();
        }

        fieldNameGuiText.setText(fieldData.getNameID());

        if (page == PAGE_FIELD_DETAIL) {
            progressBar.update(fieldData.getPercentageCompleted());
            timeGuiText.setText(fieldData.getTimeLeft());
            cropGuiText.setText("Planted: " + fieldData.getPlanted().getPlantName());

        } else if (page == PAGE_FIELD_DETAIL_PLANT) {
            plantListButtonPanel.update(); // todo pass playerLevel

            if(plantListButtonPanel.getSelectedButton() == PlantListButtonPanel.NO_BUTTON_SELECTED) {
                plantButton.setDisabled(true);
                plantSomethingGuiText.setText("Plant Something !");
            } else {
                plantButton.setDisabled(false);
                int selectedButton = plantListButtonPanel.getSelectedButton();
                plantSomethingGuiText.setText(
                        "Plant " + plantListButtonPanel.plantListItems[selectedButton].getPlantNameGuiText());
            }

        } else if (page == PAGE_FIELD_DETAIL_HARVEST) {
            cropGuiText.setText("Planted: " + fieldData.getPlanted().getPlantName());
        }

    }

    @Override
    public void updateSize() {
        updatePanelSize();

        // ====== All Pages Items ======
        backToListButton.setPosition(
                xLeftPos - (backToListButton.getWidth() / 2),
                yTopPos - (backToListButton.getHeight() / 2),
                0.0f
        );
        fieldNameGuiText.setPosition(
                xLeftPos + 25.0f,
                yTopPos + 25.0f,
                0.0f
        );

        // ====== Page Field Detail & Harvest Items ======
        cropGuiText.setPosition(
                timeLabelGuiText.getXLeftPos(),
                timeLabelGuiText.getYBottomPos() + 5.0f,
                0.0f
        );

        // ====== Page Field Detail Items ======
        timeLabelGuiText.setPosition(
                fieldNameGuiText.getXLeftPos(),
                fieldNameGuiText.getYBottomPos() + 5.0f,
                0.0f
        );
        progressBar.setPosition(
                timeLabelGuiText.getXRightPos() + 5.0f,
                timeLabelGuiText.getYCenterPos() - (progressBar.getHeight() / 2),
                0.0f
        );
        timeGuiText.setPosition(
                progressBar.getXRightPos() + 5.0f,
                progressBar.getYCenterPos() - (timeGuiText.getHeight() / 2),
                0.0f
        );

        // ====== Page Field Detail Plant Items ======
        plantSomethingGuiText.setPosition(
                timeLabelGuiText.getXLeftPos(),
                timeLabelGuiText.getYBottomPos() + 5.0f,
                0.0f
        );
        plantListButtonPanel.setPosition(
                xLeftPos + 10.0f,
                cropGuiText.getYBottomPos() + 5.0f,
                0.0f
        );
        plantButton.setPosition(
                xCenterPos - (plantButton.getWidth() / 2),
                yBottomPos - plantButton.getHeight() - 10.0f,
                0.0f
        );

        // ====== Page Field Detail Harvest Items ======
        completedGuiText.setPosition(
                fieldNameGuiText.getXLeftPos(),
                fieldNameGuiText.getYBottomPos() + 5.0f,
                0.0f
        );
        harvestButton.setPosition(
                xCenterPos - (plantButton.getWidth() / 2),
                yBottomPos - plantButton.getHeight() - 10.0f,
                0.0f
        );

    }
}
