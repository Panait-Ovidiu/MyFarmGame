package game.Gui.InterfaceGamePlay.MainButtonsPanel;

import engine.GameItem;
import engine.Window;

import game.Assets.AssetManager;
import game.Gui.Items.GuiButton;
import game.Gui.Items.GuiPanel;
import game.Gui.Items.GuiText;

import java.util.ArrayList;

import static game.Assets.GuiData.GuiTextures.*;

public class MainButtonsPanel extends GuiPanel {

    private Window window;

    public GuiButton plantsMenuButton;
    public GuiText plantsMenuGuiText;

    public GuiButton animalsMenuButton;
    public GuiText animalsMenuGuiText;

    public GuiButton treesMenuButton;
    public GuiText treesMenuGuiText;

    public GuiButton upgradesMenuButton;
    public GuiText upgradesMenuGuiText;

    public GuiButton marketMenuButton;
    public GuiText marketMenuGuiText;

    public GuiButton settingsMenuButton;

    public MainButtonsPanel(Window window, ArrayList<GameItem> parentItems) throws Exception {
        super(60.0f, 300.0f, parentItems);
        setPosition(10.0f, 170.0f, 0.0f);
        this.window = window;
        show = true;

        setPanelBackground(AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()));

        addItems(parentItems);
        setShow(show);
    }

    protected void addItems(ArrayList<GameItem> parentItems) throws Exception {
        // === Plants Menu Button ===

        plantsMenuButton = new GuiButton(50.0f, AssetManager.getGuiTextures(BUTTON_PLANTS_TEXTURE.getName()), "plantsMenuButton (Main Buttons)", parentItems);
        plantsMenuButton.setButtonAnimationSlideRight();

        plantsMenuGuiText = new GuiText("Plant Menu", GuiText.SIZE_SMALL, parentItems);
        plantsMenuGuiText.setBackgroundShow(true);
        plantsMenuGuiText.setShow(false);

        // === Animals Menu Button ===
        animalsMenuButton = new GuiButton(50.0f, AssetManager.getGuiTextures(BUTTON_ANIMALS_TEXTURE.getName()), "animalsMenuButton (Main Buttons)", parentItems);
        animalsMenuButton.setButtonAnimationSlideRight();

        animalsMenuGuiText = new GuiText("Animal Menu", GuiText.SIZE_SMALL, parentItems);
        animalsMenuGuiText.setBackgroundShow(true);
        animalsMenuGuiText.setShow(false);

        // === Trees Menu Button ===
        treesMenuButton = new GuiButton(50.0f, AssetManager.getGuiTextures(BUTTON_TREES_TEXTURE.getName()), "treesMenuButton (Main Buttons)", parentItems);
        treesMenuButton.setButtonAnimationSlideRight();

        treesMenuGuiText = new GuiText("Tree Menu", GuiText.SIZE_SMALL, parentItems);
        treesMenuGuiText.setBackgroundShow(true);
        treesMenuGuiText.setShow(false);

        // === Upgrades Menu Button ===
        upgradesMenuButton = new GuiButton(50.0f, AssetManager.getGuiTextures(BUTTON_UPGRADES_TEXTURE.getName()), "upgradesMenuButton (Main Buttons)", parentItems);
        upgradesMenuButton.setButtonAnimationSlideRight();

        upgradesMenuGuiText = new GuiText("Upgrades Menu", GuiText.SIZE_SMALL, parentItems);
        upgradesMenuGuiText.setBackgroundShow(true);
        upgradesMenuGuiText.setShow(false);

        // === Market Menu Button ===
        marketMenuButton = new GuiButton(50.0f, AssetManager.getGuiTextures(BUTTON_MARKET_TEXTURE.getName()), "marketMenuButton (Main Buttons)", parentItems);
        marketMenuButton.setButtonAnimationSlideRight();

        marketMenuGuiText = new GuiText("Market Menu", GuiText.SIZE_SMALL, parentItems);
        marketMenuGuiText.setBackgroundShow(true);
        marketMenuGuiText.setShow(false);

        // === Settings Menu Button ===
        settingsMenuButton = new GuiButton(40.0f, AssetManager.getGuiTextures(BUTTON_SETTINGS_TEXTURE.getName()), "settingsMenuButton (Main Buttons)", parentItems);
    }

    @Override
    public void setPageEmpty() {

    }

    @Override
    public void setShow(boolean show) {
        panelShow(show);

    }

    public void disableButtons(boolean isPlants, boolean isAnimals, boolean isTrees, boolean isUpgrades, boolean isMarket) {
        plantsMenuButton.setDisabled(isPlants);
        animalsMenuButton.setDisabled(isAnimals);
        treesMenuButton.setDisabled(isTrees);
        upgradesMenuButton.setDisabled(isUpgrades);
        marketMenuButton.setDisabled(isMarket);
    }

    public void update() {

    }

    public void updateSize() {
        updatePanelSize();

        plantsMenuButton.setPosition(
                position.x + 5.0f,
                position.y + 5.0f,
                0.0f
        );
        plantsMenuGuiText.setPosition(
                plantsMenuButton.getXRightPos() + 20.0f,
                plantsMenuButton.getYCenterPos() - (plantsMenuGuiText.getHeight() / 2),
                0.0f
        );
        animalsMenuButton.setPosition(
                plantsMenuButton.getPosition().x,
                plantsMenuButton.getYBottomPos() + 10.0f,
                position.z
        );
        animalsMenuGuiText.setPosition(
                animalsMenuButton.getXRightPos() + 20.0f,
                animalsMenuButton.getYCenterPos() - (animalsMenuGuiText.getHeight() / 2),
                0.0f
        );
        treesMenuButton.setPosition(
                animalsMenuButton.getPosition().x,
                animalsMenuButton.getYBottomPos() + 10.0f,
                position.z
        );
        treesMenuGuiText.setPosition(
                treesMenuButton.getXRightPos() + 20.0f,
                treesMenuButton.getYCenterPos() - (treesMenuGuiText.getHeight() / 2),
                0.0f
        );
        upgradesMenuButton.setPosition(
                treesMenuButton.getPosition().x,
                treesMenuButton.getYBottomPos() + 10.0f,
                position.z
        );
        upgradesMenuGuiText.setPosition(
                upgradesMenuButton.getXRightPos() + 20.0f,
                upgradesMenuButton.getYCenterPos() - (upgradesMenuGuiText.getHeight() / 2),
                0.0f
        );
        marketMenuButton.setPosition(
                upgradesMenuButton.getPosition().x,
                upgradesMenuButton.getYBottomPos() + 10.0f,
                position.z
        );
        marketMenuGuiText.setPosition(
                marketMenuButton.getXRightPos() + 20.0f,
                marketMenuButton.getYCenterPos() - (marketMenuGuiText.getHeight() / 2),
                0.0f
        );

        settingsMenuButton.setPosition(
                window.getWidth() - settingsMenuButton.getWidth() - 10.0f,
                10.0f,
                0.0f
        );
    }
}
