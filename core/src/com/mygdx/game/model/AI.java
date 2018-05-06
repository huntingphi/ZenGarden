package com.mygdx.game.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minad on 10/23/17.
 */

public interface AI{
    public abstract void setTarget(Entity e);
    public abstract Entity getTarget();
    public abstract List<DIRECTION> getMovements();
    public abstract void move();
}
