package game.Gui.InterfaceGamePlay.PlantWindow.FieldListPage;

import engine.GameItem;
import game.Assets.AssetManager;
import game.Data.PlayerData;
import game.Gui.Items.GuiButton;
import game.Gui.Items.GuiPanel;
import game.Gui.Items.GuiText;

import java.util.ArrayList;

import static game.Assets.GuiData.GuiTextures.BUTTON_ARROW_NEXT_TEXTURE;
import static game.Assets.GuiData.GuiTextures.BUTTON_ARROW_PREVIOUS_TEXTURE;


public class FieldListPage extends GuiPanel {

    // ====== Page Top Items ======
    public FieldListItemPanel fieldListItemPanel;

    // ====== Page Bottom Items ======
    public GuiButton previousButton;
    public GuiText pageNumberGuiText;
    public GuiButton nextButton;

    public FieldListPage(float width, float height, ArrayList<GameItem> parentItems) throws Exception {
        super(width, height, parentItems);

        setPanelBackgroundShow(false);

        addItems(parentItems);
        setShow(show);
    }

    @Override
    public void addItems(ArrayList<GameItem> parentItems) throws Exception {
        // ====== Page Top Items ======
        fieldListItemPanel = new FieldListItemPanel(width - 10.0f, height - 45.0f,parentItems);

        // ====== Pages Bottom Items ======
        previousButton = new GuiButton(40.0f, AssetManager.getGuiTextures(BUTTON_ARROW_PREVIOUS_TEXTURE.getName()), "previousButton (Plant Menu)",parentItems);

        pageNumberGuiText = new GuiText("Page 1", GuiText.SIZE_NORMAL,parentItems);

        nextButton = new GuiButton(40.0f, AssetManager.getGuiTextures(BUTTON_ARROW_NEXT_TEXTURE.getName()), "nextButton (Plant Menu)",parentItems);
    }

    @Override
    public void setPageEmpty() {

    }

    @Override
    public void setShow(boolean show) {
        panelShow(show);

        fieldListItemPanel.setShow(show);
        pageListBottomShow(show);

    }

    private void pageListBottomShow(boolean show) {
        previousButton.setShow(show);
        pageNumberGuiText.setShow(show);
        nextButton.setShow(show);
    }

    public void update(PlayerData playerData) {
        fieldListItemPanel.update(playerData);
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

        // ====== Page Top Items ======
        fieldListItemPanel.setPosition(
                xLeftPos + 5.0f,
                yTopPos,
                0.0f
        );

        // ====== Pages Bottom Items ======
        previousButton.setPosition(
                xCenterPos - (previousButton.getWidth() * 2),
                yBottomPos - previousButton.getHeight() - 2.5f,
                0.0f);
        pageNumberGuiText.setPosition(
                xCenterPos - (pageNumberGuiText.getWidth() / 2),
                previousButton.getYCenterPos() - (pageNumberGuiText.getHeight() / 2),
                0.0f);
        nextButton.setPosition(
                xCenterPos + nextButton.getWidth(),
                yBottomPos - nextButton.getHeight() - 2.5f,
                0.0f);
    }
}
