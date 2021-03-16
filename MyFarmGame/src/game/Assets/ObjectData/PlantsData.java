package game.Assets.ObjectData;

import engine.GameItem;
import engine.graph.Material;
import engine.graph.Mesh;
import engine.graph.OBJLoader;
import engine.graph.Texture;
import game.Assets.AssetList;
import game.Data.Planted;
import game.Gui.InterfaceAdmin.AdminGuiInterface.SelectedAssetInfo;
import org.joml.Vector3f;

import java.io.*;

public class PlantsData {

    public static final String CATEGORY_ID = "Plants";

    public static final String FIELD_CABBAGE_BIG_MESH_ID = "Field Cabbage Big";
    public static final String FIELD_CABBAGE_SMALL_MESH_ID = "Field Cabbage Small";
    public static final String FIELD_CARROT_BIG_MESH_ID = "Field Carrot Big";
    public static final String FIELD_CARROT_SMALL_MESH_ID = "Field Carrot Small";
    public static final String FIELD_CORN_BIG_MESH_ID = "Field Corn Big";
    public static final String FIELD_CORN_SMALL_MESH_ID = "Field Corn Small";
    public static final String FIELD_EGGPLANT_BIG_MESH_ID = "Field Eggplant Big";
    public static final String FIELD_EGGPLANT_SMALL_MESH_ID = "Field Eggplant Small";
    public static final String FIELD_ONION_BIG_MESH_ID = "Field Onion Big";
    public static final String FIELD_ONION_SMALL_MESH_ID = "Field Onion Small";
    public static final String FIELD_PEPPER_BIG_MESH_ID = "Field Pepper Big";
    public static final String FIELD_PEPPER_SMALL_MESH_ID = "Field Pepper Small";
    public static final String FIELD_PUMPKIN_BIG_MESH_ID = "Field Pumpkin Big";
    public static final String FIELD_PUMPKIN_SMALL_MESH_ID = "Field Pumpkin Small";
    public static final String FIELD_SUNFLOWER_BIG_MESH_ID = "Field Sunflower Big";
    public static final String FIELD_SUNFLOWER_SMALL_MESH_ID = "Field Sunflower Small";
    public static final String FIELD_TOMATO_BIG_MESH_ID = "Field Tomato Big";
    public static final String FIELD_TOMATO_SMALL_MESH_ID = "Field Tomato Small";
    public static final String FIELD_WATERMELON_BIG_MESH_ID = "Field Watermelon Big";
    public static final String FIELD_WATERMELON_SMALL_MESH_ID = "Field Watermelon Small";
    public static final String TREE_MESH_ID = "Tree";
    public static final String APPLES_BIG_MESH_ID = "Apples Big";
    public static final String APPLES_SMALL_MESH_ID = "Apples Small";
    public static final String APRICOTS_BIG_MESH_ID = "Apricots Big";
    public static final String APRICOTS_SMALL_MESH_ID = "Apricots Small";
    public static final String PEARS_BIG_MESH_ID = "Pears Big";
    public static final String PEARS_SMALL_MESH_ID = "Pears Small";
    public static final String APPLE_MESH_ID = "Apple";
    public static final String APRICOT_MESH_ID = "Apricot";
    public static final String PEAR_MESH_ID = "Pear";
    public static final String CABBAGE_MESH_ID = "Cabbage";
    public static final String CARROT_MESH_ID = "Carrot";
    public static final String CORN_MESH_ID = "Corn";
    public static final String EGGPLANT_MESH_ID = "Eggplant";
    public static final String ONION_MESH_ID = "Onion";
    public static final String PEPPER_MESH_ID = "Pepper";
    public static final String PUMPKIN_MESH_ID = "Pumpkin";
    public static final String TOMATO_MESH_ID = "Tomato";
    public static final String WATERMELON_MESH_ID = "Watermelon";
    public static final String MARKET_VEGETABLES_MESH_ID = "MarketVegetables";

    private static final String PLANTS_TEXTURE = "textures/AllPlantsTexture.png";

