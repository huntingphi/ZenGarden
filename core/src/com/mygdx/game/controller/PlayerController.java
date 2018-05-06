package com.mygdx.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.maps.Map;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Screens.GameScreen;
import com.mygdx.game.Screens.WorldGenerator;
import com.mygdx.game.model.DIRECTION;
import com.mygdx.game.model.Entity;
import com.mygdx.game.model.NPC;
import com.mygdx.game.model.WorldObject;

import javax.swing.JOptionPane;

import jdk.nashorn.internal.scripts.JO;

/**
 * Created by minad on 10/22/17.
 */

public class PlayerController extends InputAdapter{
    Entity entity;

    private boolean up,down,left,right;

    public PlayerController(Entity entity) {
        this.entity = entity;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Keys.UP) {
//            buttonPress[DIRECTION.NORTH.ordinal()] = true;
            up = true;
        }
        if (keycode == Keys.DOWN) {
            down = true;

//            buttonPress[DIRECTION.SOUTH.ordinal()] = true;
        }
        if (keycode == Keys.LEFT) {
            left = true;
//            buttonPress[DIRECTION.WEST.ordinal()] = true;
        }
        if (keycode == Keys.RIGHT) {
            right = true;
//            buttonPress[DIRECTION.EAST.ordinal()] = true;
        }
        return false;

    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Keys.UP) {
//            buttonPress[DIRECTION.NORTH.ordinal()] = false;
            up = false;
        }
        if (keycode == Keys.DOWN) {
            down = false;

//            buttonPress[DIRECTION.SOUTH.ordinal()] = false;
        }
        if (keycode == Keys.LEFT) {
            left = false;
//            buttonPress[DIRECTION.WEST.ordinal()] = true;
        }
        if (keycode == Keys.RIGHT) {
            right = false;
//            buttonPress[DIRECTION.EAST.ordinal()] = false;
        }
        if(keycode==Keys.SHIFT_LEFT){
            for (Entity e: GameScreen.entities
                 ) {
                if(e instanceof NPC&&((NPC) e).isTouched()){
                    ((NPC) e).setAvoiding();
                }
            }
        }
        if(keycode==Keys.SHIFT_RIGHT) {
            for (Entity e : GameScreen.entities
                    ) {
                if (e instanceof NPC&&((NPC) e).isTouched()) {
                    ((NPC) e).setChasing(GameScreen.player);
                }
            }
        }
            if(keycode==Keys.SPACE){
                for (Entity e: GameScreen.entities
                        ) {
                    if(e instanceof NPC&&((NPC) e).isTouched()){
                        ((NPC) e).setDefault_ai();
                    }
                }
        }
        if(keycode==Keys.ENTER) {
//            System.out.println(WorldGenerator.flowers.size());

                for (Entity e : GameScreen.entities
                        ) {
                    if (e instanceof NPC && ((NPC) e).isTouched()) {
                        NPC npc = (NPC) e;
                        int flowerNo = (int) (Math.random() * WorldGenerator.flowers.size());
                        try {
                            WorldObject target = WorldGenerator.flowers.get(flowerNo);

//                            while (GameScreen.world.getGrid().getTile((int) target.getWorldX(), (int) target.getWorldY()).getWo() == null) {
//                                WorldGenerator.flowers.remove(flowerNo);
//                                flowerNo = (int) (Math.random() * WorldGenerator.flowers.size());
//                                target = WorldGenerator.flowers.get(flowerNo);
//                            }
                            npc.setChasing(target);
                        } catch (NullPointerException | IndexOutOfBoundsException noMoreFlowers) {
                            break;
                        }

                    }

                }
                if(WorldGenerator.flowers.size()==0){
                    int flowers = (int)(GameScreen.world.getGrid().getWidth()-1)*(GameScreen.world.getGrid().getHeight())-1;
                    flowers/=10;
                    float time = MyGdxGame.getTime();
                    float speed = flowers/time;
                    JOptionPane.showMessageDialog(null,"Game Over! You took "+time+" seconds" +
                            " to pick "+flowers+" flowers!.\n" +
                            "Thats approximately "+Math.round(speed*100)/100+" per second!");
                    Gdx.app.exit();
                }
            }
        return false;
    }


    public void update(float delta){
        //Return so that if the player is in the process of moving and
        //a different direction is pressed that it doesn't move both directions
    if(up){
        entity.move(DIRECTION.NORTH);
        return;
    }
        if(down){
        entity.move(DIRECTION.SOUTH);
        return;
    }

        if(left){
            entity.move(DIRECTION.WEST);
            return;
        }

        if(right){
            entity.move(DIRECTION.EAST);
            return;
        }


    }
}
