package game.Gui.InterfaceAdmin.AdminWindow;

import engine.GameItem;
import game.Assets.AssetManager;
import game.Gui.Items.GuiButton;
import game.Gui.Items.GuiPanel;
import game.Gui.Items.GuiText;
import game.Gui.InterfaceAdmin.AdminGuiInterface.SelectedAssetInfo;

import java.util.ArrayList;

import static game.Assets.GuiData.GuiTextures.*;

public class AdminSelectPanel extends GuiPanel {

    public static final int PAGE_MODIFY = 1;
    public static final int PAGE_REMOVE = 2;
    public static final int PAGE_ADD = 3;

    // ====== Top Items ======
    public GuiText itemListSizeText;

    public GuiButton previousSelectButton;
    public GuiText itemNameText;
    public GuiButton nextSelectButton;

    public GuiButton modifyButton;
    public GuiButton removeButton;
    public GuiButton addButton;

    // ====== Mesh Items ======
    public GuiText meshLabelText;
    public GuiButton meshPreviousButton;
    public GuiText meshValueText;
    public GuiButton meshNextButton;

    // ====== Increment Items ======
    public GuiText incrementLabelText;
    public GuiButton incrementPreviousButton;
    public GuiText incrementValueText;
    public GuiButton incrementNextButton;

    // ====== Position Items ======
    public GuiText positionTitleText;

    public GuiText positionXLabelText;
    public GuiButton positionXPreviousButton;
    public GuiText positionXValueText;
    public GuiButton positionXNextButton;

    public GuiText positionYLabelText;
    public GuiButton positionYPreviousButton;
    public GuiText positionYValueText;
    public GuiButton positionYNextButton;

    public GuiText positionZLabelText;
    public GuiButton positionZPreviousButton;
    public GuiText positionZValueText;
    public GuiButton positionZNextButton;

    // ====== Rotation Items ======
    public GuiText rotationTitleText;

    public GuiText rotationXLabelText;
    public GuiButton rotationXPreviousButton;
    public GuiText rotationXValueText;
    public GuiButton rotationXNextButton;

    public GuiText rotationYLabelText;
    public GuiButton rotationYPreviousButton;
    public GuiText rotationYValueText;
    public GuiButton rotationYNextButton;

    public GuiText rotationZLabelText;
    public GuiButton rotationZPreviousButton;
    public GuiText rotationZValueText;
    public GuiButton rotationZNextButton;

    // ====== Bottom Items ======
    public GuiButton saveButton;
    public GuiButton cancelButton;

    public AdminSelectPanel(float width, float height, ArrayList<GameItem> parentItems) throws Exception {
        super(width, height, parentItems);
        show = false;

        setBackgroundShow(false);
        setPanelBackgroundShow(false);

        addItems(parentItems);
        setShow(show);
    }

    protected void addItems(ArrayList<GameItem> parentItems) throws Exception {
        // ====== Top Items ======
        itemListSizeText = new GuiText("Item: 1/5", GuiText.SIZE_NORMAL, parentItems);

        previousSelectButton = new GuiButton(40.0f, AssetManager.getGuiTextures(BUTTON_ARROW_PREVIOUS_TEXTURE.getName()), "previousSelectButton (Admin Menu) )", parentItems);
        itemNameText = new GuiText("gameItemName1", GuiText.SIZE_NORMAL, parentItems);
        nextSelectButton = new GuiButton(40.0f, AssetManager.getGuiTextures(BUTTON_ARROW_NEXT_TEXTURE.getName()), "nextSelectButton (Admin Menu) )", parentItems);

        modifyButton = new GuiButton(80.0f, 40.0f, AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()), "modifyButton (Admin Menu) )", parentItems);
        modifyButton.setButtonText("Modify");

