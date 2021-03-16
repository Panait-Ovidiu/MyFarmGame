package game.Assets.GuiData;

public enum GuiTextures {

    // ====== Backgrounds ======
    MAIN_LOGO_TEXTURE("MAIN_LOGO_TEXTURE", "textures/MainLogo.png"),
    WINDOW_BACKGROUND_TEXTURE("WINDOW_BACKGROUND_TEXTURE", "textures/MainPanel.png"),
    PANEL_BACKGROUND_TEXTURE("PANEL_BACKGROUND_TEXTURE", "textures/ListPanel.png"),
    PLAYER_DISPLAY_BACKGROUND_TEXTURE("PLAYER_DISPLAY_BACKGROUND_TEXTURE", "textures/PlayerDisplayPanel.png"),
    BLACK_BACKGROUND_TEXTURE("BLACK_BACKGROUND_TEXTURE", "textures/blackTexture.png"),

    // ====== Buttons ======
    MAIN_BUTTON_SQUARE_TEXTURE("MAIN_BUTTON_SQUARE_TEXTURE", "textures/MainButtonSquare.png"),
    BUTTON_SETTINGS_TEXTURE("BUTTON_SETTINGS_TEXTURE", "textures/SettingsButton.png"),
    BUTTON_CLOSE_TEXTURE("BUTTON_CLOSE_TEXTURE", "textures/CloseButton.png"),
    BUTTON_ARROW_PREVIOUS_TEXTURE("BUTTON_ARROW_PREVIOUS_TEXTURE", "textures/PreviousButton.png"),
    BUTTON_ARROW_NEXT_TEXTURE("BUTTON_ARROW_NEXT_TEXTURE", "textures/NextButton.png"),
    BUTTON_PLANTS_TEXTURE("BUTTON_PLANTS_TEXTURE", "textures/MainButtonPlants.png"),
    BUTTON_ANIMALS_TEXTURE("BUTTON_ANIMALS_TEXTURE", "textures/MainButtonAnimals.png"),
    BUTTON_TREES_TEXTURE("BUTTON_TREES_TEXTURE", "textures/MainButtonTrees.png"),
    BUTTON_UPGRADES_TEXTURE("BUTTON_UPGRADES_TEXTURE", "textures/MainButtonUpgrades.png"),
    BUTTON_MARKET_TEXTURE("BUTTON_MARKET_TEXTURE", "textures/MainButtonMarket.png"),

    // ====== Images ======
    PLAYER_ICON_TEXTURE("PLAYER_ICON_TEXTURE", "textures/playerIcon.png"),
    MONEY_ICON_TEXTURE("MONEY_ICON_TEXTURE", "textures/moneyIcon.png"),
    XP_ICON_TEXTURE("XP_ICON_TEXTURE", "textures/xpIcon.png"),
    LOCKED_ICON_TEXTURE("LOCKED_ICON_TEXTURE", "textures/lockImage.png"),
    STAR_ICON_TEXTURE("STAR_ICON_TEXTURE", "textures/StarGameButton.png"),

    PROGRESS_BAR_BACKGROUND_TEXTURE("PROGRESS_BAR_BACKGROUND_TEXTURE", "textures/expBarBackground.png"),
    PROGRESS_BAR_FILL_TEXTURE("PROGRESS_BAR_FILL_TEXTURE", "textures/expBarFill.png"),
    PROGRESS_BAR_MARGIN_TEXTURE("PROGRESS_BAR_MARGIN_TEXTURE", "textures/expBarMargin.png");

    private final String name;
    private final String texturePath;

    GuiTextures(String name, String texturePath) {
        this.texturePath = texturePath;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTexturePath() {
        return texturePath;
    }
}
