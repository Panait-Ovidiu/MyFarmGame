package game.Gui;

import engine.GameItem;
import engine.Window;
import game.Assets.AssetManager;
import game.Gui.Items.GuiButton;
import game.Gui.Items.GuiPanel;
import game.Gui.Items.GuiText;

import java.util.ArrayList;

import static game.Assets.GuiData.GuiTextures.*;

public class PopUpPanel extends GuiPanel {

    private Window window;

    public GuiButton closeButton;
    public GuiButton yesButton;
    public GuiButton noButton;
    public GuiText textMessage;

    public PopUpPanel(Window window, ArrayList<GameItem> parentItems) throws Exception {
        super(400.0f, 120.0f, parentItems);
        this.window = window;
        setPosition((window.getWidth() / 2.0f) - (getWidth() / 2), (window.getHeight() / 2.0f) - (getHeight() / 2), 0.0f);
        show = false;

        addItems(parentItems);
        setShow(show);
    }

    @Override
    protected void addItems(ArrayList<GameItem> parentItems) throws Exception {
        closeButton = new GuiButton(20.0f, AssetManager.getGuiTextures(BUTTON_CLOSE_TEXTURE.getName()), "closeButton (Panel)", parentItems);

        textMessage = new GuiText("", GuiText.SIZE_NORMAL, parentItems);

        yesButton = new GuiButton(100.f, 30.0f, AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()), "yesButton (Exit Menu) )", parentItems);
        yesButton.setButtonText("Yes");

        noButton = new GuiButton(100.f, 30.0f, AssetManager.getGuiTextures(MAIN_BUTTON_SQUARE_TEXTURE.getName()), "noButton (Exit Menu) )", parentItems);
        noButton.setButtonText("No");
    }

    public void setMessage(String message) {
        textMessage.setText(message);
    }

    @Override
    public void setPageEmpty() {

    }

    @Override
    public void setShow(boolean show) {
        panelShow(show);

        closeButton.setShow(show);
        textMessage.setShow(show);
        yesButton.setShow(show);
        noButton.setShow(show);
    }

    public void update() {

    }

    @Override
    public void updateSize() {
        updatePanelSize();

        setPosition((window.getWidth() / 2.0f) - (getWidth() / 2), (window.getHeight() / 2.0f) - (getHeight() / 2), 0.0f);

        closeButton.setPosition(
                xRightPos - closeButton.getWidth(),
                yTopPos,
                0.0f
        );
        textMessage.setPosition(
                xCenterPos - (textMessage.getWidth() / 2),
                closeButton.getYBottomPos() + 10.0f,
                0.0f
        );
        yesButton.setPosition(
                xCenterPos - yesButton.getWidth() - 25.0f,
                yBottomPos - yesButton.getHeight() - 10.0f,
                0.0f
        );
        noButton.setPosition(
                xCenterPos  + 25.0f,
                yBottomPos - noButton.getHeight() - 10.0f,
                0.0f
        );

    }
}
