package game;

import controller.PlayerController;
import display.Display;
import entity.GameObject;
import entity.Player;
import gfx.SpriteLibrary;
import input.Input;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static int SPRITE_SIZE = 64;

    private Display display;
    private List<GameObject> gameObjects;
    private Input input;
    private SpriteLibrary spriteLibrary;

    public Game(int width, int height) {
        input = new Input();
        display = new Display(width, height, input);
        gameObjects = new ArrayList<>();
        spriteLibrary = new SpriteLibrary();
        gameObjects.add(new Player(new PlayerController(input), spriteLibrary));
    }

    public void update() {
        gameObjects.forEach(gameObject -> gameObject.update());
    }

    public void render() {
        display.render(this);
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }
}
