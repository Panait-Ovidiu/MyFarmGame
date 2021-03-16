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

public class TerrainData implements Serializable {

    private static final String CATEGORY_ID = "Terrain";

    public static final String GRASS_MESH_ID = "Grass";
    public static final String DIRT_MESH_ID = "Dirt";
    public static final String GRASS_DIRT_STRAIGHT_MESH_ID = "Grass To Dirt Straight";
    public static final String GRASS_DIRT_CORNER_MESH_ID = "Grass To Dirt Corner";
    public static final String STONE_MESH_ID = "Stone";
    public static final String CROP_FIELD_TOP_MESH_ID = "CropField Top";
    public static final String CROP_FIELD_MIDDLE_MESH_ID = "CropField Middle";
    public static final String CROP_FIELD_BOTTOM_MESH_ID = "CropField Bottom";
    public static final String ROAD_STRAIGHT_MESH_ID = "Road Straight";
    public static final String ROAD_STRAIGHT_SMALL_MESH_ID = "Road Straight Small";
    public static final String ROAD_THREE_CONNECTION_MESH_ID = "Road Three Connection";
    public static final String ROAD_CORNER_MESH_ID = "Road Corner";
    public static final String ROAD_END_MESH_ID = "Road End";
    public static final String SIDE_WALK_STRAIGHT_MESH_ID = "SideWalk Straight";
    public static final String SIDE_WALK_STRAIGHT_SMALL_MESH_ID = "SideWalk Straight Small";
    public static final String SIDE_WALK_THREE_CONNECTION_MESH_ID = "SideWalk Three Connection";
    public static final String SIDE_WALK_CORNER_MESH_ID = "SideWalk Corner";
    public static final String SIDE_WALK_ONE_MARGIN_END_LEFT_MESH_ID = "SideWalk One Margin End Left";
    public static final String SIDE_WALK_DOOR_SECTION_MESH_ID = "SideWalk Door Section";
    public static final String SIDE_WALK_ONE_MARGIN_END_RIGHT_MESH_ID = "SideWalk One Margin End Right";
    public static final String SIDE_WALK_STAIRS_MARGIN_LEFT_MESH_ID = "SideWalk Stairs Margin Left";
    public static final String SIDE_WALK_STAIRS_MARGIN_RIGHT_MESH_ID = "SideWalk Stairs Margin Right";
    public static final String SIDE_WALK_STAIRS_LEFT_MESH_ID = "SideWalk Stairs Left";
    public static final String SIDE_WALK_STAIRS_LEFT_GRASS_MESH_ID = "SideWalk Stairs Left Grass";
    public static final String SIDE_WALK_STAIRS_RIGHT_MESH_ID = "SideWalk Stairs Right";
    public static final String SIDE_WALK_TWO_MARGIN_END_MESH_ID = "SideWalk Two Margin End";
    public static final String SIDE_WALK_STONE_GRASS_MESH_ID = "SideWalk Stone Grass";
    public static final String SIDE_WALK_DIAGONAL_MARGIN_BIG_LEFT_MESH_ID = "SideWalk Diagonal Margin Big Left";
    public static final String SIDE_WALK_DIAGONAL_MARGIN_BIG_RIGHT_MESH_ID = "SideWalk Diagonal Margin Big Right";
    public static final String SIDE_WALK_DIAGONAL_MARGIN_SMALL_LEFT_MESH_ID = "SideWalk Diagonal Margin Small Left";
    public static final String SIDE_WALK_DIAGONAL_MARGIN_SMALL_RIGHT_MESH_ID = "SideWalk Diagonal Margin Small Right";

    private static final String TERRAIN_TEXTURE = "textures/AllTerrainTexture.png";

