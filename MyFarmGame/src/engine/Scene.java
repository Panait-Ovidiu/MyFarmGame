package engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import engine.graph.Mesh;

public class Scene {

    private Map<Mesh, List<GameItem>> terrainMap;
    private Map<Mesh, List<GameItem>> buildingsMap;
    private Map<Mesh, List<GameItem>> decorationsMap;
    private Map<Mesh, List<GameItem>> plantsMap;
    private Map<Mesh, List<GameItem>> animalsMap;
    private Map<Mesh, List<GameItem>> utilsMap;

    private SkyBox skyBox;
    private SceneLight sceneLight;

    public Scene() {
        terrainMap = new HashMap();
        buildingsMap = new HashMap();
        decorationsMap = new HashMap();
        plantsMap = new HashMap<>();
        animalsMap = new HashMap<>();
        utilsMap = new HashMap<>();
    }

    public Map<Mesh, List<GameItem>> getTerrain() {
        return terrainMap;
    }

    public void setTerrain(GameItem[] gameItems) {
        terrainMap = new HashMap<>();
        int numGameItems = gameItems != null ? gameItems.length : 0;
        for (int i = 0; i < numGameItems; i++) {
            GameItem gameItem = gameItems[i];
            Mesh mesh = gameItem.getMesh();
            List<GameItem> list = terrainMap.get(mesh);
            if (list == null) {
                list = new ArrayList<>();
                terrainMap.put(mesh, list);
            }
            list.add(gameItem);
        }
    }

    public Map<Mesh, List<GameItem>> getBuildings() {
        return buildingsMap;
    }

    public void setBuildings(GameItem[] gameItems) {
        buildingsMap = new HashMap<>();
        int numGameItems = gameItems != null ? gameItems.length : 0;
        for (int i = 0; i < numGameItems; i++) {
            GameItem gameItem = gameItems[i];
            Mesh mesh = gameItem.getMesh();
            List<GameItem> list = buildingsMap.get(mesh);
            if (list == null) {
                list = new ArrayList<>();
                buildingsMap.put(mesh, list);
            }
            list.add(gameItem);
        }
    }

    public Map<Mesh, List<GameItem>> getDecorations() {
        return decorationsMap;
    }

    public void setDecorations(GameItem[] gameItems) {
        decorationsMap = new HashMap<>();
        int numGameItems = gameItems != null ? gameItems.length : 0;
        for (int i = 0; i < numGameItems; i++) {
            GameItem gameItem = gameItems[i];
            Mesh mesh = gameItem.getMesh();
            List<GameItem> list = decorationsMap.get(mesh);
            if (list == null) {
                list = new ArrayList<>();
                decorationsMap.put(mesh, list);
            }
            list.add(gameItem);
        }
    }

    public Map<Mesh, List<GameItem>> getPlants() {
        return plantsMap;
    }

    public void setPlants(GameItem[] gameItems) {
        plantsMap = new HashMap<>();
        int numGameItems = gameItems != null ? gameItems.length : 0;
        for (int i = 0; i < numGameItems; i++) {
            GameItem gameItem = gameItems[i];
            Mesh mesh = gameItem.getMesh();
            List<GameItem> list = plantsMap.get(mesh);
            if (list == null) {
                list = new ArrayList<>();
                plantsMap.put(mesh, list);
            }
            list.add(gameItem);
        }
    }

    public Map<Mesh, List<GameItem>> getAnimals() {
        return animalsMap;
    }

    public void setAnimals(GameItem[] gameItems) {
        animalsMap = new HashMap<>();
        int numGameItems = gameItems != null ? gameItems.length : 0;
        for (int i = 0; i < numGameItems; i++) {
            GameItem gameItem = gameItems[i];
            Mesh mesh = gameItem.getMesh();
            List<GameItem> list = animalsMap.get(mesh);
            if (list == null) {
                list = new ArrayList<>();
                animalsMap.put(mesh, list);
            }
            list.add(gameItem);
        }
    }

    public Map<Mesh, List<GameItem>> getUtils() {
        return utilsMap;
    }

    public void setUtils(GameItem[] gameItems) {
        utilsMap = new HashMap<>();
        int numGameItems = gameItems != null ? gameItems.length : 0;
        for (int i = 0; i < numGameItems; i++) {
            GameItem gameItem = gameItems[i];
            Mesh mesh = gameItem.getMesh();
            List<GameItem> list = utilsMap.get(mesh);
            if (list == null) {
                list = new ArrayList<>();
                utilsMap.put(mesh, list);
            }
            list.add(gameItem);
        }
    }

    public SkyBox getSkyBox() {
        return skyBox;
    }

    public void setSkyBox(SkyBox skyBox) {
        this.skyBox = skyBox;
    }

    public SceneLight getSceneLight() {
        return sceneLight;
    }

    public void setSceneLight(SceneLight sceneLight) {
        this.sceneLight = sceneLight;
    }

    public void updateDirectionalLight() {
        sceneLight.updateDirectionalLight();
    }

}
