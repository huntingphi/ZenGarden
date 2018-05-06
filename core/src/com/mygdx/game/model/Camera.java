package com.mygdx.game.model;

/**
 * Created by minad on 10/22/17.
 */

public class Camera {
    private float cameraX = 0f;
    private float cameraY = 0f;

    public void update(float newX,float newY){
        cameraX = newX;
        cameraY = newY;
    }

    public float getCameraX() {
        return cameraX;
    }


    public float getCameraY() {
        return cameraY;
    }

}
