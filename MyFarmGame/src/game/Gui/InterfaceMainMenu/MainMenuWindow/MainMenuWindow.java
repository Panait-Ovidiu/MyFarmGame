package game.Gui.InterfaceMainMenu.MainMenuWindow;

import engine.GameItem;
import engine.Window;
import game.Assets.AssetManager;
import game.Gui.Items.*;

import java.util.ArrayList;

import static game.Assets.GuiData.GuiTextures.MAIN_BUTTON_SQUARE_TEXTURE;
import static game.Assets.GuiData.GuiTextures.MAIN_LOGO_TEXTURE;

public class MainMenuWindow extends GuiWindow {

    private Window window;

    public GuiButton adminButton;

    public GuiButton startButton;
    public GuiButton optionsButton;
    public GuiButton exitButton;

    public GuiImage logoImage;

    public MainMenuWindow(Window window, ArrayList<GameItem> parentItems) throws Exception {
        super(300.0f, 300.0f, parentItems);
        this.window = window;
        setPosition(20.0f, (window.getHeight() / 2.0f), 0.0f);

        addItems(parentItems);
        setShow(show);
    }

    @Override
    protected void addItems(ArrayList<GameItem> parentItems) throws Exception {
        windowTitleGuiText.setText("Main Menu");

        logoImage = new GuiImage(400, 200, AssetManager.getGuiTextures(MAIN_LOGO_TEXTURE.getName()), parentItems);

        adminButton = new GuiButton(250.f, 50.0f, AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()), "adminButton (Main Menu) )", parentItems);
        adminButton.setButtonAnimationEnlarge();
        adminButton.setButtonText("Admin - World Editor");

        closeButton.setNameID("closeButton (Main Menu)");
        closeButton.setShow(false);

        startButton = new GuiButton(150.f, 50.0f, AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()), "startButton (Main Menu) )", parentItems);
        startButton.setButtonAnimationEnlarge();
        startButton.setButtonText("Start");

        optionsButton = new GuiButton(150.f, 50.0f, AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()), "optionsButton (Main Menu) )", parentItems);
        optionsButton.setButtonAnimationEnlarge();
        optionsButton.setButtonText("Options");

        exitButton = new GuiButton(150.f, 50.0f, AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()), "exitButton (Main Menu) )", parentItems);
        exitButton.setButtonAnimationEnlarge();
        exitButton.setButtonText("Exit");
    }

    @Override
    public void setPageEmpty() {

    }

    @Override
    public void setShow(boolean show) {
        windowShow(show);
        closeButton.setShow(false);
        adminButton.setShow(false);

    }

    public void update() {

    }

    @Override
    public void updateSize() {
        updateWindowSize();

        setPosition(40.0f, (window.getHeight() / 2.0f) - (getHeight() / 4), 0.0f);

        logoImage.setPosition(
                10.0f,
                10.0f,
                0.0f
        );
        adminButton.setPosition(
                logoImage.getXRightPos() + 5.0f,
                logoImage.getYTopPos()+5.0f,
                0.0f
        );

        startButton.setPosition(
                getXCenterPos() - (startButton.getWidth() / 2.0f),
                optionsButton.getYTopPos() - startButton.getHeight() - 10.0f,
                0.0f
        );
        optionsButton.setPosition(
                getXCenterPos() - (optionsButton.getWidth() / 2.0f),
                getYCenterPos() - (optionsButton.getHeight() / 2.0f),
                0.0f
        );
        exitButton.setPosition(
                getXCenterPos() - (exitButton.getWidth() / 2.0f),
                optionsButton.getYBottomPos() + 10.0f,
                0.0f
        );
    }
}
