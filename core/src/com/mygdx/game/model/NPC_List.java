package com.mygdx.game.model;

import java.util.ArrayList;

/**
 * Created by minad on 10/24/17.
 */

public class NPC_List {
    static ArrayList<NPC> characters;

    public static ArrayList<NPC> getCharacters(World world, int width,int height,Entity Player, int noCharacters) {
        Animations animations = new Animations();
        characters = new ArrayList<>();
        if(noCharacters==0)return characters;
        NPC _1 = new NPC(world,width/4+1,height/4,animations.getDefaultAnimationSet1A(),animations.getDefaultAnimationSet1B(), AITYPE.CHASE);
        _1.setTarget(Player);
        characters.add(_1);
        if(noCharacters==1)return characters;

        NPC _2=  new NPC(world,width/4+2,height/4,animations.getDefaultAnimationSet2A(),animations.getDefaultAnimationSet2B(), AITYPE.AVOID);
        _2.setTarget(Player);
        characters.add(_2);
        if(noCharacters==2)return characters;

        NPC _3 = new NPC(world,width/4+3,height/4,animations.getDefaultAnimationSet3A(),animations.getDefaultAnimationSet3B(), AITYPE.KING);
        characters.add(_3);
        _3.setTarget(Player);
        if(noCharacters==3)return characters;

        NPC _4=  new NPC(world,width/4+4,height/4,animations.getDefaultAnimationSet4A(),animations.getDefaultAnimationSet4B(), AITYPE.KNIGHT);
        characters.add(_4);
        _4.setTarget(Player);
        if(noCharacters==4)return characters;

        NPC _5 = new NPC(world,width/4+5,height/4,animations.getDefaultAnimationSet5A(),animations.getDefaultAnimationSet5B(), AITYPE.RANDOM);
        characters.add(_5);
        _5.setTarget(Player);
        if(noCharacters==5)return characters;


        NPC _6=  new NPC(world,width/4+6,height/4,animations.getDefaultAnimationSet6A(),animations.getDefaultAnimationSet6B(), AITYPE.ROOK);
        characters.add(_6);
        _6.setTarget(Player);
        if(noCharacters==6)return characters;

        NPC _7 = new NPC(world,width/4+7,height/4,animations.getDefaultAnimationSet7A(),animations.getDefaultAnimationSet7B(), AITYPE.RANDOM);
        characters.add(_7);
        _7.setTarget(Player);
        if(noCharacters==7)return characters;
        NPC _8=  new NPC(world,width/4+8,height/4,animations.getDefaultAnimationSet8A(),animations.getDefaultAnimationSet8B(), AITYPE.KING);
        _8.setTarget(Player);
        characters.add(_8);

        return characters;
    }
    }


