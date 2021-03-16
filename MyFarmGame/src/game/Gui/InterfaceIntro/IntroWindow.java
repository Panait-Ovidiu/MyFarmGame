package game.Gui.InterfaceIntro;

import engine.GameItem;
import engine.Window;
import game.Assets.AssetManager;
import game.Gui.Items.GuiImage;
import game.Gui.Items.GuiText;
import game.Gui.Items.GuiWindow;

import java.util.ArrayList;

import static game.Assets.GuiData.GuiTextures.MAIN_LOGO_TEXTURE;

public class IntroWindow extends GuiWindow {

    private Window window;

    private GuiImage logoImage;
    private GuiText loadingText;
    private GuiText loadingDots;

    private int counter = 0;

    public IntroWindow(Window window, ArrayList<GameItem> parentItems) throws Exception {
        super(window.getWidth(), window.getHeight(), parentItems);
        this.window = window;
        setPanelBackgroundShow(false);

        addItems(parentItems);
        setShow(show);
    }

    @Override
    protected void addItems(ArrayList<GameItem> parentItems) throws Exception {

        logoImage = new GuiImage(750, 250, AssetManager.getGuiTextures(MAIN_LOGO_TEXTURE.getName()), parentItems);
        loadingText = new GuiText("Loading", GuiText.SIZE_LARGE, parentItems);
        loadingDots = new GuiText(".", GuiText.SIZE_LARGE, parentItems);

    }

    @Override
    public void setPageEmpty() {

    }

    @Override
    public void setShow(boolean show) {
        windowShow(show);
        windowTitleGuiText.setShow(false);
        closeButton.setShow(false);
    }

    public void update() {
        counter++;
        if (counter > 30) {
            counter = 0;
        } else if (counter == 10) {
            loadingDots.setText(".");
        } else if (counter == 20) {
            loadingDots.setText(". .");
        } else if (counter == 30) {
            loadingDots.setText(". . .");
        }
    }

    @Override
    public void updateSize() {
        setWidthAndHeight(window.getWidth(), window.getHeight());

        logoImage.setPosition(
                (window.getWidth() / 2.0f) - (logoImage.getWidth() / 2.0f),
                (window.getHeight() / 2.0f) - logoImage.getHeight(),
                0.0f
        );
        loadingText.setPosition(
                xCenterPos - (loadingText.getWidth() / 2),
                yCenterPos + loadingText.getHeight(),
                0.0f
        );
        loadingDots.setPosition(
                loadingText.getXRightPos() + 5.0f,
                yCenterPos + loadingText.getHeight(),
                0.0f
        );
    }
}
