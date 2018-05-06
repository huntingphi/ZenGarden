package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.controller.PlayerController;
import com.mygdx.game.model.Animations;
import com.mygdx.game.model.Camera;
import com.mygdx.game.model.Entity;
import com.mygdx.game.model.Grid;
import com.mygdx.game.model.NPC;
import com.mygdx.game.model.NPC_List;
import com.mygdx.game.model.World;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Created by minad on 10/22/17.
 */

public class GameScreen extends AbstractScreen {
    private PlayerController controller;
    private SpriteBatch batch;
    public static Entity player;
    Camera camera;
    public static World world;
    WorldRenderer renderer;
    WorldGenerator generator;
    public static ArrayList<Entity> entities;



    public GameScreen(MyGdxGame app) {
        super(app);
        camera = new Camera();
        entities = new ArrayList<>();
//         grid = new Grid(10,10);
//        world = new World(20,20);
//        grass1 = new Texture("graphics_unpacked/tiles/grass1.png");
//        grass2 = new Texture("graphics_unpacked/tiles/grass2.png");
//        playerTexture = new Texture("graphics_unpacked/tiles/brendan_stand_north.png");
        Animations animations = new Animations();
        batch = new SpriteBatch();



//        world.addObject(new WorldObject(50,52,atlas.findRegion("small_house"),80,80,new GridPoint2[]{new GridPoint2(50,52),new GridPoint2(51,52),new GridPoint2(52,52)}));
        generator = new WorldGenerator(getApp().getTileAssetManager());

        int width;
        int height;
        int noNpcs;
        width=0;height=0; noNpcs=-1;
        while (width<20||noNpcs>8||noNpcs<0){
            try {
                JOptionPane.showMessageDialog(null,"Welcome to Zen Garden! First timer? Hit C for controls\n"+
                        "ZenGarden is a relaxing time waster game where the objective is to pick up all the plants on the map in the shortest time possible.\n" +
                        "\n" +
                        "The aim of the game is to pick all the flowers in your zen garden in the fastest time.\n" +
                        "\n" +
                        "You can make use of characters roaming around your map to help you but first you need to talk to them.\n" +
                        "\n" +
                        "To talk to them simply move into them. Once you talk to them they will change skin and start following you.\n" +
                        "\n" +
                        "Your pesky neighbour is always following you and will always be around if you chose to include NPC's (Non-playable characters).\n" +
                        "\n" +
                        "Once you talk to characters you can either tell them to follow you (press right-shift), avoid you (press left-shift), find a flower (enter), or you can let them go back to what they were doing (spacebar).\n" +
                        "\n" +
                        "NPC's will either find a flower or pick it for you, depending on their mood. Once they find/pick it they will wait until you give them another instruction.\n" +
                        "\n" +
                        "If you find yourself trapped by the characters ordering them away with either left-shift, spacebar or enter.\n" +
                        "\n" +
                        "You can specify how big you want your garden to be and how many characters you want roaming around.\n" +
                        "\n" +
                        "Once you've picked all the flowers you'll be shown how long you took, how many flowers you've picked and the average time per flower.");
                Object welcome = JOptionPane.showInputDialog("Please Enter the size in square units of your garden (Minimum is 20)");
                if(welcome==null) Gdx.app.exit();
                width = Integer.parseInt((String)welcome);
                Object no =JOptionPane.showInputDialog("How many helpers would you like to play with? (Maximum 8)");
                if(no==null)Gdx.app.exit();
                noNpcs = Integer.parseInt((String)no);
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Please enter integer values only within the given bounds");
                continue;
            }
            }
            height= width;
        if(height%2 !=0)height--;
        if(width%2 !=0)width--;

        world = generator.loadWorld(width,height);
        player = new Entity(world.getGrid(),width/2,height/2,animations.playerAnimation());

        world.addEntity(player);
        controller = new PlayerController(player);
        renderer = new WorldRenderer(getApp().getTileAssetManager(),world);
        ArrayList<NPC> characters = NPC_List.getCharacters(world,width,height,player,noNpcs);
        for (int i = 0; i <noNpcs ; i++) {
            NPC npc = characters.get(i);
            world.addEntity(npc);
        }
        entities.addAll(characters);
        entities.add(player);

    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(controller);
        MyGdxGame.timer = System.currentTimeMillis();
    }

    @Override
    public void render(float delta) {

            player.update(delta);
            for (Entity e : entities
                    ) {
                e.update(delta);
            }
            controller.update(delta);
            camera.update(player.getWorldX() + 0.5f, player.getWorldY() + 0.5f);
            world.update(delta);
            batch.begin();
            renderer.render(batch, camera);
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
