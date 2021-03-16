package game.Assets;

import engine.GameItem;

import java.io.Serializable;

public class AssetInfo implements Serializable {

    private String gameItemID;
    private int gameItemIndex;

    private String meshID;
    private int meshIndex;

    private GameItem gameItem;

    public AssetInfo(String gameItemID, int gameItemIndex, String meshID, int meshIndex, GameItem gameItem){
        this.gameItemID = gameItemID;
        this.gameItemIndex = gameItemIndex;
        this.meshID = meshID;
        this.meshIndex = meshIndex;
        this.gameItem = gameItem;
    }

    public String getGameItemID() {
        return gameItemID;
    }

    public int getGameItemIndex() {
        return gameItemIndex;
    }

    public String getMeshID() {
        return meshID;
    }

    public int getMeshIndex() {
        return meshIndex;
    }

    public GameItem getGameItem() {
        return gameItem;
    }

    public void setGameItemID(String gameItemID) {
        this.gameItemID = gameItemID;
    }

    public void setGameItemIndex(int gameItemIndex) {
        this.gameItemIndex = gameItemIndex;
    }

    public void setMeshID(String meshID) {
        this.meshID = meshID;
    }

    public void setMeshIndex(int meshIndex) {
        this.meshIndex = meshIndex;
    }

    public void setGameItem(String meshID, int meshIndex,GameItem gameItem) {
        this.meshID = meshID;
        this.meshIndex = meshIndex;
        this.gameItem = gameItem;
    }
}
