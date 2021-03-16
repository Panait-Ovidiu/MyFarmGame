package game.Gui.InterfaceGamePlay;

import java.util.ArrayList;

import engine.*;
import game.Assets.AssetManager;
import game.Assets.GuiData.Fonts;
import engine.graph.*;
import game.Data.Planted;
import game.Data.PlayerData;
import game.Gui.InterfaceGamePlay.AnimalMenuWindow.AnimalMenuWindow;
import game.Gui.InterfaceGamePlay.MainButtonsPanel.MainButtonsPanel;
import game.Gui.InterfaceGamePlay.MarketMenuWindow.MarketMenuWindow;
import game.Gui.InterfaceGamePlay.PlayerDisplayPanel.PlayerDisplayPanel;
import game.Gui.InterfaceGamePlay.SettingsWindow.SettingsWindow;
import game.Gui.InterfaceGamePlay.TreeMenuWindow.TreeMenuWindow;
import game.Gui.InterfaceGamePlay.UpgradeMenuWindow.UpgradeMenuWindow;
import game.Gui.GuiInterface;
import game.MyFarmGame;
import game.Gui.Items.GuiButton;
import game.Gui.InterfaceGamePlay.PlantWindow.FieldDetailPage.FieldDetailPage;
import game.Gui.InterfaceGamePlay.PlantWindow.FieldDetailPage.PlantListButtonPanel;
import game.Gui.InterfaceGamePlay.PlantWindow.FieldDetailPage.PlantListButton;
import game.Gui.InterfaceGamePlay.PlantWindow.FieldListPage.FieldListItem;
import game.Gui.InterfaceGamePlay.PlantWindow.FieldListPage.FieldListPage;
import game.Gui.InterfaceGamePlay.PlantWindow.FieldListPage.FieldListItemPanel;
import game.Gui.InterfaceGamePlay.PlantWindow.PlantMenuWindow;
import game.Gui.Temp.TempItems;
import org.joml.Vector3f;

public class GamePlayGuiInterface extends GuiInterface {

    private Fonts fonts;
    public PlayerData playerData;

    private Vector3f cameraPositionTemp;
    private Vector3f cameraRotationTemp;

    public boolean updateSizeOnce = false;

    public PlayerDisplayPanel playerDisplayPanel;
    public MainButtonsPanel mainButtonsPanel;

    public PlantMenuWindow plantMenuWindow;
    public AnimalMenuWindow animalMenuWindow;
    public TreeMenuWindow treeMenuWindow;
    public UpgradeMenuWindow upgradeMenuWindow;
    public MarketMenuWindow marketMenuWindow;

    public SettingsWindow settingsWindow;

    public TempItems tempItems;
    //========================

    public GamePlayGuiInterface(String statusText, Window window, MyFarmGame myFarmGame) throws Exception {
        super(statusText, window, myFarmGame);
        ArrayList<GameItem> items = new ArrayList<>();
        fonts = new Fonts();

        playerData = new PlayerData();
        playerData = PlayerData.loadPlayerData(playerData);

        playerDisplayPanel = new PlayerDisplayPanel(window, playerData, items);

        mainButtonsPanel = new MainButtonsPanel(window, items);

        plantMenuWindow = new PlantMenuWindow(window, mainButtonsPanel, playerData, items);

        animalMenuWindow = new AnimalMenuWindow(window, mainButtonsPanel, playerData, items);

        treeMenuWindow = new TreeMenuWindow(window, mainButtonsPanel, playerData, items);

        upgradeMenuWindow = new UpgradeMenuWindow(window, mainButtonsPanel, playerData, items);

        marketMenuWindow = new MarketMenuWindow(window, mainButtonsPanel, playerData, items);

        settingsWindow = new SettingsWindow(window, items);

        // === Temp items ===
        tempItems = new TempItems(window, fonts, statusText);
        items.addAll(tempItems.getItems());
        if(!myFarmGame.isAdminMode()){
            tempItems.show(false);
        }
        tempItems.show(false);

        //========================

        // Create list that holds the items that compose the HUD

        gameItems = items.toArray(new GameItem[items.size()]);
    }

    @Override
    public void update(MouseInput mouseInput, Camera camera) {
        playerData.update();

        playerDisplayPanel.update();
        mainButtonsPanel.update();

        if (plantMenuWindow.isShow()) {
            plantMenuWindow.update();
        }
        if (animalMenuWindow.isShow()) {
            animalMenuWindow.update();
        }
        if (treeMenuWindow.isShow()) {
            treeMenuWindow.update();
        }
        if (upgradeMenuWindow.isShow()) {
            upgradeMenuWindow.update();
        }
        if (marketMenuWindow.isShow()) {
            marketMenuWindow.update();
        }

        if (settingsWindow.isShow()) {
            settingsWindow.update();
        }

        // TODO: add InterfaceGamePlay.update() once

        // === Temp items ===
        tempItems.update(camera);
        //========================

    }

