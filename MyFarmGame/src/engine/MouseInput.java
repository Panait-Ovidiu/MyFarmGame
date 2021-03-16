package engine;

import org.joml.Vector2d;
import org.joml.Vector2f;

import static org.lwjgl.glfw.GLFW.*;

public class MouseInput {

    private final Vector2d PREVIOUS_POS;
    private final Vector2d CURRENT_POS;
    private final Vector2f DISPLACEMENT_VEC;

    private boolean inWindow = false;

    private long normalCursor;
    private long hResizeCursor;
    private long vResizeCursor;

    public boolean leftButtonPressed = false;
    public boolean leftButtonReleased = false;
    public boolean rightButtonPressed = false;
    public boolean rightButtonReleased = false;

    public MouseInput() {
        PREVIOUS_POS = new Vector2d(-1, -1);
        CURRENT_POS = new Vector2d(0, 0);
        DISPLACEMENT_VEC = new Vector2f();
    }

    public void init(Window window) {
        glfwSetCursorPosCallback(window.getWindowHandle(), (windowHandle, xpos, ypos) -> {
            CURRENT_POS.x = xpos;
            CURRENT_POS.y = ypos;
        });
        glfwSetCursorEnterCallback(window.getWindowHandle(), (windowHandle, entered) -> {
            inWindow = entered;
        });
        glfwSetMouseButtonCallback(window.getWindowHandle(), (windowHandle, button, action, mode) -> {
            leftButtonPressed = button == GLFW_MOUSE_BUTTON_LEFT && action == GLFW_PRESS;
            leftButtonReleased = button == GLFW_MOUSE_BUTTON_LEFT && action == GLFW_RELEASE;
            rightButtonPressed = button == GLFW_MOUSE_BUTTON_RIGHT && action == GLFW_PRESS;
            rightButtonReleased = button == GLFW_MOUSE_BUTTON_RIGHT && action == GLFW_RELEASE;
        });

        glfwSetScrollCallback(window.getWindowHandle(), (windowHandle, xOffset, yOffset) -> {
            System.out.println("xOffset:" + xOffset + " yOffset:" + yOffset);
        });

        normalCursor = glfwCreateStandardCursor(GLFW_HAND_CURSOR);
        hResizeCursor = glfwCreateStandardCursor(GLFW_HRESIZE_CURSOR);
        vResizeCursor = glfwCreateStandardCursor(GLFW_VRESIZE_CURSOR);
        glfwSetCursor(window.getWindowHandle(), normalCursor);
    }

    public void setNormalCursor(Window window) {
        glfwSetCursor(window.getWindowHandle(), normalCursor);
    }

    public void setHResizeCursor(Window window) {
        glfwSetCursor(window.getWindowHandle(), hResizeCursor);
    }

    public void setVResizeCursor(Window window) {
        glfwSetCursor(window.getWindowHandle(), vResizeCursor);
    }

    public Vector2f getDisplacementVec() {
        return DISPLACEMENT_VEC;
    }

    public Vector2d getCurrentPos() {
        return CURRENT_POS;
    }

    public void input(Window window) {
        DISPLACEMENT_VEC.x = 0;
        DISPLACEMENT_VEC.y = 0;
        if (PREVIOUS_POS.x > 0 && PREVIOUS_POS.y > 0 && inWindow) {
            double deltaX = CURRENT_POS.x - PREVIOUS_POS.x;
            double deltaY = CURRENT_POS.y - PREVIOUS_POS.y;
            boolean rotateX = deltaX != 0;
            boolean rotateY = deltaY != 0;
            if (rotateX) {
                DISPLACEMENT_VEC.y = (float) deltaX;
            }
            if (rotateY) {
                DISPLACEMENT_VEC.x = (float) deltaY;
            }
        }
        PREVIOUS_POS.x = CURRENT_POS.x;
        PREVIOUS_POS.y = CURRENT_POS.y;
    }

    public boolean isInWindow() {
        return inWindow;
    }

    public boolean isLeftButtonPressed() {
        return leftButtonPressed;
    }

    public void setLeftButtonPressed(boolean leftButtonPressed) {
        this.leftButtonPressed = leftButtonPressed;
    }

    public boolean isLeftButtonReleased() {
        return leftButtonReleased;
    }

    public void setLeftButtonReleased(boolean leftButtonReleased) {
        this.leftButtonReleased = leftButtonReleased;
    }

    public boolean isRightButtonPressed() {
        return rightButtonPressed;
    }

    public void setRightButtonPressed(boolean rightButtonPressed) {
        this.rightButtonPressed = rightButtonPressed;
    }

    public boolean isRightButtonReleased() {
        return rightButtonReleased;
    }

    public void setRightButtonReleased(boolean rightButtonReleased) {
        this.rightButtonReleased = rightButtonReleased;
    }
}
