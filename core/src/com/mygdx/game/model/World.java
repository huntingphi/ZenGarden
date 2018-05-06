package com.mygdx.game.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.scenes.scene2d.ui.List;

import java.util.ArrayList;

import javax.rmi.CORBA.Tie;

/**
 * Created by minad on 10/23/17.
 */

public class World {
    private Grid grid;
    private ArrayList<Entity> entitys;
    private ArrayList<WorldObject> objects;

    public World(int width,int height){
        this.grid = new Grid(width,height);
        entitys = new ArrayList<Entity>();
        objects = new ArrayList<WorldObject>();
    }

    public void addEntity(Entity e){
        grid.getTile(e.getX(),e.getY()).setEntity(e);
        entitys.add(e);
    }

    public void addObject(WorldObject wo){
        for (GridPoint2 point:wo.getTiles()
             ) {
            grid.getTile(wo.getX()+point.x,wo.getY()+point.y).setWo(wo);
            objects.add(wo);
        }
    }

    public void update(float delta) {
//        for (Entity e : entitys) {
//            if (brains.containsKey(a)) {
//                brains.get(a).update(delta);
//            }
//            a.update(delta);
//        }
        for (WorldObject o : objects) {
            o.update(delta);
        }
    }

    public Grid getGrid() {
        return grid;
    }
}
