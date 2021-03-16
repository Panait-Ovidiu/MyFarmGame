package engine;

import java.util.ArrayList;
import java.util.List;

import engine.graph.FontTexture;
import engine.graph.Material;
import engine.graph.Mesh;

public class TextItem extends GameItem {

    private static final float Z_POS = 0.0f;

    private float height;
    private float width;

    private boolean isCenter;

    private static final int VERTICES_PER_QUAD = 4;

    private final FontTexture FONT_TEXTURE;

    private String text;

    public TextItem(String text, FontTexture fontTexture) throws Exception {
        super();
        isCenter = false;
        this.text = text;
        FONT_TEXTURE = fontTexture;
        setMesh(buildMesh());
    }

    private Mesh buildMesh() {
        List<Float> positions = new ArrayList();
        List<Float> textCoords = new ArrayList();
        float[] normals = new float[0];
        List<Integer> indices = new ArrayList();
        char[] characters = text.toCharArray();
        int numChars = characters.length;

        height = FONT_TEXTURE.getHeight() + 1;
        width = 1;

        float startx = 0;
        float padding = 1;
        for (int i = 0; i < numChars; i++) {
            FontTexture.CharInfo charInfo = FONT_TEXTURE.getCharInfo(characters[i]);

            width += FONT_TEXTURE.getCharInfo(characters[i]).getWidth() + padding;

            // Build a character tile composed by two triangles

            // Left Top vertex
            positions.add(startx); // x
            positions.add(0.0f); //y
            positions.add(Z_POS); //z
            textCoords.add((float) charInfo.getStartX() / (float) FONT_TEXTURE.getWidth());
            textCoords.add(0.0f);
            indices.add(i * VERTICES_PER_QUAD);

            // Left Bottom vertex
            positions.add(startx); // x
            positions.add((float) FONT_TEXTURE.getHeight() + padding); //y
            positions.add(Z_POS); //z
            textCoords.add((float) charInfo.getStartX() / (float) FONT_TEXTURE.getWidth());
            textCoords.add(1.0f);
            indices.add(i * VERTICES_PER_QUAD + 1);

            // Right Bottom vertex
            positions.add(startx + charInfo.getWidth() + padding); // x
            positions.add((float) FONT_TEXTURE.getHeight() + padding); //y
            positions.add(Z_POS); //z
            textCoords.add((float) (charInfo.getStartX() + charInfo.getWidth()) / (float) FONT_TEXTURE.getWidth());
            textCoords.add(1.0f);
            indices.add(i * VERTICES_PER_QUAD + 2);

            // Right Top vertex
            positions.add(startx + charInfo.getWidth() + padding); // x
            positions.add(0.0f); //y
            positions.add(Z_POS); //z
            textCoords.add((float) (charInfo.getStartX() + charInfo.getWidth()) / (float) FONT_TEXTURE.getWidth());
            textCoords.add(0.0f);
            indices.add(i * VERTICES_PER_QUAD + 3);

            // Add indices por left top and bottom right vertices
            indices.add(i * VERTICES_PER_QUAD);
            indices.add(i * VERTICES_PER_QUAD + 2);

            startx += charInfo.getWidth() + padding;
        }

        float[] posArr = Utils.listToArray(positions);
        float[] textCoordsArr = Utils.listToArray(textCoords);
        int[] indicesArr = indices.stream().mapToInt(i -> i).toArray();
        Mesh mesh = new Mesh(posArr, textCoordsArr, normals, indicesArr);
        mesh.setMaterial(new Material(FONT_TEXTURE.getTexture()));
        return mesh;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        this.getMesh().deleteBuffers();
        this.setMesh(buildMesh());
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public void setToCenter() {
        isCenter = true;
        setPosition(getPosition().x - (width / 2), getPosition().y - (height / 2), getPosition().z);
    }

    public void removeToCenter() {
        if (isCenter) {
            isCenter = false;
            setPosition(getPosition().x + (width / 2), getPosition().y + (height / 2), getPosition().z);
        }
    }
}