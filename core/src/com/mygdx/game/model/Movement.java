package com.mygdx.game.model;

/**
 * Created by minad on 10/23/17.
 */
/**
 ** Java Program to Implement Movement Line Algorithm
 **/

import com.badlogic.gdx.math.GridPoint2;
         import java.util.Scanner;
         import java.util.ArrayList;
         import java.util.List;
import com.mygdx.game.model.DIRECTION;

/** Class Movement **/
public class Movement
{
    List<DIRECTION> steps;

    public List<DIRECTION> Chase(int xPredator, int yPredator, int xPray, int yPray){
        steps = new ArrayList<>();
        int dx = Math.abs(xPray - xPredator);
        int dy = Math.abs(yPray - yPredator);

        int sx = xPredator < xPray ? 1 : -1;
        int sy = yPredator < yPray ? 1 : -1;


        int err = dx-dy;
        int e2;

        while (true)
        {
            if (xPredator == xPray && yPredator == yPray)
                break;

            e2 = 2 * err;
            if (e2 > -dy)
            {
                err = err - dy;
                xPredator = xPredator + sx;
                if (sx==1)steps.add(DIRECTION.EAST);
                else steps.add(DIRECTION.WEST);
            }

            if (e2 < dx)
            {
                err = err + dx;
                yPredator = yPredator + sy;
                if (sy==1)steps.add(DIRECTION.NORTH);
                else steps.add(DIRECTION.SOUTH);
            }
        }
        return steps;
    }
    public List<DIRECTION> Avoid(int xPredator, int yPredator, int xPray, int yPray){
        steps = new ArrayList<>();
        int dx = Math.abs(xPray - xPredator);
        int dy = Math.abs(yPray - yPredator);

        int sx = xPredator < xPray ? 1 : -1;
        int sy = yPredator < yPray ? 1 : -1;


        int err = dx-dy;
        int e2;

        while (true)
        {
            if (xPredator == xPray && yPredator == yPray)
                break;

            e2 = 2 * err;
            if (e2 > -dy)
            {
                err = err - dy;
                xPredator = xPredator + sx;
                if (sx!=1)steps.add(DIRECTION.EAST);
                else steps.add(DIRECTION.WEST);
            }

            if (e2 < dx)
            {
                err = err + dx;
                yPredator = yPredator + sy;
                if (sy!=1)steps.add(DIRECTION.NORTH);
                else steps.add(DIRECTION.SOUTH);
            }
        }
        return steps;
    }

    public List<DIRECTION> RandomWalking(){
        steps = new ArrayList<>();
        double random = Math.round(Math.random()*5+0.5);
        if(random==1)steps.add(DIRECTION.NORTH);
        if(random==2)steps.add(DIRECTION.SOUTH);
        if(random==3)steps.add(DIRECTION.EAST);
        if(random==4)steps.add(DIRECTION.WEST);
        if(random==5)steps.add(null);
        random = Math.round(Math.random()*5+0.5);
        if(random==1)steps.add(DIRECTION.NORTH);
        if(random==2)steps.add(DIRECTION.SOUTH);
        if(random==3)steps.add(DIRECTION.EAST);
        if(random==4)steps.add(DIRECTION.WEST);
        if(random==5)steps.add(null);
        return steps;

    }
    public List<DIRECTION> King(){
        steps = new ArrayList<>();
        steps.add(DIRECTION.NORTH);
        steps.add(DIRECTION.SOUTH);
        steps.add(DIRECTION.EAST);
        steps.add(DIRECTION.WEST);
        return steps;

    }
    public List<DIRECTION> Rook(){
        steps = new ArrayList<>();

        steps.add(DIRECTION.NORTH);
        steps.add(DIRECTION.NORTH);
        steps.add(DIRECTION.NORTH);
        steps.add(DIRECTION.NORTH);
        steps.add(DIRECTION.SOUTH);
        steps.add(DIRECTION.SOUTH);
        steps.add(DIRECTION.SOUTH);
        steps.add(DIRECTION.SOUTH);
        steps.add(DIRECTION.EAST);
        steps.add(DIRECTION.EAST);
        steps.add(DIRECTION.EAST);
        steps.add(DIRECTION.EAST);
        steps.add(DIRECTION.WEST);
        steps.add(DIRECTION.WEST);
        steps.add(DIRECTION.WEST);
        steps.add(DIRECTION.WEST);

        return steps;

    }

    public List<DIRECTION> Knight(){
        //MOVE 4 STEPS IN ONE DIRECTION AND 2 IN THE OTHER
        steps = new ArrayList<>();

        steps.add(DIRECTION.NORTH);
        steps.add(DIRECTION.NORTH);
        steps.add(DIRECTION.NORTH);
        steps.add(DIRECTION.NORTH);
        steps.add(DIRECTION.EAST);
        steps.add(DIRECTION.EAST);
        steps.add(DIRECTION.SOUTH);
        steps.add(DIRECTION.SOUTH);
        steps.add(DIRECTION.WEST);
        steps.add(DIRECTION.WEST);
        steps.add(DIRECTION.WEST);
        steps.add(DIRECTION.WEST);
        steps.add(DIRECTION.WEST);
        steps.add(DIRECTION.WEST);
        steps.add(DIRECTION.NORTH);
        steps.add(DIRECTION.NORTH);
        steps.add(DIRECTION.EAST);
        steps.add(DIRECTION.EAST);
        steps.add(DIRECTION.EAST);
        steps.add(DIRECTION.EAST);
        steps.add(DIRECTION.SOUTH);
        steps.add(DIRECTION.SOUTH);
        return steps;
    }


}