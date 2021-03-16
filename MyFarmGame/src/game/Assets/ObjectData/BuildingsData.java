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

public class BuildingsData implements Serializable {

    private static final String CATEGORY_ID = "Building";

    public static final String BIG_BARN_MESH_ID = "Big Barn";
    public static final String BIG_HOUSE_MESH_ID = "Big House";
    public static final String COW_HOUSE_MESH_ID = "Cow House";
    public static final String PICNIC_ROOF_MESH_ID = "Picnic Roof";
    public static final String SILOS_MESH_ID = "Silos";
    public static final String SMALL_BARN_MESH_ID = "Small Barn";
    public static final String SMALL_HOUSE_MESH_ID = "Small House";
    public static final String VEHICLE_GARAGE_MESH_ID = "Vehicle Garage";
    public static final String WATER_TOWER_MESH_ID = "Water Tower";
    public static final String WINDMILL_MESH_ID = "Windmill";
    public static final String WINDMILL_BLADES_MESH_ID = "Windmill Blades";

    private static final String BUILDINGS_TEXTURE = "textures/AllBuildingsTexture.png";

    private static final String BIG_BARN_MESH = "/resources/models/Buildings/BigBarn.obj";
    private static final String BIG_HOUSE_MESH = "/resources/models/Buildings/BigHouse.obj";
    private static final String COW_HOUSE_MESH = "/resources/models/Buildings/CowHouse.obj";
    private static final String PICNIC_ROOF_MESH = "/resources/models/Buildings/PicnicRoof.obj";
    private static final String SILOS_MESH = "/resources/models/Buildings/Silos.obj";
    private static final String SMALL_BARN_MESH = "/resources/models/Buildings/SmallBarn.obj";
    private static final String SMALL_HOUSE_MESH = "/resources/models/Buildings/SmallHouse.obj";
    private static final String VEHICLE_GARAGE_MESH = "/resources/models/Buildings/VehicleGarage.obj";
    private static final String WATER_TOWER_MESH = "/resources/models/Buildings/WaterTower.obj";
    private static final String WINDMILL_MESH = "/resources/models/Buildings/Windmill.obj";
    private static final String WINDMILL_BLADES_MESH = "/resources/models/Buildings/WindmillBlades.obj";

    public AssetList buildingsAssetList = new AssetList();

    public BuildingsData() {

    }

    public void makeBuildingsMeshes() {
        Texture buildingsTexture = new Texture(BUILDINGS_TEXTURE);
        Material material = new Material(buildingsTexture, 0.5f);

        Mesh buildingsMesh1 = OBJLoader.loadMesh(BIG_BARN_MESH);
        buildingsMesh1.setMaterial(material);
        buildingsAssetList.addMesh(BIG_BARN_MESH_ID, buildingsMesh1);

        Mesh buildingsMesh2 = OBJLoader.loadMesh(BIG_HOUSE_MESH);
        buildingsMesh2.setMaterial(material);
        buildingsAssetList.addMesh(BIG_HOUSE_MESH_ID, buildingsMesh2);

        Mesh buildingsMesh3 = OBJLoader.loadMesh(COW_HOUSE_MESH);
        buildingsMesh3.setMaterial(material);
        buildingsAssetList.addMesh(COW_HOUSE_MESH_ID, buildingsMesh3);

        Mesh buildingsMesh4 = OBJLoader.loadMesh(PICNIC_ROOF_MESH);
        buildingsMesh4.setMaterial(material);
        buildingsAssetList.addMesh(PICNIC_ROOF_MESH_ID, buildingsMesh4);

        Mesh buildingsMesh5 = OBJLoader.loadMesh(SILOS_MESH);
        buildingsMesh5.setMaterial(material);
        buildingsAssetList.addMesh(SILOS_MESH_ID, buildingsMesh5);

        Mesh buildingsMesh6 = OBJLoader.loadMesh(SMALL_BARN_MESH);
        buildingsMesh6.setMaterial(material);
        buildingsAssetList.addMesh(SMALL_BARN_MESH_ID, buildingsMesh6);

        Mesh buildingsMesh7 = OBJLoader.loadMesh(SMALL_HOUSE_MESH);
        buildingsMesh7.setMaterial(material);
        buildingsAssetList.addMesh(SMALL_HOUSE_MESH_ID, buildingsMesh7);

        Mesh buildingsMesh8 = OBJLoader.loadMesh(VEHICLE_GARAGE_MESH);
        buildingsMesh8.setMaterial(material);
        buildingsAssetList.addMesh(VEHICLE_GARAGE_MESH_ID, buildingsMesh8);

        Mesh buildingsMesh9 = OBJLoader.loadMesh(WATER_TOWER_MESH);
        buildingsMesh9.setMaterial(material);
        buildingsAssetList.addMesh(WATER_TOWER_MESH_ID, buildingsMesh9);

        Mesh buildingsMesh10 = OBJLoader.loadMesh(WINDMILL_MESH);
        buildingsMesh10.setMaterial(material);
        buildingsAssetList.addMesh(WINDMILL_MESH_ID, buildingsMesh10);

        Mesh buildingsMesh11 = OBJLoader.loadMesh(WINDMILL_BLADES_MESH);
        buildingsMesh11.setMaterial(material);
        buildingsAssetList.addMesh(WINDMILL_BLADES_MESH_ID, buildingsMesh11);
    }

