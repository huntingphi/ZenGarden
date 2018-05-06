package com.mygdx.game.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by minad on 10/23/17.
 */
public interface Sortable {

    public float getWorldX();

    public float getWorldY();

    public TextureRegion getSprite();

    public float getSizeX();

    public float getSizeY();
}
