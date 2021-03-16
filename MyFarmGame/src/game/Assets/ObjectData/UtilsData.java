package game.Assets.ObjectData;

import engine.GameItem;
import engine.graph.Material;
import engine.graph.Mesh;
import engine.graph.OBJLoader;
import engine.graph.Texture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UtilsData {

    private static final String POINTER_MESH = "/resources/models/Pointer.obj";
    private static final String POINTER_TEXTURE = "textures/PointerTexture.png";
    public static final String POINTER = "POINTER";

    private Map<String, Mesh> utilsMeshes = new HashMap<>();
    private Map<String, GameItem> utilsItems = new HashMap<>();

    private static int utilsMeshesCounter = 0;
    private static int utilsItemsCounter = 0;

    public GameItem pointer;
    public ArrayList<String> utilsItemsIDs = new ArrayList<>();

    public UtilsData() {

    }

    public static int getUtilsMeshesCounter() {
        return utilsMeshesCounter;
    }

    public static int getUtilsItemsCounter() {
        return utilsItemsCounter;
    }

    public Mesh getUtilMesh(String key) {
        return utilsMeshes.get(key);
    }

    public GameItem[] getUtilsItems() {
        return utilsItems.values().toArray(new GameItem[0]);
    }

    public GameItem getUtilsItem(String key) {
        return utilsItems.get(key);
    }

    public void makeUtilsMeshes() {
        Mesh utilsMesh1 = OBJLoader.loadMesh(POINTER_MESH);
        Material utilsMaterial1 = new Material(new Texture(POINTER_TEXTURE), 1.0f);
        utilsMesh1.setMaterial(utilsMaterial1);
        utilsMeshes.put(POINTER, utilsMesh1);
        utilsMeshesCounter++;
    }

    public void addUtilsItem(String itemType, GameItem gameItem) {
        utilsItemsIDs.add("GuiData " + utilsItemsCounter + " " + itemType);
        utilsItems.put(utilsItemsIDs.get(utilsItemsCounter), gameItem);
        utilsItemsCounter++;
    }

    public void makePointerGameItem() {
        pointer = new GameItem(getUtilMesh(POINTER));
        pointer.setPosition(0.0f, 0.0f, 0.0f);
        pointer.setShow(false);
        addUtilsItem(POINTER, pointer);
    }

    public void cleanUp() {
        utilsMeshes.get(POINTER).cleanUp();
    }

}