    public GameItem[] getBuildingGameItems() {
        return buildingsAssetList.getGameItems();
    }

    public void setSelectedAsset(SelectedAssetInfo selectedAssetInfo, int assetIndex) {
        buildingsAssetList.setSelectedInfo(selectedAssetInfo, assetIndex);
    }

    public void setMesh(SelectedAssetInfo selectedItemInfo, int meshIndex) {
        buildingsAssetList.setMesh(selectedItemInfo, meshIndex);
    }

    public void setPosition(SelectedAssetInfo selectedItemInfo, Vector3f position) {
        buildingsAssetList.setPosition(selectedItemInfo, position);
    }

    public void setRotation(SelectedAssetInfo selectedItemInfo, Vector3f rotation) {
        buildingsAssetList.setRotation(selectedItemInfo, rotation);
    }

    public void removeBuildingItem(SelectedAssetInfo selectedItemInfo) {
        buildingsAssetList.removeGameItem(CATEGORY_ID, selectedItemInfo);
    }

    public void addBuildingItem(Vector3f position, Vector3f rotation, int meshIndex) {
        buildingsAssetList.addGameItem(CATEGORY_ID, meshIndex, position, rotation);
    }

    public void cleanUp() {
        buildingsAssetList.cleanUp();
    }

    // ====== Save / Load From File ======

    public void loadData() {
        try {
            BufferedReader buf = new BufferedReader(new FileReader("Data/BuildingsData.data"));
            while (true) {
                String line = buf.readLine();
                if (line != null) {
                    String lines[] = line.split("#");
                    // System.out.println(lines[0] + " loading");

                    addBuildingItem(
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
            System.out.println("Buildings File loaded");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Buildings File not found");
        }
    }

    public void saveData() {
        try {
            File file = new File("Data/BuildingsData.data");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter pw = new PrintWriter(file);

            SelectedAssetInfo assetInfo;
            assetInfo = new SelectedAssetInfo();
            int assetsNr = buildingsAssetList.getGameItems().length;
            for (int i = 0; i < assetsNr; i++) {
                setSelectedAsset(assetInfo, i);
                pw.println(assetInfo.getGameItemID() + "#" +
                        buildingsAssetList.getGameItems()[i].getPosition().x + "#" +
                        buildingsAssetList.getGameItems()[i].getPosition().y + "#" +
                        buildingsAssetList.getGameItems()[i].getPosition().z + "#" +
                        buildingsAssetList.getGameItems()[i].getRotation().x + "#" +
                        buildingsAssetList.getGameItems()[i].getRotation().y + "#" +
                        buildingsAssetList.getGameItems()[i].getRotation().z + "#" +
                        assetInfo.getMeshIndex());
            }

            pw.close();
            System.out.println("Buildings File saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
