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

public class DecorationsData {

    private static final String CATEGORY_ID = "Decorations";

    public static final String GRASS_MESH_ID = "Grass";
    public static final String GRASS_FIELD_MESH_ID = "GrassField";
    public static final String PLANT_1_MESH_ID = "Plant1";
    public static final String PLANT_2_MESH_ID = "Plant2";
    public static final String PLANT_3_MESH_ID = "Plant3";
    public static final String PLANT_4_MESH_ID = "Plant4";
    public static final String PLANT_5_MESH_ID = "Plant5";
    public static final String TREE_1_MESH_ID = "Tree1";
    public static final String TREE_2_MESH_ID = "Tree2";
    public static final String TREE_3_MESH_ID = "Tree3";
    public static final String TREE_4_MESH_ID = "Tree4";
    public static final String TREE_5_MESH_ID = "Tree5";
    public static final String MAIN_FENCE_ONE_SIDE_MESH_ID = "MainFence OneSide";
    public static final String MAIN_FENCE_TWO_SIDES_MESH_ID = "MainFence TwoSides";
    public static final String MAIN_GATE_MESH_ID = "MainGate";
    public static final String MAIN_GATE_SMALL_MESH_ID = "MainGate Small";
    public static final String WATER_MARGIN_ONE_SIDE_MESH_ID = "WaterMargin OneSide";
    public static final String WATER_MARGIN_TWO_SIDES_MESH_ID = "WaterMargin TwoSides";
    public static final String WATER_ONE_MESH_ID = "Water One";
    public static final String WATER_TWO_MESH_ID = "Water Two";
    public static final String BARREL_MESH_ID = "Barrel";
    public static final String BOX_MESH_ID = "Box";
    public static final String BOX_SMALL_MESH_ID = "Box Small";
    public static final String CRATE_MESH_ID = "Crate";
    public static final String CRATES_1_MESH_ID = "Crates1";
    public static final String CRATES_2_MESH_ID = "Crates2";
    public static final String CRATES_3_MESH_ID = "Crates3";
    public static final String BASKET_MESH_ID = "Basket";
    public static final String HAY_BAG_MESH_ID = "HayBag";
    public static final String HAY_BALES_MESH_ID = "HayBales";
    public static final String HAY_PILE_MESH_ID = "HayPile";
    public static final String SACK_BIG_PILE_MESH_ID = "Sack BigPile";
    public static final String SACK_DOWN_MESH_ID = "Sack Down";
    public static final String SACK_OPEN_MESH_ID = "Sack Open";
    public static final String SACK_SMALL_PILE_MESH_ID = "Sack SmallPile";
    public static final String SACK_UP_MESH_ID = "Sack Up";
    public static final String LOG_BIG_MESH_ID = "Log Big";
    public static final String LOG_BIG_PILE_MESH_ID = "Log Big Pile";
    public static final String LOG_HALF_MESH_ID = "Log Half";
    public static final String LOG_HALF_PILE_MESH_ID = "Log HalfPile";
    public static final String LOG_LARGE_PILE_MESH_ID = "Log LargePile";
    public static final String LOG_QUARTER_MESH_ID = "Log Quarter";
    public static final String LOG_QUARTER_PILE_MESH_ID = "Log QuarterPile";
    public static final String LOG_SMALL_MESH_ID = "Log Small";
    public static final String LOG_SMALL_PILE_MESH_ID = "Log SmallPile";
    public static final String TREE_STUMP_MESH_ID = "Tree Stump";
    public static final String TOOL_AXE_MESH_ID = "Tool Axe";
    public static final String TOOL_FORK_MESH_ID = "Tool Fork";
    public static final String TOOL_HOE_MESH_ID = "Tool Hoe";
    public static final String TOOL_RAKE_MESH_ID = "Tool Rake";
    public static final String TOOL_SCYTHE_MESH_ID = "Tool Scythe";
    public static final String TOOL_SHOVEL_MESH_ID = "Tool Shovel";
    public static final String CHICKEN_COOP_MESH_ID = "Chicken Coop";
    public static final String WATER_BOWL_BIG_MESH_ID = "Water BowlBig";
    public static final String WATER_BOWL_SMALL_MESH_ID = "Water BowlSmall";
    public static final String CHICKEN_FENCE_FOR_GATE_MESH_ID = "ChickenFence ForGate";
    public static final String CHICKEN_FENCE_ONE_SIDE_MESH_ID = "ChickenFence OneSide";
    public static final String CHICKEN_FENCE_TWO_SIDES_MESH_ID = "ChickenFence TwoSides";
    public static final String CHICKEN_GATE_MESH_ID = "Chicken Gate";
    public static final String TRACTOR_DIGGER_FRAME_MESH_ID = "Tractor DiggerFrame";
    public static final String TRACTOR_FRAME_MESH_ID = "Tractor Frame";
    public static final String TRACTOR_TIRES_BACK_MESH_ID = "Tractor TiresBack";
    public static final String TRACTOR_TIRES_FRONT_MESH_ID = "Tractor TiresFront";
    public static final String TRUCK_FRAME_MESH_ID = "Truck Frame";
    public static final String TRUCK_WHEELS_MESH_ID = "Truck Wheels";
    public static final String PICNIC_TABLE_MESH_ID = "PicnicTable";
    public static final String BENCH_MESH_ID = "Bench";
    public static final String WELL_MESH_ID = "Well";
    public static final String MOUNTAIN_MESH_ID = "Mountain";
    public static final String MARKET_MESH_ID = "Market";
    public static final String SCARECROW_MESH_ID = "ScareCrow";

