package game.Data;

import java.io.Serializable;

public enum Planted implements Serializable {
    EMPTY(-1, -1,"Empty", 0, 0),
    TOMATO(0, 8,"Tomato", 60, 10),
    CABBAGE(1, 0, "Cabbage", 90, 20),
    CORN(2, 2,"Corn", 120, 30),
    CARROT(3, 1, "Carrot", 150, 40),
    EGGPLANT(4,3, "Eggplant", 180, 50),
    PEPPER(5,5, "Pepper", 210, 60),
    MELONS(6,9, "Melons", 230, 70),
    ONIONS(7, 4,"Onions", 260, 80),
    PUMPKINS(8, 6,"Pumpkins", 290, 90),
    SUNFLOWER(9, 7,"Sunflower", 310, 100);

    private final int indexButton;
    private final int indexMesh;
    private final String plantName;
    private final int secondsToHarvest;
    private final int experienceFromHarvest;

    Planted(int indexButton, int indexMesh, String plantName, int secondsToHarvest, int experienceFromHarvest) {
        this.indexButton = indexButton;
        this.indexMesh = indexMesh;
        this.plantName = plantName;
        this.secondsToHarvest = secondsToHarvest;
        this.experienceFromHarvest = experienceFromHarvest;
    }

    public boolean plantedNotEmpty() {
        return !plantName.equals(EMPTY.plantName);
    }

    public static Planted getPlanted(int indexButton) {
        for (Planted plant : Planted.values()) {
            if (plant.indexButton == indexButton) {
                return plant;
            }
        }
        return null;
    }

    public int getIndexButton() {
        return indexButton;
    }

    public int getIndexMesh() {
        return indexMesh;
    }

    public String getPlantName() {
        return plantName;
    }

    public int getSecondsToHarvest() {
        return secondsToHarvest;
    }

    public int getExperienceFromHarvest() {
        return experienceFromHarvest;
    }

}