package game.Assets;

import engine.GameItem;
import engine.graph.Mesh;
import game.Gui.InterfaceAdmin.AdminGuiInterface.SelectedAssetInfo;
import org.joml.Vector3f;

import java.io.Serializable;
import java.util.ArrayList;

public class AssetList implements Serializable {

    private ArrayList<Mesh> meshList;
    private ArrayList<String> meshKeySet;

    private int gameItemCounter;
    private ArrayList<AssetInfo> assetList;

    public AssetList() {
        meshList = new ArrayList<>();
        meshKeySet = new ArrayList<>();
        gameItemCounter = 0;
        assetList = new ArrayList<>();
    }

    public void addMesh(String meshID, Mesh mesh) {
        meshKeySet.add(meshID);
        meshList.add(mesh);
    }

    public GameItem[] getGameItems() {
        GameItem[] gameItems = new GameItem[assetList.size()];
        for (int i = 0; i < assetList.size(); i++) {
            gameItems[i] = assetList.get(i).getGameItem();
        }
        return gameItems;
    }

    public void setSelectedInfo(SelectedAssetInfo selectedAssetInfo, int assetIndex) {
        AssetInfo assetInfo = assetList.get(assetIndex);

        selectedAssetInfo.setSelectedAssetInfo(
                assetList.size(),
                meshList.size(),
                assetInfo
        );
    }

    public void setMesh(SelectedAssetInfo selectedItemInfo, int meshIndex) {
        assetList.get(selectedItemInfo.getGameItemIndex())
                .getGameItem()
                .setMesh(meshList.get(meshIndex));

        assetList.get(selectedItemInfo.getGameItemIndex())
                .setMeshID(meshKeySet.get(meshIndex));

        assetList.get(selectedItemInfo.getGameItemIndex())
                .setMeshIndex(meshIndex);

        setSelectedInfo(selectedItemInfo, selectedItemInfo.getGameItemIndex());
    }

    public void setPosition(SelectedAssetInfo selectedItemInfo, Vector3f position) {
        assetList.get(selectedItemInfo.getGameItemIndex())
                .getGameItem().setPosition(position.x, position.y, position.z);

        setSelectedInfo(selectedItemInfo, selectedItemInfo.getGameItemIndex());
    }

    public void setRotation(SelectedAssetInfo selectedItemInfo, Vector3f rotation) {
        assetList.get(selectedItemInfo.getGameItemIndex())
                .getGameItem().setRotation(rotation.x, rotation.y, rotation.z);

        setSelectedInfo(selectedItemInfo, selectedItemInfo.getGameItemIndex());
    }

    public void addGameItem(String categoryID, int meshIndex, Vector3f position, Vector3f rotation) {
        GameItem gameItem = new GameItem(meshList.get(meshIndex));
        gameItem.setPosition(position.x, position.y, position.z);
        gameItem.setRotation(rotation.x, rotation.y, rotation.z);

        String gameItemID = categoryID + gameItemCounter;
        AssetInfo assetInfo = new AssetInfo(gameItemID, gameItemCounter, meshKeySet.get(meshIndex), meshIndex, gameItem);
        assetList.add(assetInfo);
        gameItemCounter++;
    }

    public void removeGameItem(String categoryID, SelectedAssetInfo selectedAssetInfo) {
        int selectedAsset = selectedAssetInfo.getGameItemIndex();

        ArrayList<AssetInfo> newAssetList = new ArrayList<>();
        gameItemCounter = 0;

        for (int i = 0; i < assetList.size(); i++) {

            if (i == selectedAsset) {

            } else {
                String gameItemID = categoryID + gameItemCounter;
                AssetInfo assetInfo = new AssetInfo(
                        gameItemID,
                        gameItemCounter,
                        meshKeySet.get(assetList.get(i).getMeshIndex()),
                        assetList.get(i).getMeshIndex(),
                        assetList.get(i).getGameItem());
                newAssetList.add(assetInfo);
                gameItemCounter++;
            }
        }
        assetList = newAssetList;
    }

    public void cleanUp() {
        for (Mesh mesh : meshList) {
            mesh.cleanUp();
        }
    }
}
