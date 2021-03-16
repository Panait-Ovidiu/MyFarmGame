package game.Gui.InterfaceGamePlay.PlantWindow.FieldDetailPage;

import engine.GameItem;
import game.Data.Planted;
import game.Gui.Items.GuiPanel;

import java.util.ArrayList;

public class PlantListButtonPanel extends GuiPanel {

    private static final float PLANT_LIST_ITEM_WIDTH = 200.0f;
    private static final float PLANT_LIST_ITEM_HEIGHT = 85.0f;

    public static final int NO_BUTTON_SELECTED = -1;
    private int selectedButton;

    public PlantListButton[] plantListItems;

    public PlantListButtonPanel(float width, float height, ArrayList<GameItem> parentItems) throws Exception {
        super(width, height,parentItems);
        selectedButton = NO_BUTTON_SELECTED;

        setPanelBackgroundShow(true);

        plantListItems = new PlantListButton[Planted.values().length - 1];

        addItems(parentItems);
        setShow(show);
    }

    public int getSelectedButton() {
        return selectedButton;
    }

    public void setSelectedButton(int selectedButton) {
        if (this.selectedButton == selectedButton) {
            if(selectedButton != NO_BUTTON_SELECTED) {
                this.selectedButton = NO_BUTTON_SELECTED;
                plantListItems[selectedButton].selectPlantButton.setSelected(false);
            }
        } else {
            this.selectedButton = selectedButton;
            for (int i = 0; i < plantListItems.length; i++) {
                if (i == selectedButton) {
                    plantListItems[i].selectPlantButton.setSelected(true);
                } else {
                    plantListItems[i].selectPlantButton.setSelected(false);
                }
            }
        }
    }

    @Override
    protected void addItems(ArrayList<GameItem> parentItems) throws Exception {
        for (int i = plantListItems.length - 1; i >= 0; i--) {
            plantListItems[i] = new PlantListButton(PLANT_LIST_ITEM_WIDTH, PLANT_LIST_ITEM_HEIGHT,parentItems);
        }

    }

    @Override
    public void setPageEmpty() {
        page = PAGE_EMPTY;
        setShow(show);
    }

    @Override
    public void setShow(boolean show) {
        panelShow(show);

        for (int i = 0; i < plantListItems.length; i++) {
            plantListItems[i].setShow(show);
        }
    }

    @Override
    public void setPosition(float x, float y, float z) {
        if (position.x != x || position.y != y || position.z != z) {
            this.position.x = x;
            this.position.y = y;
            this.position.z = z;
        }
        updateSize();
    }

    public void update() {

        Planted[] plants = Planted.values();
        for (int i = 1; i < Planted.values().length; i++) {
            plantListItems[i - 1].update(plants[i]);
        }

    }

    @Override
    public void updateSize() {
        updatePanelSize();

        for (int i = 0; i < plantListItems.length; i++) {
            if (i == 0) {
                plantListItems[i].setPosition(
                        xLeftPos,
                        yTopPos,
                        0.0f
                );
            } else if (i < 5) {
                plantListItems[i].setPosition(
                        plantListItems[i - 1].selectPlantButton.getXLeftPos() + plantListItems[i].selectPlantButton.getWidth(),
                        yTopPos,
                        0.0f
                );
            } else if (i == 5) {
                plantListItems[i].setPosition(
                        xLeftPos,
                        yBottomPos - plantListItems[i].selectPlantButton.getHeight() - 10.0f,
                        0.0f
                );
            } else {
                plantListItems[i].setPosition(
                        plantListItems[i - 1].selectPlantButton.getXLeftPos() + plantListItems[i].selectPlantButton.getWidth(),
                        yBottomPos - plantListItems[i].selectPlantButton.getHeight() - 10.0f,
                        0.0f
                );
            }

        }


    }
}
