package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Settings;
import com.mygdx.game.model.Camera;
import com.mygdx.game.model.Entity;
import com.mygdx.game.model.ObjectComparator;
import com.mygdx.game.model.Sortable;
import com.mygdx.game.model.TileType;
import com.mygdx.game.model.World;
import com.mygdx.game.model.WorldObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by minad on 10/23/17.
 */

   public class WorldRenderer {

//        private AssetManager assetManager;
//        private World world;
//
//        private TextureRegion grass1;
//        private TextureRegion grass2;
//        private TextureRegion indoorTiles;
//        private TextureRegion indoorTilesShadow;
//        private TextureRegion wallBottom;
//        private TextureRegion wallTop;
//
//        private List<Integer> renderedObjects = new ArrayList<Integer>();
//        private List<Sortable> forRendering = new ArrayList<Sortable>();
//
//        public WorldRenderer(AssetManager assetManager, World world) {
//            this.assetManager = assetManager;
//            this.world = world;
//
//            TextureAtlas atlas = assetManager.get("graphics_packed/tiles/tilepack.atlas", TextureAtlas.class);
//            grass1 = atlas.findRegion("grass1");
//            grass2 = atlas.findRegion("grass2");
//            indoorTiles = atlas.findRegion("indoor_tiles");
//            indoorTilesShadow = atlas.findRegion("indoor_tiles_shadow");
//            wallBottom = atlas.findRegion("wall_bottom");
//            wallTop = atlas.findRegion("wall_top");
//        }
//
//        public void render(SpriteBatch batch, Camera camera) {
//            float worldStartX = Gdx.graphics.getWidth()/2 - camera.getCameraX()*Settings.SCALED_TILE_SIZE;
//            float worldStartY = Gdx.graphics.getHeight()/2 - camera.getCameraY()*Settings.SCALED_TILE_SIZE;
//
//		/* render tile TileTypes */
//            for (int x = 0; x < world.getGrid().getWidth(); x++) {
//                for (int y = 0; y < world.getGrid().getHeight(); y++) {
//                    TextureRegion render;
//                    if (world.getGrid().getTile(x, y).getTerrain() == TileType.GRASS_1) {
//                        render = grass1;
//                    } else if (world.getGrid().getTile(x, y).getTerrain() == TileType.GRASS_2) {
//                        render = grass2;
////                    } else if (world.getGrid().getTile(x, y).getTerrain() == TileType.INDOOR_TILES) {
////                        render = indoorTiles;
////                    } else if (world.getGrid().getTile(x, y).getTerrain() == TileType.INDOOR_TILES_SHADOW) {
////                        render = indoorTilesShadow;
////                    } else if (world.getGrid().getTile(x, y).getTerrain() == TileType.WALL_BOTTOM) {
////                        render = wallBottom;
////                    } else if (world.getGrid().getTile(x, y).getTerrain() == TileType.WALL_TOP) {
////                        render = wallTop;
//                    } else {
//                        render = null;
//                    }
//
//                    if (render != null) {
//                        batch.draw(render,
//                                (int)(worldStartX+x*Settings.SCALED_TILE_SIZE),
//                                (int)(worldStartY+y*Settings.SCALED_TILE_SIZE),
//                                (int)(Settings.SCALED_TILE_SIZE),
//                                (int)(Settings.SCALED_TILE_SIZE));
//                    }
//                }
//            }
//
//		/* collect objects and entitys */
//            for (int x = 0; x < world.getGrid().getWidth(); x++) {
//                for (int y = 0; y < world.getGrid().getHeight(); y++) {
//                    if (world.getGrid().getTile(x, y).getEntity() != null) {
//                        Entity entity = world.getGrid().getTile(x, y).getEntity();
//                        forRendering.add(entity);
//                    }
//                    if (world.getGrid().getTile(x, y).getWo() != null) {
//                        WorldObject object = world.getGrid().getTile(x, y).getWo();
//                        if (renderedObjects.contains(object.hashCode())) { // test if it's already drawn
//                            continue;
//                        }
//                        if (object.isWalkable()) {  		// if it's walkable, draw it right away
//                            batch.draw(object.getSprite(),	// chances are it's probably something on the ground
//                                    worldStartX+object.getWorldX()*Settings.SCALED_TILE_SIZE,
//                                    worldStartY+object.getWorldY()*Settings.SCALED_TILE_SIZE,
//                                    Settings.SCALED_TILE_SIZE*object.getSizeX(),
//                                    Settings.SCALED_TILE_SIZE*object.getSizeY());
//                            continue;
//                        } else {	// add it to the list of YSortables
//                            forRendering.add(object);
//                            renderedObjects.add(object.hashCode());
//                        }
//                    }
//                }
//            }
//
//            Collections.sort(forRendering, new ObjectComparator());
//            Collections.reverse(forRendering);
//
//            for (Sortable loc : forRendering) {
//                if (loc instanceof Entity) {
//                    Entity a = (Entity)loc;
//                    if (!a.isVisible()) {
//                        continue;
//                    }
//                }
//                batch.draw(loc.getSprite(),
//                        worldStartX+loc.getWorldX()*Settings.SCALED_TILE_SIZE,
//                        worldStartY+loc.getWorldY()*Settings.SCALED_TILE_SIZE,
//                        Settings.SCALED_TILE_SIZE*loc.getSizeX(),
//                        Settings.SCALED_TILE_SIZE*loc.getSizeY());
//            }
//
//            renderedObjects.clear();
//            forRendering.clear();
//        }
//
//        public void setWorld(World world) {
//            this.world = world;
//        }
//
//    }


    private AssetManager assetManager;
    private World world;
    private TextureRegion grass1;
    private TextureRegion grass2;
    private TextureRegion indoorTiles;
    private TextureRegion indoorTilesShadow;
    private TextureRegion wallBottom;
    private TextureRegion wallTop;

    private ArrayList<Integer> objects = new ArrayList<>();
    private ArrayList<Sortable> renderOrder = new ArrayList<>();

    public WorldRenderer(AssetManager assetManager, World world) {
        this.assetManager = assetManager;
        this.world = world;

        TextureAtlas atlas = assetManager.get("graphics_packed/tiles/tilepack.atlas", TextureAtlas.class);
        grass1 = atlas.findRegion("grass1");
        grass2 = atlas.findRegion("grass2");
        indoorTiles = atlas.findRegion("indoor_tiles");
        indoorTilesShadow = atlas.findRegion("indoor_tiles_shadow");
        wallBottom = atlas.findRegion("wall_bottom");
        wallTop = atlas.findRegion("wall_top");
    }


    public void setWorld(World world) {
        this.world = world;
    }

    public void render(SpriteBatch batch, Camera camera) {
        float worldStartX = Gdx.graphics.getWidth() / 2 - camera.getCameraX() * Settings.SCALED_TILE_SIZE;
        float worldStartY = Gdx.graphics.getHeight() / 2 - camera.getCameraY() * Settings.SCALED_TILE_SIZE;

        for (int x = 0; x < world.getGrid().getWidth(); x++) {

            for (int y = 0; y < world.getGrid().getHeight(); y++) {
                TextureRegion tile;
                if (world.getGrid().getTile(x, y).getTerrain() == TileType.GRASS_1) tile = grass1;
                else tile = grass2;
                batch.draw(tile, worldStartX + x * Settings.SCALED_TILE_SIZE, worldStartY + y * Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
            }
        }
        for (int x = 0; x < world.getGrid().getWidth(); x++) {
            for (int y = 0; y < world.getGrid().getHeight(); y++) {
                if (world.getGrid().getTile(x, y).getEntity() != null) {
                    Entity entity = world.getGrid().getTile(x, y).getEntity();
                    renderOrder.add(entity);
                }
                if (world.getGrid().getTile(x, y).getWo() != null) {
                    WorldObject object = world.getGrid().getTile(x, y).getWo();
                    if (objects.contains(object.hashCode())) { // test if it's already drawn
                        continue;
                    }
                    if (object.isWalkable()) {  		// if it's walkable, draw it right away
                        batch.draw(object.getSprite(),	// chances are it's probably something on the ground
                                worldStartX+object.getWorldX()*Settings.SCALED_TILE_SIZE,
                                worldStartY+object.getWorldY()*Settings.SCALED_TILE_SIZE,
                                Settings.SCALED_TILE_SIZE*object.getSizeX(),
                                Settings.SCALED_TILE_SIZE*object.getSizeY());
                        continue;
                    } else {
                        renderOrder.add(object);
                        objects.add(object.hashCode());
                    }
                }
            }
        }


        Collections.sort(renderOrder, new ObjectComparator());
        Collections.reverse(renderOrder);

        for (Sortable loc : renderOrder) {
            if (loc instanceof Entity) {
                Entity e = (Entity)loc;
                if (!e.isVisible()) {
                    continue;
                }
            }
            batch.draw(loc.getSprite(),
                    worldStartX+loc.getWorldX()*Settings.SCALED_TILE_SIZE,
                    worldStartY+loc.getWorldY()*Settings.SCALED_TILE_SIZE,
                    Settings.SCALED_TILE_SIZE*loc.getSizeX(),
                    Settings.SCALED_TILE_SIZE*loc.getSizeY());
        }





        objects.clear();
        renderOrder.clear();


    }
}
