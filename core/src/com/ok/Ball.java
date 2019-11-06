package com.ok;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Ball extends DynamicGameObject {

    public static float BALL_WIDTH = 50;
    public static float BALL_HEIGHT = 50;


    public Ball(float x, float y, double speed){
        super(x, y, BALL_WIDTH, BALL_HEIGHT);
        velocity = speed;
        img = new Texture(Gdx.files.internal("Ball64.png"));

    }

    @Override
    public void overlap(Doge player) {
        wof.play();
        player.ballsRescuedScore++;
    }
}