    @Override
    public void updateSize(Window window) {

        playerDisplayPanel.updateSize();
        mainButtonsPanel.updateSize();

        if (plantMenuWindow.isShow()) {
            plantMenuWindow.updateSize();
        }
        if (animalMenuWindow.isShow()) {
            animalMenuWindow.updateSize();
        }
        if (treeMenuWindow.isShow()) {
            treeMenuWindow.updateSize();
        }
        if (upgradeMenuWindow.isShow()) {
            upgradeMenuWindow.updateSize();
        }
        if (marketMenuWindow.isShow()) {
            marketMenuWindow.updateSize();
        }

        if (settingsWindow.isShow()) {
            settingsWindow.updateSize();
        }

        // === Temp items ===
        tempItems.updateSize(window);
        //========================

        if (!updateSizeOnce) {
            updateSizeOnce = true;
            // TODO: add InterfaceGamePlay.updateSize()
            System.out.println("Done Loading");
        }
    }

    @Override
    public void input(Window window, MouseInput mouseInput, Camera camera) {

        // TODO: add updateSizeOnce and updateOnce
        if (updateSizeOnce) {

            inputPlayerDisplayPanel(window, mouseInput);
            inputMainButtonsPanel(window, mouseInput, camera);

            inputPlantMenuWindow(window, mouseInput, camera);
            inputAnimalMenuWindow(window, mouseInput, camera);
            inputTreeMenuWindow(window, mouseInput, camera);
            inputUpgradeMenuWindow(window, mouseInput);
            inputMarketMenuWindow(window, mouseInput);
            inputSettingsWindow(window, mouseInput);

        }
    }

    private void inputPlayerDisplayPanel(Window window, MouseInput mouseInput) {

        // ====== Player Icon Button ======
        if (playerDisplayPanel.playerIcon.isShow()) {
            if (!playerDisplayPanel.playerIcon.isDisabled()) {
                if (isHovered(playerDisplayPanel.playerIcon, mouseInput)) {
                    // === HOVER ===
                    playerDisplayPanel.playerIcon.mouseEntered();

                    if (mouseInput.isLeftButtonPressed()) {
                        // === CLICKED ===
                        playerDisplayPanel.playerIcon.mouseClicked();
                        mouseInput.setLeftButtonPressed(false);

                        playerDisplayPanel.setShow(!playerDisplayPanel.isShow());

                    }
                } else if (playerDisplayPanel.playerIcon.entered) {
                    // === NO HOVER ===
                    playerDisplayPanel.playerIcon.mouseExited();
                }
            }
        }

        if (playerDisplayPanel.isShow()) {

            // ====== Progress Bar ======
            // TODO: Add isShow and isDisabled if's
            if (isHovered(playerDisplayPanel.progressBar, mouseInput)) {
                // === HOVER ===
                playerDisplayPanel.experienceGuiText.setShow(true);
            } else {
                // === NO HOVER ===
                playerDisplayPanel.experienceGuiText.setShow(false);
            }

        }

    }

