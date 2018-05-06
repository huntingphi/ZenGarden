package com.mygdx.game.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.mygdx.game.Screens.WorldGenerator;
import com.mygdx.game.utilities.AnimationSet;

/**
 * Created by minad on 10/22/17.
 */

public class Entity implements Sortable {
    private Grid grid;
    private int x;
    private int y;
    private DIRECTION facing;
    private boolean visible;

    private World world;
    private float worldX, worldY;
    private int fromX, fromY;
    private int toX, toY;
    private float animationTimer;
    private float ANIMATION_TIME=0.3f;
    private ENTITY_STATE state;
    private float walkTimer;
    private boolean moveRequestThisFrame;
    protected AnimationSet animation2;
    protected AnimationSet animation1;
    protected AnimationSet animation;



    public World getWorld() {
        return world;
    }

    public Entity(int x, int y){
        this.x = x;
        this.y = y;
        this.worldX = x;
        this.worldY = y;
        this.visible = false;
    }

    public Entity(Grid grid, int x, int y,AnimationSet animations) {

        this.animation = animations;
        this.grid = grid;
        this.x = x;
        this.y = y;
        this.worldX = x;
        this.worldY = y;
        grid.getTile(x,y).setEntity(this);
        this.state = ENTITY_STATE.STANDING;
        this.facing = DIRECTION.SOUTH;
        this.visible = true;
    }
    public Entity(World world, int x, int y, AnimationSet animation1, AnimationSet animation2) {
        this.animation = animation1;
        this.animation1 = animation1;
        this.animation2 = animation2;
        this.grid = world.getGrid();
        this.world = world;
        this.x = x;
        this.y = y;
        this.worldX = x;
        this.worldY = y;
        grid.getTile(x,y).setEntity(this);
        this.state = ENTITY_STATE.STANDING;
        this.facing = DIRECTION.SOUTH;
        this.visible = true;
    }

    public TextureRegion getSprite(){
        if(state == ENTITY_STATE.WALKING) {
//            try {
                return (TextureRegion) animation.getWalking(facing).getKeyFrame(walkTimer);
//            }catch (Exception e){
//                return animation.getStanding(facing);
//
//            }
        }else if(state == ENTITY_STATE.STANDING) {
            return animation.getStanding(facing);
        }
        return animation.getStanding(DIRECTION.SOUTH);

        }

    @Override
    public float getSizeX() {
//        return getWorldX();
            return 1f;
    }

    @Override
    public float getSizeY() {
//        return getWorldY();
        return 1.5f;
    }

    public boolean isVisible() {
        return visible;
    }


    public enum ENTITY_STATE{
        WALKING, STANDING,;
    }

    public float getWorldX() {
        return worldX;
    }

    public float getWorldY() {
        return worldY;
    }

    public void update(float delta){
        if(state == ENTITY_STATE.WALKING){

            animationTimer += delta;
            walkTimer+=delta;
            float alpha = animationTimer /ANIMATION_TIME;
            worldX = Interpolation.linear.apply(fromX,toX,alpha);
            worldY =  Interpolation.linear.apply(fromY,toY,alpha);
            if(animationTimer >ANIMATION_TIME) {
             float leftOverTime = animationTimer - ANIMATION_TIME;
                walkTimer-=leftOverTime;
                finishMotion();
                if(moveRequestThisFrame){
                    move(facing);

                }else{
                    walkTimer=0f;
                }
            }
        }
        moveRequestThisFrame=false;
    }

    public boolean move(DIRECTION d){
        int dx = d.getDX();
        int dy = d.getDY();
        if(state!=ENTITY_STATE.STANDING){
            if(facing == d){
                moveRequestThisFrame = true;
            }
            return false;
        }
        int newX = x+dx;
        int newY = y+dy;
        if(newX> grid.getWidth()-1||newY> grid.getHeight()-1||newX<0||newY<0)return false;
        if(grid.getTile(newX,newY).getEntity()==null&&(grid.getTile(newX,newY).getWo()==null)){

            startMotion(d);
            grid.getTile(x,y).setEntity(null);
            x=newX;
            y=newY;
            grid.getTile(newX,newY).setEntity(this);
            return true;
        }else if(grid.getTile(newX,newY).getWo()!=null&&grid.getTile(newX,newY).getWo().isWalkable()==true){
            WorldGenerator.flowers.remove(grid.getTile(newX,newY).getWo());
            grid.getTile(newX,newY).setWo(null);
        }else if(grid.getTile(newX,newY).getEntity()!=null){
//            System.out.println("?");
            if(grid.getTile(newX,newY).getEntity() instanceof NPC){
                NPC npc =(NPC)grid.getTile(newX,newY).getEntity();
                        npc.isTouched(true);
            }
        }
return false;
    }

    public boolean move(DIRECTION d,boolean clearPlants){
        int dx = d.getDX();
        int dy = d.getDY();
        if(state!=ENTITY_STATE.STANDING){
            if(facing == d){
                moveRequestThisFrame = false;
            }
            return false;
        }
        int newX = x+dx;
        int newY = y+dy;
        if(newX> grid.getWidth()-1||newY> grid.getHeight()-1||newX<0||newY<0)return false;
        if(grid.getTile(newX,newY).getEntity()==null&&(grid.getTile(newX,newY).getWo()==null)){

            startMotion(d);
            grid.getTile(x,y).setEntity(null);
            x=newX;
            y=newY;
            grid.getTile(newX,newY).setEntity(this);
            return true;
        }else if(grid.getTile(newX,newY).getWo()!=null&&grid.getTile(newX,newY).getWo().isWalkable()==true&&clearPlants==true){
            WorldGenerator.flowers.remove(grid.getTile(newX,newY).getWo());
            grid.getTile(newX,newY).setWo(null);

            return true;
        }else if(grid.getTile(newX,newY).getEntity()!=null){
//            System.out.println("?");
            if(grid.getTile(newX,newY).getEntity() instanceof NPC&&!(this instanceof NPC)){
                NPC npc =(NPC)grid.getTile(newX,newY).getEntity();
                npc.isTouched(true);
            }
        }
        return false;
    }


    private void startMotion(DIRECTION d){
        this.facing = d;
        this.worldX = x;
        this.worldY = y;
        this.toX = x+d.getDX();
        this.toY = y+d.getDY();
        this.fromX =x;
        this.fromY = y;
        animationTimer = 0f;
        state = ENTITY_STATE.WALKING;
    }

    private void finishMotion(){
        state = ENTITY_STATE.STANDING;
        this.worldX = toX;
        this.worldY = toY;
        this.toX = 0;
        this.toY = 0;
        this.fromX = 0;
        this.fromY = 0;

    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
