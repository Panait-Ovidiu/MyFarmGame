package engine;

public class GameEngine implements Runnable {

    public static final int TARGET_FPS = 75;
    public static final int TARGET_UPS = 30;

    private final Window WINDOW;
    private final Timer TIMER;
    private final IGameLogic GAME_LOGIC;
    private final MouseInput MOUSE_INPUT;

    private boolean inputOnce = false;
    private boolean updateOnce = false;
    private boolean renderOnce = false;

    public GameEngine(String windowTitle, int width, int height, boolean vSync, IGameLogic gameLogic) throws Exception {
        WINDOW = new Window(windowTitle, width, height, vSync);
        TIMER = new Timer();
        GAME_LOGIC = gameLogic;
        MOUSE_INPUT = new MouseInput();
    }

    @Override
    public void run() {
        try {
            init();
            gameLoop();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cleanup();
        }
    }

    protected void init() throws Exception {
        WINDOW.init();
        System.out.println("Initialize MainMenuWindow");
        TIMER.init();
        System.out.println("Initialize Timer");
        MOUSE_INPUT.init(WINDOW);
        System.out.println("Initialize Input");
        GAME_LOGIC.init(WINDOW);
        System.out.println("Initialize Logic");
    }

    protected void gameLoop() {
        float elapsedTime;
        float accumulator = 0f;
        float interval = 1f / TARGET_UPS;

        boolean running = true;
        while (running && !WINDOW.windowShouldClose()) {
            elapsedTime = TIMER.getElapsedTime();
            accumulator += elapsedTime;

            input();
            if (!inputOnce) {
                inputOnce = true;
                System.out.println("Initialize input");
            }

            while (accumulator >= interval) {
                update(interval);
                if (!updateOnce) {
                    updateOnce = true;
                    System.out.println("Initialize update");
                }
                accumulator -= interval;
            }

            render();
            if (!renderOnce) {
                renderOnce = true;
                System.out.println("Initialize Render");
            }

            if (!WINDOW.isvSync()) {
                sync();
            }
        }
    }

    protected void cleanup() {
        GAME_LOGIC.cleanUp();
    }

    private void sync() {
        float loopSlot = 1f / TARGET_FPS;
        double endTime = TIMER.getLastLoopTime() + loopSlot;
        while (TIMER.getTime() < endTime) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ie) {
            }
        }
    }

    protected void input() {
        MOUSE_INPUT.input(WINDOW);
        GAME_LOGIC.input(WINDOW, MOUSE_INPUT);
    }

    protected void update(float interval) {
        GAME_LOGIC.update(interval, MOUSE_INPUT);
    }

    protected void render() {
        GAME_LOGIC.render(WINDOW);
        if (!renderOnce) {
            System.out.println("Initialize GameLogic Render");
        }
        WINDOW.update();
        if (!renderOnce) {
            System.out.println("Initialize MainMenuWindow Update");
        }
    }
}