    private static final String FIELD_CABBAGE_BIG_MESH = "/resources/models/Plants/FieldCabbageBig.obj";
    private static final String FIELD_CABBAGE_SMALL_MESH = "/resources/models/Plants/FieldCabbageSmall.obj";
    private static final String FIELD_CARROT_BIG_MESH = "/resources/models/Plants/FieldCarrotBig.obj";
    private static final String FIELD_CARROT_SMALL_MESH = "/resources/models/Plants/FieldCarrotSmall.obj";
    private static final String FIELD_CORN_BIG_MESH = "/resources/models/Plants/FieldCornBig.obj";
    private static final String FIELD_CORN_SMALL_MESH = "/resources/models/Plants/FieldCornSmall.obj";
    private static final String FIELD_EGGPLANT_BIG_MESH = "/resources/models/Plants/FieldEggplantBig.obj";
    private static final String FIELD_EGGPLANT_SMALL_MESH = "/resources/models/Plants/FieldEggplantSmall.obj";
    private static final String FIELD_ONION_BIG_MESH = "/resources/models/Plants/FieldOnionBig.obj";
    private static final String FIELD_ONION_SMALL_MESH = "/resources/models/Plants/FieldOnionSmall.obj";
    private static final String FIELD_PEPPER_BIG_MESH = "/resources/models/Plants/FieldPepperBig.obj";
    private static final String FIELD_PEPPER_SMALL_MESH = "/resources/models/Plants/FieldPepperSmall.obj";
    private static final String FIELD_PUMPKIN_BIG_MESH = "/resources/models/Plants/FieldPumpkinBig.obj";
    private static final String FIELD_PUMPKIN_SMALL_MESH = "/resources/models/Plants/FieldPumpkinSmall.obj";
    private static final String FIELD_SUNFLOWER_BIG_MESH = "/resources/models/Plants/FieldSunflowerBig.obj";
    private static final String FIELD_SUNFLOWER_SMALL_MESH = "/resources/models/Plants/FieldSunflowerSmall.obj";
    private static final String FIELD_TOMATO_BIG_MESH = "/resources/models/Plants/FieldTomatoBig.obj";
    private static final String FIELD_TOMATO_SMALL_MESH = "/resources/models/Plants/FieldTomatoSmall.obj";
    private static final String FIELD_WATERMELON_BIG_MESH = "/resources/models/Plants/FieldWatermelonBig.obj";
    private static final String FIELD_WATERMELON_SMALL_MESH = "/resources/models/Plants/FieldWatermelonSmall.obj";
    private static final String TREE_MESH = "/resources/models/Plants/Tree.obj";
    private static final String APPLES_BIG_MESH = "/resources/models/Plants/ApplesBig.obj";
    private static final String APPLES_SMALL_MESH = "/resources/models/Plants/ApplesSmall.obj";
    private static final String APRICOTS_BIG_MESH = "/resources/models/Plants/ApricotsBig.obj";
    private static final String APRICOTS_SMALL_MESH = "/resources/models/Plants/ApricotsSmall.obj";
    private static final String PEARS_BIG_MESH = "/resources/models/Plants/PearsBig.obj";
    private static final String PEARS_SMALL_MESH = "/resources/models/Plants/PearsSmall.obj";
    private static final String APPLE_MESH = "/resources/models/Plants/Apple.obj";
    private static final String APRICOT_MESH = "/resources/models/Plants/Apricot.obj";
    private static final String PEAR_MESH = "/resources/models/Plants/Pear.obj";
    private static final String CABBAGE_MESH = "/resources/models/Plants/Cabbage.obj";
    private static final String CARROT_MESH = "/resources/models/Plants/Carrot.obj";
    private static final String CORN_MESH = "/resources/models/Plants/Corn.obj";
    private static final String EGGPLANT_MESH = "/resources/models/Plants/Eggplant.obj";
    private static final String ONION_MESH = "/resources/models/Plants/Onion.obj";
    private static final String PEPPER_MESH = "/resources/models/Plants/Pepper.obj";
    private static final String PUMPKIN_MESH = "/resources/models/Plants/Pumpkin.obj";
    private static final String TOMATO_MESH = "/resources/models/Plants/Tomato.obj";
    private static final String WATERMELON_MESH = "/resources/models/Plants/Watermelon.obj";
    private static final String MARKET_VEGETABLES_MESH = "/resources/models/Plants/MarketVegetables.obj";

    public AssetList plantsAssetList = new AssetList();

    private GameItem[][][] fieldsArray;
    private static final int FIELD_NR = 16;
    private static final int PLANT_NR = 10;
    private static final int PLANT_STAGES_NR = 2;

    public PlantsData() {

    }