        removeButton = new GuiButton(80.0f, 40.0f, AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()), "removeButton (Admin Menu) )", parentItems);
        removeButton.setButtonText("Remove");

        addButton = new GuiButton(80.0f, 40.0f, AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()), "addButton (Admin Menu) )", parentItems);
        addButton.setButtonText("Add");

        // ====== Mesh Items ======
        meshLabelText = new GuiText("Mesh: 1/5", GuiText.SIZE_NORMAL, parentItems);
        meshPreviousButton = new GuiButton(30.0f, AssetManager.getGuiTextures(BUTTON_ARROW_PREVIOUS_TEXTURE.getName()), "meshPreviousButton (Admin Menu) )", parentItems);
        meshValueText = new GuiText("meshName1", GuiText.SIZE_NORMAL, parentItems);
        ;
        meshNextButton = new GuiButton(30.0f, AssetManager.getGuiTextures(BUTTON_ARROW_NEXT_TEXTURE.getName()), "meshNextButton (Admin Menu) )", parentItems);

        // ====== Increment Items ======
        incrementLabelText = new GuiText("Increment by", GuiText.SIZE_NORMAL, parentItems);
        incrementPreviousButton = new GuiButton(30.0f, AssetManager.getGuiTextures(BUTTON_ARROW_PREVIOUS_TEXTURE.getName()), "incrementPreviousButton (Admin Menu) )", parentItems);
        incrementValueText = new GuiText("5.5", GuiText.SIZE_NORMAL, parentItems);
        incrementNextButton = new GuiButton(30.0f, AssetManager.getGuiTextures(BUTTON_ARROW_NEXT_TEXTURE.getName()), "incrementNextButton (Admin Menu) )", parentItems);

        // ====== Position Items ======
        positionTitleText = new GuiText("Position", GuiText.SIZE_NORMAL, parentItems);

        positionXLabelText = new GuiText("X", GuiText.SIZE_NORMAL, parentItems);
        positionXPreviousButton = new GuiButton(30.0f, AssetManager.getGuiTextures(BUTTON_ARROW_PREVIOUS_TEXTURE.getName()), "positionXPreviousButton (Admin Menu) )", parentItems);
        positionXValueText = new GuiText("100", GuiText.SIZE_NORMAL, parentItems);
        positionXNextButton = new GuiButton(30.0f, AssetManager.getGuiTextures(BUTTON_ARROW_NEXT_TEXTURE.getName()), "positionXNextButton (Admin Menu) )", parentItems);

        positionYLabelText = new GuiText("Y", GuiText.SIZE_NORMAL, parentItems);
        positionYPreviousButton = new GuiButton(30.0f, AssetManager.getGuiTextures(BUTTON_ARROW_PREVIOUS_TEXTURE.getName()), "positionYPreviousButton (Admin Menu) )", parentItems);
        positionYValueText = new GuiText("200", GuiText.SIZE_NORMAL, parentItems);
        positionYNextButton = new GuiButton(30.0f, AssetManager.getGuiTextures(BUTTON_ARROW_NEXT_TEXTURE.getName()), "positionYNextButton (Admin Menu) )", parentItems);

        positionZLabelText = new GuiText("Z", GuiText.SIZE_NORMAL, parentItems);
        positionZPreviousButton = new GuiButton(30.0f, AssetManager.getGuiTextures(BUTTON_ARROW_PREVIOUS_TEXTURE.getName()), "positionZPreviousButton (Admin Menu) )", parentItems);
        positionZValueText = new GuiText("300", GuiText.SIZE_NORMAL, parentItems);
        positionZNextButton = new GuiButton(30.0f, AssetManager.getGuiTextures(BUTTON_ARROW_NEXT_TEXTURE.getName()), "positionZNextButton (Admin Menu) )", parentItems);

        // ====== Rotation Items ======
        rotationTitleText = new GuiText("Rotation", GuiText.SIZE_NORMAL, parentItems);

        rotationXLabelText = new GuiText("X", GuiText.SIZE_NORMAL, parentItems);
        rotationXPreviousButton = new GuiButton(30.0f, AssetManager.getGuiTextures(BUTTON_ARROW_PREVIOUS_TEXTURE.getName()), "rotationXPreviousButton (Admin Menu) )", parentItems);
        rotationXValueText = new GuiText("100", GuiText.SIZE_NORMAL, parentItems);
        rotationXNextButton = new GuiButton(30.0f, AssetManager.getGuiTextures(BUTTON_ARROW_NEXT_TEXTURE.getName()), "rotationXNextButton (Admin Menu) )", parentItems);

        rotationYLabelText = new GuiText("Y", GuiText.SIZE_NORMAL, parentItems);
        rotationYPreviousButton = new GuiButton(30.0f, AssetManager.getGuiTextures(BUTTON_ARROW_PREVIOUS_TEXTURE.getName()), "rotationYPreviousButton (Admin Menu) )", parentItems);
        rotationYValueText = new GuiText("200", GuiText.SIZE_NORMAL, parentItems);
        rotationYNextButton = new GuiButton(30.0f, AssetManager.getGuiTextures(BUTTON_ARROW_NEXT_TEXTURE.getName()), "rotationYNextButton (Admin Menu) )", parentItems);

        rotationZLabelText = new GuiText("Z", GuiText.SIZE_NORMAL, parentItems);
        rotationZPreviousButton = new GuiButton(30.0f, AssetManager.getGuiTextures(BUTTON_ARROW_PREVIOUS_TEXTURE.getName()), "rotationZPreviousButton (Admin Menu) )", parentItems);
        rotationZValueText = new GuiText("300", GuiText.SIZE_NORMAL, parentItems);
        rotationZNextButton = new GuiButton(30.0f, AssetManager.getGuiTextures(BUTTON_ARROW_NEXT_TEXTURE.getName()), "rotationZNextButton (Admin Menu) )", parentItems);

        // ====== Bottom Items ======
        saveButton = new GuiButton(80.0f, 40.0f, AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()), "saveButton (Admin Menu) )", parentItems);
        saveButton.setButtonText("Save");

        cancelButton = new GuiButton(80.0f, 40.0f, AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()), "cancelButton (Admin Menu) )", parentItems);
        cancelButton.setButtonText("Cancel");
    }

    @Override
    public void setPageEmpty() {
        page = PAGE_EMPTY;
        setShow(show);
    }

    public void setPageModify() {
        page = PAGE_MODIFY;
        setShow(show);
    }

    public void setPageRemove() {
        page = PAGE_REMOVE;
        setShow(show);
    }

    public void setPageAdd() {
        page = PAGE_ADD;
        setShow(show);
    }

    @Override
    public void setShow(boolean show) {
        panelShow(show);

        // ====== Top Items ======
        itemListSizeText.setShow(show);

        previousSelectButton.setShow(show);
        itemNameText.setShow(show);
        nextSelectButton.setShow(show);

        modifyButton.setShow(show);
        removeButton.setShow(show);
        addButton.setShow(show);

        // ====== Mesh Items ======
        meshLabelText.setShow(show);
        meshPreviousButton.setShow(show);
        meshValueText.setShow(show);
        meshNextButton.setShow(show);

        // ====== Increment Items ======
        incrementLabelText.setShow(show);
        incrementPreviousButton.setShow(show);
        incrementValueText.setShow(show);
        incrementNextButton.setShow(show);

        // ====== Position Items ======
        positionTitleText.setShow(show);

        positionXLabelText.setShow(show);
        positionXPreviousButton.setShow(show);
        positionXValueText.setShow(show);
        positionXNextButton.setShow(show);

        positionYLabelText.setShow(show);
        positionYPreviousButton.setShow(show);
        positionYValueText.setShow(show);
        positionYNextButton.setShow(show);

        positionZLabelText.setShow(show);
        positionZPreviousButton.setShow(show);
        positionZValueText.setShow(show);
        positionZNextButton.setShow(show);

        // ====== Rotation Items ======
        rotationTitleText.setShow(show);

        rotationXLabelText.setShow(show);
        rotationXPreviousButton.setShow(show);
        rotationXValueText.setShow(show);
        rotationXNextButton.setShow(show);

        rotationYLabelText.setShow(show);
        rotationYPreviousButton.setShow(show);
        rotationYValueText.setShow(show);
        rotationYNextButton.setShow(show);

        rotationZLabelText.setShow(show);
        rotationZPreviousButton.setShow(show);
        rotationZValueText.setShow(show);
        rotationZNextButton.setShow(show);

        if (page == PAGE_EMPTY) {
            disableTopButtons(false);
            disableCenterButtons(true);
            disableBottomButtons(true);
            saveButton.setShow(false);
            cancelButton.setShow(false);

        } else if (page == PAGE_MODIFY) {
            disableTopButtons(true);
            disableCenterButtons(false);
            disableBottomButtons(false);
            saveButton.setShow(show);
            cancelButton.setShow(show);

        } else if (page == PAGE_ADD) {
            disableTopButtons(true);
            disableCenterButtons(false);
            disableBottomButtons(false);
            saveButton.setShow(show);
            cancelButton.setShow(show);

        }

    }

    private void disableTopButtons(boolean value) {
        previousSelectButton.setDisabled(value);
        nextSelectButton.setDisabled(value);

        modifyButton.setDisabled(value);
        removeButton.setDisabled(value);
        addButton.setDisabled(value);
    }

    private void disableCenterButtons(boolean value) {
        // ====== Mesh Buttons ======
        meshPreviousButton.setDisabled(value);
        meshNextButton.setDisabled(value);

        // ====== Increment Buttons ======
        incrementPreviousButton.setDisabled(value);
        incrementNextButton.setDisabled(value);

        // ====== Position Buttons ======
        positionXPreviousButton.setDisabled(value);
        positionXNextButton.setDisabled(value);

        positionYPreviousButton.setDisabled(value);
        positionYNextButton.setDisabled(value);

        positionZPreviousButton.setDisabled(value);
        positionZNextButton.setDisabled(value);

        // ====== Rotation Buttons ======
        rotationXPreviousButton.setDisabled(value);
        rotationXNextButton.setDisabled(value);

        rotationYPreviousButton.setDisabled(value);
        rotationYNextButton.setDisabled(value);

        rotationZPreviousButton.setDisabled(value);
        rotationZNextButton.setDisabled(value);
    }

    private void disableBottomButtons(boolean value) {
        saveButton.setDisabled(value);
        cancelButton.setDisabled(value);
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

    public void update(SelectedAssetInfo itemInfo) {

        itemListSizeText.setText("Item: " + (itemInfo.getGameItemIndex() + 1) + "/" + itemInfo.getAssetListSize());
        itemNameText.setText(itemInfo.getGameItemID());
        meshLabelText.setText("Mesh: " + (itemInfo.getMeshIndex()+1) + "/" + itemInfo.getMeshListSize());
        meshValueText.setText(itemInfo.getMeshID());
        incrementValueText.setText(Float.toString(itemInfo.getIncrementBy()));

        positionXValueText.setText(Float.toString(itemInfo.getGameItemPosition().x));
        positionYValueText.setText(Float.toString(itemInfo.getGameItemPosition().y));
        positionZValueText.setText(Float.toString(itemInfo.getGameItemPosition().z));

        rotationXValueText.setText(Float.toString(itemInfo.getGameItemRotation().x));
        rotationYValueText.setText(Float.toString(itemInfo.getGameItemRotation().y));
        rotationZValueText.setText(Float.toString(itemInfo.getGameItemRotation().z));
    }

    @Override
    public void updateSize() {
        updatePanelSize();

        // ====== Top Items ======
        itemListSizeText.setPosition(
                xLeftPos + 30.0f,
                yTopPos - (itemListSizeText.getHeight() / 2) + 20.0f,
                0.0f
        );
        previousSelectButton.setPosition(
                xLeftPos + 20.0f,
                itemListSizeText.getYBottomPos() + 10.0f,
                0.0f
        );
        itemNameText.setPosition(
                previousSelectButton.getXRightPos() + 10.0f,
                previousSelectButton.getYCenterPos() - (itemNameText.getHeight() / 2),
                0.0f

        );
        nextSelectButton.setPosition(
                itemNameText.getXRightPos() + 10.0f,
                itemListSizeText.getYBottomPos() + 10.0f,
                0.0f
        );
        modifyButton.setPosition(
                nextSelectButton.getXRightPos() + 10.0f,
                itemListSizeText.getYBottomPos() + 10.0f,
                0.0f
        );
        removeButton.setPosition(
                modifyButton.getXRightPos() + 10.0f,
                itemListSizeText.getYBottomPos() + 10.0f,
                0.0f
        );
        addButton.setPosition(
                removeButton.getXRightPos() + 10.0f,
                itemListSizeText.getYBottomPos() + 10.0f,
                0.0f
        );

        // ====== Mesh Items ======
        meshLabelText.setPosition(
                xLeftPos + 20.0f,
                meshPreviousButton.getYCenterPos() - (meshLabelText.getHeight() / 2),
                0.0f
        );
        meshPreviousButton.setPosition(
                meshLabelText.getXRightPos() + 10.0f,
                previousSelectButton.getYBottomPos() + 20.0f,
                0.0f
        );
        meshNextButton.setPosition(
                meshPreviousButton.getXRightPos() + 10.0f,
                previousSelectButton.getYBottomPos() + 20.0f,
                0.0f
        );
        meshValueText.setPosition(
                meshNextButton.getXRightPos() + 10.0f,
                meshPreviousButton.getYCenterPos() - (meshValueText.getHeight() / 2),
                0.0f
        );

        // ====== Increment Items ======
        incrementLabelText.setPosition(
                xLeftPos + 20.0f,
                incrementPreviousButton.getYCenterPos() - (incrementLabelText.getHeight() / 2),
                0.0f
        );
        incrementPreviousButton.setPosition(
                incrementLabelText.getXRightPos() + 10.0f,
                meshPreviousButton.getYBottomPos() + 10.0f,
                0.0f
        );
        incrementValueText.setPosition(
                incrementPreviousButton.getXRightPos() + 10.0f,
                incrementPreviousButton.getYCenterPos() - (incrementValueText.getHeight() / 2),
                0.0f
        );
        incrementNextButton.setPosition(
                incrementValueText.getXRightPos() + 10.0f,
                meshPreviousButton.getYBottomPos() + 10.0f,
                0.0f
        );

        // ====== Position Items ======
        positionTitleText.setPosition(
                positionXValueText.getXCenterPos() - (positionTitleText.getWidth() / 2),
                incrementPreviousButton.getYBottomPos() + 10.0f,
                0.0f
        );
        positionXLabelText.setPosition(
                xLeftPos + 20.0f,
                positionXPreviousButton.getYCenterPos() - (positionXLabelText.getHeight() / 2),
                0.0f
        );
        positionXPreviousButton.setPosition(
                positionXLabelText.getXRightPos() + 10.0f,
                positionTitleText.getYBottomPos() + 10.0f,
                0.0f
        );
        positionXValueText.setPosition(
                positionXPreviousButton.getXRightPos() + 10.0f,
                positionXPreviousButton.getYCenterPos() - (positionXValueText.getHeight() / 2),
                0.0f
        );
        positionXNextButton.setPosition(
                positionXValueText.getXRightPos() + 10.0f,
                positionTitleText.getYBottomPos() + 10.0f,
                0.0f
        );

        positionYLabelText.setPosition(
                xLeftPos + 20.0f,
                positionYPreviousButton.getYCenterPos() - (positionYLabelText.getHeight() / 2),
                0.0f
        );
        positionYPreviousButton.setPosition(
                positionYLabelText.getXRightPos() + 10.0f,
                positionXPreviousButton.getYBottomPos() + 10.0f,
                0.0f
        );
        positionYValueText.setPosition(
                positionYPreviousButton.getXRightPos() + 10.0f,
                positionYPreviousButton.getYCenterPos() - (positionYValueText.getHeight() / 2),
                0.0f
        );
        positionYNextButton.setPosition(
                positionYValueText.getXRightPos() + 10.0f,
                positionXPreviousButton.getYBottomPos() + 10.0f,
                0.0f
        );

        positionZLabelText.setPosition(
                xLeftPos + 20.0f,
                positionZPreviousButton.getYCenterPos() - (positionZLabelText.getHeight() / 2),
                0.0f
        );
        positionZPreviousButton.setPosition(
                positionZLabelText.getXRightPos() + 10.0f,
                positionYPreviousButton.getYBottomPos() + 10.0f,
                0.0f
        );
        positionZValueText.setPosition(
                positionZPreviousButton.getXRightPos() + 10.0f,
                positionZPreviousButton.getYCenterPos() - (positionZValueText.getHeight() / 2),
                0.0f
        );
        positionZNextButton.setPosition(
                positionZValueText.getXRightPos() + 10.0f,
                positionYPreviousButton.getYBottomPos() + 10.0f,
                0.0f
        );

        // ====== Rotation Items ======
        rotationTitleText.setPosition(
                rotationXValueText.getXCenterPos() - (rotationTitleText.getWidth() / 2),
                positionZPreviousButton.getYBottomPos() + 10.0f,
                0.0f
        );
        rotationXLabelText.setPosition(
                xLeftPos + 20.0f,
                rotationXPreviousButton.getYCenterPos() - (rotationXLabelText.getHeight() / 2),
                0.0f
        );
        rotationXPreviousButton.setPosition(
                rotationXLabelText.getXRightPos() + 10.0f,
                rotationTitleText.getYBottomPos() + 10.0f,
                0.0f
        );
        rotationXValueText.setPosition(
                rotationXPreviousButton.getXRightPos() + 10.0f,
                rotationXPreviousButton.getYCenterPos() - (rotationXValueText.getHeight() / 2),
                0.0f
        );
        rotationXNextButton.setPosition(
                rotationXValueText.getXRightPos() + 10.0f,
                rotationTitleText.getYBottomPos() + 10.0f,
                0.0f
        );

        rotationYLabelText.setPosition(
                xLeftPos + 20.0f,
                rotationYPreviousButton.getYCenterPos() - (rotationYLabelText.getHeight() / 2),
                0.0f
        );
        rotationYPreviousButton.setPosition(
                rotationYLabelText.getXRightPos() + 10.0f,
                rotationXPreviousButton.getYBottomPos() + 10.0f,
                0.0f
        );
        rotationYValueText.setPosition(
                rotationYPreviousButton.getXRightPos() + 10.0f,
                rotationYPreviousButton.getYCenterPos() - (rotationYValueText.getHeight() / 2),
                0.0f
        );
        rotationYNextButton.setPosition(
                rotationYValueText.getXRightPos() + 10.0f,
                rotationXPreviousButton.getYBottomPos() + 10.0f,
                0.0f
        );

        rotationZLabelText.setPosition(
                xLeftPos + 20.0f,
                rotationZPreviousButton.getYCenterPos() - (rotationZLabelText.getHeight() / 2),
                0.0f
        );
        rotationZPreviousButton.setPosition(
                rotationZLabelText.getXRightPos() + 10.0f,
                rotationYPreviousButton.getYBottomPos() + 10.0f,
                0.0f
        );
        rotationZValueText.setPosition(
                rotationZPreviousButton.getXRightPos() + 10.0f,
                rotationZPreviousButton.getYCenterPos() - (rotationZValueText.getHeight() / 2),
                0.0f
        );
        rotationZNextButton.setPosition(
                rotationZValueText.getXRightPos() + 10.0f,
                rotationYPreviousButton.getYBottomPos() + 10.0f,
                0.0f
        );

        // ====== Bottom Items ======
        saveButton.setPosition(
                xLeftPos + 20.0f,
                rotationZPreviousButton.getYBottomPos() + 10.0f,
                0.0f
        );
        cancelButton.setPosition(
                saveButton.getXRightPos() + 30.0f,
                rotationZPreviousButton.getYBottomPos() + 10.0f,
                0.0f
        );
    }
}