    private static final String GRASS_MESH = "/resources/models/Terrain/TerrainGrass.obj";
    private static final String DIRT_MESH = "/resources/models/Terrain/TerrainDirt.obj";
    private static final String GRASS_DIRT_CORNER_MESH = "/resources/models/Terrain/TerrainGrassDirtCorner.obj";
    private static final String GRASS_DIRT_STRAIGHT_MESH = "/resources/models/Terrain/TerrainGrassDirtStraight.obj";
    private static final String STONE_MESH = "/resources/models/Terrain/TerrainStone.obj";
    private static final String CROP_FIELD_TOP_MESH = "/resources/models/Terrain/CropFieldTop.obj";
    private static final String CROP_FIELD_MIDDLE_MESH = "/resources/models/Terrain/CropFieldMiddle.obj";
    private static final String CROP_FIELD_BOTTOM_MESH = "/resources/models/Terrain/CropFieldBottom.obj";
    private static final String ROAD_STRAIGHT_MESH = "/resources/models/Terrain/RoadStraight.obj";
    private static final String ROAD_STRAIGHT_SMALL_MESH = "/resources/models/Terrain/RoadStraightSmall.obj";
    private static final String ROAD_THREE_CONNECTION_MESH = "/resources/models/Terrain/RoadThreeConnection.obj";
    private static final String ROAD_CORNER_MESH = "/resources/models/Terrain/RoadCorner.obj";
    private static final String ROAD_END_MESH = "/resources/models/Terrain/RoadEnd.obj";
    private static final String SIDE_WALK_STRAIGHT_MESH = "/resources/models/Terrain/SideWalkStraight.obj";
    private static final String SIDE_WALK_STRAIGHT_SMALL_MESH = "/resources/models/Terrain/SideWalkStraightSmall.obj";
    private static final String SIDE_WALK_THREE_CONNECTION_MESH = "/resources/models/Terrain/SideWalkThreeConnection.obj";
    private static final String SIDE_WALK_CORNER_MESH = "/resources/models/Terrain/SideWalkCorner.obj";
    private static final String SIDE_WALK_ONE_MARGIN_END_LEFT_MESH = "/resources/models/Terrain/SideWalkOneMarginEndLeft.obj";
    private static final String SIDE_WALK_DOOR_SECTION_MESH = "/resources/models/Terrain/SideWalkDoorSection.obj";
    private static final String SIDE_WALK_ONE_MARGIN_END_RIGHT_MESH = "/resources/models/Terrain/SideWalkOneMarginEndRight.obj";
    private static final String SIDE_WALK_STAIRS_MARGIN_LEFT_MESH = "/resources/models/Terrain/SideWalkStairsMarginLeft.obj";
    private static final String SIDE_WALK_STAIRS_MARGIN_RIGHT_MESH = "/resources/models/Terrain/SideWalkStairsMarginRight.obj";
    private static final String SIDE_WALK_STAIRS_LEFT_MESH = "/resources/models/Terrain/SideWalkStairsLeft.obj";
    private static final String SIDE_WALK_STAIRS_LEFT_GRASS_MESH = "/resources/models/Terrain/SideWalkStairsLeftGrass.obj";
    private static final String SIDE_WALK_STAIRS_RIGHT_MESH = "/resources/models/Terrain/SideWalkStairsRight.obj";
    private static final String SIDE_WALK_TWO_MARGIN_END_MESH = "/resources/models/Terrain/SideWalkTwoMarginEnd.obj";
    private static final String SIDE_WALK_STONE_GRASS_MESH = "/resources/models/Terrain/SideWalkStoneGrass.obj";
    private static final String SIDE_WALK_DIAGONAL_MARGIN_BIG_LEFT_MESH = "/resources/models/Terrain/SideWalkDiagonalMarginBigLeft.obj";
    private static final String SIDE_WALK_DIAGONAL_MARGIN_BIG_RIGHT_MESH = "/resources/models/Terrain/SideWalkDiagonalMarginBigRight.obj";
    private static final String SIDE_WALK_DIAGONAL_MARGIN_SMALL_LEFT_MESH = "/resources/models/Terrain/SideWalkDiagonalMarginSmallLeft.obj";
    private static final String SIDE_WALK_DIAGONAL_MARGIN_SMALL_RIGHT_MESH = "/resources/models/Terrain/SideWalkDiagonalMarginSmallRight.obj";

    public AssetList terrainAssetList = new AssetList();