    private static final String DECORATIONS_TEXTURE = "textures/AllPropsTexture.png";

    private static final String GRASS_MESH = "/resources/models/Decorations/Grass.obj";
    private static final String GRASS_FIELD_MESH = "/resources/models/Decorations/GrassField.obj";
    private static final String PLANT_1_MESH = "/resources/models/Decorations/Plant1.obj";
    private static final String PLANT_2_MESH = "/resources/models/Decorations/Plant2.obj";
    private static final String PLANT_3_MESH = "/resources/models/Decorations/Plant3.obj";
    private static final String PLANT_4_MESH = "/resources/models/Decorations/Plant4.obj";
    private static final String PLANT_5_MESH = "/resources/models/Decorations/Plant5.obj";
    private static final String TREE_1_MESH = "/resources/models/Decorations/Tree1.obj";
    private static final String TREE_2_MESH = "/resources/models/Decorations/Tree2.obj";
    private static final String TREE_3_MESH = "/resources/models/Decorations/Tree3.obj";
    private static final String TREE_4_MESH = "/resources/models/Decorations/Tree4.obj";
    private static final String TREE_5_MESH = "/resources/models/Decorations/Tree5.obj";
    private static final String MAIN_FENCE_ONE_SIDE_MESH = "/resources/models/Decorations/MainFenceOneSide.obj";
    private static final String MAIN_FENCE_TWO_SIDES_MESH = "/resources/models/Decorations/MainFenceTwoSides.obj";
    private static final String MAIN_GATE_MESH = "/resources/models/Decorations/MainGate.obj";
    private static final String MAIN_GATE_SMALL_MESH = "/resources/models/Decorations/MainGateSmall.obj";
    private static final String WATER_MARGIN_ONE_SIDE_MESH = "/resources/models/Decorations/WaterMarginOneSide.obj";
    private static final String WATER_MARGIN_TWO_SIDES_MESH = "/resources/models/Decorations/WaterMarginTwoSides.obj";
    private static final String WATER_ONE_MESH = "/resources/models/Decorations/WaterOne.obj";
    private static final String WATER_TWO_MESH = "/resources/models/Decorations/WaterTwo.obj";
    private static final String BARREL_MESH = "/resources/models/Decorations/Barrel.obj";
    private static final String BOX_MESH = "/resources/models/Decorations/Box.obj";
    private static final String BOX_SMALL_MESH = "/resources/models/Decorations/BoxSmall.obj";
    private static final String CRATE_MESH = "/resources/models/Decorations/Crate.obj";
    private static final String CRATES_1_MESH = "/resources/models/Decorations/Crates1.obj";
    private static final String CRATES_2_MESH = "/resources/models/Decorations/Crates2.obj";
    private static final String CRATES_3_MESH = "/resources/models/Decorations/Crates3.obj";
    private static final String BASKET_MESH = "/resources/models/Decorations/Basket.obj";
    private static final String HAY_BAG_MESH = "/resources/models/Decorations/HayBag.obj";
    private static final String HAY_BALES_MESH = "/resources/models/Decorations/HayBales.obj";
    private static final String HAY_PILE_MESH = "/resources/models/Decorations/HayPile.obj";
    private static final String SACK_BIG_PILE_MESH = "/resources/models/Decorations/SackBigPile.obj";
    private static final String SACK_DOWN_MESH = "/resources/models/Decorations/SackDown.obj";
    private static final String SACK_OPEN_MESH = "/resources/models/Decorations/SackOpen.obj";
    private static final String SACK_SMALL_PILE_MESH = "/resources/models/Decorations/SackSmallPile.obj";
    private static final String SACK_UP_MESH = "/resources/models/Decorations/SackUp.obj";
    private static final String LOG_BIG_MESH = "/resources/models/Decorations/LogBig.obj";
    private static final String LOG_BIG_PILE_MESH = "/resources/models/Decorations/LogBigPile.obj";
    private static final String LOG_HALF_MESH = "/resources/models/Decorations/LogHalf.obj";
    private static final String LOG_HALF_PILE_MESH = "/resources/models/Decorations/LogHalfPile.obj";
    private static final String LOG_LARGE_PILE_MESH = "/resources/models/Decorations/LogLargePile.obj";
    private static final String LOG_QUARTER_MESH = "/resources/models/Decorations/LogQuarter.obj";
    private static final String LOG_QUARTER_PILE_MESH = "/resources/models/Decorations/LogQuarterPile.obj";
    private static final String LOG_SMALL_MESH = "/resources/models/Decorations/LogSmall.obj";
    private static final String LOG_SMALL_PILE_MESH = "/resources/models/Decorations/LogSmallPile.obj";
    private static final String TREE_STUMP_MESH = "/resources/models/Decorations/TreeStump.obj";
    private static final String TOOL_AXE_MESH = "/resources/models/Decorations/ToolAxe.obj";
    private static final String TOOL_FORK_MESH = "/resources/models/Decorations/ToolFork.obj";
    private static final String TOOL_HOE_MESH = "/resources/models/Decorations/ToolHoe.obj";
    private static final String TOOL_RAKE_MESH = "/resources/models/Decorations/ToolRake.obj";
    private static final String TOOL_SCYTHE_MESH = "/resources/models/Decorations/ToolScythe.obj";
    private static final String TOOL_SHOVEL_MESH = "/resources/models/Decorations/ToolShovel.obj";
    private static final String CHICKEN_COOP_MESH = "/resources/models/Decorations/ChickenCoop.obj";
    private static final String WATER_BOWL_BIG_MESH = "/resources/models/Decorations/WaterBowlBig.obj";
    private static final String WATER_BOWL_SMALL_MESH = "/resources/models/Decorations/WaterBowlSmall.obj";
    private static final String CHICKEN_FENCE_FOR_GATE_MESH = "/resources/models/Decorations/ChickenFenceForGate.obj";
    private static final String CHICKEN_FENCE_ONE_SIDE_MESH = "/resources/models/Decorations/ChickenFenceOneSide.obj";
    private static final String CHICKEN_FENCE_TWO_SIDES_MESH = "/resources/models/Decorations/ChickenFenceTwoSides.obj";
    private static final String CHICKEN_GATE_MESH = "/resources/models/Decorations/ChickenGate.obj";
    private static final String TRACTOR_DIGGER_FRAME_MESH = "/resources/models/Decorations/TractorDiggerFrame.obj";
    private static final String TRACTOR_FRAME_MESH = "/resources/models/Decorations/TractorFrame.obj";
    private static final String TRACTOR_TIRES_BACK_MESH = "/resources/models/Decorations/TractorTiresBack.obj";
    private static final String TRACTOR_TIRES_FRONT_MESH = "/resources/models/Decorations/TractorTiresFront.obj";
    private static final String TRUCK_FRAME_MESH = "/resources/models/Decorations/TruckFrame.obj";
    private static final String TRUCK_WHEELS_MESH = "/resources/models/Decorations/TruckWheels.obj";
    private static final String PICNIC_TABLE_MESH = "/resources/models/Decorations/PicnicTable.obj";
    private static final String BENCH_MESH = "/resources/models/Decorations/Bench.obj";
    private static final String WELL_MESH = "/resources/models/Decorations/Well.obj";
    private static final String MOUNTAIN_MESH = "/resources/models/Decorations/Mountain.obj";
    private static final String MARKET_MESH = "/resources/models/Decorations/Market.obj";
    private static final String SCARECROW_MESH = "/resources/models/Decorations/ScareCrow.obj";

