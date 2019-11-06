package com.ok;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Coco extends DynamicGameObject {

    public static float COCO_WIDTH = 50;
    public static float COCO_HEIGHT = 50;

    public Coco (float x, float y, double speed){
        super(x, y ,COCO_WIDTH, COCO_HEIGHT );
        velocity = speed;
        img = new Texture(Gdx.files.internal("coco128.png"));
    }

    @Override
    public void overlap(Doge player) {
        dead.play();
       player.playerHealth--;
    }
}