    private void inputMainButtonsPanel(Window window, MouseInput mouseInput, Camera camera) {
        if (!mainButtonsPanel.isPaused()) {
            if (mainButtonsPanel.isShow()) {

                // ====== Plants Menu Button ======
                if (mainButtonsPanel.plantsMenuButton.isShow()) {
                    if (!mainButtonsPanel.plantsMenuButton.isDisabled()) {
                        if (isHovered(mainButtonsPanel.plantsMenuButton, mouseInput)) {
                            // === HOVER ===
                            mainButtonsPanel.plantsMenuButton.mouseEntered();
                            mainButtonsPanel.plantsMenuGuiText.setShow(true);

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                mainButtonsPanel.plantsMenuButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                plantMenuWindow.setShow(!plantMenuWindow.isShow());
                                mainButtonsPanel.disableButtons(false, plantMenuWindow.isShow(),
                                        plantMenuWindow.isShow(), plantMenuWindow.isShow(), plantMenuWindow.isShow());

                                plantMenuWindow.fieldDetailPage.plantListButtonPanel.setSelectedButton(
                                        plantMenuWindow.fieldDetailPage.plantListButtonPanel.NO_BUTTON_SELECTED);

                                if (plantMenuWindow.isShow()) {
                                    mainButtonsPanel.plantsMenuButton.setSelected(true);
                                    plantMenuWindow.setFieldListPage();
                                    cameraPositionTemp = new Vector3f(camera.getPosition().x, camera.getPosition().y, camera.getPosition().z);
                                    cameraRotationTemp = new Vector3f(camera.getRotation().x, camera.getRotation().y, camera.getRotation().z);

                                    camera.setPosition(93.0f, 25.0f, -25.0f);
                                    camera.setRotation(44.0f, -90.0f, 0.0f);

                                } else {
                                    mainButtonsPanel.plantsMenuButton.setSelected(false);
                                    camera.setPosition(cameraPositionTemp.x, cameraPositionTemp.y, cameraPositionTemp.z);
                                    camera.setRotation(cameraRotationTemp.x, cameraRotationTemp.y, cameraRotationTemp.z);
                                }
                            }
                        } else if (mainButtonsPanel.plantsMenuButton.entered) {
                            // === NO HOVER ===
                            mainButtonsPanel.plantsMenuButton.mouseExited();
                            mainButtonsPanel.plantsMenuGuiText.setShow(false);
                        }
                    }
                }

                // ====== Animals Menu Button ======
                if (!mainButtonsPanel.animalsMenuButton.isDisabled()) {
                    if (isHovered(mainButtonsPanel.animalsMenuButton, mouseInput)) {
                        // === HOVER ===
                        mainButtonsPanel.animalsMenuButton.mouseEntered();
                        mainButtonsPanel.animalsMenuGuiText.setShow(true);

                        if (mouseInput.isLeftButtonPressed()) {
                            // === CLICKED ===
                            mainButtonsPanel.animalsMenuButton.mouseClicked();
                            mouseInput.setLeftButtonPressed(false);

                            animalMenuWindow.setShow(!animalMenuWindow.isShow());
                            mainButtonsPanel.disableButtons(animalMenuWindow.isShow(), false,
                                    animalMenuWindow.isShow(), animalMenuWindow.isShow(), animalMenuWindow.isShow());

                            if (animalMenuWindow.isShow()) {
                                mainButtonsPanel.animalsMenuButton.setSelected(true);
                                cameraPositionTemp = new Vector3f(camera.getPosition().x, camera.getPosition().y, camera.getPosition().z);
                                cameraRotationTemp = new Vector3f(camera.getRotation().x, camera.getRotation().y, camera.getRotation().z);

                                camera.setPosition(-130.0f, 75.0f, 262.0f);
                                camera.setRotation(34.0f, 0.0f, 0.0f);
                            } else {
                                mainButtonsPanel.animalsMenuButton.setSelected(false);
                                camera.setPosition(cameraPositionTemp.x, cameraPositionTemp.y, cameraPositionTemp.z);
                                camera.setRotation(cameraRotationTemp.x, cameraRotationTemp.y, cameraRotationTemp.z);
                            }
                        }
                    } else if (mainButtonsPanel.animalsMenuButton.entered) {
                        // === NO HOVER ===
                        mainButtonsPanel.animalsMenuButton.mouseExited();
                        mainButtonsPanel.animalsMenuGuiText.setShow(false);
                    }
                }

                // ====== Trees Menu Button ======
                if (mainButtonsPanel.treesMenuButton.isShow()) {
                    if (!mainButtonsPanel.treesMenuButton.isDisabled()) {
                        if (isHovered(mainButtonsPanel.treesMenuButton, mouseInput)) {
                            // === HOVER ===
                            mainButtonsPanel.treesMenuButton.mouseEntered();
                            mainButtonsPanel.treesMenuGuiText.setShow(true);

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                mainButtonsPanel.treesMenuButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                treeMenuWindow.setShow(!treeMenuWindow.isShow());
                                mainButtonsPanel.disableButtons(treeMenuWindow.isShow(), treeMenuWindow.isShow(),
                                        false, treeMenuWindow.isShow(), treeMenuWindow.isShow());

                                if (treeMenuWindow.isShow()) {
                                    mainButtonsPanel.treesMenuButton.setSelected(true);
                                    cameraPositionTemp = new Vector3f(camera.getPosition().x, camera.getPosition().y, camera.getPosition().z);
                                    cameraRotationTemp = new Vector3f(camera.getRotation().x, camera.getRotation().y, camera.getRotation().z);

                                    camera.setPosition(110.0f, 105.0f, -327.0f);
                                    camera.setRotation(34.0f, 180.0f, 0.0f);
                                } else {
                                    mainButtonsPanel.treesMenuButton.setSelected(false);
                                    camera.setPosition(cameraPositionTemp.x, cameraPositionTemp.y, cameraPositionTemp.z);
                                    camera.setRotation(cameraRotationTemp.x, cameraRotationTemp.y, cameraRotationTemp.z);
                                }
                            }
                        } else if (mainButtonsPanel.treesMenuButton.entered) {
                            // === NO HOVER ===
                            mainButtonsPanel.treesMenuButton.mouseExited();
                            mainButtonsPanel.treesMenuGuiText.setShow(false);
                        }
                    }
                }

                // ====== Upgrades Menu Button ======
                if (mainButtonsPanel.upgradesMenuButton.isShow()) {
                    if (!mainButtonsPanel.upgradesMenuButton.isDisabled()) {
                        if (isHovered(mainButtonsPanel.upgradesMenuButton, mouseInput)) {
                            // === HOVER ===
                            mainButtonsPanel.upgradesMenuButton.mouseEntered();
                            mainButtonsPanel.upgradesMenuGuiText.setShow(true);

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                mainButtonsPanel.upgradesMenuButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                upgradeMenuWindow.setShow(!upgradeMenuWindow.isShow());
                                mainButtonsPanel.disableButtons(upgradeMenuWindow.isShow(), upgradeMenuWindow.isShow(),
                                        upgradeMenuWindow.isShow(), false, upgradeMenuWindow.isShow());

                                if (upgradeMenuWindow.isShow()) {
                                    mainButtonsPanel.upgradesMenuButton.setSelected(true);

                                } else {
                                    mainButtonsPanel.upgradesMenuButton.setSelected(false);
                                }
                            }
                        } else if (mainButtonsPanel.upgradesMenuButton.entered) {
                            // === NO HOVER ===
                            mainButtonsPanel.upgradesMenuButton.mouseExited();
                            mainButtonsPanel.upgradesMenuGuiText.setShow(false);
                        }
                    }
                }