    public void makePlantMeshes() {
        Texture plantsTexture = new Texture(PLANTS_TEXTURE);
        Material material = new Material(plantsTexture, 0.5f);

        Mesh plantsMesh1 = OBJLoader.loadMesh(FIELD_CABBAGE_BIG_MESH);
        plantsMesh1.setMaterial(material);
        plantsAssetList.addMesh(FIELD_CABBAGE_BIG_MESH_ID, plantsMesh1);

        Mesh plantsMesh2 = OBJLoader.loadMesh(FIELD_CABBAGE_SMALL_MESH);
        plantsMesh2.setMaterial(material);
        plantsAssetList.addMesh(FIELD_CABBAGE_SMALL_MESH_ID, plantsMesh2);

        Mesh plantsMesh3 = OBJLoader.loadMesh(FIELD_CARROT_BIG_MESH);
        plantsMesh3.setMaterial(material);
        plantsAssetList.addMesh(FIELD_CARROT_BIG_MESH_ID, plantsMesh3);

        Mesh plantsMesh4 = OBJLoader.loadMesh(FIELD_CARROT_SMALL_MESH);
        plantsMesh4.setMaterial(material);
        plantsAssetList.addMesh(FIELD_CARROT_SMALL_MESH_ID, plantsMesh4);

        Mesh plantsMesh5 = OBJLoader.loadMesh(FIELD_CORN_BIG_MESH);
        plantsMesh5.setMaterial(material);
        plantsAssetList.addMesh(FIELD_CORN_BIG_MESH_ID, plantsMesh5);

        Mesh plantsMesh6 = OBJLoader.loadMesh(FIELD_CORN_SMALL_MESH);
        plantsMesh6.setMaterial(material);
        plantsAssetList.addMesh(FIELD_CORN_SMALL_MESH_ID, plantsMesh6);

        Mesh plantsMesh7 = OBJLoader.loadMesh(FIELD_EGGPLANT_BIG_MESH);
        plantsMesh7.setMaterial(material);
        plantsAssetList.addMesh(FIELD_EGGPLANT_BIG_MESH_ID, plantsMesh7);

        Mesh plantsMesh8 = OBJLoader.loadMesh(FIELD_EGGPLANT_SMALL_MESH);
        plantsMesh8.setMaterial(material);
        plantsAssetList.addMesh(FIELD_EGGPLANT_SMALL_MESH_ID, plantsMesh8);

        Mesh plantsMesh9 = OBJLoader.loadMesh(FIELD_ONION_BIG_MESH);
        plantsMesh9.setMaterial(material);
        plantsAssetList.addMesh(FIELD_ONION_BIG_MESH_ID, plantsMesh9);

        Mesh plantsMesh10 = OBJLoader.loadMesh(FIELD_ONION_SMALL_MESH);
        plantsMesh10.setMaterial(material);
        plantsAssetList.addMesh(FIELD_ONION_SMALL_MESH_ID, plantsMesh10);

        Mesh plantsMesh11 = OBJLoader.loadMesh(FIELD_PEPPER_BIG_MESH);
        plantsMesh11.setMaterial(material);
        plantsAssetList.addMesh(FIELD_PEPPER_BIG_MESH_ID, plantsMesh11);

        Mesh plantsMesh12 = OBJLoader.loadMesh(FIELD_PEPPER_SMALL_MESH);
        plantsMesh12.setMaterial(material);
        plantsAssetList.addMesh(FIELD_PEPPER_SMALL_MESH_ID, plantsMesh12);

        Mesh plantsMesh13 = OBJLoader.loadMesh(FIELD_PUMPKIN_BIG_MESH);
        plantsMesh13.setMaterial(material);
        plantsAssetList.addMesh(FIELD_PUMPKIN_BIG_MESH_ID, plantsMesh13);

        Mesh plantsMesh14 = OBJLoader.loadMesh(FIELD_PUMPKIN_SMALL_MESH);
        plantsMesh14.setMaterial(material);
        plantsAssetList.addMesh(FIELD_PUMPKIN_SMALL_MESH_ID, plantsMesh14);

        Mesh plantsMesh15 = OBJLoader.loadMesh(FIELD_SUNFLOWER_BIG_MESH);
        plantsMesh15.setMaterial(material);
        plantsAssetList.addMesh(FIELD_SUNFLOWER_BIG_MESH_ID, plantsMesh15);

        Mesh plantsMesh16 = OBJLoader.loadMesh(FIELD_SUNFLOWER_SMALL_MESH);
        plantsMesh16.setMaterial(material);
        plantsAssetList.addMesh(FIELD_SUNFLOWER_SMALL_MESH_ID, plantsMesh16);

        Mesh plantsMesh17 = OBJLoader.loadMesh(FIELD_TOMATO_BIG_MESH);
        plantsMesh17.setMaterial(material);
        plantsAssetList.addMesh(FIELD_TOMATO_BIG_MESH_ID, plantsMesh17);

        Mesh plantsMesh18 = OBJLoader.loadMesh(FIELD_TOMATO_SMALL_MESH);
        plantsMesh18.setMaterial(material);
        plantsAssetList.addMesh(FIELD_TOMATO_SMALL_MESH_ID, plantsMesh18);

        Mesh plantsMesh19 = OBJLoader.loadMesh(FIELD_WATERMELON_BIG_MESH);
        plantsMesh19.setMaterial(material);
        plantsAssetList.addMesh(FIELD_WATERMELON_BIG_MESH_ID, plantsMesh19);

        Mesh plantsMesh20 = OBJLoader.loadMesh(FIELD_WATERMELON_SMALL_MESH);
        plantsMesh20.setMaterial(material);
        plantsAssetList.addMesh(FIELD_WATERMELON_SMALL_MESH_ID, plantsMesh20);

        Mesh plantsMesh21 = OBJLoader.loadMesh(TREE_MESH);
        plantsMesh21.setMaterial(material);
        plantsAssetList.addMesh(TREE_MESH_ID, plantsMesh21);

        Mesh plantsMesh22 = OBJLoader.loadMesh(APPLES_BIG_MESH);
        plantsMesh22.setMaterial(material);
        plantsAssetList.addMesh(APPLES_BIG_MESH_ID, plantsMesh22);

        Mesh plantsMesh23 = OBJLoader.loadMesh(APPLES_SMALL_MESH);
        plantsMesh23.setMaterial(material);
        plantsAssetList.addMesh(APPLES_SMALL_MESH_ID, plantsMesh23);

        Mesh plantsMesh24 = OBJLoader.loadMesh(APRICOTS_BIG_MESH);
        plantsMesh24.setMaterial(material);
        plantsAssetList.addMesh(APRICOTS_BIG_MESH_ID, plantsMesh24);

        Mesh plantsMesh25 = OBJLoader.loadMesh(APRICOTS_SMALL_MESH);
        plantsMesh25.setMaterial(material);
        plantsAssetList.addMesh(APRICOTS_SMALL_MESH_ID, plantsMesh25);

        Mesh plantsMesh26 = OBJLoader.loadMesh(PEARS_BIG_MESH);
        plantsMesh26.setMaterial(material);
        plantsAssetList.addMesh(PEARS_BIG_MESH_ID, plantsMesh26);

        Mesh plantsMesh27 = OBJLoader.loadMesh(PEARS_SMALL_MESH);
        plantsMesh27.setMaterial(material);
        plantsAssetList.addMesh(PEARS_SMALL_MESH_ID, plantsMesh27);

        Mesh plantsMesh28 = OBJLoader.loadMesh(APPLE_MESH);
        plantsMesh28.setMaterial(material);
        plantsAssetList.addMesh(APPLE_MESH_ID, plantsMesh28);

        Mesh plantsMesh29 = OBJLoader.loadMesh(APRICOT_MESH);
        plantsMesh29.setMaterial(material);
        plantsAssetList.addMesh(APRICOT_MESH_ID, plantsMesh29);

        Mesh plantsMesh30 = OBJLoader.loadMesh(PEAR_MESH);
        plantsMesh30.setMaterial(material);
        plantsAssetList.addMesh(PEAR_MESH_ID, plantsMesh30);

        Mesh plantsMesh31 = OBJLoader.loadMesh(CABBAGE_MESH);
        plantsMesh31.setMaterial(material);
        plantsAssetList.addMesh(CABBAGE_MESH_ID, plantsMesh31);

        Mesh plantsMesh32 = OBJLoader.loadMesh(CARROT_MESH);
        plantsMesh32.setMaterial(material);
        plantsAssetList.addMesh(CARROT_MESH_ID, plantsMesh32);

        Mesh plantsMesh33 = OBJLoader.loadMesh(CORN_MESH);
        plantsMesh33.setMaterial(material);
        plantsAssetList.addMesh(CORN_MESH_ID, plantsMesh33);

        Mesh plantsMesh34 = OBJLoader.loadMesh(EGGPLANT_MESH);
        plantsMesh34.setMaterial(material);
        plantsAssetList.addMesh(EGGPLANT_MESH_ID, plantsMesh34);

        Mesh plantsMesh35 = OBJLoader.loadMesh(ONION_MESH);
        plantsMesh35.setMaterial(material);
        plantsAssetList.addMesh(ONION_MESH_ID, plantsMesh35);

        Mesh plantsMesh36 = OBJLoader.loadMesh(PEPPER_MESH);
        plantsMesh36.setMaterial(material);
        plantsAssetList.addMesh(PEPPER_MESH_ID, plantsMesh36);

        Mesh plantsMesh37 = OBJLoader.loadMesh(PUMPKIN_MESH);
        plantsMesh37.setMaterial(material);
        plantsAssetList.addMesh(PUMPKIN_MESH_ID, plantsMesh37);

        Mesh plantsMesh38 = OBJLoader.loadMesh(TOMATO_MESH);
        plantsMesh38.setMaterial(material);
        plantsAssetList.addMesh(TOMATO_MESH_ID, plantsMesh38);

        Mesh plantsMesh39 = OBJLoader.loadMesh(WATERMELON_MESH);
        plantsMesh39.setMaterial(material);
        plantsAssetList.addMesh(WATERMELON_MESH_ID, plantsMesh39);

        Mesh plantsMesh40 = OBJLoader.loadMesh(MARKET_VEGETABLES_MESH);
        plantsMesh40.setMaterial(material);
        plantsAssetList.addMesh(MARKET_VEGETABLES_MESH_ID, plantsMesh40);
    }

