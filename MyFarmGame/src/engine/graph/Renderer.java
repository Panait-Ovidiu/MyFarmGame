package engine.graph;

import java.util.List;
import java.util.Map;

import engine.*;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import static org.lwjgl.opengl.GL11.*;

public class Renderer {

    private static final float FOV = (float) Math.toRadians(60.0f);
    private static final float Z_NEAR = 0.01f;
    private static final float Z_FAR = 1000.f;

    private static final int MAX_POINT_LIGHTS = 5;
    private static final int MAX_SPOT_LIGHTS = 5;

    private Transformation transformation;
    private ShaderProgram sceneShaderProgram;
    private ShaderProgram guiShaderProgram;
    private ShaderProgram skyBoxShaderProgram;

    private float rotation = 0;
    private static final float ROTATE_SPEED = 0.016f;
    private float specularPower;

    public Renderer() {
        transformation = new Transformation();
        specularPower = 10f;
    }

    public void init(Window window) throws Exception {
        setupSkyBoxShader();
        setupSceneShader();
        setupGuiShader();
    }

    private void setupSkyBoxShader() throws Exception {
        skyBoxShaderProgram = new ShaderProgram();
        skyBoxShaderProgram.createVertexShader(Utils.loadResource("/resources/shaders/sb_vertex.vs"));
        skyBoxShaderProgram.createFragmentShader(Utils.loadResource("/resources/shaders/sb_fragment.fs"));
        skyBoxShaderProgram.link();

        // Create uniforms for projection matrix
        skyBoxShaderProgram.createUniform("projectionMatrix");
        skyBoxShaderProgram.createUniform("modelViewMatrix");
        skyBoxShaderProgram.createUniform("texture_sampler");
        skyBoxShaderProgram.createUniform("ambientLight");
    }

    private void setupSceneShader() throws Exception {
        // Create shader
        sceneShaderProgram = new ShaderProgram();
        sceneShaderProgram.createVertexShader(Utils.loadResource("/resources/shaders/scene_vertex.vs"));
        sceneShaderProgram.createFragmentShader(Utils.loadResource("/resources/shaders/scene_fragment.fs"));
        sceneShaderProgram.link();

        // Create uniforms for modelView and projection matrices and texture
        sceneShaderProgram.createUniform("projectionMatrix");
        sceneShaderProgram.createUniform("modelViewMatrix");
        sceneShaderProgram.createUniform("texture_sampler");
        // Create uniform for material
        sceneShaderProgram.createMaterialUniform("material");
        // Create lighting related uniforms
        sceneShaderProgram.createUniform("specularPower");
        sceneShaderProgram.createUniform("ambientLight");
        sceneShaderProgram.createPointLightListUniform("pointLights", MAX_POINT_LIGHTS);
        sceneShaderProgram.createSpotLightListUniform("spotLights", MAX_SPOT_LIGHTS);
        sceneShaderProgram.createDirectionalLightUniform("directionalLight");
    }

    private void setupGuiShader() throws Exception {
        guiShaderProgram = new ShaderProgram();
        guiShaderProgram.createVertexShader(Utils.loadResource("/resources/shaders/hud_vertex.vs"));
        guiShaderProgram.createFragmentShader(Utils.loadResource("/resources/shaders/hud_fragment.fs"));
        guiShaderProgram.link();

        // Create uniforms for Orthographic-model projection matrix and base colour
        guiShaderProgram.createUniform("projModelMatrix");
        guiShaderProgram.createUniform("colour");
        guiShaderProgram.createUniform("hasTexture");
    }

    public void clear() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    public void render(Window window, Camera camera, Scene scene, IGui gui) {
        clear();

        if (window.isResized()) {
            glViewport(0, 0, window.getWidth(), window.getHeight());
            window.setResized(false);
        }

        // Update projection and view matrices once per render cycle
        transformation.updateProjectionMatrix(FOV, window.getWidth(), window.getHeight(), Z_NEAR, Z_FAR);
        transformation.updateViewMatrix(camera);

        renderScene(window, camera, scene);

        if (scene.getSkyBox() != null) {
            renderSkyBox(window, camera, scene);
        }

        renderGui(window, gui);
    }

