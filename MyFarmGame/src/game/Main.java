package game;

import engine.GameEngine;
import engine.IGameLogic;

public class Main {

    public static void main(String[] args) {
        try {
            boolean vSync = true;
            IGameLogic gameLogic = new MyFarmGame();
            GameEngine gameEngine = new GameEngine("GAME", 1024, 600, vSync, gameLogic);
            System.out.println("Made Game Engine");
            gameEngine.run();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}