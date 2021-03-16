package game.Gui.InterfaceGamePlay.PlayerDisplayPanel;

import engine.GameItem;
import engine.Window;
import game.Assets.AssetManager;
import game.Data.PlayerData;
import game.Gui.Items.*;

import java.util.ArrayList;

import static game.Assets.GuiData.GuiTextures.*;

public class PlayerDisplayPanel extends GuiPanel {

    private Window window;
    private PlayerData playerData;

    public GuiButton playerIcon;

    public GuiImage moneyIcon;
    public GuiText moneyGuiText;
    public GuiBackground moneyBackground;

    public GuiImage experienceIcon;
    public GuiText playerLevelGuiText;
    public GuiText experienceGuiText;
    public ProgressBar progressBar;

    public PlayerDisplayPanel(Window window, PlayerData playerData, ArrayList<GameItem> parentItems) throws Exception {
        super(245.0f, 110.0f, parentItems);
        setPosition(10.0f, 10.0f, 0.0f);
        this.window = window;
        this.playerData = playerData;
        show = true;

        setPanelBackground(AssetManager.getGuiTextures(PLAYER_DISPLAY_BACKGROUND_TEXTURE.getName()));

        addItems(parentItems);
        setShow(show);
    }

    protected void addItems(ArrayList<GameItem> parentItems) throws Exception {

        // Player Icon Button
        playerIcon = new GuiButton(80.0f, AssetManager.getGuiTextures(PLAYER_ICON_TEXTURE.getName()), "playerIcon (Player Display)",parentItems);

        // Money Background
        moneyBackground = new GuiBackground(25, 10, AssetManager.getGuiTextures(PANEL_BACKGROUND_TEXTURE.getName()));
        parentItems.add(moneyBackground);

        // Money Icon
        moneyIcon = new GuiImage(30.0f, AssetManager.getGuiTextures(MONEY_ICON_TEXTURE.getName()),parentItems);

        // Money GuiText
        moneyGuiText = new GuiText("0 $", GuiText.SIZE_SMALL,parentItems);

        // XP ProgressBar
        progressBar = new ProgressBar(100.0f, 20.0f,parentItems);

        // XP Icon
        experienceIcon = new GuiImage(30.0f, AssetManager.getGuiTextures(XP_ICON_TEXTURE.getName()),parentItems);

        playerLevelGuiText = new GuiText("", GuiText.SIZE_NORMAL,parentItems);

        // XP GuiText
        experienceGuiText = new GuiText("", GuiText.SIZE_EXTRA_SMALL,parentItems);
        experienceGuiText.setBackgroundShow(true);
        experienceGuiText.setShow(false);

    }

    @Override
    public void setPageEmpty() {

    }

    public void setShow(boolean show) {
        panelShow(show);

        moneyBackground.setShow(!show);
        progressBar.setShow(show);
    }

    public void update() {
        moneyGuiText.setText(playerData.getPlayerMoney() + " $");
        moneyBackground.rebuildMesh(moneyGuiText.getWidth() + 15.0f, moneyGuiText.getHeight());
        playerLevelGuiText.setText("" + playerData.getPlayerLevel());
        progressBar.update(10.0f);
        experienceGuiText.setText(playerData.getPlayerExp() + " / 100 XP (75%)");
    }

    public void updateSize() {
        updatePanelSize();

        playerIcon.setPosition(
                xLeftPos + 15.0f,
                yCenterPos - (playerIcon.getHeight() / 2),
                0.0f
        );
        if (show) {
            moneyIcon.setPosition(
                    playerIcon.getXRightPos() + 10.0f,
                    yTopPos + 25.0f,
                    0.0f
            );
        } else {
            moneyIcon.setPosition(
                    playerIcon.getXRightPos() - (moneyIcon.getWidth() / 2),
                    yTopPos + 10.0f,
                    0.0f
            );
        }
        moneyGuiText.setPosition(
                moneyIcon.getXRightPos() + 5.0f,
                moneyIcon.getYCenterPos() - (moneyGuiText.getHeight() / 2),
                0.0f
        );
        moneyBackground.setPosition(
                moneyIcon.getXRightPos() - 5.0f,
                moneyIcon.getYCenterPos() - (moneyGuiText.getHeight() / 2),
                0.0f
        );
        if (show) {
            experienceIcon.setPosition(
                    playerIcon.getXRightPos() + 10.0f,
                    yBottomPos - experienceIcon.getHeight() - 15.0f,
                    0.0f
            );
        } else {
            experienceIcon.setPosition(
                    playerIcon.getXCenterPos() - (experienceIcon.getWidth() / 2),
                    yBottomPos - (experienceIcon.getHeight()),
                    0.0f
            );
        }
        playerLevelGuiText.setPosition(
                experienceIcon.getXCenterPos() - (playerLevelGuiText.getWidth() / 2),
                experienceIcon.getYCenterPos() - (playerLevelGuiText.getHeight() / 2),
                0.0f
        );
        if (show) {
            progressBar.setPosition(
                    experienceIcon.getXRightPos() - 5.0f,
                    experienceIcon.getYCenterPos() - (progressBar.getHeight() / 2),
                    0.0f
            );
            if (playerLevelGuiText.isShow()) {
                experienceGuiText.setPosition(
                        progressBar.getXCenterPos() - (experienceGuiText.getWidth() / 2),
                        experienceIcon.getYCenterPos() - (experienceGuiText.getHeight() / 2),
                        0.0f
                );
            }
        }

    }
}
