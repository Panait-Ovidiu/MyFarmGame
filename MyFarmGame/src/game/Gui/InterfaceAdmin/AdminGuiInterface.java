package game.Gui.InterfaceAdmin;

import engine.GameItem;
import engine.MouseInput;
import engine.Window;
import engine.graph.Camera;
import game.Assets.AssetInfo;
import game.Assets.AssetManager;
import game.Assets.GuiData.Fonts;
import game.Gui.PopUpPanel;
import game.Gui.GuiInterface;
import game.Gui.InterfaceAdmin.AdminWindow.AdminWindow;
import game.Gui.InterfaceAdmin.AdminWindow.AdminSelectPanel;
import game.Gui.Temp.TempItems;
import game.MyFarmGame;
import org.joml.Vector3f;

import java.util.ArrayList;

public class AdminGuiInterface extends GuiInterface {

    public AdminWindow adminWindow;
    public PopUpPanel removeMessagePanel;

    public TempItems tempItems;

    private SelectedAssetInfo itemInfo;

    public AdminGuiInterface(String statusText, Window window, MyFarmGame myFarmGame) throws Exception {
        super(statusText, window, myFarmGame);
        ArrayList<GameItem> items = new ArrayList<>();
        Fonts fonts = new Fonts();
        itemInfo = new SelectedAssetInfo();

        adminWindow = new AdminWindow(window, items);

        removeMessagePanel = new PopUpPanel(window, items);
        removeMessagePanel.setMessage("Do you really want to delete this item ?");

        tempItems = new TempItems(window, fonts, statusText);
        items.addAll(tempItems.getItems());

        gameItems = items.toArray(new GameItem[items.size()]);
    }

    public void update(MouseInput mouseInput, Camera camera) {

        if (adminWindow.isShow()) {
            adminWindow.update(itemInfo);
        }
        if (removeMessagePanel.isShow()) {
            removeMessagePanel.update();
        }
        if (tempItems.isShow()) {
            tempItems.update(camera);
        }

        AssetManager.utilsData.pointer.setPosition(itemInfo.getGameItemPosition().x, itemInfo.getGameItemPosition().y, itemInfo.getGameItemPosition().z);
        AssetManager.utilsData.pointer.setRotation(itemInfo.getGameItemRotation().x, itemInfo.getGameItemRotation().y, itemInfo.getGameItemRotation().z);

    }

    public void updateSize(Window window) {

        if (adminWindow.isShow()) {
            adminWindow.updateSize();
        }
        if (removeMessagePanel.isShow()) {
            removeMessagePanel.updateSize();
        }
        if (tempItems.isShow()) {
            tempItems.updateSize(window);
        }

    }

    public void input(Window window, MouseInput mouseInput, Camera camera) {
        inputAdminWindow(window, mouseInput);
        inputPopUpPanel(window, mouseInput);
    }

    public void inputAdminWindow(Window window, MouseInput mouseInput) {
        if (!adminWindow.isPaused()) {
            if (adminWindow.isShow()) {

                // ====== Main Menu Button ======
                if (adminWindow.mainMenuButton.isShow()) {
                    if (!adminWindow.mainMenuButton.isDisabled()) {
                        if (isHovered(adminWindow.mainMenuButton, mouseInput)) {
                            // === HOVER ===
                            adminWindow.mainMenuButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                adminWindow.mainMenuButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                myFarmGame.setMainMenuScreen();

                            }
                        } else if (adminWindow.mainMenuButton.entered) {
                            // === NO HOVER ===
                            adminWindow.mainMenuButton.mouseExited();
                        }
                    }
                }

                // ====== Terrain Button ======
                if (adminWindow.terrainButton.isShow()) {
                    if (!adminWindow.terrainButton.isDisabled()) {
                        if (isHovered(adminWindow.terrainButton, mouseInput)) {
                            // === HOVER ===
                            adminWindow.terrainButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                adminWindow.terrainButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                adminWindow.selectPanel.setShow(!adminWindow.selectPanel.isShow());
                                adminWindow.disableButtons(
                                        adminWindow.selectPanel.isShow(),
                                        false,
                                        adminWindow.selectPanel.isShow(),
                                        adminWindow.selectPanel.isShow(),
                                        adminWindow.selectPanel.isShow(),
                                        adminWindow.selectPanel.isShow());
                                if (adminWindow.selectPanel.isShow()) {
                                    adminWindow.setPageTerrain();
                                    AssetManager.utilsData.pointer.setShow(true);
                                    if (AssetManager.terrainData.getTerrainGameItems().length != 0) {
                                        AssetManager.terrainData.setSelectedAsset(itemInfo, 0);
                                    }

                                } else {
                                    adminWindow.setPageEmpty();
                                    itemInfo.setEmpty();
                                    AssetManager.utilsData.pointer.setShow(false);
                                }

                            }
                        } else if (adminWindow.terrainButton.entered) {
                            // === NO HOVER ===
                            adminWindow.terrainButton.mouseExited();
                        }
                    }
                }

                // ====== Buildings Button ======
                if (adminWindow.buildingsButton.isShow()) {
                    if (!adminWindow.buildingsButton.isDisabled()) {
                        if (isHovered(adminWindow.buildingsButton, mouseInput)) {
                            // === HOVER ===
                            adminWindow.buildingsButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                adminWindow.buildingsButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                adminWindow.selectPanel.setShow(!adminWindow.selectPanel.isShow());
                                adminWindow.disableButtons(
                                        adminWindow.selectPanel.isShow(),
                                        adminWindow.selectPanel.isShow(),
                                        false,
                                        adminWindow.selectPanel.isShow(),
                                        adminWindow.selectPanel.isShow(),
                                        adminWindow.selectPanel.isShow());
                                if (adminWindow.selectPanel.isShow()) {
                                    adminWindow.setPageBuildings();
                                    AssetManager.utilsData.pointer.setShow(true);
                                    if (AssetManager.buildingsData.getBuildingGameItems().length != 0) {
                                        AssetManager.buildingsData.setSelectedAsset(itemInfo, 0);
                                    }

                                } else {
                                    adminWindow.setPageEmpty();
                                    itemInfo.setEmpty();
                                    AssetManager.utilsData.pointer.setShow(false);
                                }

                            }
                        } else if (adminWindow.buildingsButton.entered) {
                            // === NO HOVER ===
                            adminWindow.buildingsButton.mouseExited();
                        }
                    }
                }