    public TerrainData() {

    }

    public void makeTerrainMeshes() {
        Texture terrainTexture = new Texture(TERRAIN_TEXTURE);
        Material material = new Material(terrainTexture, 0.5f);

        Mesh terrainMesh1 = OBJLoader.loadMesh(GRASS_MESH);
        terrainMesh1.setMaterial(material);
        terrainAssetList.addMesh(GRASS_MESH_ID, terrainMesh1);

        Mesh terrainMesh2 = OBJLoader.loadMesh(DIRT_MESH);
        terrainMesh2.setMaterial(material);
        terrainAssetList.addMesh(DIRT_MESH_ID, terrainMesh2);

        Mesh terrainMesh3 = OBJLoader.loadMesh(GRASS_DIRT_STRAIGHT_MESH);
        terrainMesh3.setMaterial(material);
        terrainAssetList.addMesh(GRASS_DIRT_STRAIGHT_MESH_ID, terrainMesh3);

        Mesh terrainMesh4 = OBJLoader.loadMesh(GRASS_DIRT_CORNER_MESH);
        terrainMesh4.setMaterial(material);
        terrainAssetList.addMesh(GRASS_DIRT_CORNER_MESH_ID, terrainMesh4);

        Mesh terrainMesh5 = OBJLoader.loadMesh(STONE_MESH);
        terrainMesh5.setMaterial(material);
        terrainAssetList.addMesh(STONE_MESH_ID, terrainMesh5);

        Mesh terrainMesh6 = OBJLoader.loadMesh(CROP_FIELD_TOP_MESH);
        terrainMesh6.setMaterial(material);
        terrainAssetList.addMesh(CROP_FIELD_TOP_MESH_ID, terrainMesh6);

        Mesh terrainMesh7 = OBJLoader.loadMesh(CROP_FIELD_MIDDLE_MESH);
        terrainMesh7.setMaterial(material);
        terrainAssetList.addMesh(CROP_FIELD_MIDDLE_MESH_ID, terrainMesh7);

        Mesh terrainMesh8 = OBJLoader.loadMesh(CROP_FIELD_BOTTOM_MESH);
        terrainMesh8.setMaterial(material);
        terrainAssetList.addMesh(CROP_FIELD_BOTTOM_MESH_ID, terrainMesh8);

        Mesh terrainMesh9 = OBJLoader.loadMesh(ROAD_STRAIGHT_MESH);
        terrainMesh9.setMaterial(material);
        terrainAssetList.addMesh(ROAD_STRAIGHT_MESH_ID, terrainMesh9);

        Mesh terrainMesh10 = OBJLoader.loadMesh(ROAD_STRAIGHT_SMALL_MESH);
        terrainMesh10.setMaterial(material);
        terrainAssetList.addMesh(ROAD_STRAIGHT_SMALL_MESH_ID, terrainMesh10);

        Mesh terrainMesh11 = OBJLoader.loadMesh(ROAD_THREE_CONNECTION_MESH);
        terrainMesh11.setMaterial(material);
        terrainAssetList.addMesh(ROAD_THREE_CONNECTION_MESH_ID, terrainMesh11);

        Mesh terrainMesh12 = OBJLoader.loadMesh(ROAD_CORNER_MESH);
        terrainMesh12.setMaterial(material);
        terrainAssetList.addMesh(ROAD_CORNER_MESH_ID, terrainMesh12);

        Mesh terrainMesh13 = OBJLoader.loadMesh(ROAD_END_MESH);
        terrainMesh13.setMaterial(material);
        terrainAssetList.addMesh(ROAD_END_MESH_ID, terrainMesh13);

        Mesh terrainMesh14 = OBJLoader.loadMesh(SIDE_WALK_STRAIGHT_MESH);
        terrainMesh14.setMaterial(material);
        terrainAssetList.addMesh(SIDE_WALK_STRAIGHT_MESH_ID, terrainMesh14);

        Mesh terrainMesh15 = OBJLoader.loadMesh(SIDE_WALK_STRAIGHT_SMALL_MESH);
        terrainMesh15.setMaterial(material);
        terrainAssetList.addMesh(SIDE_WALK_STRAIGHT_SMALL_MESH_ID, terrainMesh15);

        Mesh terrainMesh16 = OBJLoader.loadMesh(SIDE_WALK_THREE_CONNECTION_MESH);
        terrainMesh16.setMaterial(material);
        terrainAssetList.addMesh(SIDE_WALK_THREE_CONNECTION_MESH_ID, terrainMesh16);

        Mesh terrainMesh17 = OBJLoader.loadMesh(SIDE_WALK_CORNER_MESH);
        terrainMesh17.setMaterial(material);
        terrainAssetList.addMesh(SIDE_WALK_CORNER_MESH_ID, terrainMesh17);

        Mesh terrainMesh18 = OBJLoader.loadMesh(SIDE_WALK_ONE_MARGIN_END_LEFT_MESH);
        terrainMesh18.setMaterial(material);
        terrainAssetList.addMesh(SIDE_WALK_ONE_MARGIN_END_LEFT_MESH_ID, terrainMesh18);

        Mesh terrainMesh19 = OBJLoader.loadMesh(SIDE_WALK_DOOR_SECTION_MESH);
        terrainMesh19.setMaterial(material);
        terrainAssetList.addMesh(SIDE_WALK_DOOR_SECTION_MESH_ID, terrainMesh19);

        Mesh terrainMesh20 = OBJLoader.loadMesh(SIDE_WALK_ONE_MARGIN_END_RIGHT_MESH);
        terrainMesh20.setMaterial(material);
        terrainAssetList.addMesh(SIDE_WALK_ONE_MARGIN_END_RIGHT_MESH_ID, terrainMesh20);

        Mesh terrainMesh21 = OBJLoader.loadMesh(SIDE_WALK_STAIRS_MARGIN_LEFT_MESH);
        terrainMesh21.setMaterial(material);
        terrainAssetList.addMesh(SIDE_WALK_STAIRS_MARGIN_LEFT_MESH_ID, terrainMesh21);

        Mesh terrainMesh22 = OBJLoader.loadMesh(SIDE_WALK_STAIRS_MARGIN_RIGHT_MESH);
        terrainMesh22.setMaterial(material);
        terrainAssetList.addMesh(SIDE_WALK_STAIRS_MARGIN_RIGHT_MESH_ID, terrainMesh22);

        Mesh terrainMesh23 = OBJLoader.loadMesh(SIDE_WALK_STAIRS_LEFT_MESH);
        terrainMesh23.setMaterial(material);
        terrainAssetList.addMesh(SIDE_WALK_STAIRS_LEFT_MESH_ID, terrainMesh23);

        Mesh terrainMesh24 = OBJLoader.loadMesh(SIDE_WALK_STAIRS_LEFT_GRASS_MESH);
        terrainMesh24.setMaterial(material);
        terrainAssetList.addMesh(SIDE_WALK_STAIRS_LEFT_GRASS_MESH_ID, terrainMesh24);

        Mesh terrainMesh25 = OBJLoader.loadMesh(SIDE_WALK_STAIRS_RIGHT_MESH);
        terrainMesh25.setMaterial(material);
        terrainAssetList.addMesh(SIDE_WALK_STAIRS_RIGHT_MESH_ID, terrainMesh25);

        Mesh terrainMesh26 = OBJLoader.loadMesh(SIDE_WALK_TWO_MARGIN_END_MESH);
        terrainMesh26.setMaterial(material);
        terrainAssetList.addMesh(SIDE_WALK_TWO_MARGIN_END_MESH_ID, terrainMesh26);

        Mesh terrainMesh27 = OBJLoader.loadMesh(SIDE_WALK_STONE_GRASS_MESH);
        terrainMesh27.setMaterial(material);
        terrainAssetList.addMesh(SIDE_WALK_STONE_GRASS_MESH_ID, terrainMesh27);

        Mesh terrainMesh28 = OBJLoader.loadMesh(SIDE_WALK_DIAGONAL_MARGIN_BIG_LEFT_MESH);
        terrainMesh28.setMaterial(material);
        terrainAssetList.addMesh(SIDE_WALK_DIAGONAL_MARGIN_BIG_LEFT_MESH_ID, terrainMesh28);

        Mesh terrainMesh29 = OBJLoader.loadMesh(SIDE_WALK_DIAGONAL_MARGIN_BIG_RIGHT_MESH);
        terrainMesh29.setMaterial(material);
        terrainAssetList.addMesh(SIDE_WALK_DIAGONAL_MARGIN_BIG_RIGHT_MESH_ID, terrainMesh29);

        Mesh terrainMesh30 = OBJLoader.loadMesh(SIDE_WALK_DIAGONAL_MARGIN_SMALL_LEFT_MESH);
        terrainMesh30.setMaterial(material);
        terrainAssetList.addMesh(SIDE_WALK_DIAGONAL_MARGIN_SMALL_LEFT_MESH_ID, terrainMesh30);

        Mesh terrainMesh31 = OBJLoader.loadMesh(SIDE_WALK_DIAGONAL_MARGIN_SMALL_RIGHT_MESH);
        terrainMesh31.setMaterial(material);
        terrainAssetList.addMesh(SIDE_WALK_DIAGONAL_MARGIN_SMALL_RIGHT_MESH_ID, terrainMesh31);

    }

