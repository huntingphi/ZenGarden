package com.mygdx.game.utilities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.model.DIRECTION;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by minad on 10/23/17.
 */

public class AnimationSet {
    private Map<DIRECTION,Animation> walking;
    private Map<DIRECTION,TextureRegion> standing;

    public AnimationSet(
            Animation walkNorth,Animation walkSouth,Animation  walkEast,Animation walkWest,
            TextureRegion standNorth, TextureRegion standSouth, TextureRegion standEast, TextureRegion standWest

    ){
        walking = new HashMap<DIRECTION,Animation>();
        walking.put(DIRECTION.NORTH,walkNorth);
        walking.put(DIRECTION.SOUTH,walkSouth);
        walking.put(DIRECTION.EAST,walkEast);
        walking.put(DIRECTION.WEST,walkWest);
        standing = new HashMap<DIRECTION,TextureRegion>();
        standing.put(DIRECTION.NORTH,standNorth);
        standing.put(DIRECTION.SOUTH,standSouth);
        standing.put(DIRECTION.EAST,standEast);
        standing.put(DIRECTION.WEST,standWest);
    }

    public Animation getWalking(DIRECTION d){
        return walking.get(d);
    }
    public TextureRegion getStanding(DIRECTION d){
        return standing.get(d);
    }

}
