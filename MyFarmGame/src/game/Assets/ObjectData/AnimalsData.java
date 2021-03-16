package game.Assets.ObjectData;

import engine.GameItem;
import engine.graph.Material;
import engine.graph.Mesh;
import engine.graph.OBJLoader;
import engine.graph.Texture;
import game.Assets.AssetList;
import game.Gui.InterfaceAdmin.AdminGuiInterface.SelectedAssetInfo;
import org.joml.Vector3f;

import java.io.*;

public class AnimalsData {

    public static final String CATEGORY_ID = "Animals";

    public static final String ANIMAL_MESH_ID = "Animals";

    private static final String ANIMALS_TEXTURE = "textures/blackTexture.png";

    private static final String ANIMAL_MESH = "/resources/models/Pointer.obj";

    public AssetList animalsAssetList = new AssetList();

    public AnimalsData() {

    }

    public void makeAnimalMeshes() {
        Texture animalsTexture = new Texture(ANIMALS_TEXTURE);
        Material material = new Material(animalsTexture, 0.5f);

        Mesh plantsMesh1 = OBJLoader.loadMesh(ANIMAL_MESH);
        plantsMesh1.setMaterial(material);
        animalsAssetList.addMesh(ANIMAL_MESH_ID, plantsMesh1);
    }

    public GameItem[] getAnimalGameItems() {
        return animalsAssetList.getGameItems();
    }

    public void setSelectedAsset(SelectedAssetInfo selectedAssetInfo, int assetIndex) {
        animalsAssetList.setSelectedInfo(selectedAssetInfo, assetIndex);
    }

    public void setMesh(SelectedAssetInfo selectedItemInfo, int meshIndex) {
        animalsAssetList.setMesh(selectedItemInfo, meshIndex);
    }

    public void setPosition(SelectedAssetInfo selectedItemInfo, Vector3f position) {
        animalsAssetList.setPosition(selectedItemInfo, position);
    }

    public void setRotation(SelectedAssetInfo selectedItemInfo, Vector3f rotation) {
        animalsAssetList.setRotation(selectedItemInfo, rotation);
    }

    public void removeAnimalItem(SelectedAssetInfo selectedItemInfo) {
        animalsAssetList.removeGameItem(CATEGORY_ID, selectedItemInfo);
    }

    public void addAnimalItem(Vector3f position, Vector3f rotation, int meshIndex) {
        animalsAssetList.addGameItem(CATEGORY_ID, meshIndex, position, rotation);
    }

    public void cleanUp() {
        animalsAssetList.cleanUp();
    }

    // ====== Save / Load From File ======

    public void loadData() {
        try {
            File file = new File("Data/AnimalsData.data");

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedReader buf = new BufferedReader(new FileReader("Data/AnimalsData.data"));
            while (true) {
                String line = buf.readLine();
                if (line != null) {
                    String lines[] = line.split("#");
                    // System.out.println(lines[0] + " loading");

                    addAnimalItem(
                            new Vector3f(Float.parseFloat(lines[1]),
                                    Float.parseFloat(lines[2]),
                                    Float.parseFloat(lines[3])),
                            new Vector3f(Float.parseFloat(lines[4]),
                                    Float.parseFloat(lines[5]), Float.parseFloat(lines[6])),
                            Integer.parseInt(lines[7]));

                } else {
                    break;
                }
            }

            buf.close();
            System.out.println("Animals File loaded");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Animals File not found");
        }
    }

    public void saveData() {
        try {
            File file = new File("Data/AnimalsData.data");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter pw = new PrintWriter(file);

            SelectedAssetInfo assetInfo;
            assetInfo = new SelectedAssetInfo();
            int assetsNr = animalsAssetList.getGameItems().length;
            for (int i = 0; i < assetsNr; i++) {
                setSelectedAsset(assetInfo, i);
                pw.println(assetInfo.getGameItemID() + "#" +
                        animalsAssetList.getGameItems()[i].getPosition().x + "#" +
                        animalsAssetList.getGameItems()[i].getPosition().y + "#" +
                        animalsAssetList.getGameItems()[i].getPosition().z + "#" +
                        animalsAssetList.getGameItems()[i].getRotation().x + "#" +
                        animalsAssetList.getGameItems()[i].getRotation().y + "#" +
                        animalsAssetList.getGameItems()[i].getRotation().z + "#" +
                        assetInfo.getMeshIndex());
            }

            pw.close();
            System.out.println("Animals File saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
