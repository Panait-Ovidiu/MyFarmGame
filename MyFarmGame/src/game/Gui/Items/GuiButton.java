package game.Gui.Items;

import engine.GameItem;
import engine.graph.Texture;

import java.util.ArrayList;

public class GuiButton extends GuiContainer {

    protected boolean show;

    public boolean entered;
    public boolean disabled;
    private boolean selected;

    private String nameID;

    private ButtonAnimation buttonAnimation;

    public GuiImage buttonBackground;
    public GuiText buttonText;

    public GuiButton(float size, Texture backgroundTexture, String nameID, ArrayList<GameItem> parentItems) throws Exception {
        super(size, size, parentItems);
        entered = false;
        disabled = false;
        selected = false;
        show = true;
        this.nameID = nameID;
        buttonAnimation = new ButtonAnimation(Animation.NONE);

        makeButton(backgroundTexture, parentItems);
    }

    public GuiButton(float width, float height, Texture backgroundTexture, String nameID, ArrayList<GameItem> parentItems) throws Exception {
        super(width, height, parentItems);
        entered = false;
        disabled = false;
        selected = false;
        show = true;
        this.nameID = nameID;
        buttonAnimation = new ButtonAnimation(Animation.NONE);

        makeButton(backgroundTexture, parentItems);
    }

    public void makeButton(Texture backgroundTexture, ArrayList<GameItem> parentItems) throws Exception {
        buttonBackground = new GuiImage(width, height, backgroundTexture, parentItems);

        buttonText = new GuiText("", GuiText.SIZE_SMALL, parentItems);

        setTransparency(0.85f);
    }

    public boolean isShow() {
        return show;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
        if (disabled) {
            setTransparency(0.5f);
        } else {
            setTransparency(0.85f);
        }
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        if (selected) {
            setTransparency(1.0f);
        } else {
            setTransparency(0.85f);
        }
    }

    public void setNameID(String nameID) {
        this.nameID = nameID;
    }

    public void setTransparency(float value) {
        buttonBackground.setTransparency(value);
    }

    public void setButtonAnimationNone() {
        this.buttonAnimation.setAnimation(Animation.NONE);
    }

    public void setButtonAnimationSlideRight() {
        this.buttonAnimation.setAnimation(Animation.SLIDE_RIGHT);
    }

    public void setButtonAnimationEnlarge() {
        this.buttonAnimation.setAnimation(Animation.ENLARGE);
    }

    public void setButtonText(String text) {
        buttonText.setText(text);
    }

    public void setShow(boolean show) {
        this.show = show;
        buttonBackground.setShow(show);
        if (isBackgroundShow()) {
            containerBackground.setShow(show);
        }
        buttonText.setShow(show);
    }

    @Override
    public void setPosition(float x, float y, float z) {
        if (position.x != x || position.y != y || position.z != z) {
            this.position.x = x;
            this.position.y = y;
            this.position.z = z;
        }
        updateButtonSize();
    }

    public void updateButtonSize() {
        updateBackgroundSize();

        if (entered || selected) {
            if (buttonAnimation.animation.equals(Animation.SLIDE_RIGHT)) {
                buttonBackground.setPosition(
                        position.x + 10.0f,
                        position.y,
                        position.z
                );
            }
            if (buttonAnimation.animation.equals(Animation.ENLARGE)) {
                buttonBackground.setPosition(
                        position.x,
                        position.y,
                        position.z
                );
            }
        } else {
            buttonBackground.setPosition(
                    position.x,
                    position.y,
                    position.z
            );
        }

        buttonText.setPosition(
                getXCenterPos() - (buttonText.getWidth() / 2),
                getYCenterPos() - (buttonText.getHeight() / 2),
                0.0f
        );

    }

    public void mouseClicked() {
        System.out.println("Clicked -> " + nameID);
        // setTransparency(0.75f);
    }

    public void mouseEntered() {
        setTransparency(1.0f);
        if (!entered) {
            System.out.println("Hovered -> " + nameID);
            entered = true;

            if (!selected) {
                if (buttonAnimation.animation.equals(Animation.SLIDE_RIGHT)) {
                    setWidth(width + 10.0f);
                }
                if (buttonAnimation.animation.equals(Animation.ENLARGE)) {
                    setWidthAndHeight(width + 10.0f, height + 10.0f);
                    buttonBackground.setWidthAndHeight(width, height);
                }
            }
        }
    }

    public void mouseExited() {
        System.out.println("Stop Hovering -> " + nameID);
        entered = false;

        if (!selected) {
            setTransparency(0.85f);

            if (buttonAnimation.animation.equals(Animation.SLIDE_RIGHT)) {
                setWidth(width - 10.0f);
            }
            if (buttonAnimation.animation.equals(Animation.ENLARGE)) {
                setWidthAndHeight(width - 10.0f, height - 10.0f);
                buttonBackground.setWidthAndHeight(width, height);
            }
        }
    }

    //=============

    private enum Animation {
        NONE, SLIDE_RIGHT, ENLARGE
    }

    private class ButtonAnimation {

        Animation animation;

        public ButtonAnimation(Animation animation) {
            this.animation = animation;
        }

        public void setAnimation(Animation animation) {
            this.animation = animation;
        }
    }
}
