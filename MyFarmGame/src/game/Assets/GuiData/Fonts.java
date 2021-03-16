package game.Assets.GuiData;

import engine.graph.FontTexture;

import java.awt.*;

public class Fonts {

    private static final Font FONT_EXTRA_SMALL = new Font("Arial", Font.BOLD, 10);
    private static final Font FONT_SMALL = new Font("Arial", Font.BOLD, 16);
    private static final Font FONT_NORMAL = new Font("Arial", Font.BOLD, 18);
    private static final Font FONT_BIG = new Font("Arial", Font.BOLD, 26);

    private static final String CHARSET = "ISO-8859-1";

    private FontTexture fontExtraSmall;
    private FontTexture fontSmall;
    private FontTexture fontNormal;
    private FontTexture fontLarge;

    public Fonts(){
        try {
            fontExtraSmall = new FontTexture(FONT_EXTRA_SMALL, CHARSET);
            fontSmall = new FontTexture(FONT_SMALL, CHARSET);
            fontNormal = new FontTexture(FONT_NORMAL, CHARSET);
            fontLarge = new FontTexture(FONT_BIG, CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FontTexture getFontExtraSmall() {
        return fontExtraSmall;
    }

    public FontTexture getFontSmall() {
        return fontSmall;
    }

    public FontTexture getFontNormal() {
        return fontNormal;
    }

    public FontTexture getFontLarge() {
        return fontLarge;
    }
}
