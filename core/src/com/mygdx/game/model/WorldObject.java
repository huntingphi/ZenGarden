package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.scenes.scene2d.ui.List;

import java.util.ArrayList;

/**
 * Created by minad on 10/23/17.
 */

public class WorldObject implements Sortable {
    private float animationTimer;
    private int x,y;
    private TextureRegion texture;
    private float sizeX,sizeY;
    private Animation animation;

    private ArrayList<GridPoint2> tiles;
    private boolean walkable;


    public WorldObject(int x, int y, TextureRegion texture, float sizeX, float sizeY,  GridPoint2[] tiles) {
        this.x = x;
        this.y = y;
        this.texture = texture;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.tiles = new ArrayList<GridPoint2>();
        for (GridPoint2 point:tiles
                ) {
            this.tiles.add(point);
        }
    }

    public WorldObject(int x, int y, Animation animation, float sizeX, float sizeY, GridPoint2[] tiles,boolean walkable) {
        this.x = x;
        this.y = y;
        this.animation = animation;
        this.animationTimer = 0f;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.tiles = new ArrayList<GridPoint2>();
        for (GridPoint2 point:tiles
                ) {
            this.tiles.add(point);
        }
        this.walkable = walkable;
    }

    public WorldObject(int x, int y, TextureRegion texture, float sizeX, float sizeY,GridPoint2[] tiles, boolean walkable) {
        this.x = x;
        this.y = y;
        this.texture = texture;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.tiles = new ArrayList<GridPoint2>();
        for (GridPoint2 point:tiles
                ) {
            this.tiles.add(point);
        }
        this.walkable = walkable;


    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TextureRegion getTexture() {
        return texture;
    }

    @Override
    public float getWorldX() {
        return getX();
    }

    @Override
    public float getWorldY() {
        return getY();
    }

    public void update(float delta) {
        if (animation == null) return;
            animationTimer += delta;
    }

    @Override
    public TextureRegion getSprite() {
        if(texture == null)return (TextureRegion) animation.getKeyFrame(animationTimer);
        return getTexture();
    }

    public float getSizeX() {
        return sizeX;
    }

    public float getSizeY() {
        return sizeY;
    }

    public ArrayList<GridPoint2> getTiles() {
        return tiles;
    }

    public boolean isWalkable() {
        return walkable;
    }


}

