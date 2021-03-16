package game.Gui.Temp;

import game.Assets.GuiData.Fonts;
import engine.GameItem;
import engine.TextItem;
import engine.Window;
import engine.graph.*;
import org.joml.Vector4f;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TempItems {

    private boolean show;

    private ArrayList<GameItem> items;

    private TextItem statusTextItem;
    private TextItem cameraPositionTextItem;
    private TextItem currentTime;

    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public TempItems(Window window, Fonts fonts, String statusText) throws Exception {
        show = true;
        items = new ArrayList<>();
        makePanel(window, fonts, statusText);
        show(show);
    }

    public void makePanel(Window window, Fonts fonts, String statusText) throws Exception {
        statusTextItem = new TextItem(statusText, fonts.getFontNormal());
        statusTextItem.getMesh().getMaterial().setAmbientColour(new Vector4f(1, 1, 1, 1));
        items.add(statusTextItem);

        cameraPositionTextItem = new TextItem("", fonts.getFontSmall());
        cameraPositionTextItem.getMesh().getMaterial().setAmbientColour(new Vector4f(1, 1, 1, 1));
        items.add(cameraPositionTextItem);

        currentTime = new TextItem("", fonts.getFontSmall());
        currentTime.getMesh().getMaterial().setAmbientColour(new Vector4f(1, 1, 1, 1));
        items.add(currentTime);
    }

    public boolean isShow() {
        return show;
    }

    public void show(boolean show) {
        this.show = show;
        statusTextItem.setShow(show);
        cameraPositionTextItem.setShow(show);
        currentTime.setShow(show);
    }

    public ArrayList<GameItem> getItems() {
        return items;
    }

    public void updateSize(Window window) {

        this.statusTextItem.setPosition(10f, window.getHeight() - 50f, 0);
        this.cameraPositionTextItem.setPosition(10.0f, window.getHeight() - 25.0f, 0.0f);
        currentTime.setPosition(window.getWidth() - 225.0f, 20.0f, 0.0f);

    }

    public void update(Camera camera) {
        cameraPositionTextItem.setText("Camera Pos: x:" + (int) camera.getPosition().x +
                " y:" + (int) camera.getPosition().y +
                " z:" + (int) camera.getPosition().z + "  " +
                "Camera Rot: x:" + (int) camera.getRotation().x +
                " y:" + (int) camera.getRotation().y +
                " z:" + (int) camera.getRotation().z);

        currentTime.setText(SDF.format(new Timestamp(System.currentTimeMillis())));
    }
}