    public void makeFieldArray() {
        fieldsArray = new GameItem[FIELD_NR][PLANT_NR][PLANT_STAGES_NR];

        int counter = 0;
        for (int i = 0; i < FIELD_NR; i++) {
            for (int j = 0; j < PLANT_NR; j++) {
                for (int k = 0; k < PLANT_STAGES_NR; k++) {
                    counter++;
                    fieldsArray[i][j][k] = plantsAssetList.getGameItems()[counter];
                    fieldsArray[i][j][k].setShow(false);
                }
            }
        }

    }

    public void setPlantShow(int field, int plant) {
        int plantIndex = Planted.getPlanted(plant).getIndexMesh();

        for (int j = 0; j < PLANT_NR; j++) {
            for (int k = 0; k < PLANT_STAGES_NR; k++) {
                if (j == plantIndex && k == 1) {
                    fieldsArray[field][j][k].setShow(true);
                } else {
                    fieldsArray[field][j][k].setShow(false);
                }
            }
        }
    }

    public GameItem[][][] getFieldsArray() {
        return fieldsArray;
    }

    public GameItem[] getPlantGameItems() {
        return plantsAssetList.getGameItems();
    }

    public void setSelectedAsset(SelectedAssetInfo selectedAssetInfo, int assetIndex) {
        plantsAssetList.setSelectedInfo(selectedAssetInfo, assetIndex);
    }

