package game.Gui.InterfaceGamePlay.PlantWindow.FieldListPage;

import engine.GameItem;
import game.Assets.AssetManager;
import game.Data.FieldData;
import game.Gui.Items.*;

import java.util.ArrayList;

import static game.Assets.GuiData.GuiTextures.LOCKED_ICON_TEXTURE;
import static game.Assets.GuiData.GuiTextures.BUTTON_ARROW_NEXT_TEXTURE;
import static game.Assets.GuiData.GuiTextures.MAIN_BUTTON_SQUARE_TEXTURE;

public class FieldListItem extends GuiPanel {

    public static final int PAGE_LOCKED = 1;
    public static final int PAGE_UNLOCKED = 2;
    public static final int PAGE_UNLOCKED_CROP_EMPTY = 3;
    public static final int PAGE_UNLOCKED_CROP_COMPLETED = 4;

    // ====== All Pages Items ======
    public GuiText fieldNameGuiText;

    // ====== Page Locked Items ======
    public GuiText lockedLabelGuiText;
    public GuiImage lockedImage;
    public GuiText buyLabelGuiText;
    public GuiButton buyButton;
    public GuiText buyButtonGuiText;

    // ====== Page Unlocked Items ======
    public GuiButton goToButton;
    public GuiText cropGuiText;
    public GuiText timeLabelGuiText;
    public ProgressBar progressBar;
    public GuiText timeGuiText;

    // ====== Page Unlocked Crop Empty Items ======
    public GuiText plantSomethingGuiText;

    // ====== Page Unlocked Crop Completed Items ======
    public GuiText completedGuiText;

    public FieldListItem(float width, float height, ArrayList<GameItem> parentItems) throws Exception {
        super(width, height, parentItems);

        addItems(parentItems);
        setShow(show);
    }

    protected void addItems(ArrayList<GameItem> parentItems) throws Exception {

        // ====== All Pages Items ======
        fieldNameGuiText = new GuiText("Field", GuiText.SIZE_SMALL, parentItems);

        // ====== Page Locked Items ======
        lockedLabelGuiText = new GuiText("Locked", GuiText.SIZE_SMALL, parentItems);

        lockedImage = new GuiImage(15.0f, AssetManager.getGuiTextures(LOCKED_ICON_TEXTURE.getName()), parentItems);

        buyLabelGuiText = new GuiText("Buy", GuiText.SIZE_NORMAL, parentItems);

        buyButton = new GuiButton(100.f, 30.0f, AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()), "buyButton (Plant Menu) )", parentItems);

        buyButtonGuiText = new GuiText("5.000 $", GuiText.SIZE_SMALL, parentItems);

        // ====== Page Unlocked Items ======
        goToButton = new GuiButton(25.0f, AssetManager.getGuiTextures(BUTTON_ARROW_NEXT_TEXTURE.getName()), "cropGoToButton1 (Plant Menu)", parentItems);

        cropGuiText = new GuiText("Crop:", GuiText.SIZE_SMALL, parentItems);

        timeLabelGuiText = new GuiText("Time:", GuiText.SIZE_SMALL, parentItems);

        progressBar = new ProgressBar(100.0f, 15.0f, parentItems);

        timeGuiText = new GuiText("2:15", GuiText.SIZE_EXTRA_SMALL, parentItems);

        // ====== Page Unlocked Crop Empty Items ======
        plantSomethingGuiText = new GuiText("Plant Something !", GuiText.SIZE_NORMAL, parentItems);

