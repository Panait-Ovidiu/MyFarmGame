package game.Gui.InterfaceGamePlay.PlantWindow.FieldListPage;

import engine.GameItem;
import game.Data.PlayerData;
import game.Gui.Items.GuiPanel;

import java.util.ArrayList;

public class FieldListItemPanel extends GuiPanel {

    private static final float LIST_ITEM_WIDTH = 225.0f;
    private static final float LIST_ITEM_HEIGHT = 75.0f;

    public static final int PAGE_ONE = 1;
    public static final int PAGE_TWO = 2;

    // ====== Page One Items ======
    public FieldListItem[] fieldListItemPageOne;

    // ====== Page Two Items ======
    public FieldListItem[] fieldListItemPageTwo;

    public FieldListItemPanel(float width, float height, ArrayList<GameItem> parentItems) throws Exception {
        super(width, height, parentItems);

        setPanelBackgroundShow(false);

        fieldListItemPageOne = new FieldListItem[8];
        fieldListItemPageTwo = new FieldListItem[8];

        addItems(parentItems);
        setShow(show);
    }

    @Override
    protected void addItems(ArrayList<GameItem> parentItems) throws Exception {
        // ====== Page One Top Items ======
        for (int i = 0; i < fieldListItemPageOne.length; i++) {
            fieldListItemPageOne[i] = new FieldListItem(LIST_ITEM_WIDTH, LIST_ITEM_HEIGHT, parentItems);
        }

        // ====== Page Two Top Items ======
        for (int i = 0; i < fieldListItemPageTwo.length; i++) {
            fieldListItemPageTwo[i] = new FieldListItem(LIST_ITEM_WIDTH, LIST_ITEM_HEIGHT, parentItems);
        }
    }

    @Override
    public void setPageEmpty() {
        page = PAGE_EMPTY;
        setShow(show);
    }

    public void setPageOne() {
        page = PAGE_ONE;
        setShow(show);
    }

    public void setPageTwo() {
        page = PAGE_TWO;
        setShow(show);
    }

    @Override
    public void setShow(boolean show) {
        panelShow(show);

        if (page == PAGE_EMPTY) {
            pageListOneShow(false);
            pageListTwoShow(false);

        } else if (page == PAGE_ONE) {

            pageListOneShow(show);
            pageListTwoShow(false);

        } else if (page == PAGE_TWO) {

            pageListOneShow(false);
            pageListTwoShow(show);
        }
    }

    private void pageListOneShow(boolean show) {
        for (int i = 0; i < fieldListItemPageOne.length; i++) {
            fieldListItemPageOne[i].setShow(show);
        }
    }

    private void pageListTwoShow(boolean show) {
        for (int i = 0; i < fieldListItemPageTwo.length; i++) {
            fieldListItemPageTwo[i].setShow(show);
        }
    }

    public void update(PlayerData playerData) {

        if (page == PAGE_ONE) {
            for (int i = 0; i < fieldListItemPageOne.length; i++) {
                fieldListItemPageOne[i].update(playerData.getFieldData(i));
            }
        } else if (page == PAGE_TWO) {
            for (int i = 0; i < fieldListItemPageTwo.length; i++) {
                fieldListItemPageTwo[i].update(playerData.getFieldData(i + fieldListItemPageOne.length));
            }
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

    @Override
    public void updateSize() {
        updatePanelSize();

        // ====== Page One Items ======
        for (int i = 0; i < fieldListItemPageOne.length; i++) {
            if (i < (fieldListItemPageOne.length / 2)) {
                fieldListItemPageOne[i].setPosition(
                        xLeftPos,
                        yTopPos + (i * fieldListItemPageOne[i].getHeight()) + (i * 7.5f),
                        0.0f
                );
            } else {
                fieldListItemPageOne[i].setPosition(
                        xRightPos - fieldListItemPageOne[i].getWidth(),
                        yTopPos + ((i % 4) * fieldListItemPageOne[i].getHeight()) + ((i % 4) * 7.5f),
                        0.0f
                );
            }
        }

        // ====== Page Two Items ======
        for (int i = 0; i < fieldListItemPageTwo.length; i++) {
            if (i < (fieldListItemPageTwo.length / 2)) {
                fieldListItemPageTwo[i].setPosition(
                        xLeftPos,
                        yTopPos + (i * fieldListItemPageTwo[i].getHeight()) + (i * 7.5f),
                        0.0f
                );
            } else {
                fieldListItemPageTwo[i].setPosition(
                        xRightPos - fieldListItemPageTwo[i].getWidth(),
                        yTopPos + ((i % 4) * fieldListItemPageTwo[i].getHeight()) + ((i % 4) * 7.5f),
                        0.0f
                );
            }
        }
    }
}
