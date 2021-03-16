package game;

import engine.*;
import engine.graph.*;
import game.Assets.AssetManager;
import game.Gui.InterfaceAdmin.AdminGuiInterface;
import game.Gui.InterfaceGamePlay.GamePlayGuiInterface;
import game.Gui.GuiInterface;
import game.Gui.InterfaceIntro.IntroGuiInterface;
import game.Gui.InterfaceMainMenu.MainMenuGuiInterface;
import org.joml.Vector2f;
import org.joml.Vector3f;

import static org.lwjgl.glfw.GLFW.*;

public class MyFarmGame implements IGameLogic {

    private static final String GAME_NAME = "MyFarm";
    private static final boolean ADMIN_MODE = true;

    private static final Vector3f CAMERA_START_POSITION = new Vector3f(82.0f, 25.0f, -29.0f);
    private static final Vector3f CAMERA_START_ROTATION = new Vector3f(21.0f, -88.0f, 0);
    private static final Vector3f CAMERA_INC = new Vector3f(0.0f, 0.f, 0.0f);
    private static final float MOUSE_SENSITIVITY = 0.2f;
    private static final float CAMERA_POS_STEP = 0.05f;

    private static final int NO_SCENE = -1;
    private static final int INTRO_SCREEN = 0;
    private static final int MAIN_MENU_SCREEN = 1;
    private static final int GAME_PLAY_SCREEN = 2;
    private static final int ADMIN_SCREEN = 3;

    private Window window;
    private final Renderer RENDERER;
    private final Camera CAMERA;

    private int currentScreen;
    public Scene currentScene;

    private GuiInterface currentGuiInterface;
    private GuiInterface introGuiInterface;
    private GuiInterface mainMenuGuiInterface;
    private GuiInterface gamePlayGuiInterface;
    private GuiInterface adminGuiInterface;

    private int startCounter;
    private int plantCounter = 0;
    private int plantStagesCounter = 0;

    private boolean waterSwitch = true;
    private int waterCounter = 0;

    public MyFarmGame() {
        currentScreen = NO_SCENE;
        RENDERER = new Renderer();
        CAMERA = new Camera();
    }

    @Override
    public void init(Window window) throws Exception {
        this.window = window;
        RENDERER.init(window);

        currentScene = new Scene();
        currentGuiInterface = new GuiInterface(GAME_NAME, window, this);

        AssetManager.setDefaultAssets();
        setupLights();

        setIntroScreen();
    }

