package game.Gui.InterfaceGamePlay.PlantWindow;

import engine.GameItem;
import engine.Window;
import game.Data.PlayerData;
import game.Gui.Items.*;
import game.Gui.InterfaceGamePlay.PlantWindow.FieldDetailPage.FieldDetailPage;
import game.Gui.InterfaceGamePlay.PlantWindow.FieldListPage.FieldListPage;

import java.util.ArrayList;

public class PlantMenuWindow extends GuiWindow {

    private Window window;
    private PlayerData playerData;

    private static final float PANEL_WIDTH_NORMAL = 500.0f;
    private static final float PANEL_HEIGHT_NORMAL = 415.0f;
    private static final float PANEL_WIDTH_SMALL = 350.0f;
    private static final float PANEL_HEIGHT_SMALL = 325.0f;

    public static final int PAGE_FIELD_LIST = 1;
    public static final int PAGE_FIELD_DETAIL = 2;

    private int selectedFieldNumber;

    // ====== Page Field List Items ======
    public FieldListPage fieldListPage;

    // ====== Page Field Detail Items ======
    public FieldDetailPage fieldDetailPage;

    public PlantMenuWindow(Window window, GuiContainer parent, PlayerData playerData, ArrayList<GameItem> parentItems) throws Exception {
        super(PANEL_WIDTH_NORMAL, PANEL_HEIGHT_NORMAL, parentItems);
        setPosition(parent.getXRightPos() + 5.0f, parent.getYTopPos(), 0.0f);
        this.window = window;
        this.playerData = playerData;
        show = false;

        addItems(parentItems);
        setShow(show);
    }

    protected void addItems(ArrayList<GameItem> parentItems) throws Exception {
        windowTitleGuiText.setText("Plant Menu");
        closeButton.setNameID("closeButton (Plant Menu)");

        // ====== Page Field List Items ======
        fieldListPage = new FieldListPage(PANEL_WIDTH_NORMAL - 20.0f, PANEL_HEIGHT_NORMAL - windowTitleGuiText.getHeight() - 15.0f, parentItems);

        // ====== Page Field Detail Items ======
        fieldDetailPage = new FieldDetailPage(window, PANEL_WIDTH_SMALL - 50.0f, PANEL_HEIGHT_SMALL - 50.f, parentItems);

    }

    public int getSelectedFieldNumber() {
        return selectedFieldNumber;
    }

    @Override
    public void setPageEmpty() {
        page = PAGE_EMPTY;
        setShow(show);
    }

    public void setFieldListPage() {
        page = PAGE_FIELD_LIST;
        setWidthAndHeight(PANEL_WIDTH_NORMAL, PANEL_HEIGHT_NORMAL);
        fieldListPage.fieldListItemPanel.setPageOne();
        setShow(show);
    }

    public void setPageFieldDetail(int selectedFieldNumber) {
        page = PAGE_FIELD_DETAIL;
        setWidthAndHeight(PANEL_WIDTH_SMALL, PANEL_HEIGHT_SMALL);
        this.selectedFieldNumber = selectedFieldNumber;

        setShow(true);
    }

    public void setShow(boolean show) {
        windowShow(show);

        if (page == PAGE_EMPTY) {
            fieldListPage.setShow(false);
            fieldDetailPage.setShow(false);

        } else if (page == PAGE_FIELD_LIST) {
            fieldListPage.setShow(show);
            fieldDetailPage.setShow(false);

        } else if (page == PAGE_FIELD_DETAIL) {
            fieldListPage.setShow(false);
            fieldDetailPage.setShow(show);

        }

    }

    public void update() {

        if (page == PAGE_FIELD_LIST) {
            fieldListPage.update(playerData);
        }

        if (page == PAGE_FIELD_DETAIL) {
            fieldDetailPage.update(playerData.getFieldData(selectedFieldNumber));
        }

    }

    public void updateSize() {
        updateWindowSize();

        // ====== Page Field List Items ======
        fieldListPage.setPosition(
                xLeftPos + 10.0f,
                windowTitleGuiText.getYBottomPos(),
                0.0f
        );

        // === Page Field Detail Items ===
        fieldDetailPage.setPosition(
                xLeftPos + 25.0f,
                windowTitleGuiText.getYBottomPos(),
                0.0f
        );
    }
}