    private void renderSkyBox(Window window, Camera camera, Scene scene) {
        skyBoxShaderProgram.bind();

        skyBoxShaderProgram.setUniform("texture_sampler", 0);

        Matrix4f projectionMatrix = transformation.getProjectionMatrix();
        skyBoxShaderProgram.setUniform("projectionMatrix", projectionMatrix);

        SkyBox skyBox = scene.getSkyBox();
        rotation += ROTATE_SPEED;
        if(rotation > 360) {
            rotation = rotation % 360;
        }
        skyBox.setRotation(0, rotation, 0);
        Matrix4f viewMatrix = transformation.getViewMatrix();
        viewMatrix.m30(0);
        viewMatrix.m31(0);
        viewMatrix.m32(0);
        Matrix4f modelViewMatrix = transformation.buildModelViewMatrix(skyBox, viewMatrix);
        skyBoxShaderProgram.setUniform("modelViewMatrix", modelViewMatrix);
        skyBoxShaderProgram.setUniform("ambientLight", scene.getSceneLight().getAmbientLight());

        scene.getSkyBox().getMesh().render();

        skyBoxShaderProgram.unbind();
    }

    public void renderScene(Window window, Camera camera, Scene scene) {
        sceneShaderProgram.bind();

        Matrix4f projectionMatrix = transformation.getProjectionMatrix();
        sceneShaderProgram.setUniform("projectionMatrix", projectionMatrix);

        Matrix4f viewMatrix = transformation.getViewMatrix();

        SceneLight sceneLight = scene.getSceneLight();
        renderLights(viewMatrix, sceneLight);

        sceneShaderProgram.setUniform("texture_sampler", 0);

        // Render each mesh with the associated terrain Items
        Map<Mesh, List<GameItem>> terrainMeshes = scene.getTerrain();
        for (Mesh mesh : terrainMeshes.keySet()) {
            sceneShaderProgram.setUniform("material", mesh.getMaterial());
            mesh.renderList(terrainMeshes.get(mesh), (GameItem gameItem) -> {
                        Matrix4f modelViewMatrix = transformation.buildModelViewMatrix(gameItem, viewMatrix);
                        sceneShaderProgram.setUniform("modelViewMatrix", modelViewMatrix);
                    }
            );
        }

        // Render each mesh with the associated building Items
        Map<Mesh, List<GameItem>> buildingMeshes = scene.getBuildings();
        for (Mesh mesh : buildingMeshes.keySet()) {
            sceneShaderProgram.setUniform("material", mesh.getMaterial());
            mesh.renderList(buildingMeshes.get(mesh), (GameItem gameItem) -> {
                        Matrix4f modelViewMatrix = transformation.buildModelViewMatrix(gameItem, viewMatrix);
                        sceneShaderProgram.setUniform("modelViewMatrix", modelViewMatrix);
                    }
            );
        }

        // Render each mesh with the associated decoration Items
        Map<Mesh, List<GameItem>> decorationMeshes = scene.getDecorations();
        for (Mesh mesh : decorationMeshes.keySet()) {
            sceneShaderProgram.setUniform("material", mesh.getMaterial());
            mesh.renderList(decorationMeshes.get(mesh), (GameItem gameItem) -> {
                        Matrix4f modelViewMatrix = transformation.buildModelViewMatrix(gameItem, viewMatrix);
                        sceneShaderProgram.setUniform("modelViewMatrix", modelViewMatrix);
                    }
            );
        }

        // Render each mesh with the associated plant Items
        Map<Mesh, List<GameItem>> plantMeshes = scene.getPlants();
        for (Mesh mesh : plantMeshes.keySet()) {
            sceneShaderProgram.setUniform("material", mesh.getMaterial());
            mesh.renderList(plantMeshes.get(mesh), (GameItem gameItem) -> {
                        Matrix4f modelViewMatrix = transformation.buildModelViewMatrix(gameItem, viewMatrix);
                        sceneShaderProgram.setUniform("modelViewMatrix", modelViewMatrix);
                    }
            );
        }

        // Render each mesh with the associated animal Items
        Map<Mesh, List<GameItem>> animalMeshes = scene.getAnimals();
        for (Mesh mesh : animalMeshes.keySet()) {
            sceneShaderProgram.setUniform("material", mesh.getMaterial());
            mesh.renderList(animalMeshes.get(mesh), (GameItem gameItem) -> {
                        Matrix4f modelViewMatrix = transformation.buildModelViewMatrix(gameItem, viewMatrix);
                        sceneShaderProgram.setUniform("modelViewMatrix", modelViewMatrix);
                    }
            );
        }

        // Render each mesh with the associated utils Items
        Map<Mesh, List<GameItem>> utilMeshes = scene.getUtils();
        for (Mesh mesh : utilMeshes.keySet()) {
            sceneShaderProgram.setUniform("material", mesh.getMaterial());
            mesh.renderList(utilMeshes.get(mesh), (GameItem gameItem) -> {
                        Matrix4f modelViewMatrix = transformation.buildModelViewMatrix(gameItem, viewMatrix);
                        sceneShaderProgram.setUniform("modelViewMatrix", modelViewMatrix);
                    }
            );
        }

        sceneShaderProgram.unbind();
    }

