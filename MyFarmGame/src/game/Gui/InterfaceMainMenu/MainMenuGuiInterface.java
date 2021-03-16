package game.Gui.InterfaceMainMenu;

import engine.GameItem;
import engine.MouseInput;
import engine.Window;
import engine.graph.Camera;
import game.Assets.AssetManager;
import game.Gui.PopUpPanel;
import game.Gui.GuiInterface;
import game.Gui.Items.GuiContainer;
import game.Gui.InterfaceMainMenu.MainMenuWindow.MainMenuWindow;
import game.MyFarmGame;

import java.util.ArrayList;

import static org.lwjgl.glfw.GLFW.glfwSetWindowShouldClose;

public class MainMenuGuiInterface extends GuiInterface {

    public MainMenuWindow mainMenuWindow;
    public PopUpPanel exitPanel;

    public MainMenuGuiInterface(String statusText, Window window, MyFarmGame myFarmGame) throws Exception {
        super(statusText, window, myFarmGame);
        ArrayList<GameItem> items = new ArrayList<>();

        mainMenuWindow = new MainMenuWindow(window, items);

        exitPanel = new PopUpPanel(window, items);
        exitPanel.setMessage("Do you really want to exit ?");

        gameItems = items.toArray(new GameItem[items.size()]);
        mainMenuWindow.adminButton.setShow(MyFarmGame.isAdminMode());
    }

    public void update(MouseInput mouseInput, Camera camera) {

        if (mainMenuWindow.isShow()) {
            mainMenuWindow.update();
        }
        if (exitPanel.isShow()) {
            exitPanel.update();
        }
    }

    public void updateSize(Window window) {

        if (mainMenuWindow.isShow()) {
            mainMenuWindow.updateSize();
        }
        if (exitPanel.isShow()) {
            exitPanel.updateSize();
        }

    }

    public void input(Window window, MouseInput mouseInput, Camera camera) {
        inputMainMenuWindow(window, mouseInput);
        inputExitPanel(window, mouseInput);
    }

    private void inputMainMenuWindow(Window window, MouseInput mouseInput) {
        if (!mainMenuWindow.isPaused()) {
            if (mainMenuWindow.isShow()) {

                // ====== Admin - World Editor Button ======
                if (mainMenuWindow.adminButton.isShow()) {
                    if (!mainMenuWindow.adminButton.isDisabled()) {
                        if (isHovered(mainMenuWindow.adminButton, mouseInput)) {
                            // === HOVER ===
                            mainMenuWindow.adminButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                mainMenuWindow.adminButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                AssetManager.decorationsData.getDecorationGameItems()[295].setShow(true);
                                AssetManager.decorationsData.getDecorationGameItems()[296].setShow(true);

                                for (int i = 0; i < 16; i++) {
                                    for (int j = 0; j < 10; j++) {
                                        for (int k = 0; k < 2; k++) {
                                            AssetManager.plantsData.getFieldsArray()[i][j][k].setShow(false);
                                        }
                                    }
                                }

                                myFarmGame.setAdminScreen();

                            }
                        } else if (mainMenuWindow.adminButton.entered) {
                            // === NO HOVER ===
                            mainMenuWindow.adminButton.mouseExited();
                        }
                    }
                }

                // ====== Start Menu Button ======
                if (mainMenuWindow.startButton.isShow()) {
                    if (!mainMenuWindow.startButton.isDisabled()) {
                        if (isHovered(mainMenuWindow.startButton, mouseInput)) {
                            // === HOVER ===
                            mainMenuWindow.startButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                mainMenuWindow.startButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                AssetManager.decorationsData.getDecorationGameItems()[295].setShow(true);
                                AssetManager.decorationsData.getDecorationGameItems()[296].setShow(true);

                                for (int i = 0; i < 16; i++) {
                                    for (int j = 0; j < 10; j++) {
                                        for (int k = 0; k < 2; k++) {
                                            AssetManager.plantsData.getFieldsArray()[i][j][k].setShow(false);
                                        }
                                    }
                                }

                                myFarmGame.setGamePlayScreen();

                            }
                        } else if (mainMenuWindow.startButton.entered) {
                            // === NO HOVER ===
                            mainMenuWindow.startButton.mouseExited();
                        }
                    }
                }

                // ====== Options Menu Button ======
                if (mainMenuWindow.optionsButton.isShow()) {
                    if (!mainMenuWindow.optionsButton.isDisabled()) {
                        if (isHovered(mainMenuWindow.optionsButton, mouseInput)) {
                            // === HOVER ===
                            mainMenuWindow.optionsButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                mainMenuWindow.optionsButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);


                            }
                        } else if (mainMenuWindow.optionsButton.entered) {
                            // === NO HOVER ===
                            mainMenuWindow.optionsButton.mouseExited();
                        }
                    }
                }

                // ====== Exit Menu Button ======
                if (mainMenuWindow.exitButton.isShow()) {
                    if (!mainMenuWindow.exitButton.isDisabled()) {
                        if (isHovered(mainMenuWindow.exitButton, mouseInput)) {
                            // === HOVER ===
                            mainMenuWindow.exitButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                mainMenuWindow.exitButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                exitPanel.setShow(true);
                                mainMenuWindow.setPaused(true);
                            }
                        } else if (mainMenuWindow.exitButton.entered) {
                            // === NO HOVER ===
                            mainMenuWindow.exitButton.mouseExited();
                        }
                    }
                }

            }
        }
    }

    private void inputExitPanel(Window window, MouseInput mouseInput) {
        if (!exitPanel.isPaused()) {
            if (exitPanel.isShow()) {

                // ====== Close Button ======
                if (exitPanel.closeButton.isShow()) {
                    if (!exitPanel.closeButton.isDisabled()) {
                        if (isHovered(exitPanel.closeButton, mouseInput)) {
                            // === HOVER ===
                            exitPanel.closeButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                exitPanel.closeButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                exitPanel.setShow(false);
                                mainMenuWindow.setPaused(false);
                            }
                        } else if (exitPanel.closeButton.entered) {
                            // === NO HOVER ===
                            exitPanel.closeButton.mouseExited();
                        }
                    }
                }

                // ====== Yes Button ======
                if (exitPanel.yesButton.isShow()) {
                    if (!exitPanel.yesButton.isDisabled()) {
                        if (isHovered(exitPanel.yesButton, mouseInput)) {
                            // === HOVER ===
                            exitPanel.yesButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                exitPanel.yesButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                glfwSetWindowShouldClose(window.getWindowHandle(), true);
                            }
                        } else if (exitPanel.yesButton.entered) {
                            // === NO HOVER ===
                            exitPanel.yesButton.mouseExited();
                        }
                    }
                }

                // ====== No Button ======
                if (exitPanel.noButton.isShow()) {
                    if (!exitPanel.noButton.isDisabled()) {
                        if (isHovered(exitPanel.noButton, mouseInput)) {
                            // === HOVER ===
                            exitPanel.noButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                exitPanel.noButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                exitPanel.setShow(false);
                                mainMenuWindow.setPaused(false);
                            }
                        } else if (exitPanel.noButton.entered) {
                            // === NO HOVER ===
                            exitPanel.noButton.mouseExited();
                        }
                    }
                }

            }
        }
    }

    @Override
    public void cleanUp() {
        GameItem[] gameItems = getGameItems();
        for (GameItem gameItem : gameItems) {
            gameItem.getMesh().cleanUp();
        }
    }

}
