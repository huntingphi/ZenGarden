package com.mygdx.game.model;

/**
 * Created by minad on 10/22/17.
 */

public class Tile {
    private TileType terrain;
    private WorldObject wo;

    public WorldObject getWo() {
        return wo;
    }

    public void setWo(WorldObject wo) {

        this.wo = wo;
    }

    private Entity entity;

    public Tile(TileType terrain) {
        this.terrain = terrain;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public TileType getTerrain() {
        return terrain;
    }

}
