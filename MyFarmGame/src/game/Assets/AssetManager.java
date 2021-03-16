package game.Assets;

import engine.*;
import engine.graph.Texture;
import game.Assets.ObjectData.*;
import game.Assets.GuiData.GuiTextures;

import java.util.HashMap;
import java.util.Map;

public class AssetManager {

    private static Map<String, Texture> guiTextures = new HashMap<>();

    public static TerrainData terrainData = new TerrainData();
    public static BuildingsData buildingsData = new BuildingsData();
    public static DecorationsData decorationsData = new DecorationsData();
    public static PlantsData plantsData = new PlantsData();
    public static AnimalsData animalsData = new AnimalsData();
    public static UtilsData utilsData = new UtilsData();

    public AssetManager() {

    }

    public static Texture getGuiTextures(String key) {
        return guiTextures.get(key);
    }

    public static void setDefaultAssets() {
        for (GuiTextures textureFilesPath : GuiTextures.values()) {
            Texture texture = new Texture(textureFilesPath.getTexturePath());
            guiTextures.put(textureFilesPath.getName(), texture);
        }
    }

    public static void setAssets(Scene currentScene) {
        setDefaultAssets();

        terrainData.makeTerrainMeshes();
        terrainData.loadData();
        if (terrainData.getTerrainGameItems().length > 0) {
            currentScene.setTerrain(terrainData.getTerrainGameItems());
        }

        buildingsData.makeBuildingsMeshes();
        buildingsData.loadData();
        if (buildingsData.getBuildingGameItems().length > 0) {
            currentScene.setBuildings(buildingsData.getBuildingGameItems());
        }

        decorationsData.makeDecorationsMeshes();
        decorationsData.loadData();
        if (decorationsData.getDecorationGameItems().length > 0) {
            currentScene.setDecorations(decorationsData.getDecorationGameItems());
        }

        plantsData.makePlantMeshes();
        plantsData.loadData();
        plantsData.makeFieldArray();
        if (plantsData.getPlantGameItems().length > 0) {
            currentScene.setPlants(plantsData.getPlantGameItems());
        }

        animalsData.makeAnimalMeshes();
        animalsData.loadData();
        if (animalsData.getAnimalGameItems().length > 0) {
            currentScene.setAnimals(animalsData.getAnimalGameItems());
        }

        utilsData.makeUtilsMeshes();
        utilsData.makePointerGameItem();
        if (utilsData.getUtilsItems().length > 0) {
            currentScene.setUtils(utilsData.getUtilsItems());
        }

        /*
        decorationsData.getDecorationGameItems()[643].setPosition(
                decorationsData.getDecorationGameItems()[643].getPosition().x+ decorationsData.TRUCK_WHEELS_BACK_X,
                decorationsData.getDecorationGameItems()[643].getPosition().y + decorationsData.TRUCK_WHEELS_Y,
                decorationsData.getDecorationGameItems()[643].getPosition().z);

        decorationsData.getDecorationGameItems()[644].setPosition(
                decorationsData.getDecorationGameItems()[644].getPosition().x+ decorationsData.TRUCK_WHEELS_FRONT_X,
                decorationsData.getDecorationGameItems()[644].getPosition().y + decorationsData.TRUCK_WHEELS_Y,
                decorationsData.getDecorationGameItems()[644].getPosition().z);

         */

        // Setup  SkyBox
        try {
            SkyBox skyBox = new SkyBox("/resources/models/skybox.obj", "textures/skyboxDay.png");
            skyBox.setScale(350.0f);
            currentScene.setSkyBox(skyBox);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cleanUp() {
        if (guiTextures.size() > 0) {
            for (GuiTextures textures : GuiTextures.values()) {
                guiTextures.get(textures.getName()).cleanUp();
                guiTextures.remove(textures.getName());
            }
        }
        terrainData.cleanUp();
        buildingsData.cleanUp();
        decorationsData.cleanUp();
        plantsData.cleanUp();
        animalsData.cleanUp();
        utilsData.cleanUp();
    }

}