                // ====== Decorations Button ======
                if (adminWindow.decorationsButton.isShow()) {
                    if (!adminWindow.decorationsButton.isDisabled()) {
                        if (isHovered(adminWindow.decorationsButton, mouseInput)) {
                            // === HOVER ===
                            adminWindow.decorationsButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                adminWindow.decorationsButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                adminWindow.selectPanel.setShow(!adminWindow.selectPanel.isShow());
                                adminWindow.disableButtons(
                                        adminWindow.selectPanel.isShow(),
                                        adminWindow.selectPanel.isShow(),
                                        adminWindow.selectPanel.isShow(),
                                        false,
                                        adminWindow.selectPanel.isShow(),
                                        adminWindow.selectPanel.isShow());
                                if (adminWindow.selectPanel.isShow()) {
                                    adminWindow.setPageDecorations();
                                    AssetManager.utilsData.pointer.setShow(true);
                                    if (AssetManager.decorationsData.getDecorationGameItems().length != 0) {
                                        AssetManager.decorationsData.setSelectedAsset(itemInfo, 0);
                                    }

                                } else {
                                    adminWindow.setPageEmpty();
                                    itemInfo.setEmpty();
                                    AssetManager.utilsData.pointer.setShow(false);
                                }

                            }
                        } else if (adminWindow.decorationsButton.entered) {
                            // === NO HOVER ===
                            adminWindow.decorationsButton.mouseExited();
                        }
                    }
                }

                // ====== Plants Button ======
                if (adminWindow.plantsButton.isShow()) {
                    if (!adminWindow.plantsButton.isDisabled()) {
                        if (isHovered(adminWindow.plantsButton, mouseInput)) {
                            // === HOVER ===
                            adminWindow.plantsButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                adminWindow.plantsButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                adminWindow.selectPanel.setShow(!adminWindow.selectPanel.isShow());
                                adminWindow.disableButtons(
                                        adminWindow.selectPanel.isShow(),
                                        adminWindow.selectPanel.isShow(),
                                        adminWindow.selectPanel.isShow(),
                                        adminWindow.selectPanel.isShow(),
                                        false,
                                        adminWindow.selectPanel.isShow());
                                if (adminWindow.selectPanel.isShow()) {
                                    adminWindow.setPagePlants();
                                    AssetManager.utilsData.pointer.setShow(true);
                                    if (AssetManager.plantsData.getPlantGameItems().length != 0) {
                                        AssetManager.plantsData.setSelectedAsset(itemInfo, 0);
                                    }

                                } else {
                                    adminWindow.setPageEmpty();
                                    itemInfo.setEmpty();
                                    AssetManager.utilsData.pointer.setShow(false);
                                }

                            }
                        } else if (adminWindow.plantsButton.entered) {
                            // === NO HOVER ===
                            adminWindow.plantsButton.mouseExited();
                        }
                    }
                }

                // ====== Animals Button ======
                if (adminWindow.animalsButton.isShow()) {
                    if (!adminWindow.animalsButton.isDisabled()) {
                        if (isHovered(adminWindow.animalsButton, mouseInput)) {
                            // === HOVER ===
                            adminWindow.animalsButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                adminWindow.animalsButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);

                                adminWindow.selectPanel.setShow(!adminWindow.selectPanel.isShow());
                                adminWindow.disableButtons(
                                        adminWindow.selectPanel.isShow(),
                                        adminWindow.selectPanel.isShow(),
                                        adminWindow.selectPanel.isShow(),
                                        adminWindow.selectPanel.isShow(),
                                        adminWindow.selectPanel.isShow(),
                                        false);
                                if (adminWindow.selectPanel.isShow()) {
                                    adminWindow.setPageAnimals();
                                    AssetManager.utilsData.pointer.setShow(true);
                                    if (AssetManager.animalsData.getAnimalGameItems().length != 0) {
                                        AssetManager.animalsData.setSelectedAsset(itemInfo, 0);
                                    }

                                } else {
                                    adminWindow.setPageEmpty();
                                    itemInfo.setEmpty();
                                    AssetManager.utilsData.pointer.setShow(false);
                                }

                            }
                        } else if (adminWindow.animalsButton.entered) {
                            // === NO HOVER ===
                            adminWindow.animalsButton.mouseExited();
                        }
                    }
                }

                // ====== Select Panel ======
                if (adminWindow.selectPanel.isShow()) {
                    AdminSelectPanel selectPanel = adminWindow.selectPanel;

                    // ====== Select Previous Button ======
                    if (selectPanel.previousSelectButton.isShow()) {
                        if (!selectPanel.previousSelectButton.isDisabled()) {
                            if (isHovered(selectPanel.previousSelectButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.previousSelectButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.previousSelectButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    int size = itemInfo.getAssetListSize();
                                    if (size > 0) {
                                        int selectedItem = itemInfo.getGameItemIndex() - 1;
                                        if (selectedItem < 0) {
                                            selectedItem = size - 1;
                                        }

                                        if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {
                                            AssetManager.terrainData.setSelectedAsset(itemInfo, selectedItem);

                                        } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {
                                            AssetManager.buildingsData.setSelectedAsset(itemInfo, selectedItem);

                                        } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {
                                            AssetManager.decorationsData.setSelectedAsset(itemInfo, selectedItem);

                                        } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {
                                            AssetManager.plantsData.setSelectedAsset(itemInfo, selectedItem);

                                        } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {
                                            AssetManager.animalsData.setSelectedAsset(itemInfo, selectedItem);

                                        }

                                    }
                                }
                            } else if (selectPanel.previousSelectButton.entered) {
                                // === NO HOVER ===
                                selectPanel.previousSelectButton.mouseExited();
                            }
                        }
                    }

                    // ====== Select Next Button ======
                    if (selectPanel.nextSelectButton.isShow()) {
                        if (!selectPanel.nextSelectButton.isDisabled()) {
                            if (isHovered(selectPanel.nextSelectButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.nextSelectButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.nextSelectButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    int size = itemInfo.getAssetListSize();
                                    if (size > 0) {
                                        int selectedItem = itemInfo.getGameItemIndex() + 1;
                                        if (selectedItem > size - 1) {
                                            selectedItem = 0;
                                        }

                                        if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {
                                            AssetManager.terrainData.setSelectedAsset(itemInfo, selectedItem);

                                        } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {
                                            AssetManager.buildingsData.setSelectedAsset(itemInfo, selectedItem);

                                        } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {
                                            AssetManager.decorationsData.setSelectedAsset(itemInfo, selectedItem);

                                        } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {
                                            AssetManager.plantsData.setSelectedAsset(itemInfo, selectedItem);

                                        } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {
                                            AssetManager.animalsData.setSelectedAsset(itemInfo, selectedItem);

                                        }

                                    }
                                }
                            } else if (selectPanel.nextSelectButton.entered) {
                                // === NO HOVER ===
                                selectPanel.nextSelectButton.mouseExited();
                            }
                        }
                    }

                    // ====== Modify Button ======
                    if (selectPanel.modifyButton.isShow()) {
                        if (!selectPanel.modifyButton.isDisabled()) {
                            if (isHovered(selectPanel.modifyButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.modifyButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.modifyButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    int size = itemInfo.getAssetListSize();
                                    if (size > 0) {

                                        selectPanel.setPageModify();

                                        if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {
                                            adminWindow.terrainButton.setDisabled(true);

                                        } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {
                                            adminWindow.buildingsButton.setDisabled(true);

                                        } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {
                                            adminWindow.decorationsButton.setDisabled(true);

                                        } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {
                                            adminWindow.plantsButton.setDisabled(true);

                                        } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {
                                            adminWindow.animalsButton.setDisabled(true);
                                        }

                                    }
                                }
                            } else if (selectPanel.modifyButton.entered) {
                                // === NO HOVER ===
                                selectPanel.modifyButton.mouseExited();
                            }
                        }
                    }

                    // ====== Remove Button ======
                    if (selectPanel.removeButton.isShow()) {
                        if (!selectPanel.removeButton.isDisabled()) {
                            if (isHovered(selectPanel.removeButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.removeButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.removeButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    int size = itemInfo.getAssetListSize();
                                    if (size > 0) {
                                        selectPanel.setPageRemove();
                                        removeMessagePanel.setShow(true);
                                        adminWindow.setPaused(true);
                                    }

                                }
                            } else if (selectPanel.removeButton.entered) {
                                // === NO HOVER ===
                                selectPanel.removeButton.mouseExited();
                            }
                        }
                    }

                    // ====== Add Button ======
                    if (selectPanel.addButton.isShow()) {
                        if (!selectPanel.addButton.isDisabled()) {
                            if (isHovered(selectPanel.addButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.addButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.addButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    selectPanel.setPageAdd();

                                    if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {
                                        adminWindow.terrainButton.setDisabled(true);

                                        AssetManager.terrainData.addTerrainItem(
                                                itemInfo.getGameItemPosition(), itemInfo.getGameItemRotation(), 0);
                                        AssetManager.terrainData.setSelectedAsset(itemInfo, itemInfo.assetListSize);
                                        myFarmGame.currentScene.setTerrain(AssetManager.terrainData.getTerrainGameItems());

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {
                                        adminWindow.buildingsButton.setDisabled(true);

                                        AssetManager.buildingsData.addBuildingItem(
                                                itemInfo.getGameItemPosition(), itemInfo.getGameItemRotation(), 0);
                                        AssetManager.buildingsData.setSelectedAsset(itemInfo, itemInfo.assetListSize);
                                        myFarmGame.currentScene.setBuildings(AssetManager.buildingsData.getBuildingGameItems());

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {
                                        adminWindow.decorationsButton.setDisabled(true);

                                        AssetManager.decorationsData.addDecorationItem(
                                                itemInfo.getGameItemPosition(), itemInfo.getGameItemRotation(), 0);
                                        AssetManager.decorationsData.setSelectedAsset(itemInfo, itemInfo.assetListSize);
                                        myFarmGame.currentScene.setDecorations(AssetManager.decorationsData.getDecorationGameItems());

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {
                                        adminWindow.plantsButton.setDisabled(true);

                                        AssetManager.plantsData.addPlantItem(
                                                itemInfo.getGameItemPosition(), itemInfo.getGameItemRotation(), 0);
                                        AssetManager.plantsData.setSelectedAsset(itemInfo, itemInfo.assetListSize);
                                        myFarmGame.currentScene.setPlants(AssetManager.plantsData.getPlantGameItems());

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {
                                        adminWindow.animalsButton.setDisabled(true);

                                        AssetManager.animalsData.addAnimalItem(
                                                itemInfo.getGameItemPosition(), itemInfo.getGameItemRotation(), 0);
                                        AssetManager.animalsData.setSelectedAsset(itemInfo, itemInfo.assetListSize);
                                        myFarmGame.currentScene.setAnimals(AssetManager.animalsData.getAnimalGameItems());
                                    }

                                }
                            } else if (selectPanel.addButton.entered) {
                                // === NO HOVER ===
                                selectPanel.addButton.mouseExited();
                            }
                        }
                    }

                    // ====== Mesh Previous Button ======
                    if (selectPanel.meshPreviousButton.isShow()) {
                        if (!selectPanel.meshPreviousButton.isDisabled()) {
                            if (isHovered(selectPanel.meshPreviousButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.meshPreviousButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.meshPreviousButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    int size = itemInfo.getMeshListSize();
                                    int selectedItem = itemInfo.getMeshIndex() - 1;
                                    if (selectedItem < 0) {
                                        selectedItem = size - 1;
                                    }

                                    if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {
                                        AssetManager.terrainData.setMesh(itemInfo, selectedItem);
                                        myFarmGame.currentScene.setTerrain(AssetManager.terrainData.getTerrainGameItems());

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {
                                        AssetManager.buildingsData.setMesh(itemInfo, selectedItem);
                                        myFarmGame.currentScene.setBuildings(AssetManager.buildingsData.getBuildingGameItems());

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {
                                        AssetManager.decorationsData.setMesh(itemInfo, selectedItem);
                                        myFarmGame.currentScene.setDecorations(AssetManager.decorationsData.getDecorationGameItems());

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {
                                        AssetManager.plantsData.setMesh(itemInfo, selectedItem);
                                        myFarmGame.currentScene.setPlants(AssetManager.plantsData.getPlantGameItems());

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {
                                        AssetManager.animalsData.setMesh(itemInfo, selectedItem);
                                        myFarmGame.currentScene.setAnimals(AssetManager.animalsData.getAnimalGameItems());

                                    }

                                }
                            } else if (selectPanel.meshPreviousButton.entered) {
                                // === NO HOVER ===
                                selectPanel.meshPreviousButton.mouseExited();
                            }
                        }
                    }

                    // ====== Mesh Next Button ======
                    if (selectPanel.meshNextButton.isShow()) {
                        if (!selectPanel.meshNextButton.isDisabled()) {
                            if (isHovered(selectPanel.meshNextButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.meshNextButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.meshNextButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    int size = itemInfo.getMeshListSize();
                                    int selectedMesh = itemInfo.getMeshIndex() + 1;
                                    if (selectedMesh > size - 1) {
                                        selectedMesh = 0;
                                    }

                                    if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {
                                        AssetManager.terrainData.setMesh(itemInfo, selectedMesh);
                                        myFarmGame.currentScene.setTerrain(AssetManager.terrainData.getTerrainGameItems());

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {
                                        AssetManager.buildingsData.setMesh(itemInfo, selectedMesh);
                                        myFarmGame.currentScene.setBuildings(AssetManager.buildingsData.getBuildingGameItems());

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {
                                        AssetManager.decorationsData.setMesh(itemInfo, selectedMesh);
                                        myFarmGame.currentScene.setDecorations(AssetManager.decorationsData.getDecorationGameItems());

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {
                                        AssetManager.plantsData.setMesh(itemInfo, selectedMesh);
                                        myFarmGame.currentScene.setPlants(AssetManager.plantsData.getPlantGameItems());

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {
                                        AssetManager.animalsData.setMesh(itemInfo, selectedMesh);
                                        myFarmGame.currentScene.setAnimals(AssetManager.animalsData.getAnimalGameItems());

                                    }

                                }
                            } else if (selectPanel.meshNextButton.entered) {
                                // === NO HOVER ===
                                selectPanel.meshNextButton.mouseExited();
                            }
                        }
                    }

                    // ====== Increment Previous Button ======
                    if (selectPanel.incrementPreviousButton.isShow()) {
                        if (!selectPanel.incrementPreviousButton.isDisabled()) {
                            if (isHovered(selectPanel.incrementPreviousButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.incrementPreviousButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.incrementPreviousButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    float incrementBy = itemInfo.getIncrementBy() - 0.5f;
                                    if (incrementBy < 0.5) {
                                        incrementBy = 0.5f;
                                    }
                                    itemInfo.setIncrementBy(incrementBy);
                                }
                            } else if (selectPanel.incrementPreviousButton.entered) {
                                // === NO HOVER ===
                                selectPanel.incrementPreviousButton.mouseExited();
                            }
                        }
                    }

                    // ====== Increment Next Button ======
                    if (selectPanel.incrementNextButton.isShow()) {
                        if (!selectPanel.incrementNextButton.isDisabled()) {
                            if (isHovered(selectPanel.incrementNextButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.incrementNextButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.incrementNextButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    float incrementBy = itemInfo.getIncrementBy() + 0.5f;
                                    itemInfo.setIncrementBy(incrementBy);
                                }
                            } else if (selectPanel.incrementNextButton.entered) {
                                // === NO HOVER ===
                                selectPanel.incrementNextButton.mouseExited();
                            }
                        }
                    }

                    // ====== Position X Previous Button ======
                    if (selectPanel.positionXPreviousButton.isShow()) {
                        if (!selectPanel.positionXPreviousButton.isDisabled()) {
                            if (isHovered(selectPanel.positionXPreviousButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.positionXPreviousButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.positionXPreviousButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    Vector3f position = itemInfo.getGameItemPosition();

                                    if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {
                                        AssetManager.terrainData.setPosition(itemInfo,
                                                new Vector3f(position.x - itemInfo.getIncrementBy(), position.y, position.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {
                                        AssetManager.buildingsData.setPosition(itemInfo,
                                                new Vector3f(position.x - itemInfo.getIncrementBy(), position.y, position.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {
                                        AssetManager.decorationsData.setPosition(itemInfo,
                                                new Vector3f(position.x - itemInfo.getIncrementBy(), position.y, position.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {
                                        AssetManager.plantsData.setPosition(itemInfo,
                                                new Vector3f(position.x - itemInfo.getIncrementBy(), position.y, position.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {
                                        AssetManager.animalsData.setPosition(itemInfo,
                                                new Vector3f(position.x - itemInfo.getIncrementBy(), position.y, position.z));

                                    }

                                }
                            } else if (selectPanel.positionXPreviousButton.entered) {
                                // === NO HOVER ===
                                selectPanel.positionXPreviousButton.mouseExited();
                            }
                        }
                    }

                    // ====== Position X Next Button ======
                    if (selectPanel.positionXNextButton.isShow()) {
                        if (!selectPanel.positionXNextButton.isDisabled()) {
                            if (isHovered(selectPanel.positionXNextButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.positionXNextButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.positionXNextButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    Vector3f position = itemInfo.getGameItemPosition();

                                    if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {
                                        AssetManager.terrainData.setPosition(itemInfo,
                                                new Vector3f(position.x + itemInfo.getIncrementBy(), position.y, position.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {
                                        AssetManager.buildingsData.setPosition(itemInfo,
                                                new Vector3f(position.x + itemInfo.getIncrementBy(), position.y, position.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {
                                        AssetManager.decorationsData.setPosition(itemInfo,
                                                new Vector3f(position.x + itemInfo.getIncrementBy(), position.y, position.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {
                                        AssetManager.plantsData.setPosition(itemInfo,
                                                new Vector3f(position.x + itemInfo.getIncrementBy(), position.y, position.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {
                                        AssetManager.animalsData.setPosition(itemInfo,
                                                new Vector3f(position.x + itemInfo.getIncrementBy(), position.y, position.z));

                                    }

                                }
                            } else if (selectPanel.positionXNextButton.entered) {
                                // === NO HOVER ===
                                selectPanel.positionXNextButton.mouseExited();
                            }
                        }
                    }

                    // ====== Position Y Previous Button ======
                    if (selectPanel.positionYPreviousButton.isShow()) {
                        if (!selectPanel.positionYPreviousButton.isDisabled()) {
                            if (isHovered(selectPanel.positionYPreviousButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.positionYPreviousButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.positionYPreviousButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    Vector3f position = itemInfo.getGameItemPosition();

                                    if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {
                                        AssetManager.terrainData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y - itemInfo.getIncrementBy(), position.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {
                                        AssetManager.buildingsData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y - itemInfo.getIncrementBy(), position.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {
                                        AssetManager.decorationsData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y - itemInfo.getIncrementBy(), position.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {
                                        AssetManager.plantsData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y - itemInfo.getIncrementBy(), position.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {
                                        AssetManager.animalsData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y - itemInfo.getIncrementBy(), position.z));

                                    }

                                }
                            } else if (selectPanel.positionYPreviousButton.entered) {
                                // === NO HOVER ===
                                selectPanel.positionYPreviousButton.mouseExited();
                            }
                        }
                    }

                    // ====== Position Y Next Button ======
                    if (selectPanel.positionYNextButton.isShow()) {
                        if (!selectPanel.positionYNextButton.isDisabled()) {
                            if (isHovered(selectPanel.positionYNextButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.positionYNextButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.positionYNextButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    Vector3f position = itemInfo.getGameItemPosition();

                                    if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {
                                        AssetManager.terrainData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y + itemInfo.getIncrementBy(), position.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {
                                        AssetManager.buildingsData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y + itemInfo.getIncrementBy(), position.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {
                                        AssetManager.decorationsData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y + itemInfo.getIncrementBy(), position.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {
                                        AssetManager.plantsData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y + itemInfo.getIncrementBy(), position.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {
                                        AssetManager.animalsData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y + itemInfo.getIncrementBy(), position.z));

                                    }

                                }
                            } else if (selectPanel.positionYNextButton.entered) {
                                // === NO HOVER ===
                                selectPanel.positionYNextButton.mouseExited();
                            }
                        }
                    }

                    // ====== Position Z Previous Button ======
                    if (selectPanel.positionZPreviousButton.isShow()) {
                        if (!selectPanel.positionZPreviousButton.isDisabled()) {
                            if (isHovered(selectPanel.positionZPreviousButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.positionZPreviousButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.positionZPreviousButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    Vector3f position = itemInfo.getGameItemPosition();

                                    if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {
                                        AssetManager.terrainData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y, position.z - itemInfo.getIncrementBy()));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {
                                        AssetManager.buildingsData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y, position.z - itemInfo.getIncrementBy()));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {
                                        AssetManager.decorationsData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y, position.z - itemInfo.getIncrementBy()));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {
                                        AssetManager.plantsData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y, position.z - itemInfo.getIncrementBy()));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {
                                        AssetManager.animalsData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y, position.z - itemInfo.getIncrementBy()));

                                    }

                                }
                            } else if (selectPanel.positionZPreviousButton.entered) {
                                // === NO HOVER ===
                                selectPanel.positionZPreviousButton.mouseExited();
                            }
                        }
                    }

                    // ====== Position Z Next Button ======
                    if (selectPanel.positionZNextButton.isShow()) {
                        if (!selectPanel.positionZNextButton.isDisabled()) {
                            if (isHovered(selectPanel.positionZNextButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.positionZNextButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.positionZNextButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    Vector3f position = itemInfo.getGameItemPosition();

                                    if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {
                                        AssetManager.terrainData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y, position.z + itemInfo.getIncrementBy()));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {
                                        AssetManager.buildingsData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y, position.z + itemInfo.getIncrementBy()));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {
                                        AssetManager.decorationsData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y, position.z + itemInfo.getIncrementBy()));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {
                                        AssetManager.plantsData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y, position.z + itemInfo.getIncrementBy()));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {
                                        AssetManager.animalsData.setPosition(itemInfo,
                                                new Vector3f(position.x, position.y, position.z + itemInfo.getIncrementBy()));

                                    }

                                }
                            } else if (selectPanel.positionZNextButton.entered) {
                                // === NO HOVER ===
                                selectPanel.positionZNextButton.mouseExited();
                            }
                        }
                    }

                    // ====== Rotation X Previous Button ======
                    if (selectPanel.rotationXPreviousButton.isShow()) {
                        if (!selectPanel.rotationXPreviousButton.isDisabled()) {
                            if (isHovered(selectPanel.rotationXPreviousButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.rotationXPreviousButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.rotationXPreviousButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    Vector3f rotation = itemInfo.getGameItemRotation();
                                    float rotationX = rotation.x - 45.0f;
                                    if (rotationX < 0) {
                                        rotationX = 315.0f;
                                    }

                                    if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {
                                        AssetManager.terrainData.setRotation(itemInfo, new Vector3f(rotationX, rotation.y, rotation.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {
                                        AssetManager.buildingsData.setRotation(itemInfo, new Vector3f(rotationX, rotation.y, rotation.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {
                                        AssetManager.decorationsData.setRotation(itemInfo, new Vector3f(rotationX, rotation.y, rotation.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {
                                        AssetManager.plantsData.setRotation(itemInfo, new Vector3f(rotationX, rotation.y, rotation.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {
                                        AssetManager.animalsData.setRotation(itemInfo, new Vector3f(rotationX, rotation.y, rotation.z));

                                    }

                                }
                            } else if (selectPanel.rotationXPreviousButton.entered) {
                                // === NO HOVER ===
                                selectPanel.rotationXPreviousButton.mouseExited();
                            }
                        }
                    }

                    // ====== Rotation X Next Button ======
                    if (selectPanel.rotationXNextButton.isShow()) {
                        if (!selectPanel.rotationXNextButton.isDisabled()) {
                            if (isHovered(selectPanel.rotationXNextButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.rotationXNextButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.rotationXNextButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    Vector3f rotation = itemInfo.getGameItemRotation();
                                    float rotationX = rotation.x + 45.0f;
                                    if (rotationX >= 360) {
                                        rotationX = 0.0f;
                                    }

                                    if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {
                                        AssetManager.terrainData.setRotation(itemInfo, new Vector3f(rotationX, rotation.y, rotation.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {
                                        AssetManager.buildingsData.setRotation(itemInfo, new Vector3f(rotationX, rotation.y, rotation.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {
                                        AssetManager.decorationsData.setRotation(itemInfo, new Vector3f(rotationX, rotation.y, rotation.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {
                                        AssetManager.plantsData.setRotation(itemInfo, new Vector3f(rotationX, rotation.y, rotation.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {
                                        AssetManager.animalsData.setRotation(itemInfo, new Vector3f(rotationX, rotation.y, rotation.z));

                                    }

                                }
                            } else if (selectPanel.rotationXNextButton.entered) {
                                // === NO HOVER ===
                                selectPanel.rotationXNextButton.mouseExited();
                            }
                        }
                    }

                    // ====== Rotation Y Previous Button ======
                    if (selectPanel.rotationYPreviousButton.isShow()) {
                        if (!selectPanel.rotationYPreviousButton.isDisabled()) {
                            if (isHovered(selectPanel.rotationYPreviousButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.rotationYPreviousButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.rotationYPreviousButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    Vector3f rotation = itemInfo.getGameItemRotation();
                                    float rotationY = rotation.y - 45.0f;
                                    if (rotationY < 0) {
                                        rotationY = 315.0f;
                                    }

                                    if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {
                                        AssetManager.terrainData.setRotation(itemInfo, new Vector3f(rotation.x, rotationY, rotation.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {
                                        AssetManager.buildingsData.setRotation(itemInfo, new Vector3f(rotation.x, rotationY, rotation.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {
                                        AssetManager.decorationsData.setRotation(itemInfo, new Vector3f(rotation.x, rotationY, rotation.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {
                                        AssetManager.plantsData.setRotation(itemInfo, new Vector3f(rotation.x, rotationY, rotation.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {
                                        AssetManager.animalsData.setRotation(itemInfo, new Vector3f(rotation.x, rotationY, rotation.z));

                                    }

                                }
                            } else if (selectPanel.rotationYPreviousButton.entered) {
                                // === NO HOVER ===
                                selectPanel.rotationYPreviousButton.mouseExited();
                            }
                        }
                    }

                    // ====== Rotation Y Next Button ======
                    if (selectPanel.rotationYNextButton.isShow()) {
                        if (!selectPanel.rotationYNextButton.isDisabled()) {
                            if (isHovered(selectPanel.rotationYNextButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.rotationYNextButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.rotationYNextButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    Vector3f rotation = itemInfo.getGameItemRotation();
                                    float rotationY = rotation.y + 45.0f;
                                    if (rotationY >= 360) {
                                        rotationY = 0.0f;
                                    }

                                    if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {
                                        AssetManager.terrainData.setRotation(itemInfo, new Vector3f(rotation.x, rotationY, rotation.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {
                                        AssetManager.buildingsData.setRotation(itemInfo, new Vector3f(rotation.x, rotationY, rotation.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {
                                        AssetManager.decorationsData.setRotation(itemInfo, new Vector3f(rotation.x, rotationY, rotation.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {
                                        AssetManager.plantsData.setRotation(itemInfo, new Vector3f(rotation.x, rotationY, rotation.z));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {
                                        AssetManager.animalsData.setRotation(itemInfo, new Vector3f(rotation.x, rotationY, rotation.z));

                                    }

                                }
                            } else if (selectPanel.rotationYNextButton.entered) {
                                // === NO HOVER ===
                                selectPanel.rotationYNextButton.mouseExited();
                            }
                        }
                    }

                    // ====== Rotation Z Previous Button ======
                    if (selectPanel.rotationZPreviousButton.isShow()) {
                        if (!selectPanel.rotationZPreviousButton.isDisabled()) {
                            if (isHovered(selectPanel.rotationZPreviousButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.rotationZPreviousButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.rotationZPreviousButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    Vector3f rotation = itemInfo.getGameItemRotation();
                                    float rotationZ = rotation.z - 45.0f;
                                    if (rotationZ < 0) {
                                        rotationZ = 315.0f;
                                    }

                                    if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {
                                        AssetManager.terrainData.setRotation(itemInfo, new Vector3f(rotation.x, rotation.y, rotationZ));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {
                                        AssetManager.buildingsData.setRotation(itemInfo, new Vector3f(rotation.x, rotation.y, rotationZ));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {
                                        AssetManager.decorationsData.setRotation(itemInfo, new Vector3f(rotation.x, rotation.y, rotationZ));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {
                                        AssetManager.plantsData.setRotation(itemInfo, new Vector3f(rotation.x, rotation.y, rotationZ));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {
                                        AssetManager.animalsData.setRotation(itemInfo, new Vector3f(rotation.x, rotation.y, rotationZ));

                                    }

                                }
                            } else if (selectPanel.rotationZPreviousButton.entered) {
                                // === NO HOVER ===
                                selectPanel.rotationZPreviousButton.mouseExited();
                            }
                        }
                    }

                    // ====== Rotation Z Next Button ======
                    if (selectPanel.rotationZNextButton.isShow()) {
                        if (!selectPanel.rotationZNextButton.isDisabled()) {
                            if (isHovered(selectPanel.rotationZNextButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.rotationZNextButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.rotationZNextButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    Vector3f rotation = itemInfo.getGameItemRotation();
                                    float rotationZ = rotation.z + 45.0f;
                                    if (rotationZ >= 360) {
                                        rotationZ = 0.0f;
                                    }

                                    if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {
                                        AssetManager.terrainData.setRotation(itemInfo, new Vector3f(rotation.x, rotation.y, rotationZ));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {
                                        AssetManager.buildingsData.setRotation(itemInfo, new Vector3f(rotation.x, rotation.y, rotationZ));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {
                                        AssetManager.decorationsData.setRotation(itemInfo, new Vector3f(rotation.x, rotation.y, rotationZ));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {
                                        AssetManager.plantsData.setRotation(itemInfo, new Vector3f(rotation.x, rotation.y, rotationZ));

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {
                                        AssetManager.animalsData.setRotation(itemInfo, new Vector3f(rotation.x, rotation.y, rotationZ));

                                    }

                                }
                            } else if (selectPanel.rotationZNextButton.entered) {
                                // === NO HOVER ===
                                selectPanel.rotationZNextButton.mouseExited();
                            }
                        }
                    }

                    // ====== Save Button ======
                    if (selectPanel.saveButton.isShow()) {
                        if (!selectPanel.saveButton.isDisabled()) {
                            if (isHovered(selectPanel.saveButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.saveButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.saveButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    AssetManager.terrainData.saveData();
                                    AssetManager.buildingsData.saveData();
                                    AssetManager.decorationsData.saveData();
                                    AssetManager.plantsData.saveData();
                                    AssetManager.animalsData.saveData();

                                }
                            } else if (selectPanel.saveButton.entered) {
                                // === NO HOVER ===
                                selectPanel.saveButton.mouseExited();
                            }
                        }
                    }

                    // ====== Cancel Button ======
                    if (selectPanel.cancelButton.isShow()) {
                        if (!selectPanel.cancelButton.isDisabled()) {
                            if (isHovered(selectPanel.cancelButton, mouseInput)) {
                                // === HOVER ===
                                selectPanel.cancelButton.mouseEntered();

                                if (mouseInput.isLeftButtonPressed()) {
                                    // === CLICKED ===
                                    selectPanel.cancelButton.mouseClicked();
                                    mouseInput.setLeftButtonPressed(false);

                                    selectPanel.setPageEmpty();

                                    if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {
                                        adminWindow.terrainButton.setDisabled(false);

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {
                                        adminWindow.buildingsButton.setDisabled(false);

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {
                                        adminWindow.decorationsButton.setDisabled(false);

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {
                                        adminWindow.plantsButton.setDisabled(false);

                                    } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {
                                        adminWindow.animalsButton.setDisabled(false);

                                    }

                                }
                            } else if (selectPanel.cancelButton.entered) {
                                // === NO HOVER ===
                                selectPanel.cancelButton.mouseExited();
                            }
                        }
                    }

                }

            }
        }
    }

    private void inputPopUpPanel(Window window, MouseInput mouseInput) {
        if (!removeMessagePanel.isPaused()) {
            if (removeMessagePanel.isShow()) {

                // ====== Close Button ======
                if (removeMessagePanel.closeButton.isShow()) {
                    if (!removeMessagePanel.closeButton.isDisabled()) {
                        if (isHovered(removeMessagePanel.closeButton, mouseInput)) {
                            // === HOVER ===
                            removeMessagePanel.closeButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                removeMessagePanel.closeButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);
                                adminWindow.selectPanel.setPageEmpty();

                                removeMessagePanel.setShow(false);
                                adminWindow.setPaused(false);
                            }
                        } else if (removeMessagePanel.closeButton.entered) {
                            // === NO HOVER ===
                            removeMessagePanel.closeButton.mouseExited();
                        }
                    }
                }

                // ====== Yes Button ======
                if (removeMessagePanel.yesButton.isShow()) {
                    if (!removeMessagePanel.yesButton.isDisabled()) {
                        if (isHovered(removeMessagePanel.yesButton, mouseInput)) {
                            // === HOVER ===
                            removeMessagePanel.yesButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                removeMessagePanel.yesButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);
                                adminWindow.selectPanel.setPageEmpty();

                                if (adminWindow.isPage(AdminWindow.PAGE_TERRAIN)) {

                                    AssetManager.terrainData.removeTerrainItem(itemInfo);

                                    if (AssetManager.terrainData.getTerrainGameItems().length != 0) {
                                        AssetManager.terrainData.setSelectedAsset(itemInfo, 0);
                                    } else {
                                        itemInfo.setEmpty();
                                    }

                                    myFarmGame.currentScene.setTerrain(AssetManager.terrainData.getTerrainGameItems());

                                } else if (adminWindow.isPage(AdminWindow.PAGE_BUILDINGS)) {

                                    AssetManager.buildingsData.removeBuildingItem(itemInfo);

                                    if (AssetManager.buildingsData.getBuildingGameItems().length != 0) {
                                        AssetManager.buildingsData.setSelectedAsset(itemInfo, 0);
                                    } else {
                                        itemInfo.setEmpty();
                                    }

                                    myFarmGame.currentScene.setBuildings(AssetManager.buildingsData.getBuildingGameItems());

                                } else if (adminWindow.isPage(AdminWindow.PAGE_DECORATIONS)) {

                                    AssetManager.decorationsData.removeDecorationItem(itemInfo);

                                    if (AssetManager.decorationsData.getDecorationGameItems().length != 0) {
                                        AssetManager.decorationsData.setSelectedAsset(itemInfo, 0);
                                    } else {
                                        itemInfo.setEmpty();
                                    }

                                    myFarmGame.currentScene.setDecorations(AssetManager.decorationsData.getDecorationGameItems());

                                } else if (adminWindow.isPage(AdminWindow.PAGE_PLANTS)) {

                                    AssetManager.plantsData.removePlantItem(itemInfo);

                                    if (AssetManager.plantsData.getPlantGameItems().length != 0) {
                                        AssetManager.plantsData.setSelectedAsset(itemInfo, 0);
                                    } else {
                                        itemInfo.setEmpty();
                                    }

                                    myFarmGame.currentScene.setPlants(AssetManager.plantsData.getPlantGameItems());

                                } else if (adminWindow.isPage(AdminWindow.PAGE_ANIMALS)) {

                                    AssetManager.animalsData.removeAnimalItem(itemInfo);

                                    if (AssetManager.animalsData.getAnimalGameItems().length != 0) {
                                        AssetManager.animalsData.setSelectedAsset(itemInfo, 0);
                                    } else {
                                        itemInfo.setEmpty();
                                    }

                                    myFarmGame.currentScene.setAnimals(AssetManager.animalsData.getAnimalGameItems());
                                }

                                removeMessagePanel.setShow(false);
                                adminWindow.setPaused(false);
                            }
                        } else if (removeMessagePanel.yesButton.entered) {
                            // === NO HOVER ===
                            removeMessagePanel.yesButton.mouseExited();
                        }
                    }
                }

                // ====== No Button ======
                if (removeMessagePanel.noButton.isShow()) {
                    if (!removeMessagePanel.noButton.isDisabled()) {
                        if (isHovered(removeMessagePanel.noButton, mouseInput)) {
                            // === HOVER ===
                            removeMessagePanel.noButton.mouseEntered();

                            if (mouseInput.isLeftButtonPressed()) {
                                // === CLICKED ===
                                removeMessagePanel.noButton.mouseClicked();
                                mouseInput.setLeftButtonPressed(false);
                                adminWindow.selectPanel.setPageEmpty();

                                removeMessagePanel.setShow(false);
                                adminWindow.setPaused(false);
                            }
                        } else if (removeMessagePanel.noButton.entered) {
                            // === NO HOVER ===
                            removeMessagePanel.noButton.mouseExited();
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

    public static class SelectedAssetInfo {

        private float incrementBy;

        private int assetListSize;

        private int meshListSize;

        private AssetInfo assetInfo;

        private int emptyAssetListSize;
        private int emptyMeshListSize;
        private AssetInfo emptyAssetInfo;

        public SelectedAssetInfo() {
            emptyAssetListSize = 0;
            emptyMeshListSize = 0;
            emptyAssetInfo = new AssetInfo("", 0, "", 0, new GameItem());
            incrementBy = 1.0f;
            setEmpty();
        }

        public float getIncrementBy() {
            return incrementBy;
        }

        public int getAssetListSize() {
            return assetListSize;
        }

        public int getMeshListSize() {
            return meshListSize;
        }

        public String getGameItemID() {
            return assetInfo.getGameItemID();
        }

        public int getGameItemIndex() {
            return assetInfo.getGameItemIndex();
        }

        public String getMeshID() {
            return assetInfo.getMeshID();
        }

        public int getMeshIndex() {
            return assetInfo.getMeshIndex();
        }

        public Vector3f getGameItemPosition() {
            return assetInfo.getGameItem().getPosition();
        }

        public Vector3f getGameItemRotation() {
            return assetInfo.getGameItem().getRotation();
        }

        public void setIncrementBy(float incrementBy) {
            this.incrementBy = incrementBy;
        }

        public void setSelectedAssetInfo(int assetListSize, int meshListSize, AssetInfo assetInfo) {
            this.assetListSize = assetListSize;
            this.meshListSize = meshListSize;
            this.assetInfo = assetInfo;
        }

        public void setEmpty() {
            assetListSize = emptyAssetListSize;
            meshListSize = emptyMeshListSize;
            assetInfo = emptyAssetInfo;
        }

    }
}
