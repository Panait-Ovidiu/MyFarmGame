package engine.graph;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import engine.GameItem;

public class Transformation {

    private Matrix4f projectionMatrix;
    private Matrix4f modelMatrix;
    private Matrix4f modelViewMatrix;
    private Matrix4f viewMatrix;
    private Matrix4f orthogonalMatrix;
    private Matrix4f orthogonalModelMatrix;

    public Transformation() {
        projectionMatrix = new Matrix4f();
        modelMatrix = new Matrix4f();
        modelViewMatrix = new Matrix4f();
        viewMatrix = new Matrix4f();
        orthogonalMatrix = new Matrix4f();
        orthogonalModelMatrix = new Matrix4f();
    }

    public Matrix4f getProjectionMatrix() {
        return projectionMatrix;
    }

    public Matrix4f updateProjectionMatrix(float fov, float width, float height, float zNear, float zFar) {
        float aspectRatio = width / height;
        projectionMatrix.identity();
        projectionMatrix.perspective(fov, aspectRatio, zNear, zFar);
        return projectionMatrix;
    }

    public Matrix4f getViewMatrix() {
        return viewMatrix;
    }

    public Matrix4f updateViewMatrix(Camera camera) {
        Vector3f cameraPos = camera.getPosition();
        Vector3f rotation = camera.getRotation();

        viewMatrix.identity();
        // First do the rotation so camera rotates over its position
        viewMatrix.rotate((float)Math.toRadians(rotation.x), new Vector3f(1, 0, 0))
                .rotate((float)Math.toRadians(rotation.y), new Vector3f(0, 1, 0));
        // Then do the translation
        viewMatrix.translate(-cameraPos.x, -cameraPos.y, -cameraPos.z);
        return viewMatrix;
    }

    public Matrix4f getOrthogonalProjectionMatrix(float left, float right, float bottom, float top) {
        orthogonalMatrix.identity();
        orthogonalMatrix.setOrtho2D(left, right, bottom, top);
        return orthogonalMatrix;
    }

    public Matrix4f buildModelViewMatrix(GameItem gameItem, Matrix4f viewMatrix) {
        Vector3f rotation = gameItem.getRotation();
        modelMatrix.identity().translate(gameItem.getPosition()).
                rotateX((float)Math.toRadians(-rotation.x)).
                rotateY((float)Math.toRadians(-rotation.y)).
                rotateZ((float)Math.toRadians(-rotation.z)).
                scale(gameItem.getScale());
        modelViewMatrix.set(viewMatrix);
        return modelViewMatrix.mul(modelMatrix);
    }

    public Matrix4f buildOrthogonalProjectionModelMatrix(GameItem gameItem, Matrix4f orthogonalMatrix) {
        Vector3f rotation = gameItem.getRotation();
        modelMatrix.identity().translate(gameItem.getPosition()).
                rotateX((float) Math.toRadians(-rotation.x)).
                rotateY((float) Math.toRadians(-rotation.y)).
                rotateZ((float) Math.toRadians(-rotation.z)).
                scale(gameItem.getScale());
        orthogonalModelMatrix.set(orthogonalMatrix);
        orthogonalModelMatrix.mul(modelMatrix);
        return orthogonalModelMatrix;
    }
}
