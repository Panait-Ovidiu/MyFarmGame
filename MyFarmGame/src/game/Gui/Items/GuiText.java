package game.Gui.Items;

import engine.GameItem;
import game.Assets.GuiData.Fonts;
import engine.TextItem;

import java.util.ArrayList;

public class GuiText extends GuiContainer {

    private static final Fonts FONTS = new Fonts();

    protected boolean show;

    public static final int SIZE_NORMAL = 0;
    public static final int SIZE_SMALL = 1;
    public static final int SIZE_EXTRA_SMALL = 2;
    public static final int SIZE_LARGE = 3;
    private int size;

    private TextItem textItem;

    public GuiText(String text, int size, ArrayList<GameItem> parentItems) throws Exception {
        super(10.0f, 10.0f, parentItems);
        this.size = size;
        show = true;

        //   textItem.getMesh().getMaterial().setAmbientColour(new Vector4f(0.0f,0.0f,0.0f,1.0f)); //set color black

        makeText(text, parentItems);
        setShow(show);
    }

    public void makeText(String text, ArrayList<GameItem> parentItems) throws Exception {
        switch (size) {
            case 1:
                textItem = new TextItem(text, FONTS.getFontSmall());
                break;
            case 2:
                textItem = new TextItem(text, FONTS.getFontExtraSmall());
                break;
            case 3:
                textItem = new TextItem(text, FONTS.getFontLarge());
                break;
            default:
                textItem = new TextItem(text, FONTS.getFontNormal());
                break;
        }
        setWidthAndHeight(textItem.getWidth(), textItem.getHeight());
        parentItems.add(textItem);
    }

    public boolean isShow() {
        return show;
    }

    public String getText() {
        return textItem.getText();
    }

    public void setText(String text) {
        if (!textItem.getText().equals(text)) {
            this.textItem.setText(text);
            setWidthAndHeight(textItem.getWidth(), textItem.getHeight());
        }
        setShow(show);
    }

    public void setShow(boolean show) {
        this.show = show;
        textItem.setShow(show);

        if (isBackgroundShow()) {
            if (textItem.getText().length() == 0) {
                containerBackground.setShow(false);
            } else {
                containerBackground.setShow(show);
            }
        } else {
            containerBackground.setShow(false);
        }

    }

    @Override
    public void setPosition(float x, float y, float z) {
        if (position.x != x || position.y != y || position.z != z) {
            this.position.x = x;
            this.position.y = y;
            this.position.z = z;
        }
        updateTextSize();
    }

    public void updateTextSize() {
        updateBackgroundSize();

        textItem.setPosition(position.x, position.y, position.z);

    }
}