    public GameItem[] getTerrainGameItems() {
        return terrainAssetList.getGameItems();
    }

    public void setSelectedAsset(SelectedAssetInfo selectedAssetInfo, int assetIndex) {
        terrainAssetList.setSelectedInfo(selectedAssetInfo, assetIndex);
    }

    public void setMesh(SelectedAssetInfo selectedItemInfo, int meshIndex) {
        terrainAssetList.setMesh(selectedItemInfo, meshIndex);
    }

    public void setPosition(SelectedAssetInfo selectedItemInfo, Vector3f position) {
        terrainAssetList.setPosition(selectedItemInfo, position);
    }

    public void setRotation(SelectedAssetInfo selectedItemInfo, Vector3f rotation) {
        terrainAssetList.setRotation(selectedItemInfo, rotation);
    }

    public void removeTerrainItem(SelectedAssetInfo selectedItemInfo) {
        terrainAssetList.removeGameItem(CATEGORY_ID, selectedItemInfo);
    }

    public void addTerrainItem(Vector3f position, Vector3f rotation, int meshIndex) {
        terrainAssetList.addGameItem(CATEGORY_ID, meshIndex, position, rotation);
    }

    public void cleanUp() {
        terrainAssetList.cleanUp();
    }

    // ====== Save / Load From File ======

