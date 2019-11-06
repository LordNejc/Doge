package com.ok;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Doge extends DynamicGameObject {

    public static float DOGE_WIDTH = 50;
    public static float DOGE_HEIGHT = 50;
    private static int SPEED = 600; // pixels per second

    public int ballsRescuedScore;
    public int playerHealth; //Starts with 100

    public Doge(float x, float y){
        super(x, y, DOGE_WIDTH, DOGE_HEIGHT);
        img = new Texture(Gdx.files.internal("doge64.png"));
    }

    public void update(Camera camera){
        bounds.x = position.x - bounds.width / 2;
        bounds.y = position.y - bounds.height / 2;

        if(Gdx.input.isTouched()) commandTouched(camera); //mouse or touch screen
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) commandMoveLeft();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) commandMoveRight();
        if(Gdx.input.isKeyPressed(Input.Keys.A)) commandMoveLeftCorner();
        if(Gdx.input.isKeyPressed(Input.Keys.S)) commandMoveRightCorner();

    }

    public void commandMoveLeft() {
        position.x -= SPEED * Gdx.graphics.getDeltaTime();
        if(position.x < 0){
            position.x = Gdx.graphics.getWidth() - img.getWidth();
        }
    }
    public void commandMoveRight() {
        position.x += SPEED * Gdx.graphics.getDeltaTime();
        if(position.x > Gdx.graphics.getWidth() - img.getWidth()) {
            position.x = 0;
        }
    }
    public void commandMoveLeftCorner() {
        position.x = 0;
    }
    public void commandMoveRightCorner() {
        position.x = Gdx.graphics.getWidth() - img.getWidth();
    }
    public void commandTouched(Camera camera) {
        Vector3 touchPos = new Vector3();
        touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(touchPos);
        position.x = touchPos.x - img.getWidth() / 2;
    }
    @Override
    public void overlap(Doge player) {
        //wof.play();
    }
}