        // ====== Page Unlocked Crop Completed Items ======
        completedGuiText = new GuiText("Completed", GuiText.SIZE_SMALL, parentItems);

    }

    @Override
    public void setPageEmpty() {
        page = PAGE_EMPTY;
        setShow(show);
    }

    public void setPageLocked() {
        page = PAGE_LOCKED;
        setShow(show);
    }

    public void setPageUnlocked() {
        page = PAGE_UNLOCKED;
        setShow(show);
    }

    public void setPageCropEmpty() {
        page = PAGE_UNLOCKED_CROP_EMPTY;
        setShow(show);
    }

    public void setPageCropCompleted() {
        page = PAGE_UNLOCKED_CROP_COMPLETED;
        setShow(show);
    }

    @Override
    public void setShow(boolean show) {
        panelShow(show);

        fieldNameGuiText.setShow(show);

        if (page == PAGE_EMPTY) {
            goToButton.setShow(false);
            pageLockedShow(false);
            cropInfoShow(false);
            timeShow(false);
            pageCropEmptyShow(false);
            pageCropCompletedShow(false);

        } else if (page == PAGE_LOCKED) {
            goToButton.setShow(false);
            pageLockedShow(show);
            cropInfoShow(false);
            timeShow(false);
            pageCropEmptyShow(false);
            pageCropCompletedShow(false);

        } else if (page == PAGE_UNLOCKED) {
            goToButton.setShow(show);
            pageLockedShow(false);
            cropInfoShow(show);
            timeShow(show);
            pageCropEmptyShow(false);
            pageCropCompletedShow(false);

        } else if (page == PAGE_UNLOCKED_CROP_EMPTY) {
            goToButton.setShow(show);
            pageLockedShow(false);
            cropInfoShow(false);
            timeShow(false);
            pageCropEmptyShow(show);
            pageCropCompletedShow(false);

        } else if (page == PAGE_UNLOCKED_CROP_COMPLETED) {
            goToButton.setShow(show);
            pageLockedShow(false);
            cropInfoShow(show);
            timeShow(false);
            pageCropEmptyShow(false);
            pageCropCompletedShow(show);
        }
    }

    public void pageLockedShow(boolean show) {
        lockedLabelGuiText.setShow(show);
        lockedImage.setShow(show);
        buyLabelGuiText.setShow(show);
        buyButton.setShow(show);
        buyButtonGuiText.setShow(show);
    }

    public void cropInfoShow(boolean show) {
        cropGuiText.setShow(show);
    }

    public void timeShow(boolean show) {
        timeLabelGuiText.setShow(show);
        progressBar.setShow(show);
        timeGuiText.setShow(show);
    }

    public void pageCropEmptyShow(boolean show) {
        plantSomethingGuiText.setShow(show);
    }

    public void pageCropCompletedShow(boolean show) {
        completedGuiText.setShow(show);
    }

    public void update(FieldData fieldData) {

        if (fieldData.isUnlocked()) {
            if (fieldData.getPlanted().plantedNotEmpty()) {
                if (fieldData.isCompleted()) {
                    setPageCropCompleted();
                } else {
                    setPageUnlocked();
                }
            } else {
                setPageCropEmpty();
            }
        } else {
            setPageLocked();
        }

        fieldNameGuiText.setText(fieldData.getNameID());
        cropGuiText.setText("Crop: " + fieldData.getPlanted().getPlantName());

        if (page == PAGE_UNLOCKED) {
            progressBar.update(fieldData.getPercentageCompleted());
            timeGuiText.setText(fieldData.getTimeLeft());
        }

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

    @Override
    public void updateSize() {
        updatePanelSize();

        // ====== All Pages Items ======
        fieldNameGuiText.setPosition(
                xLeftPos + 5.0f,
                yTopPos + 5.0f,
                0.0f
        );

        // ====== Page Locked Items ======
        lockedLabelGuiText.setPosition(
                xRightPos - lockedLabelGuiText.getWidth() - lockedImage.getWidth() - 10.0f,
                yTopPos + 5.0f,
                0.0f
        );
        lockedImage.setPosition(
                xRightPos - lockedImage.getWidth() - 5.0f,
                yTopPos + 5.0f,
                0.0f
        );
        buyLabelGuiText.setPosition(
                xCenterPos - (buyLabelGuiText.getWidth() / 2) - (buyButton.getWidth() / 2),
                buyButton.getYCenterPos() - (buyLabelGuiText.getHeight() / 2),
                0.0f
        );
        buyButton.setPosition(
                buyLabelGuiText.getXRightPos() + 10.0f,
                yBottomPos - buyButton.getHeight() - 10.0f,
                0.0f
        );
        buyButtonGuiText.setPosition(
                buyButton.getXCenterPos() - (buyButtonGuiText.getWidth() / 2),
                buyButton.getYCenterPos() - (buyButtonGuiText.getHeight() / 2),
                0.0f
        );

        // ====== Page Unlocked Items ======
        goToButton.setPosition(
                xRightPos - goToButton.getWidth() - 5.0f,
                yTopPos + 5.0f,
                0.0f
        );
        cropGuiText.setPosition(
                xLeftPos + 5.0f,
                fieldNameGuiText.getYBottomPos() + 2.5f,
                0.0f
        );
        timeLabelGuiText.setPosition(
                xLeftPos + 5.0f,
                cropGuiText.getYBottomPos() + 2.5f,
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

        // ====== Page Unlocked Crop Empty Items ======
        plantSomethingGuiText.setPosition(
                xCenterPos - (plantSomethingGuiText.getWidth() / 2),
                fieldNameGuiText.getYBottomPos() + 10.0f,
                0.0f
        );

        // ====== Page Unlocked Crop Completed Items ======
        completedGuiText.setPosition(
                xCenterPos - (completedGuiText.getWidth() / 2),
                cropGuiText.getYBottomPos() + 2.5f,
                0.0f
        );
    }
}
