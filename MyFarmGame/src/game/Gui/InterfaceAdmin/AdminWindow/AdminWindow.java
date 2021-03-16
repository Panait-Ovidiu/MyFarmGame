package game.Gui.InterfaceAdmin.AdminWindow;

import engine.GameItem;
import engine.Window;
import game.Assets.AssetManager;
import game.Gui.Items.GuiButton;
import game.Gui.Items.GuiPanel;
import game.Gui.InterfaceAdmin.AdminGuiInterface.SelectedAssetInfo;

import java.util.ArrayList;

import static game.Assets.GuiData.GuiTextures.BUTTON_ARROW_PREVIOUS_TEXTURE;
import static game.Assets.GuiData.GuiTextures.MAIN_BUTTON_SQUARE_TEXTURE;

public class AdminWindow extends GuiPanel {

    private Window window;

    public static final int PAGE_TERRAIN = 1;
    public static final int PAGE_BUILDINGS = 2;
    public static final int PAGE_DECORATIONS = 3;
    public static final int PAGE_PLANTS = 4;
    public static final int PAGE_ANIMALS = 5;

    public GuiButton mainMenuButton;
    public GuiButton terrainButton;
    public GuiButton buildingsButton;
    public GuiButton decorationsButton;
    public GuiButton plantsButton;
    public GuiButton animalsButton;

    public AdminSelectPanel selectPanel;

    public AdminWindow(Window window, ArrayList<GameItem> parentItems) throws Exception {
        super(600.0f, 600.0f, parentItems);
        this.window = window;
        setPosition(10.0f, 10.0f, 0.0f);

        setBackgroundShow(false);
        setPanelBackgroundShow(false);

        addItems(parentItems);
        setShow(show);
    }

    @Override
    protected void addItems(ArrayList<GameItem> parentItems) throws Exception {
        mainMenuButton = new GuiButton(40.0f, AssetManager.getGuiTextures(BUTTON_ARROW_PREVIOUS_TEXTURE.getName()), "mainMenuButton (Admin Menu) )", parentItems);

        terrainButton = new GuiButton(150.f, 40.0f, AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()), "terrainButton (Admin Menu) )", parentItems);
        terrainButton.setButtonText("Terrain");

        buildingsButton = new GuiButton(150.f, 40.0f, AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()), "buildingsButton (Admin Menu) )", parentItems);
        buildingsButton.setButtonText("Buildings");

        decorationsButton = new GuiButton(150.f, 40.0f, AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()), "decorationsButton (Admin Menu) )", parentItems);
        decorationsButton.setButtonText("Decorations");

        plantsButton = new GuiButton(150.f, 40.0f, AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()), "plantsButton (Admin Menu) )", parentItems);
        plantsButton.setButtonText("Plants");

        animalsButton = new GuiButton(150.f, 40.0f, AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()), "animalsButton (Admin Menu) )", parentItems);
        animalsButton.setButtonText("Animals");

        selectPanel = new AdminSelectPanel(width - 20.0f, height - 70.0f, parentItems);
    }

    @Override
    public void setPageEmpty() {
        page = PAGE_EMPTY;
        setShow(show);
    }

    public void setPageTerrain() {
        page = PAGE_TERRAIN;
        setShow(show);
    }
    public void setPageBuildings() {
        page = PAGE_BUILDINGS;
        setShow(show);
    }


    public void setPageDecorations() {
        page = PAGE_DECORATIONS;
        setShow(show);
    }

    public void setPagePlants() {
        page = PAGE_PLANTS;
        setShow(show);
    }

    public void setPageAnimals() {
        page = PAGE_ANIMALS;
        setShow(show);
    }

    @Override
    public void setShow(boolean show) {
        panelShow(show);

    }

    public void disableButtons(boolean isMainMenu, boolean isTerrain, boolean isBuildings ,
                               boolean isDecorations, boolean isPlants, boolean isAnimals) {
        mainMenuButton.setDisabled(isMainMenu);
        terrainButton.setDisabled(isTerrain);
        buildingsButton.setDisabled(isBuildings);
        decorationsButton.setDisabled(isDecorations);
        plantsButton.setDisabled(isPlants);
        animalsButton.setDisabled(isAnimals);
    }

    public void update(SelectedAssetInfo itemInfo) {

        if (page == PAGE_TERRAIN) {
            selectPanel.update(itemInfo);
        }

        if (page == PAGE_BUILDINGS) {
            selectPanel.update(itemInfo);
        }

        if (page == PAGE_DECORATIONS) {
            selectPanel.update(itemInfo);
        }

        if (page == PAGE_PLANTS) {
            selectPanel.update(itemInfo);
        }

        if (page == PAGE_ANIMALS) {
            selectPanel.update(itemInfo);
        }

    }

    @Override
    public void updateSize() {
        updatePanelSize();

        mainMenuButton.setPosition(
                xLeftPos + 10.0f,
                yTopPos + 10.0f,
                0.0f
        );
        terrainButton.setPosition(
                mainMenuButton.getXRightPos() + 10.0f,
                yTopPos + 10.0f,
                0.0f
        );
        buildingsButton.setPosition(
                terrainButton.getXRightPos() + 10.0f,
                yTopPos + 10.0f,
                0.0f
        );
        decorationsButton.setPosition(
                buildingsButton.getXRightPos() + 10.0f,
                yTopPos + 10.0f,
                0.0f
        );
        plantsButton.setPosition(
                decorationsButton.getXRightPos() + 10.0f,
                yTopPos + 10.0f,
                0.0f
        );
        animalsButton.setPosition(
                plantsButton.getXRightPos() + 10.0f,
                yTopPos + 10.0f,
                0.0f
        );

        selectPanel.setPosition(
                xLeftPos + 10.0f,
                terrainButton.getYBottomPos() + 10.0f,
                0.0f
        );
    }

}