    public void loadData() {
        try {
            BufferedReader buf = new BufferedReader(new FileReader("Data/TerrainData.data"));
            while (true) {
                String line = buf.readLine();
                if (line != null) {
                    String lines[] = line.split("#");
                    // System.out.println(lines[0] + " loading");

                    addTerrainItem(
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
            System.out.println("Terrain File loaded");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Terrain File not found");
        }
    }

    public void saveData() {
        try {
            File file = new File("Data/TerrainData.data");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter pw = new PrintWriter(file);

            SelectedAssetInfo assetInfo;
            assetInfo = new SelectedAssetInfo();
            int assetsNr = terrainAssetList.getGameItems().length;
            for (int i = 0; i < assetsNr; i++) {
                setSelectedAsset(assetInfo, i);
                pw.println(assetInfo.getGameItemID() + "#" +
                        terrainAssetList.getGameItems()[i].getPosition().x + "#" +
                        terrainAssetList.getGameItems()[i].getPosition().y + "#" +
                        terrainAssetList.getGameItems()[i].getPosition().z + "#" +
                        terrainAssetList.getGameItems()[i].getRotation().x + "#" +
                        terrainAssetList.getGameItems()[i].getRotation().y + "#" +
                        terrainAssetList.getGameItems()[i].getRotation().z + "#" +
                        assetInfo.getMeshIndex());
            }

            pw.close();
            System.out.println("Terrain File saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