    public static final float TRACTOR_TIRES_BACK_X = -1.51831f;
    public static final float TRACTOR_TIRES_BACK_Y = 1.02847f;
    public static final float TRACTOR_TIRES_FRONT_X = 2.06548f;
    public static final float TRACTOR_TIRES_FRONT_Y = 0.76491f;
    public static final float TRUCK_WHEELS_BACK_X = -2.0f;
    public static final float TRUCK_WHEELS_FRONT_X = 2.3f;
    public static final float TRUCK_WHEELS_Y = 0.685f;

    public AssetList decorationsAssetList = new AssetList();

    public DecorationsData() {

    }

    public void makeDecorationsMeshes() {
        Texture decorationsTexture = new Texture(DECORATIONS_TEXTURE);
        Material material = new Material(decorationsTexture, 0.5f);

        Mesh decorationsMesh1 = OBJLoader.loadMesh(GRASS_MESH);
        decorationsMesh1.setMaterial(material);
        decorationsAssetList.addMesh(GRASS_MESH_ID, decorationsMesh1);

        Mesh decorationsMesh2 = OBJLoader.loadMesh(GRASS_FIELD_MESH);
        decorationsMesh2.setMaterial(material);
        decorationsAssetList.addMesh(GRASS_FIELD_MESH_ID, decorationsMesh2);

        Mesh decorationsMesh3 = OBJLoader.loadMesh(PLANT_1_MESH);
        decorationsMesh3.setMaterial(material);
        decorationsAssetList.addMesh(PLANT_1_MESH_ID, decorationsMesh3);

        Mesh decorationsMesh4 = OBJLoader.loadMesh(PLANT_2_MESH);
        decorationsMesh4.setMaterial(material);
        decorationsAssetList.addMesh(PLANT_2_MESH_ID, decorationsMesh4);

        Mesh decorationsMesh5 = OBJLoader.loadMesh(PLANT_3_MESH);
        decorationsMesh5.setMaterial(material);
        decorationsAssetList.addMesh(PLANT_3_MESH_ID, decorationsMesh5);

        Mesh decorationsMesh6 = OBJLoader.loadMesh(PLANT_4_MESH);
        decorationsMesh6.setMaterial(material);
        decorationsAssetList.addMesh(PLANT_4_MESH_ID, decorationsMesh6);

        Mesh decorationsMesh7 = OBJLoader.loadMesh(PLANT_5_MESH);
        decorationsMesh7.setMaterial(material);
        decorationsAssetList.addMesh(PLANT_5_MESH_ID, decorationsMesh7);

        Mesh decorationsMesh8 = OBJLoader.loadMesh(TREE_1_MESH);
        decorationsMesh8.setMaterial(material);
        decorationsAssetList.addMesh(TREE_1_MESH_ID, decorationsMesh8);

        Mesh decorationsMesh9 = OBJLoader.loadMesh(TREE_2_MESH);
        decorationsMesh9.setMaterial(material);
        decorationsAssetList.addMesh(TREE_2_MESH_ID, decorationsMesh9);

        Mesh decorationsMesh10 = OBJLoader.loadMesh(TREE_3_MESH);
        decorationsMesh10.setMaterial(material);
        decorationsAssetList.addMesh(TREE_3_MESH_ID, decorationsMesh10);

        Mesh decorationsMesh11 = OBJLoader.loadMesh(TREE_4_MESH);
        decorationsMesh11.setMaterial(material);
        decorationsAssetList.addMesh(TREE_4_MESH_ID, decorationsMesh11);

        Mesh decorationsMesh12 = OBJLoader.loadMesh(TREE_5_MESH);
        decorationsMesh12.setMaterial(material);
        decorationsAssetList.addMesh(TREE_5_MESH_ID, decorationsMesh12);

        Mesh decorationsMesh13 = OBJLoader.loadMesh(MAIN_FENCE_ONE_SIDE_MESH);
        decorationsMesh13.setMaterial(material);
        decorationsAssetList.addMesh(MAIN_FENCE_ONE_SIDE_MESH_ID, decorationsMesh13);

        Mesh decorationsMesh14 = OBJLoader.loadMesh(MAIN_FENCE_TWO_SIDES_MESH);
        decorationsMesh14.setMaterial(material);
        decorationsAssetList.addMesh(MAIN_FENCE_TWO_SIDES_MESH_ID, decorationsMesh14);

        Mesh decorationsMesh15 = OBJLoader.loadMesh(MAIN_GATE_MESH);
        decorationsMesh15.setMaterial(material);
        decorationsAssetList.addMesh(MAIN_GATE_MESH_ID, decorationsMesh15);

        Mesh decorationsMesh16 = OBJLoader.loadMesh(MAIN_GATE_SMALL_MESH);
        decorationsMesh16.setMaterial(material);
        decorationsAssetList.addMesh(MAIN_GATE_SMALL_MESH_ID, decorationsMesh16);

        Mesh decorationsMesh17 = OBJLoader.loadMesh(WATER_MARGIN_ONE_SIDE_MESH);
        decorationsMesh17.setMaterial(material);
        decorationsAssetList.addMesh(WATER_MARGIN_ONE_SIDE_MESH_ID, decorationsMesh17);

        Mesh decorationsMesh18 = OBJLoader.loadMesh(WATER_MARGIN_TWO_SIDES_MESH);
        decorationsMesh18.setMaterial(material);
        decorationsAssetList.addMesh(WATER_MARGIN_TWO_SIDES_MESH_ID, decorationsMesh18);

        Mesh decorationsMesh19 = OBJLoader.loadMesh(WATER_ONE_MESH);
        decorationsMesh19.setMaterial(material);
        decorationsAssetList.addMesh(WATER_ONE_MESH_ID, decorationsMesh19);

        Mesh decorationsMesh20 = OBJLoader.loadMesh(WATER_TWO_MESH);
        decorationsMesh20.setMaterial(material);
        decorationsAssetList.addMesh(WATER_TWO_MESH_ID, decorationsMesh20);

        Mesh decorationsMesh21 = OBJLoader.loadMesh(BARREL_MESH);
        decorationsMesh21.setMaterial(material);
        decorationsAssetList.addMesh(BARREL_MESH_ID, decorationsMesh21);

        Mesh decorationsMesh22 = OBJLoader.loadMesh(BOX_MESH);
        decorationsMesh22.setMaterial(material);
        decorationsAssetList.addMesh(BOX_MESH_ID, decorationsMesh22);

        Mesh decorationsMesh23 = OBJLoader.loadMesh(BOX_SMALL_MESH);
        decorationsMesh23.setMaterial(material);
        decorationsAssetList.addMesh(BOX_SMALL_MESH_ID, decorationsMesh23);

        Mesh decorationsMesh24 = OBJLoader.loadMesh(CRATE_MESH);
        decorationsMesh24.setMaterial(material);
        decorationsAssetList.addMesh(CRATE_MESH_ID, decorationsMesh24);

        Mesh decorationsMesh25 = OBJLoader.loadMesh(CRATES_1_MESH);
        decorationsMesh25.setMaterial(material);
        decorationsAssetList.addMesh(CRATES_1_MESH_ID, decorationsMesh25);

        Mesh decorationsMesh26 = OBJLoader.loadMesh(CRATES_2_MESH);
        decorationsMesh26.setMaterial(material);
        decorationsAssetList.addMesh(CRATES_2_MESH_ID, decorationsMesh26);

        Mesh decorationsMesh27 = OBJLoader.loadMesh(CRATES_3_MESH);
        decorationsMesh27.setMaterial(material);
        decorationsAssetList.addMesh(CRATES_3_MESH_ID, decorationsMesh27);

        Mesh decorationsMesh28 = OBJLoader.loadMesh(BASKET_MESH);
        decorationsMesh28.setMaterial(material);
        decorationsAssetList.addMesh(BASKET_MESH_ID, decorationsMesh28);

        Mesh decorationsMesh29 = OBJLoader.loadMesh(HAY_BAG_MESH);
        decorationsMesh29.setMaterial(material);
        decorationsAssetList.addMesh(HAY_BAG_MESH_ID, decorationsMesh29);

        Mesh decorationsMesh30 = OBJLoader.loadMesh(HAY_BALES_MESH);
        decorationsMesh30.setMaterial(material);
        decorationsAssetList.addMesh(HAY_BALES_MESH_ID, decorationsMesh30);

        Mesh decorationsMesh31 = OBJLoader.loadMesh(HAY_PILE_MESH);
        decorationsMesh31.setMaterial(material);
        decorationsAssetList.addMesh(HAY_PILE_MESH_ID, decorationsMesh31);

        Mesh decorationsMesh32 = OBJLoader.loadMesh(SACK_BIG_PILE_MESH);
        decorationsMesh32.setMaterial(material);
        decorationsAssetList.addMesh(SACK_BIG_PILE_MESH_ID, decorationsMesh32);

        Mesh decorationsMesh33 = OBJLoader.loadMesh(SACK_DOWN_MESH);
        decorationsMesh33.setMaterial(material);
        decorationsAssetList.addMesh(SACK_DOWN_MESH_ID, decorationsMesh33);

        Mesh decorationsMesh34 = OBJLoader.loadMesh(SACK_OPEN_MESH);
        decorationsMesh34.setMaterial(material);
        decorationsAssetList.addMesh(SACK_OPEN_MESH_ID, decorationsMesh34);

        Mesh decorationsMesh35 = OBJLoader.loadMesh(SACK_SMALL_PILE_MESH);
        decorationsMesh35.setMaterial(material);
        decorationsAssetList.addMesh(SACK_SMALL_PILE_MESH_ID, decorationsMesh35);

        Mesh decorationsMesh36 = OBJLoader.loadMesh(SACK_UP_MESH);
        decorationsMesh36.setMaterial(material);
        decorationsAssetList.addMesh(SACK_UP_MESH_ID, decorationsMesh36);

        Mesh decorationsMesh37 = OBJLoader.loadMesh(LOG_BIG_MESH);
        decorationsMesh37.setMaterial(material);
        decorationsAssetList.addMesh(LOG_BIG_MESH_ID, decorationsMesh37);

        Mesh decorationsMesh38 = OBJLoader.loadMesh(LOG_BIG_PILE_MESH);
        decorationsMesh38.setMaterial(material);
        decorationsAssetList.addMesh(LOG_BIG_PILE_MESH_ID, decorationsMesh38);

        Mesh decorationsMesh39 = OBJLoader.loadMesh(LOG_HALF_MESH);
        decorationsMesh39.setMaterial(material);
        decorationsAssetList.addMesh(LOG_HALF_MESH_ID, decorationsMesh39);

        Mesh decorationsMesh40 = OBJLoader.loadMesh(LOG_HALF_PILE_MESH);
        decorationsMesh40.setMaterial(material);
        decorationsAssetList.addMesh(LOG_HALF_PILE_MESH_ID, decorationsMesh40);

        Mesh decorationsMesh41 = OBJLoader.loadMesh(LOG_LARGE_PILE_MESH);
        decorationsMesh41.setMaterial(material);
        decorationsAssetList.addMesh(LOG_LARGE_PILE_MESH_ID, decorationsMesh41);

        Mesh decorationsMesh42 = OBJLoader.loadMesh(LOG_QUARTER_MESH);
        decorationsMesh42.setMaterial(material);
        decorationsAssetList.addMesh(LOG_QUARTER_MESH_ID, decorationsMesh42);

        Mesh decorationsMesh43 = OBJLoader.loadMesh(LOG_QUARTER_PILE_MESH);
        decorationsMesh43.setMaterial(material);
        decorationsAssetList.addMesh(LOG_QUARTER_PILE_MESH_ID, decorationsMesh43);

        Mesh decorationsMesh44 = OBJLoader.loadMesh(LOG_SMALL_MESH);
        decorationsMesh44.setMaterial(material);
        decorationsAssetList.addMesh(LOG_SMALL_MESH_ID, decorationsMesh44);

        Mesh decorationsMesh45 = OBJLoader.loadMesh(LOG_SMALL_PILE_MESH);
        decorationsMesh45.setMaterial(material);
        decorationsAssetList.addMesh(LOG_SMALL_PILE_MESH_ID, decorationsMesh45);

        Mesh decorationsMesh46 = OBJLoader.loadMesh(TREE_STUMP_MESH);
        decorationsMesh46.setMaterial(material);
        decorationsAssetList.addMesh(TREE_STUMP_MESH_ID, decorationsMesh46);

        Mesh decorationsMesh47 = OBJLoader.loadMesh(TOOL_AXE_MESH);
        decorationsMesh47.setMaterial(material);
        decorationsAssetList.addMesh(TOOL_AXE_MESH_ID, decorationsMesh47);

        Mesh decorationsMesh48 = OBJLoader.loadMesh(TOOL_FORK_MESH);
        decorationsMesh48.setMaterial(material);
        decorationsAssetList.addMesh(TOOL_FORK_MESH_ID, decorationsMesh48);

        Mesh decorationsMesh49 = OBJLoader.loadMesh(TOOL_HOE_MESH);
        decorationsMesh49.setMaterial(material);
        decorationsAssetList.addMesh(TOOL_HOE_MESH_ID, decorationsMesh49);

        Mesh decorationsMesh50 = OBJLoader.loadMesh(TOOL_RAKE_MESH);
        decorationsMesh50.setMaterial(material);
        decorationsAssetList.addMesh(TOOL_RAKE_MESH_ID, decorationsMesh50);

        Mesh decorationsMesh51 = OBJLoader.loadMesh(TOOL_SCYTHE_MESH);
        decorationsMesh51.setMaterial(material);
        decorationsAssetList.addMesh(TOOL_SCYTHE_MESH_ID, decorationsMesh51);

        Mesh decorationsMesh52 = OBJLoader.loadMesh(TOOL_SHOVEL_MESH);
        decorationsMesh52.setMaterial(material);
        decorationsAssetList.addMesh(TOOL_SHOVEL_MESH_ID, decorationsMesh52);

        Mesh decorationsMesh53 = OBJLoader.loadMesh(CHICKEN_COOP_MESH);
        decorationsMesh53.setMaterial(material);
        decorationsAssetList.addMesh(CHICKEN_COOP_MESH_ID, decorationsMesh53);

        Mesh decorationsMesh54 = OBJLoader.loadMesh(WATER_BOWL_BIG_MESH);
        decorationsMesh54.setMaterial(material);
        decorationsAssetList.addMesh(WATER_BOWL_BIG_MESH_ID, decorationsMesh54);

        Mesh decorationsMesh55 = OBJLoader.loadMesh(WATER_BOWL_SMALL_MESH);
        decorationsMesh55.setMaterial(material);
        decorationsAssetList.addMesh(WATER_BOWL_SMALL_MESH_ID, decorationsMesh55);

        Mesh decorationsMesh56 = OBJLoader.loadMesh(CHICKEN_FENCE_FOR_GATE_MESH);
        decorationsMesh56.setMaterial(material);
        decorationsAssetList.addMesh(CHICKEN_FENCE_FOR_GATE_MESH_ID, decorationsMesh56);

        Mesh decorationsMesh57 = OBJLoader.loadMesh(CHICKEN_FENCE_ONE_SIDE_MESH);
        decorationsMesh57.setMaterial(material);
        decorationsAssetList.addMesh(CHICKEN_FENCE_ONE_SIDE_MESH_ID, decorationsMesh57);

        Mesh decorationsMesh58 = OBJLoader.loadMesh(CHICKEN_FENCE_TWO_SIDES_MESH);
        decorationsMesh58.setMaterial(material);
        decorationsAssetList.addMesh(CHICKEN_FENCE_TWO_SIDES_MESH_ID, decorationsMesh58);

        Mesh decorationsMesh59 = OBJLoader.loadMesh(CHICKEN_GATE_MESH);
        decorationsMesh59.setMaterial(material);
        decorationsAssetList.addMesh(CHICKEN_GATE_MESH_ID, decorationsMesh59);

        Mesh decorationsMesh60 = OBJLoader.loadMesh(TRACTOR_DIGGER_FRAME_MESH);
        decorationsMesh60.setMaterial(material);
        decorationsAssetList.addMesh(TRACTOR_DIGGER_FRAME_MESH_ID, decorationsMesh60);

        Mesh decorationsMesh61 = OBJLoader.loadMesh(TRACTOR_FRAME_MESH);
        decorationsMesh61.setMaterial(material);
        decorationsAssetList.addMesh(TRACTOR_FRAME_MESH_ID, decorationsMesh61);

        Mesh decorationsMesh62 = OBJLoader.loadMesh(TRACTOR_TIRES_BACK_MESH);
        decorationsMesh62.setMaterial(material);
        decorationsAssetList.addMesh(TRACTOR_TIRES_BACK_MESH_ID, decorationsMesh62);

        Mesh decorationsMesh63 = OBJLoader.loadMesh(TRACTOR_TIRES_FRONT_MESH);
        decorationsMesh63.setMaterial(material);
        decorationsAssetList.addMesh(TRACTOR_TIRES_FRONT_MESH_ID, decorationsMesh63);

        Mesh decorationsMesh64 = OBJLoader.loadMesh(TRUCK_FRAME_MESH);
        decorationsMesh64.setMaterial(material);
        decorationsAssetList.addMesh(TRUCK_FRAME_MESH_ID, decorationsMesh64);

        Mesh decorationsMesh65 = OBJLoader.loadMesh(TRUCK_WHEELS_MESH);
        decorationsMesh65.setMaterial(material);
        decorationsAssetList.addMesh(TRUCK_WHEELS_MESH_ID, decorationsMesh65);

        Mesh decorationsMesh66 = OBJLoader.loadMesh(PICNIC_TABLE_MESH);
        decorationsMesh66.setMaterial(material);
        decorationsAssetList.addMesh(PICNIC_TABLE_MESH_ID, decorationsMesh66);

        Mesh decorationsMesh67 = OBJLoader.loadMesh(BENCH_MESH);
        decorationsMesh67.setMaterial(material);
        decorationsAssetList.addMesh(BENCH_MESH_ID, decorationsMesh67);

        Mesh decorationsMesh68 = OBJLoader.loadMesh(WELL_MESH);
        decorationsMesh68.setMaterial(material);
        decorationsAssetList.addMesh(WELL_MESH_ID, decorationsMesh68);

        Mesh decorationsMesh69 = OBJLoader.loadMesh(MOUNTAIN_MESH);
        decorationsMesh69.setMaterial(material);
        decorationsAssetList.addMesh(MOUNTAIN_MESH_ID, decorationsMesh69);

        Mesh decorationsMesh70 = OBJLoader.loadMesh(MARKET_MESH);
        decorationsMesh70.setMaterial(material);
        decorationsAssetList.addMesh(MARKET_MESH_ID, decorationsMesh70);

        Mesh decorationsMesh71 = OBJLoader.loadMesh(SCARECROW_MESH);
        decorationsMesh71.setMaterial(material);
        decorationsAssetList.addMesh(SCARECROW_MESH_ID, decorationsMesh71);
    }

