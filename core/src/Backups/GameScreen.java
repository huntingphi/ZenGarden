package Backups;

/**
 * Created by minad on 10/23/17.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Screens.AbstractScreen;
import com.mygdx.game.Settings;
import com.mygdx.game.controller.PlayerController;
import com.mygdx.game.model.Camera;
import com.mygdx.game.model.Entity;
import com.mygdx.game.model.Grid;
import com.mygdx.game.model.TileType;
import com.mygdx.game.utilities.AnimationSet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Settings;
import com.mygdx.game.controller.PlayerController;
import com.mygdx.game.model.Camera;
import com.mygdx.game.model.Entity;
import com.mygdx.game.model.Grid;
import com.mygdx.game.model.TileType;
import com.mygdx.game.utilities.AnimationSet;

/**
 * Created by minad on 10/22/17.
 */

public class GameScreen extends AbstractScreen {
    private PlayerController controller;
    private SpriteBatch batch;
    private Texture playerTexture;
    private Entity player;
    Grid grid;
    private Texture grass1;
    private Texture grass2;
    Camera camera;

    public GameScreen(MyGdxGame app) {
        super(app);
        camera = new Camera();
        grid = new Grid(10,10);
        grass1 = new Texture("graphics_unpacked/tiles/grass1.png");
        grass2 = new Texture("graphics_unpacked/tiles/grass2.png");
        playerTexture = new Texture("graphics_unpacked/tiles/brendan_stand_north.png");
        batch = new SpriteBatch();

        TextureAtlas atlas = app.getTileAssetManager().get("graphics_packed/tiles/tilepack.atlas", TextureAtlas.class);
        AnimationSet animationSet = new AnimationSet(
                new Animation(0.3f/2f,atlas.findRegions("brendan_walk_north"), Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f/2f,atlas.findRegions("brendan_walk_south"), Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f/2f,atlas.findRegions("brendan_walk_east"), Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f/2f,atlas.findRegions("brendan_walk_west"), Animation.PlayMode.LOOP_PINGPONG),
                atlas.findRegion("brendan_stand_north"),
                atlas.findRegion("brendan_stand_south"),
                atlas.findRegion("brendan_stand_east"),
                atlas.findRegion("brendan_stand_west"));
        player = new Entity(grid,0,0,animationSet);
        controller = new PlayerController(player);


    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(controller);
    }

    @Override
    public void render(float delta) {
        player.update(delta);
        controller.update(delta);
        camera.update(player.getWorldX()+0.5f, player.getWorldY()+0.5f);
        batch.begin();
        float worldStartX = Gdx.graphics.getWidth()/2 - camera.getCameraX()* Settings.SCALED_TILE_SIZE;
        float worldStartY = Gdx.graphics.getHeight()/2 - camera.getCameraY()*Settings.SCALED_TILE_SIZE;

        for(int x = 0; x< grid.getWidth(); x++){

            for (int y = 0; y< grid.getHeight(); y++) {
                Texture tile;
                if (grid.getTile(x,y).getTerrain()== TileType.GRASS_1) tile = grass1;
                else tile = grass2;
                batch.draw(tile,worldStartX+x*Settings.SCALED_TILE_SIZE,worldStartY+ y* Settings.SCALED_TILE_SIZE,Settings.SCALED_TILE_SIZE,Settings.SCALED_TILE_SIZE);
            }
        }
        batch.draw(player.getSprite(), worldStartX+ player.getWorldX()*Settings.SCALED_TILE_SIZE,worldStartY+ player.getWorldY()* Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE*1.5f);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public MyGdxGame getApp() {
        return super.getApp();
    }
}
