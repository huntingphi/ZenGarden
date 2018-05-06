package com.mygdx.game.Screens;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.model.Animations;
import com.mygdx.game.model.Entity;
import com.mygdx.game.model.World;
import com.mygdx.game.model.WorldObject;
import com.mygdx.game.utilities.AnimationSet;

import java.util.ArrayList;

/**
 * Created by minad on 10/23/17.
 */

public class WorldGenerator {

    private Animation flowerAnimation;

    private AssetManager assetManager;
    public static ArrayList<WorldObject> flowers = new ArrayList<>();




    public World loadWorld(int WORLD_WIDTH,int WORLD_HEIGHT) {
        int width = WORLD_WIDTH;
        int height = WORLD_HEIGHT;
        World world = new World(width,height);
        addHouse(world,height/2+2,width/2+2);
        for (int xi = 0; xi < width; xi++) {
            for (int yi = 0; yi < height; yi++) {
                if (xi==0 || xi==width-2) {
                    if (world.getGrid().getTile(xi, yi).getWo() == null) {
                        addTree(world,xi,yi);

                    }

                }
                if (yi==0||yi==height-2) {
                    if (world.getGrid().getTile(xi, yi).getWo() == null) {
                        addTree(world,xi,yi);
                    }
                }
            }
        }

        for (int i = 0; i < width*height/10; i++) {
            int xr = MathUtils.random(width-2)+1;
            int yr = MathUtils.random(height-2)+1;
            if (world.getGrid().getTile(xr, yr).getWo() == null) {
                double decider = Math.random();
                if(decider>0.4) {
                    addFlowers(world, xr, yr);
                }else{
                    if (world.getGrid().getTile(xr, yr+1).getWo() != null) {
//                        addTree(world, xr, yr);
                    }else {
                        addFlowers(world,xr,yr);

                    }
                }
            }
        }
//        addRug(world,35,35);

//        addTree(world,6,6);
//        addTree(world,7,6);
//        addTree(world,8,6);

//        addFlowers(world,5,5);






        return world;
    }


    private void addHouse(World world, int x, int y) {
        TextureAtlas atlas = assetManager.get("graphics_packed/tiles/tilepack.atlas", TextureAtlas.class);
        TextureRegion houseRegion = atlas.findRegion("small_house");
        GridPoint2[] gridArray = new GridPoint2[5*4-1];
        int index = 0;
        for (int loopX = 0; loopX < 5; loopX++) {
            for (int loopY = 0; loopY < 4; loopY++) {
                if (loopX==3&&loopY==0) {
                    continue;
                }
//                if(loopY==0){
//                    addFlowers(world,x,y-1);
//                    addFlowers(world,x+1,y-1);
//                    addFlowers(world,x+2,y-1);
//                    addFlowers(world,x+4,y-1);
//
//
//                }
                gridArray[index] = new GridPoint2(loopX, loopY);
                index++;
            }
        }
        WorldObject house = new WorldObject(x, y,  houseRegion, 5f, 5f, gridArray,false);
        world.addObject(house);
    }



    private void addFlowers(World world, int x, int y) {
        GridPoint2[] gridArray = new GridPoint2[1];
        gridArray[0] = new GridPoint2(0,0);
        WorldObject flower = new WorldObject(x, y, flowerAnimation, 1f, 1f, gridArray,true);
        world.addObject(flower);
        flowers.add(flower);
    }

    private void addTree(World world, int x, int y) {
        TextureAtlas atlas = assetManager.get("graphics_packed/tiles/tilepack.atlas", TextureAtlas.class);
        TextureRegion treeRegion = atlas.findRegion("large_tree");
        GridPoint2[] gridArray = new GridPoint2[2*2];
        gridArray[0] = new GridPoint2(0,0);
        gridArray[1] = new GridPoint2(0,1);
        gridArray[2] = new GridPoint2(1,1);
        gridArray[3] = new GridPoint2(1,0);
        WorldObject tree = new WorldObject(x, y, treeRegion, 2f, 3f, gridArray,false);
        world.addObject(tree);
    }
    private void addRug(World world, int x, int y) {
        TextureAtlas atlas = assetManager.get("graphics_packed/tiles/tilepack.atlas", TextureAtlas.class);
        TextureRegion rugRegion = atlas.findRegion("rug");
//        GridPoint2[] gridArray = new GridPoint2[3*2];
        GridPoint2[] gridArray = new GridPoint2[2];
        gridArray[0] = new GridPoint2(1,1);
        gridArray[1] = new GridPoint2(1,1);
//        gridArray[1] = new GridPoint2(0,1);
//        gridArray[2] = new GridPoint2(0,2);
//        gridArray[3] = new GridPoint2(1,0);
//        gridArray[4] = new GridPoint2(1,1);
//        gridArray[5] = new GridPoint2(1,2);
        WorldObject rug = new WorldObject(x, y, rugRegion, 3f, 2f, gridArray,true);
        world.addObject(rug);
    }

    public WorldGenerator(AssetManager assetManager) {
        this.assetManager = assetManager;
        flowerAnimation = new Animations().getFlowerAnimation();
    }



    }