    public GameItem[] getDecorationGameItems() {
        return decorationsAssetList.getGameItems();
    }

    public void setSelectedAsset(SelectedAssetInfo selectedAssetInfo, int assetIndex) {
        decorationsAssetList.setSelectedInfo(selectedAssetInfo, assetIndex);
    }

    public void setMesh(SelectedAssetInfo selectedItemInfo, int meshIndex) {
        decorationsAssetList.setMesh(selectedItemInfo, meshIndex);
    }

    public void setPosition(SelectedAssetInfo selectedItemInfo, Vector3f position) {
        decorationsAssetList.setPosition(selectedItemInfo, position);
    }

    public void setRotation(SelectedAssetInfo selectedItemInfo, Vector3f rotation) {
        decorationsAssetList.setRotation(selectedItemInfo, rotation);
    }

    public void removeDecorationItem(SelectedAssetInfo selectedItemInfo) {
        decorationsAssetList.removeGameItem(CATEGORY_ID, selectedItemInfo);
    }

    public void addDecorationItem(Vector3f position, Vector3f rotation, int meshIndex) {
        decorationsAssetList.addGameItem(CATEGORY_ID, meshIndex, position, rotation);
    }

    public void cleanUp() {
        decorationsAssetList.cleanUp();
    }

    // ====== Save / Load From File ======