    private void renderLights(Matrix4f viewMatrix, SceneLight sceneLight) {

        sceneShaderProgram.setUniform("ambientLight", sceneLight.getAmbientLight());
        sceneShaderProgram.setUniform("specularPower", specularPower);

        // Process Point Lights
        PointLight[] pointLightList = sceneLight.getPointLightList();
        int numLights = pointLightList != null ? pointLightList.length : 0;
        for (int i = 0; i < numLights; i++) {
            // Get a copy of the point light object and transform its position to view coordinates
            PointLight currPointLight = new PointLight(pointLightList[i]);
            Vector3f lightPos = currPointLight.getPosition();
            Vector4f aux = new Vector4f(lightPos, 1);
            aux.mul(viewMatrix);
            lightPos.x = aux.x;
            lightPos.y = aux.y;
            lightPos.z = aux.z;
            sceneShaderProgram.setUniform("pointLights", currPointLight, i);
        }

        // Process Spot Lights
        SpotLight[] spotLightList = sceneLight.getSpotLightList();
        numLights = spotLightList != null ? spotLightList.length : 0;
        for (int i = 0; i < numLights; i++) {
            // Get a copy of the spot light object and transform its position and cone direction to view coordinates
            SpotLight currSpotLight = new SpotLight(spotLightList[i]);
            Vector4f dir = new Vector4f(currSpotLight.getConeDirection(), 0);
            dir.mul(viewMatrix);
            currSpotLight.setConeDirection(new Vector3f(dir.x, dir.y, dir.z));

            Vector3f lightPos = currSpotLight.getPointLight().getPosition();
            Vector4f aux = new Vector4f(lightPos, 1);
            aux.mul(viewMatrix);
            lightPos.x = aux.x;
            lightPos.y = aux.y;
            lightPos.z = aux.z;

            sceneShaderProgram.setUniform("spotLights", currSpotLight, i);
        }

        // Get a copy of the directional light object and transform its position to view coordinates
        DirectionalLight currDirLight = new DirectionalLight(sceneLight.getDirectionalLight());
        Vector4f dir = new Vector4f(currDirLight.getDirection(), 0);
        dir.mul(viewMatrix);
        currDirLight.setDirection(new Vector3f(dir.x, dir.y, dir.z));
        sceneShaderProgram.setUniform("directionalLight", currDirLight);
    }

    private void renderGui(Window window, IGui gui) {
        guiShaderProgram.bind();

        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glDisable(GL_DEPTH_TEST);

        Matrix4f ortho = transformation.getOrthogonalProjectionMatrix(0, window.getWidth(), window.getHeight(), 0);
        for (GameItem gameItem : gui.getGameItems()) {
            if(gameItem.isShow()) {
                Mesh mesh = gameItem.getMesh();
                // Set orthographic and model matrix for this HUD item
                Matrix4f projModelMatrix = transformation.buildOrthogonalProjectionModelMatrix(gameItem, ortho);
                guiShaderProgram.setUniform("projModelMatrix", projModelMatrix);
                guiShaderProgram.setUniform("colour", gameItem.getMesh().getMaterial().getAmbientColour());
                guiShaderProgram.setUniform("hasTexture", gameItem.getMesh().getMaterial().isTextured() ? 1 : 0);

                // Render the mesh for this HUD item
                mesh.render();
            }
        }

        glEnable(GL_DEPTH_TEST);
        glDisable(GL_BLEND);

        guiShaderProgram.unbind();
    }

    public void cleanUp() {
        if (skyBoxShaderProgram != null) {
            skyBoxShaderProgram.cleanup();
        }
        if (sceneShaderProgram != null) {
            sceneShaderProgram.cleanup();
        }
        if (guiShaderProgram != null) {
            guiShaderProgram.cleanup();
        }
    }
}
