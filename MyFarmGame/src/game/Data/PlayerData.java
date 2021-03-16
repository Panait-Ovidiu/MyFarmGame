package game.Data;

import java.io.*;
import java.sql.Timestamp;

public class PlayerData implements Serializable {

    private int playerExp;
    private int playerLevel;
    private int playerMoney;

    // ====== Crop Fields ======
    private FieldData[] fieldData;

//    private Inventory inventory;
//    private TreeData[] treeData;
//    private AnimalData[] animalData;
//    private Updates updates;

    public PlayerData() {
        playerExp = 0;
        playerLevel = 1;
        playerMoney = 200;

        fieldData = new FieldData[16];
        for (int i = 0; i < fieldData.length; i++) {
            fieldData[i] = new FieldData();
        }

        fieldData[0].unlocked();
        fieldData[1].unlocked();
        fieldData[2].unlocked();

    }

    public int getPlayerExp() {
        return playerExp;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public FieldData getFieldData(int fieldNumber) {
        return fieldData[fieldNumber];
    }

    public void setFieldData(int fieldNumber, boolean isUnlocked, Planted planted) {
        fieldData[fieldNumber].setPlanted(planted);
    }

    public void update() {
        for (FieldData fieldData : fieldData) {
            fieldData.update();
        }
    }

    public String print() {
        return "PlayerExp:" + playerExp +
                "\nPlayerLevel:" + playerLevel +
                "\nplayerMoney:" + playerMoney +
                "\nFields:\n======\n" + FieldData.printArray(fieldData);
    }

    // ====== Save / Load From File ======

    public static PlayerData loadPlayerData(PlayerData playerData) {
        try {
            FileInputStream f = new FileInputStream(new File("PlayerData.txt"));
            ObjectInputStream o = new ObjectInputStream(f);

            //Read object
            playerData = (PlayerData) o.readObject();

            System.out.println(playerData.print());

            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return playerData;
    }

    public void savePlayerData() {
        try {
            FileOutputStream f = new FileOutputStream(new File("PlayerData.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            //Write objects to file
            o.writeObject(this);

            o.close();
            f.close();

            System.out.println(this.print());

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
}