    public void setMesh(SelectedAssetInfo selectedItemInfo, int meshIndex) {
        plantsAssetList.setMesh(selectedItemInfo, meshIndex);
    }

    public void setPosition(SelectedAssetInfo selectedItemInfo, Vector3f position) {
        plantsAssetList.setPosition(selectedItemInfo, position);
    }

    public void setRotation(SelectedAssetInfo selectedItemInfo, Vector3f rotation) {
        plantsAssetList.setRotation(selectedItemInfo, rotation);
    }

    public void removePlantItem(SelectedAssetInfo selectedItemInfo) {
        plantsAssetList.removeGameItem(CATEGORY_ID, selectedItemInfo);
    }

    public void addPlantItem(Vector3f position, Vector3f rotation, int meshIndex) {
        plantsAssetList.addGameItem(CATEGORY_ID, meshIndex, position, rotation);
    }

    public void cleanUp() {
        plantsAssetList.cleanUp();
    }

    // ====== Save / Load From File ======

    public void loadData() {
        try {
            BufferedReader buf = new BufferedReader(new FileReader("Data/PlantsData.data"));
            while (true) {
                String line = buf.readLine();
                if (line != null) {
                    String lines[] = line.split("#");
                    // System.out.println(lines[0] + " loading");

                    addPlantItem(
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
            System.out.println("Plants File loaded");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Plants File not found");
        }
    }

    public void saveData() {
        try {
            File file = new File("Data/PlantsData.data");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter pw = new PrintWriter(file);

            SelectedAssetInfo assetInfo;
            assetInfo = new SelectedAssetInfo();
            int assetsNr = plantsAssetList.getGameItems().length;
            for (int i = 0; i < assetsNr; i++) {
                setSelectedAsset(assetInfo, i);
                pw.println(assetInfo.getGameItemID() + "#" +
                        plantsAssetList.getGameItems()[i].getPosition().x + "#" +
                        plantsAssetList.getGameItems()[i].getPosition().y + "#" +
                        plantsAssetList.getGameItems()[i].getPosition().z + "#" +
                        plantsAssetList.getGameItems()[i].getRotation().x + "#" +
                        plantsAssetList.getGameItems()[i].getRotation().y + "#" +
                        plantsAssetList.getGameItems()[i].getRotation().z + "#" +
                        assetInfo.getMeshIndex());
            }

            pw.close();
            System.out.println("Plants File saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
