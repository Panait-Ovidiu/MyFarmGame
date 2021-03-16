package game.Data;

import java.io.Serializable;
import java.sql.Timestamp;

public class FieldData implements Serializable {

    private static int counter = 1;
    private String nameID;

    private boolean isUnlocked;
    private boolean isCompleted;

    private Planted planted;
    private Time timePlanted;
    private Time finishTime;
    private long timeLeft;
    private float percentageCompleted;

    FieldData() {
        nameID = "Field " + counter++;
        isUnlocked = false;
        isCompleted = false;
        planted = Planted.EMPTY;
        timePlanted = new Time();
        finishTime = new Time(timePlanted, planted.getSecondsToHarvest());
        timeLeft = 0;
        percentageCompleted = 0.0f;
    }

    // ====== Getters ======

    public String getNameID() {
        return nameID;
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Planted getPlanted() {
        return planted;
    }

    public String getTimeLeft() {
        return Time.getTimeLeft(timeLeft);
    }

    public float getPercentageCompleted() {
        return percentageCompleted;
    }

    // ====== Setters ======

    // TODO: 1/24/2020 make more secure
    public void unlocked() {
        isUnlocked = true;
    }

    public void setPlanted(Planted planted) {
        this.planted = planted;
        isCompleted = false;
        timePlanted.setTime(new Timestamp(System.currentTimeMillis()));
        finishTime.setTime(timePlanted, planted.getSecondsToHarvest());
    }

    // ====== Other ======

    public void update() {
        if (planted.plantedNotEmpty()) {

            // Calculate Time Left
            timeLeft = finishTime.getTimeMilliseconds() - System.currentTimeMillis();

            // Calculate Percentage Completed
            float secondsPassed = (System.currentTimeMillis() - timePlanted.getTimeMilliseconds()) / 1000;
            if (secondsPassed <= planted.getSecondsToHarvest()) {
                percentageCompleted = (secondsPassed / planted.getSecondsToHarvest()) * 100;
            }

            // Check if Completed
            if (Time.checkFinishTime(finishTime)) {
                isCompleted = true;
                percentageCompleted = 100.0f;
            }
        }
    }

    // ====== ToString's ======

    public String print() {
        return "NameID: " + nameID +
                "\nisUnlocked: " + isUnlocked +
                "\ncheckCompleted: " + isCompleted +
                "\nPlanted: " + planted.toString() +
                "\nTimePlanted: " + timePlanted.getTimeString();
    }

    public static String printArray(FieldData[] fieldData) {
        String string = "";
        for (int i = 0; i < fieldData.length; i++) {
            string += fieldData[i].print() + "\n";
        }
        return string;
    }
}