    public void loadData() {
        try {
            BufferedReader buf = new BufferedReader(new FileReader("Data/DecorationsData.data"));
            while (true) {
                String line = buf.readLine();
                if (line != null) {
                    String lines[] = line.split("#");
                    // System.out.println(lines[0] + " loading");

                    addDecorationItem(
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
            System.out.println("Decorations File loaded");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Decorations File not found");
        }
    }

    public void saveData() {
        try {
            File file = new File("Data/DecorationsData.data");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter pw = new PrintWriter(file);

            SelectedAssetInfo assetInfo;
            assetInfo = new SelectedAssetInfo();
            int assetsNr = decorationsAssetList.getGameItems().length;
            for (int i = 0; i < assetsNr; i++) {
                setSelectedAsset(assetInfo, i);
                pw.println(assetInfo.getGameItemID() + "#" +
                        decorationsAssetList.getGameItems()[i].getPosition().x + "#" +
                        decorationsAssetList.getGameItems()[i].getPosition().y + "#" +
                        decorationsAssetList.getGameItems()[i].getPosition().z + "#" +
                        decorationsAssetList.getGameItems()[i].getRotation().x + "#" +
                        decorationsAssetList.getGameItems()[i].getRotation().y + "#" +
                        decorationsAssetList.getGameItems()[i].getRotation().z + "#" +
                        assetInfo.getMeshIndex());
            }

            pw.close();
            System.out.println("Decorations File saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