                // ====== Market Menu Button ======
                if (mainButtonsPanel.marketMenuButton.isShow()) {
                    if (!mainButtonsPanel.marketMenuButton.isDisabled()) {
                        if (isHovered(mainButtonsPanel.marketMenuButton, mouseInput)) {
                            // === HOVER ===
                            mainButtonsPanel.marketMenuButton.mouseEntered();
                            mainButtonsPanel.marketMenuGuiText.setShow(true);

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                mainButtonsPanel.marketMenuButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                marketMenuWindow.setShow(!marketMenuWindow.isShow());
                                mainButtonsPanel.disableButtons(marketMenuWindow.isShow(), marketMenuWindow.isShow(),
                                        marketMenuWindow.isShow(), marketMenuWindow.isShow(), false);

                                if (marketMenuWindow.isShow()) {
                                    mainButtonsPanel.marketMenuButton.setSelected(true);

                                } else {
                                    mainButtonsPanel.marketMenuButton.setSelected(false);
                                }
                            }
                        } else if (mainButtonsPanel.marketMenuButton.entered) {
                            // === NO HOVER ===
                            mainButtonsPanel.marketMenuButton.mouseExited();
                            mainButtonsPanel.marketMenuGuiText.setShow(false);
                        }
                    }
                }

            }
        }

        // ====== Settings Menu Button ======
        if (mainButtonsPanel.settingsMenuButton.isShow()) {
            if (!mainButtonsPanel.settingsMenuButton.isDisabled()) {
                if (isHovered(mainButtonsPanel.settingsMenuButton, mouseInput)) {
                    // === HOVER ===
                    mainButtonsPanel.settingsMenuButton.mouseEntered();

                    if (mouseInput.isLeftButtonPressed()) {
                        // === CLICKED ===
                        mainButtonsPanel.settingsMenuButton.mouseClicked();
                        mouseInput.setLeftButtonPressed(false);

                        settingsWindow.setShow(!settingsWindow.isShow());
                        myFarmGame.setMainMenuScreen();

                        // TODO: //Add pause for player display
                        mainButtonsPanel.setPaused(!mainButtonsPanel.isPaused());
                        plantMenuWindow.setPaused(!plantMenuWindow.isPaused());
                        animalMenuWindow.setPaused(!animalMenuWindow.isPaused());
                        treeMenuWindow.setPaused(!treeMenuWindow.isPaused());
                        upgradeMenuWindow.setPaused(!upgradeMenuWindow.isPaused());
                        marketMenuWindow.setPaused(!upgradeMenuWindow.isPaused());
                    }
                } else if (mainButtonsPanel.settingsMenuButton.entered) {
                    // === NO HOVER ===
                    mainButtonsPanel.settingsMenuButton.mouseExited();
                }
            }
        }

    }

    private void inputPlantMenuWindow(Window window, MouseInput mouseInput, Camera camera) {
        if (!plantMenuWindow.isPaused()) {
            if (plantMenuWindow.isShow()) {

                // ====== Close Button ======
                if (plantMenuWindow.closeButton.isShow()) {
                    if (!plantMenuWindow.closeButton.isDisabled()) {
                        if (isHovered(plantMenuWindow.closeButton, mouseInput)) {
                            // === HOVER ===
                            plantMenuWindow.closeButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                plantMenuWindow.closeButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                plantMenuWindow.setShow(false);
                                mainButtonsPanel.plantsMenuButton.setSelected(false);
                                mainButtonsPanel.plantsMenuButton.mouseExited();
                                mainButtonsPanel.disableButtons(false, false, false, false, false);

                                plantMenuWindow.fieldDetailPage.plantListButtonPanel.setSelectedButton(
                                        plantMenuWindow.fieldDetailPage.plantListButtonPanel.NO_BUTTON_SELECTED);

                                camera.setPosition(cameraPositionTemp.x, cameraPositionTemp.y, cameraPositionTemp.z);
                                camera.setRotation(cameraRotationTemp.x, cameraRotationTemp.y, cameraRotationTemp.z);
                            }
                        } else if (plantMenuWindow.closeButton.entered) {
                            // === NO HOVER ===
                            plantMenuWindow.closeButton.mouseExited();
                        }
                    }
                }

                // ====== Page Field List Selected ======
                if (plantMenuWindow.isPage(PlantMenuWindow.PAGE_FIELD_LIST)) {
                    FieldListPage fieldListPage = plantMenuWindow.fieldListPage;
                    FieldListItemPanel fieldListPanel = plantMenuWindow.fieldListPage.fieldListItemPanel;

                    if (fieldListPanel.isPage(FieldListItemPanel.PAGE_ONE) ||
                            fieldListPanel.isPage(FieldListItemPanel.PAGE_TWO)) {

                        // ====== Previous Page Button ======
                        if (fieldListPage.previousButton.isShow()) {
                            if (!fieldListPage.previousButton.isDisabled()) {
                                if (isHovered(fieldListPage.previousButton, mouseInput)) {
                                    // === HOVER ===
                                    fieldListPage.previousButton.mouseEntered();

                                    if (mouseInput.isLeftButtonPressed()) {
                                        // === CLICKED ===
                                        fieldListPage.previousButton.mouseClicked();
                                        mouseInput.setLeftButtonPressed(false);

                                        fieldListPage.fieldListItemPanel.setPageOne();
                                        fieldListPage.previousButton.setDisabled(true);
                                        fieldListPage.nextButton.setDisabled(false);
                                        fieldListPage.pageNumberGuiText.setText("Page 1");

                                    }
                                } else if (fieldListPage.previousButton.entered) {
                                    // === NO HOVER ===
                                    fieldListPage.previousButton.mouseExited();
                                }
                            }
                        }

                        // ====== Next Page Button ======
                        if (fieldListPage.nextButton.isShow()) {
                            if (!fieldListPage.nextButton.isDisabled()) {
                                if (isHovered(fieldListPage.nextButton, mouseInput)) {
                                    // === HOVER ===
                                    fieldListPage.nextButton.mouseEntered();

                                    if (mouseInput.isLeftButtonPressed()) {
                                        // === CLICKED ===
                                        fieldListPage.nextButton.mouseClicked();
                                        mouseInput.setLeftButtonPressed(false);

                                        fieldListPage.fieldListItemPanel.setPageTwo();
                                        fieldListPage.previousButton.setDisabled(false);
                                        fieldListPage.nextButton.setDisabled(true);
                                        fieldListPage.pageNumberGuiText.setText("Page 1");

                                    }
                                } else if (fieldListPage.nextButton.entered) {
                                    // === NO HOVER ===
                                    fieldListPage.nextButton.mouseExited();
                                }
                            }
                        }

                        // ====== Field List Panel ======
                        if (fieldListPanel.isShow()) {
                            FieldListItem[] pageItems = new FieldListItem[0];
                            int size = pageItems.length;

                            if (fieldListPanel.isPage(FieldListItemPanel.PAGE_ONE)) {
                                size = fieldListPanel.fieldListItemPageOne.length;
                                pageItems = fieldListPanel.fieldListItemPageOne;

                            } else if (fieldListPanel.isPage(FieldListItemPanel.PAGE_TWO)) {
                                size = fieldListPanel.fieldListItemPageTwo.length;
                                pageItems = fieldListPanel.fieldListItemPageTwo;
                            }

                            // ====== Field List Items Buttons ======
                            for (int i = 0; i < size; i++) {
                                FieldListItem listItem = pageItems[i];

                                if (listItem.isPage(FieldListItem.PAGE_UNLOCKED) ||
                                        listItem.isPage(FieldListItem.PAGE_UNLOCKED_CROP_EMPTY) ||
                                        listItem.isPage(FieldListItem.PAGE_UNLOCKED_CROP_COMPLETED)) {

                                    // ====== Field Item GoTo Button ======
                                    if (listItem.goToButton.isShow()) {
                                        if (!listItem.goToButton.isDisabled()) {
                                            if (isHovered(listItem.goToButton, mouseInput)) {
                                                // === HOVER ===
                                                listItem.goToButton.mouseEntered();

                                                if (fieldListPanel.isPage(FieldListItemPanel.PAGE_ONE)) {
                                                    if (i < (size / 2)) {
                                                        camera.setPosition(52.0f + (i * 10), 6.0f, -23.0f);
                                                        camera.setRotation(39.0f, -88.0f, 0.0f);
                                                    } else {
                                                        camera.setPosition(
                                                                52.0f + ((i % (size / 2.0f)) * 10), 6.0f, -33.0f);
                                                        camera.setRotation(39.0f, -88.0f, 0.0f);
                                                    }
                                                } else if (fieldListPanel.isPage(FieldListItemPanel.PAGE_TWO)) {
                                                    if (i < (size / 2)) {
                                                        camera.setPosition(52.0f + (i * 10), 6.0f, -47.0f);
                                                        camera.setRotation(39.0f, -88.0f, 0.0f);
                                                    } else {
                                                        camera.setPosition(
                                                                52.0f + ((i % (size / 2.0f)) * 10), 6.0f, -57.0f);
                                                        camera.setRotation(39.0f, -88.0f, 0.0f);
                                                    }
                                                }

                                                if (mouseInput.isLeftButtonPressed()) {
                                                    // === CLICKED ===
                                                    listItem.goToButton.mouseClicked();
                                                    mouseInput.setLeftButtonPressed(false);

                                                    // === Set Camera To Field Position ===
                                                    if (fieldListPanel.isPage(FieldListItemPanel.PAGE_ONE)) {
                                                        plantMenuWindow.setPageFieldDetail(i);
                                                    } else if (fieldListPanel.isPage(FieldListItemPanel.PAGE_TWO)) {
                                                        plantMenuWindow.setPageFieldDetail((i + fieldListPanel.fieldListItemPageOne.length));
                                                    }

                                                }
                                            } else if (listItem.goToButton.entered) {
                                                // === NO HOVER ===
                                                listItem.goToButton.mouseExited();
                                                camera.setPosition(93.0f, 25.0f, -25.0f);
                                                camera.setRotation(44.0f, -90.0f, 0.0f);
                                            }
                                        }
                                    }

                                } else if (listItem.isPage(FieldListItem.PAGE_LOCKED)) {

                                    // ====== Field Item Buy Button ======
                                    if (listItem.buyButton.isShow()) {
                                        if (!listItem.buyButton.isDisabled()) {
                                            if (isHovered(listItem.buyButton, mouseInput)) {
                                                // === HOVER ===
                                                listItem.buyButton.mouseEntered();

                                                // === Set Camera To Field Position ===
                                                if (fieldListPanel.isPage(FieldListItemPanel.PAGE_ONE)) {
                                                    if (i < (size / 2)) {
                                                        camera.setPosition(52.0f + (i * 10), 6.0f, -23.0f);
                                                        camera.setRotation(39.0f, -88.0f, 0.0f);
                                                    } else {
                                                        camera.setPosition(
                                                                52.0f + ((i % (size / 2.0f)) * 10), 6.0f, -33.0f);
                                                        camera.setRotation(39.0f, -88.0f, 0.0f);
                                                    }

                                                } else if (fieldListPanel.isPage(FieldListItemPanel.PAGE_TWO)) {
                                                    if (i < (size / 2)) {
                                                        camera.setPosition(52.0f + (i * 10), 6.0f, -47.0f);
                                                        camera.setRotation(39.0f, -88.0f, 0.0f);
                                                    } else {
                                                        camera.setPosition(
                                                                52.0f + ((i % (size / 2.0f)) * 10), 6.0f, -57.0f);
                                                        camera.setRotation(39.0f, -88.0f, 0.0f);
                                                    }
                                                }

                                                if (mouseInput.isLeftButtonPressed()) {
                                                    // === CLICKED ===
                                                    listItem.buyButton.mouseClicked();
                                                    mouseInput.setLeftButtonPressed(false);

                                                    // TODO: Add Buy Field Method
                                                    if (fieldListPanel.isPage(FieldListItemPanel.PAGE_ONE)) {
                                                        playerData.getFieldData(i).unlocked();
                                                        System.out.println("Buy Crop Field " + (i + 1));

                                                    } else if (fieldListPanel.isPage(FieldListItemPanel.PAGE_TWO)) {
                                                        playerData.getFieldData(i + size).unlocked();
                                                        System.out.println("Buy Crop Field " + ((i + 1) + size));
                                                    }

                                                }
                                            } else if (listItem.buyButton.entered) {
                                                // === NO HOVER ===
                                                listItem.buyButton.mouseExited();
                                                camera.setPosition(93.0f, 25.0f, -25.0f);
                                                camera.setRotation(44.0f, -90.0f, 0.0f);
                                            }
                                        }
                                    }

                                }
                            }
                        }

                    }
                }

                // ====== Page Field Detail Selected ======
                if (plantMenuWindow.isPage(PlantMenuWindow.PAGE_FIELD_DETAIL)) {
                    FieldDetailPage fieldDetailPage = plantMenuWindow.fieldDetailPage;

                    if (fieldDetailPage.isPage(FieldDetailPage.PAGE_FIELD_DETAIL) ||
                            fieldDetailPage.isPage(FieldDetailPage.PAGE_FIELD_DETAIL_PLANT) ||
                            fieldDetailPage.isPage(FieldDetailPage.PAGE_FIELD_DETAIL_HARVEST)) {

                        // ====== Back To List Button ======
                        if (fieldDetailPage.backToListButton.isShow()) {
                            if (!fieldDetailPage.backToListButton.isDisabled()) {
                                if (isHovered(fieldDetailPage.backToListButton, mouseInput)) {
                                    // === HOVER ===
                                    fieldDetailPage.backToListButton.mouseEntered();

                                    if (mouseInput.isLeftButtonPressed()) {
                                        // === CLICKED ===
                                        fieldDetailPage.backToListButton.mouseClicked();
                                        mouseInput.setLeftButtonPressed(false);

                                        plantMenuWindow.fieldDetailPage.plantListButtonPanel.setSelectedButton(
                                                plantMenuWindow.fieldDetailPage.plantListButtonPanel.NO_BUTTON_SELECTED);

                                        if (plantMenuWindow.getSelectedFieldNumber() >= 0 && plantMenuWindow.getSelectedFieldNumber() < 8) {
                                            plantMenuWindow.setFieldListPage();
                                            plantMenuWindow.fieldListPage.fieldListItemPanel.setPageOne();
                                        } else if (plantMenuWindow.getSelectedFieldNumber() >= 8 && plantMenuWindow.getSelectedFieldNumber() < 16) {
                                            plantMenuWindow.setFieldListPage();
                                            plantMenuWindow.fieldListPage.fieldListItemPanel.setPageTwo();
                                        }
                                        camera.setPosition(93.0f, 25.0f, -25.0f);
                                        camera.setRotation(44.0f, -90.0f, 0.0f);

                                    }
                                } else if (fieldDetailPage.backToListButton.entered) {
                                    // === NO HOVER ===
                                    fieldDetailPage.backToListButton.mouseExited();
                                }
                            }
                        }

                    }

                    if (fieldDetailPage.isPage(FieldDetailPage.PAGE_FIELD_DETAIL_PLANT)) {
                        PlantListButtonPanel plantListButtonPanel = plantMenuWindow.fieldDetailPage.plantListButtonPanel;

                        // Add Plant Select Buttons
                        if (plantListButtonPanel.isShow()) {
                            PlantListButton[] plantButtonList = plantListButtonPanel.plantListItems;

                            for (int i = 0; i < plantButtonList.length; i++) {
                                GuiButton plantButton = plantButtonList[i].selectPlantButton;
                                if (plantButton.isShow()) {
                                    if (!plantButton.isDisabled()) {
                                        if (isHovered(plantButton, mouseInput)) {
                                            // === HOVER ===
                                            plantButton.mouseEntered();
                                            plantButtonList[i].setButtonPanelShow(true);

                                            if (mouseInput.isLeftButtonPressed()) {
                                                // === CLICKED ===
                                                plantButton.mouseClicked();
                                                mouseInput.setLeftButtonPressed(false);

                                                plantListButtonPanel.setSelectedButton(i);
                                                System.out.println(plantListButtonPanel.getSelectedButton());

                                                AssetManager.plantsData.setPlantShow(plantMenuWindow.getSelectedFieldNumber(), plantListButtonPanel.getSelectedButton());

                                                // TODO: Add plant button select/deselect
                                            }
                                        } else if (plantButton.entered) {
                                            // === NO HOVER ===
                                            plantButton.mouseExited();
                                            plantButtonList[i].setButtonPanelShow(false);
                                        }
                                    }
                                }

                            }

                        }

                        // ====== Plant Button ======
                        if (fieldDetailPage.plantButton.isShow()) {
                            if (!fieldDetailPage.plantButton.isDisabled()) {
                                if (isHovered(fieldDetailPage.plantButton, mouseInput)) {
                                    // === HOVER ===
                                    fieldDetailPage.plantButton.mouseEntered();

                                    if (mouseInput.isLeftButtonPressed()) {
                                        // === CLICKED ===
                                        fieldDetailPage.plantButton.mouseClicked();
                                        mouseInput.setLeftButtonPressed(false);

                                        // TODO: Add Plant Button actions
                                        System.out.println(plantListButtonPanel.getSelectedButton());
                                        Planted plant = Planted.getPlanted((plantListButtonPanel.getSelectedButton()));
                                        System.out.println(plant.getPlantName() + "");

                                        playerData.setFieldData(plantMenuWindow.getSelectedFieldNumber(), true, plant);

                                        System.out.println(plantMenuWindow.getSelectedFieldNumber());

                                    }
                                } else if (fieldDetailPage.plantButton.entered) {
                                    // === NO HOVER ===
                                    fieldDetailPage.plantButton.mouseExited();
                                }
                            }
                        }

                    }

                    if (fieldDetailPage.isPage(FieldDetailPage.PAGE_FIELD_DETAIL_HARVEST)) {

                        // ====== Harvest Button ======
                        if (fieldDetailPage.harvestButton.isShow()) {
                            if (!fieldDetailPage.harvestButton.isDisabled()) {
                                if (isHovered(fieldDetailPage.harvestButton, mouseInput)) {
                                    // === HOVER ===
                                    fieldDetailPage.harvestButton.mouseEntered();

                                    if (mouseInput.isLeftButtonPressed()) {
                                        // === CLICKED ===
                                        fieldDetailPage.harvestButton.mouseClicked();
                                        mouseInput.setLeftButtonPressed(false);

                                        // TODO: Add Harvest Button actions
                                        playerData.setFieldData(plantMenuWindow.getSelectedFieldNumber(), true, Planted.EMPTY);


                                    }
                                } else if (fieldDetailPage.harvestButton.entered) {
                                    // === NO HOVER ===
                                    fieldDetailPage.harvestButton.mouseExited();
                                }
                            }
                        }

                    }

                }
            }
        }
    }

    private void inputAnimalMenuWindow(Window window, MouseInput mouseInput, Camera camera) {
        if (!animalMenuWindow.isPaused()) {
            if (animalMenuWindow.isShow()) {

                // ====== Close Button ======
                if (animalMenuWindow.closeButton.isShow()) {
                    if (!animalMenuWindow.closeButton.isDisabled()) {
                        if (isHovered(animalMenuWindow.closeButton, mouseInput)) {
                            // === HOVER ===
                            animalMenuWindow.closeButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                animalMenuWindow.closeButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                animalMenuWindow.setShow(false);

                                mainButtonsPanel.animalsMenuButton.setSelected(false);
                                mainButtonsPanel.animalsMenuButton.mouseExited();
                                mainButtonsPanel.disableButtons(false, false, false, false, false);

                                camera.setPosition(cameraPositionTemp.x, cameraPositionTemp.y, cameraPositionTemp.z);
                                camera.setRotation(cameraRotationTemp.x, cameraRotationTemp.y, cameraRotationTemp.z);
                            }
                        } else if (animalMenuWindow.closeButton.entered) {
                            // === NO HOVER ===
                            animalMenuWindow.closeButton.mouseExited();
                        }
                    }
                }

            }
        }
    }

    private void inputTreeMenuWindow(Window window, MouseInput mouseInput, Camera camera) {
        if (!treeMenuWindow.isPaused()) {
            if (treeMenuWindow.isShow()) {

                // ====== Close Button ======
                if (treeMenuWindow.closeButton.isShow()) {
                    if (!treeMenuWindow.closeButton.isDisabled()) {
                        if (isHovered(treeMenuWindow.closeButton, mouseInput)) {
                            // === HOVER ===
                            treeMenuWindow.closeButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                treeMenuWindow.closeButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                treeMenuWindow.setShow(false);

                                mainButtonsPanel.treesMenuButton.setSelected(false);
                                mainButtonsPanel.treesMenuButton.mouseExited();
                                mainButtonsPanel.disableButtons(false, false, false, false, false);

                                camera.setPosition(cameraPositionTemp.x, cameraPositionTemp.y, cameraPositionTemp.z);
                                camera.setRotation(cameraRotationTemp.x, cameraRotationTemp.y, cameraRotationTemp.z);
                            }
                        } else if (treeMenuWindow.closeButton.entered) {
                            // === NO HOVER ===
                            treeMenuWindow.closeButton.mouseExited();
                        }
                    }
                }

            }
        }
    }

    private void inputUpgradeMenuWindow(Window window, MouseInput mouseInput) {
        if (!upgradeMenuWindow.isPaused()) {
            if (upgradeMenuWindow.isShow()) {

                // ====== Close Button ======
                if (upgradeMenuWindow.closeButton.isShow()) {
                    if (!upgradeMenuWindow.closeButton.isDisabled()) {
                        if (isHovered(upgradeMenuWindow.closeButton, mouseInput)) {
                            // === HOVER ===
                            upgradeMenuWindow.closeButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                upgradeMenuWindow.closeButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                upgradeMenuWindow.setShow(false);

                                mainButtonsPanel.upgradesMenuButton.setSelected(false);
                                mainButtonsPanel.upgradesMenuButton.mouseExited();
                                mainButtonsPanel.disableButtons(false, false, false, false, false);
                            }
                        } else if (upgradeMenuWindow.closeButton.entered) {
                            // === NO HOVER ===
                            upgradeMenuWindow.closeButton.mouseExited();
                        }
                    }
                }

            }
        }
    }

    private void inputMarketMenuWindow(Window window, MouseInput mouseInput) {
        if (!marketMenuWindow.isPaused()) {
            if (marketMenuWindow.isShow()) {

                // ====== Close Button ======
                if (marketMenuWindow.closeButton.isShow()) {
                    if (!marketMenuWindow.closeButton.isDisabled()) {
                        if (isHovered(marketMenuWindow.closeButton, mouseInput)) {
                            // === HOVER ===
                            marketMenuWindow.closeButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                marketMenuWindow.closeButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                marketMenuWindow.setShow(false);

                                mainButtonsPanel.marketMenuButton.setSelected(false);
                                mainButtonsPanel.marketMenuButton.mouseExited();
                                mainButtonsPanel.disableButtons(false, false, false, false, false);
                            }
                        } else if (marketMenuWindow.closeButton.entered) {
                            // === NO HOVER ===
                            marketMenuWindow.closeButton.mouseExited();
                        }
                    }
                }

            }
        }
    }

    private void inputSettingsWindow(Window window, MouseInput mouseInput) {
        if (!settingsWindow.isPaused()) {
            if (settingsWindow.isShow()) {

                // ====== Close Button ======
                if (settingsWindow.closeButton.isShow()) {
                    if (!settingsWindow.closeButton.isDisabled()) {
                        if (isHovered(settingsWindow.closeButton, mouseInput)) {
                            // === HOVER ===
                            settingsWindow.closeButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                settingsWindow.closeButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                settingsWindow.setShow(false);

                                // TODO: //Add pause for player display
                                mainButtonsPanel.setPaused(!mainButtonsPanel.isPaused());
                                plantMenuWindow.setPaused(!plantMenuWindow.isPaused());
                                animalMenuWindow.setPaused(!animalMenuWindow.isPaused());
                                treeMenuWindow.setPaused(!treeMenuWindow.isPaused());
                                upgradeMenuWindow.setPaused(!upgradeMenuWindow.isPaused());
                                marketMenuWindow.setPaused(!upgradeMenuWindow.isPaused());
                            }
                        } else if (settingsWindow.closeButton.entered) {
                            // === NO HOVER ===
                            settingsWindow.closeButton.mouseExited();
                        }
                    }
                }

            }
        }
    }

    @Override
    public void cleanUp() {
        playerData.savePlayerData();
        GameItem[] gameItems = getGameItems();
        for (GameItem gameItem : gameItems) {
            gameItem.getMesh().cleanUp();
        }
    }
}
