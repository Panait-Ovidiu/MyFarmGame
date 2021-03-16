package game.Gui.Items;

import engine.GameItem;
import engine.graph.Material;
import engine.graph.Mesh;
import engine.graph.OBJLoader;
import engine.graph.Texture;
import org.joml.Vector4f;

public class GuiBackground extends GameItem {

    private Texture texture;

    private float width;
    private float height;

    public GuiBackground(float width, float height, Texture texture) throws Exception {
        super();
        this.width = width;
        this.height = height;
        this.texture = texture;
        Mesh mesh = OBJLoader.makeMesh(width, height);
        Material material = new Material();
        material.setTexture(this.texture);
        mesh.setMaterial(material);
        setMesh(mesh);
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
        try {
            Mesh mesh = OBJLoader.makeMesh(width, height);
            Material material = new Material();
            material.setTexture(this.texture);
            mesh.setMaterial(material);
            getMesh().deleteBuffers();
            setMesh(mesh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTransparency(float value) {
        getMesh().getMaterial().setAmbientColour(new Vector4f(1, 1, 1, value));
    }

    @Override
    public void setPosition(float x, float y, float z) {
        if (getPosition().x != x || getPosition().y != y || getPosition().z != z) {
            super.setPosition(x, y, z);
        }
    }

    public void rebuildMesh(float width, float height) {
        if (this.width != width || this.height != height) {
            try {
                Mesh mesh = OBJLoader.makeMesh(width, height);
                Material material = new Material();
                material.setTexture(getMesh().getMaterial().getTexture());
                mesh.setMaterial(material);
                getMesh().deleteBuffers();
                setMesh(mesh);
                this.width = width;
                this.height = height;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
