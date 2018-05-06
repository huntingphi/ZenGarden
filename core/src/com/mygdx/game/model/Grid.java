package com.mygdx.game.model;

import java.util.Random;

/**
 * Created by minad on 10/22/17.
 */

public class Grid {
    private int width, height;
    private Tile[][] tiles;
    Random generator;
    public Grid(int width, int height) {
        generator  = new Random();
        this.width = width;
        this.height = height;
        tiles = new Tile[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if(generator.nextDouble()<0.5)
                tiles[x][y] = new Tile(TileType.GRASS_1);
                else tiles[x][y] = new Tile(TileType.GRASS_2);

            }
        }
    }

    public Tile getTile(int x, int y){
        return tiles[x][y];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
