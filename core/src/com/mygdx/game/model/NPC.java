package com.mygdx.game.model;

import com.mygdx.game.utilities.AnimationSet;

import java.util.List;

/**
 * Created by minad on 10/23/17.
 */

public class NPC extends Entity implements AI {
    Entity target;
    AITYPE ai;
    static boolean chasing;
    static boolean avoiding;
    boolean touched = false;
    AITYPE default_ai;


    public NPC(World world, int x, int y, AnimationSet animation2,AnimationSet animation1,AITYPE ai) {
        super(world, x, y, animation1, animation2);
        this.ai= ai;
        default_ai=this.ai;
    }
    void isTouched(boolean b){
        if(touched==false)switchAnimation();
        ai = AITYPE.CHASE;
        touched=b;
    }
    void switchAnimation(){
        if(this.animation == animation1)
        this.animation = animation2;
        else
            this.animation = animation1;


    }


    public boolean isTouched(){
        return touched;
    }

    public void setDefault_ai(){
        ai = default_ai;
    }

    public void setChasing(Entity e){
        setTarget(e);
        chasing = true;
        ai = AITYPE.CHASE;
    }
    public void setChasing(WorldObject wo){
        Entity e = new Entity((int)wo.getWorldX(),(int)wo.getWorldY());
        setTarget(e);
        chasing = true;
        ai = AITYPE.CHASE;
    }

    public void setAvoiding(){
     avoiding = true;
        ai = AITYPE.AVOID;
    }

    @Override
    public void setTarget(Entity e) {
        target = e;
    }

    @Override
    public Entity getTarget() {
        return target;
    }

    @Override
    public List<DIRECTION> getMovements() {
        //We stack movement for all but those using bresenham's algorithm as we want the movement relative
        //to the players latest position
//        stackMovement = false;
        Movement movement = new Movement();
        switch (ai){
            case CHASE:
//                stackMovement = false;
                return movement.Chase((int)getWorldX(),(int)getWorldY(),(int)target.getWorldX(),(int)target.getWorldY());
            case AVOID:
//                stackMovement = false;
                return movement.Avoid((int)getWorldX(),(int)getWorldY(),(int)target.getWorldX(),(int)target.getWorldY());
            case RANDOM:
                return movement.RandomWalking();
            case ROOK:
                return movement.Rook();
            case KING:
                return movement.King();
            case KNIGHT:
                return movement.Knight();
            default: return movement.RandomWalking();
        }

    }

    @Override
    public void move() {
//        System.out.println(getMovements().size());



            try {
                if((ai == AITYPE.CHASE||ai == AITYPE.AVOID)&&isTouched()==false) {
                    DIRECTION d = getMovements().get(0);
                if (getMovements().size() > 1 || ai == AITYPE.AVOID) {
                    if (!move(d, isTouched()) && !move(getMovements().get(1),isTouched())) {
                        if ((d == DIRECTION.NORTH || d == DIRECTION.SOUTH)) {
                            if (!move(DIRECTION.EAST, isTouched())) {
                                move(DIRECTION.WEST, isTouched());
                            }
                            move(d, isTouched());


                        } else {
                            if (!move(DIRECTION.NORTH, isTouched())) {
                                move(DIRECTION.SOUTH, isTouched());
                            }
                            move(d, isTouched());

                        }
                    }
                }
            }else {
                for (DIRECTION dir : getMovements()
                        ) {
                    move(dir, isTouched());
                }
            }
            }catch (NullPointerException | IndexOutOfBoundsException e) {
            //No movement
            }


//        for (DIRECTION d:getMovements()
//             ) {
//            if(!move(d))move(DIRECTION.getOpposite(d));
////            System.out.println(move(d));
//            break;
////

            }



    @Override
    public void update(float delta) {
//        if(chasing){
//            ai=AITYPE.CHASE;
//        }else if(avoiding){
//            ai=AITYPE.CHASE;
//        }
        move();
        super.update(delta);
    }
}