    public void setIntroScreen() {
        currentScreen = INTRO_SCREEN;
        startCounter = 0;

        try {
            introGuiInterface = new IntroGuiInterface(GAME_NAME, window, this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        currentGuiInterface = introGuiInterface;

        CAMERA.setPosition(CAMERA_START_POSITION.x, CAMERA_START_POSITION.y, CAMERA_START_POSITION.z);
        CAMERA.setRotation(CAMERA_START_ROTATION.x, CAMERA_START_ROTATION.y, CAMERA_START_ROTATION.z);
    }

    public void setMainMenuScreen() {
        currentScreen = MAIN_MENU_SCREEN;
        startCounter = 0;

        try {
            mainMenuGuiInterface = new MainMenuGuiInterface(GAME_NAME, window, this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        currentGuiInterface = mainMenuGuiInterface;

        CAMERA.setPosition(78, 3, 9);
        CAMERA.setRotation(5, 703, 0);
    }

    public void setGamePlayScreen() {
        currentScreen = GAME_PLAY_SCREEN;

        try {
            gamePlayGuiInterface = new GamePlayGuiInterface(GAME_NAME, window, this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        currentGuiInterface = gamePlayGuiInterface;

        CAMERA.setPosition(CAMERA_START_POSITION.x, CAMERA_START_POSITION.y, CAMERA_START_POSITION.z);
        CAMERA.setRotation(CAMERA_START_ROTATION.x, CAMERA_START_ROTATION.y, CAMERA_START_ROTATION.z);
    }

    public void setAdminScreen() {
        currentScreen = ADMIN_SCREEN;

        try {
            adminGuiInterface = new AdminGuiInterface(GAME_NAME, window, this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        currentGuiInterface = adminGuiInterface;

        CAMERA.setPosition(CAMERA_START_POSITION.x, CAMERA_START_POSITION.y, CAMERA_START_POSITION.z);
        CAMERA.setRotation(CAMERA_START_ROTATION.x, CAMERA_START_ROTATION.y, CAMERA_START_ROTATION.z);
    }

    private void setupLights() {
        SceneLight sceneLight = new SceneLight();

        // Ambient Light
        sceneLight.setAmbientLight(new Vector3f(1.0f, 1.0f, 1.0f));

        // Directional Light
        float lightIntensity = 1.0f;
        Vector3f lightPosition = new Vector3f(-1, 0, 0);
        sceneLight.setDirectionalLight(new DirectionalLight(new Vector3f(1, 1, 1), lightPosition, lightIntensity));

        currentScene.setSceneLight(sceneLight);
    }

    public static boolean isAdminMode() {
        return ADMIN_MODE;
    }

    @Override
    public void input(Window window, MouseInput mouseInput) {
        CAMERA_INC.set(0, 0, 0);
        if (window.isKeyPressed(GLFW_KEY_W)) {
            CAMERA_INC.z = -10;
        } else if (window.isKeyPressed(GLFW_KEY_S)) {
            CAMERA_INC.z = 10;
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            CAMERA_INC.x = -10;
        } else if (window.isKeyPressed(GLFW_KEY_D)) {
            CAMERA_INC.x = 10;
        }
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            CAMERA_INC.y = -10;
        } else if (window.isKeyPressed(GLFW_KEY_E)) {
            CAMERA_INC.y = 10;
        }

        // MOUSE
        if (mouseInput.isInWindow() && mouseInput.getCurrentPos().y < 5) {
            mouseInput.setVResizeCursor(window);
            CAMERA_INC.z = -10;
        } else if (mouseInput.isInWindow() && mouseInput.getCurrentPos().y > window.getHeight() - 5) {
            mouseInput.setVResizeCursor(window);
            CAMERA_INC.z = 10;
        } else if (mouseInput.isInWindow() && mouseInput.getCurrentPos().x < 5) {
            mouseInput.setHResizeCursor(window);
            CAMERA_INC.x = -10;
        } else if (mouseInput.isInWindow() && mouseInput.getCurrentPos().x > window.getWidth() - 5) {
            mouseInput.setHResizeCursor(window);
            CAMERA_INC.x = 10;
        } else {
            mouseInput.setNormalCursor(window);
        }

        currentGuiInterface.input(window, mouseInput, CAMERA);
    }

    @Override
    public void update(float interval, MouseInput mouseInput) {
        if (currentScreen == INTRO_SCREEN) {
            if (startCounter == 200) {
                AssetManager.setAssets(currentScene);
                setMainMenuScreen();
            }
            startCounter++;
        }

        currentScene.updateDirectionalLight();

        if (currentScreen == MAIN_MENU_SCREEN) {

            AssetManager.decorationsData.getDecorationGameItems()[295].setShow(false);
            AssetManager.decorationsData.getDecorationGameItems()[296].setShow(false);

            // Move Windmill Blades
            if (AssetManager.buildingsData.getBuildingGameItems()[10].getRotation().x == 360) {
                AssetManager.buildingsData.getBuildingGameItems()[10].setRotation(
                        0.0f + 2.0f,
                        AssetManager.buildingsData.getBuildingGameItems()[10].getRotation().y,
                        AssetManager.buildingsData.getBuildingGameItems()[10].getRotation().z);
            } else {
                AssetManager.buildingsData.getBuildingGameItems()[10].setRotation(
                        AssetManager.buildingsData.getBuildingGameItems()[10].getRotation().x + 2.0f,
                        AssetManager.buildingsData.getBuildingGameItems()[10].getRotation().y,
                        AssetManager.buildingsData.getBuildingGameItems()[10].getRotation().z);
            }

            if (startCounter == 50) {
                startCounter = 0;
                for (int i = 0; i < 16; i++) {
                    for (int j = 0; j < 10; j++) {
                        for (int k = 0; k < 2; k++) {
                            if (j == plantCounter && k == plantStagesCounter) {
                                AssetManager.plantsData.getFieldsArray()[i][j][k].setShow(true);
                            } else {
                                AssetManager.plantsData.getFieldsArray()[i][j][k].setShow(false);
                            }
                        }
                    }
                }
                plantStagesCounter++;
                if (plantStagesCounter == 2) {
                    plantStagesCounter = 0;
                    plantCounter++;
                }
                if (plantCounter == 10) {
                    plantCounter = 0;
                }
            }
            startCounter++;

        } else if (currentScreen == GAME_PLAY_SCREEN) {
            // == Update moving Objects
            // Move Windmill Blades
            if (AssetManager.buildingsData.getBuildingGameItems()[10].getRotation().x == 360) {
                AssetManager.buildingsData.getBuildingGameItems()[10].setRotation(
                        0.0f + 2.0f,
                        AssetManager.buildingsData.getBuildingGameItems()[10].getRotation().y,
                        AssetManager.buildingsData.getBuildingGameItems()[10].getRotation().z);
            } else {
                AssetManager.buildingsData.getBuildingGameItems()[10].setRotation(
                        AssetManager.buildingsData.getBuildingGameItems()[10].getRotation().x + 2.0f,
                        AssetManager.buildingsData.getBuildingGameItems()[10].getRotation().y,
                        AssetManager.buildingsData.getBuildingGameItems()[10].getRotation().z);
            }

            // Move Water Obj
            for (int i = 0; i < 72; i++) {
                if (AssetManager.decorationsData.getDecorationGameItems()[i].getPosition().x > 175.0f) {
                    AssetManager.decorationsData.getDecorationGameItems()[i].setPosition(
                            -175.0f,
                            AssetManager.decorationsData.getDecorationGameItems()[i].getPosition().y,
                            AssetManager.decorationsData.getDecorationGameItems()[i].getPosition().z);
                }
                if (i <= 35) {
                    AssetManager.decorationsData.getDecorationGameItems()[i].setPosition(
                            AssetManager.decorationsData.getDecorationGameItems()[i].getPosition().x + 0.050000f,
                            AssetManager.decorationsData.getDecorationGameItems()[i].getPosition().y,
                            AssetManager.decorationsData.getDecorationGameItems()[i].getPosition().z);
                }
                if (i > 35) {
                    AssetManager.decorationsData.getDecorationGameItems()[i].setPosition(
                            AssetManager.decorationsData.getDecorationGameItems()[i].getPosition().x + 0.050000f,
                            AssetManager.decorationsData.getDecorationGameItems()[i].getPosition().y,
                            AssetManager.decorationsData.getDecorationGameItems()[i].getPosition().z);
                }
            }

            // Switch Water Obj
            waterCounter++;
            if (waterCounter >= 20) {
                waterCounter = 0;
                for (int i = 0; i < 72; i++) {
                    if (i <= 35) {
                        AssetManager.decorationsData.getDecorationGameItems()[i].setShow(waterSwitch);
                    }
                    if (i > 35) {
                        AssetManager.decorationsData.getDecorationGameItems()[i].setShow(!waterSwitch);
                    }
                }
                waterSwitch = !waterSwitch;
            }

            // Update CAMERA based on mouse
            if (mouseInput.isRightButtonPressed()) {
                Vector2f rotVec = mouseInput.getDisplacementVec();
                CAMERA.moveRotation(rotVec.x * MOUSE_SENSITIVITY, rotVec.y * MOUSE_SENSITIVITY, 0);
            }

            // Update CAMERA position
            CAMERA.movePosition(CAMERA_INC.x * CAMERA_POS_STEP, CAMERA_INC.y * CAMERA_POS_STEP, CAMERA_INC.z * CAMERA_POS_STEP);

            if (CAMERA.getPosition().x > 95.0f) {
                CAMERA.setPosition(95.0f, CAMERA.getPosition().y, CAMERA.getPosition().z);
            }
            if (CAMERA.getPosition().x < -95.0f) {
                CAMERA.setPosition(-95.0f, CAMERA.getPosition().y, CAMERA.getPosition().z);
            }
            if (CAMERA.getPosition().y > 35) {
                CAMERA.setPosition(CAMERA.getPosition().x, 35.0f, CAMERA.getPosition().z);
            }
            if (CAMERA.getPosition().y < 1.0f) {
                CAMERA.setPosition(CAMERA.getPosition().x, 1.0f, CAMERA.getPosition().z);
            }
            if (CAMERA.getPosition().z > 95.0f) {
                CAMERA.setPosition(CAMERA.getPosition().x, CAMERA.getPosition().y, 95.0f);
            }
            if (CAMERA.getPosition().z < -95.0f) {
                CAMERA.setPosition(CAMERA.getPosition().x, CAMERA.getPosition().y, -95.0f);
            }

        } else if (currentScreen == ADMIN_SCREEN) {
            // Update CAMERA based on mouse
            if (mouseInput.isRightButtonPressed()) {
                Vector2f rotVec = mouseInput.getDisplacementVec();
                CAMERA.moveRotation(rotVec.x * MOUSE_SENSITIVITY, rotVec.y * MOUSE_SENSITIVITY, 0);
            }

            // Update CAMERA position
            CAMERA.movePosition(CAMERA_INC.x * CAMERA_POS_STEP, CAMERA_INC.y * CAMERA_POS_STEP, CAMERA_INC.z * CAMERA_POS_STEP);
            /*
            if (CAMERA.getPosition().x > 95.0f) {
                CAMERA.setPosition(95.0f, CAMERA.getPosition().y, CAMERA.getPosition().z);
            }
            if (CAMERA.getPosition().x < -95.0f) {
                CAMERA.setPosition(-95.0f, CAMERA.getPosition().y, CAMERA.getPosition().z);
            }
            if (CAMERA.getPosition().y > 35) {
                CAMERA.setPosition(CAMERA.getPosition().x, 35.0f, CAMERA.getPosition().z);
            }
            if (CAMERA.getPosition().y < 1.0f) {
                CAMERA.setPosition(CAMERA.getPosition().x, 1.0f, CAMERA.getPosition().z);
            }
            if (CAMERA.getPosition().z > 95.0f) {
                CAMERA.setPosition(CAMERA.getPosition().x, CAMERA.getPosition().y, 95.0f);
            }
            if (CAMERA.getPosition().z < -95.0f) {
                CAMERA.setPosition(CAMERA.getPosition().x, CAMERA.getPosition().y, -95.0f);
            }
             */
        }

        currentGuiInterface.update(mouseInput, CAMERA);
    }

    @Override
    public void render(Window window) {
        currentGuiInterface.updateSize(window);
        RENDERER.render(window, CAMERA, currentScene, currentGuiInterface);
    }

    @Override
    public void cleanUp() {
        RENDERER.cleanUp();
        currentGuiInterface.cleanUp();
        AssetManager.cleanUp();
    }
}
