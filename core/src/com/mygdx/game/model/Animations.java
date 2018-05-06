package com.mygdx.game.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Screens.AbstractScreen;
import com.mygdx.game.utilities.AnimationSet;

/**
 * Created by minad on 10/24/17.
 */

public class Animations {
   public static AnimationSet defaultAnimationSet1A;
    public static AnimationSet defaultAnimationSet1B;
    public static AnimationSet defaultAnimationSet2A;
    public static AnimationSet defaultAnimationSet2B;
    public static AnimationSet defaultAnimationSet3A;
    public static AnimationSet defaultAnimationSet3B;
    public static AnimationSet defaultAnimationSet4A;
    public static AnimationSet defaultAnimationSet4B;
    public static AnimationSet defaultAnimationSet5A;
    public static AnimationSet defaultAnimationSet5B;
    public static AnimationSet defaultAnimationSet6A;
    public static AnimationSet defaultAnimationSet6B;
    public static AnimationSet defaultAnimationSet7A;
    public static AnimationSet defaultAnimationSet7B;
    public static AnimationSet defaultAnimationSet8A;
    public static AnimationSet defaultAnimationSet8B;
    public static AnimationSet Player;
    public static Animation flowerAnimation;
    public static boolean done = false;
    TextureAtlas atlas;
    TextureAtlas defaultTA;


    public AnimationSet playerAnimation() {
        atlas = AbstractScreen.app.getTileAssetManager().get("graphics_packed/tiles/tilepack.atlas", TextureAtlas.class);

        AnimationSet Player = new AnimationSet(
                new Animation(0.3f / 2f, atlas.findRegions("brendan_walk_north"), Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, atlas.findRegions("brendan_walk_south"), Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, atlas.findRegions("brendan_walk_east"), Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, atlas.findRegions("brendan_walk_west"), Animation.PlayMode.LOOP_PINGPONG),
                atlas.findRegion("brendan_stand_north"),
                atlas.findRegion("brendan_stand_south"),
                atlas.findRegion("brendan_stand_east"),
                atlas.findRegion("brendan_stand_west"));

        return Player;
    }

    public AnimationSet getDefaultAnimationSet1A() {

        defaultTA = new TextureAtlas("sprites.txt");
        Array<TextureAtlas.AtlasRegion> dBack = new Array<>();
        dBack.add(defaultTA.findRegion("ybo1_bk1"));
        dBack.add(defaultTA.findRegion("ybo1_bk2"));
        Array<TextureAtlas.AtlasRegion> dFront = new Array<>();
        dFront.add(defaultTA.findRegion("ybo1_fr1"));
        dFront.add(defaultTA.findRegion("ybo1_fr2"));
        Array<TextureAtlas.AtlasRegion> dRight = new Array<>();
        dRight.add(defaultTA.findRegion("ybo1_rt1"));
        dRight.add(defaultTA.findRegion("ybo1_rt2"));
        Array<TextureAtlas.AtlasRegion> dLeft = new Array<>();
        dLeft.add(defaultTA.findRegion("ybo1_lf1"));
        dLeft.add(defaultTA.findRegion("ybo1_lf2"));


        defaultAnimationSet1A = new AnimationSet(
                new Animation(0.3f / 2f, dBack, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dFront, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dRight, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dLeft, Animation.PlayMode.LOOP_PINGPONG),
                defaultTA.findRegion("ybo1_bk1"),
                defaultTA.findRegion("ybo1_fr1"),
                defaultTA.findRegion("ybo1_rt1"),
                defaultTA.findRegion("ybo1_lf1"));
        return defaultAnimationSet1A;
    }



    public AnimationSet getDefaultAnimationSet1B() {

        defaultTA = new TextureAtlas("sprites.txt");
        Array<TextureAtlas.AtlasRegion> dBack = new Array<>();
        dBack.add(defaultTA.findRegion("ygr1_bk1"));
        dBack.add(defaultTA.findRegion("ygr1_bk2"));
        Array<TextureAtlas.AtlasRegion> dFront = new Array<>();
        dFront.add(defaultTA.findRegion("ygr1_fr1"));
        dFront.add(defaultTA.findRegion("ygr1_fr2"));
        Array<TextureAtlas.AtlasRegion> dRight = new Array<>();
        dRight.add(defaultTA.findRegion("ygr1_rt1"));
        dRight.add(defaultTA.findRegion("ygr1_rt2"));
        Array<TextureAtlas.AtlasRegion> dLeft = new Array<>();
        dLeft.add(defaultTA.findRegion("ygr1_lf1"));
        dLeft.add(defaultTA.findRegion("ygr1_lf2"));


        defaultAnimationSet1B = new AnimationSet(
                new Animation(0.3f / 2f, dBack, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dFront, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dRight, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dLeft, Animation.PlayMode.LOOP_PINGPONG),
                defaultTA.findRegion("ygr1_bk1"),
                defaultTA.findRegion("ygr1_fr1"),
                defaultTA.findRegion("ygr1_rt1"),
                defaultTA.findRegion("ygr1_lf1"));

        return defaultAnimationSet1B;
    }
    public AnimationSet getDefaultAnimationSet2A() {

        defaultTA = new TextureAtlas("sprites.txt");
        Array<TextureAtlas.AtlasRegion> dBack = new Array<>();
        dBack.add(defaultTA.findRegion("wnv1_bk1"));
        dBack.add(defaultTA.findRegion("wnv1_bk2"));
        Array<TextureAtlas.AtlasRegion> dFront = new Array<>();
        dFront.add(defaultTA.findRegion("wnv1_fr1"));
        dFront.add(defaultTA.findRegion("wnv1_fr2"));
        Array<TextureAtlas.AtlasRegion> dRight = new Array<>();
        dRight.add(defaultTA.findRegion("wnv1_rt1"));
        dRight.add(defaultTA.findRegion("wnv1_rt2"));
        Array<TextureAtlas.AtlasRegion> dLeft = new Array<>();
        dLeft.add(defaultTA.findRegion("wnv1_lf1"));
        dLeft.add(defaultTA.findRegion("wnv1_lf2"));


        defaultAnimationSet1A = new AnimationSet(
                new Animation(0.3f / 2f, dBack, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dFront, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dRight, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dLeft, Animation.PlayMode.LOOP_PINGPONG),
                defaultTA.findRegion("wnv1_bk1"),
                defaultTA.findRegion("wnv1_fr1"),
                defaultTA.findRegion("wnv1_rt1"),
                defaultTA.findRegion("wnv1_lf1"));
        return defaultAnimationSet1A;
    }



    public AnimationSet getDefaultAnimationSet2B() {

        defaultTA = new TextureAtlas("sprites.txt");
        Array<TextureAtlas.AtlasRegion> dBack = new Array<>();
        dBack.add(defaultTA.findRegion("wnv4_bk1"));
        dBack.add(defaultTA.findRegion("wnv4_bk2"));
        Array<TextureAtlas.AtlasRegion> dFront = new Array<>();
        dFront.add(defaultTA.findRegion("wnv4_fr1"));
        dFront.add(defaultTA.findRegion("wnv4_fr2"));
        Array<TextureAtlas.AtlasRegion> dRight = new Array<>();
        dRight.add(defaultTA.findRegion("wnv4_rt1"));
        dRight.add(defaultTA.findRegion("wnv4_rt2"));
        Array<TextureAtlas.AtlasRegion> dLeft = new Array<>();
        dLeft.add(defaultTA.findRegion("wnv4_lf1"));
        dLeft.add(defaultTA.findRegion("wnv4_lf2"));


        defaultAnimationSet1B = new AnimationSet(
                new Animation(0.3f / 2f, dBack, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dFront, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dRight, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dLeft, Animation.PlayMode.LOOP_PINGPONG),
                defaultTA.findRegion("wnv4_bk1"),
                defaultTA.findRegion("wnv4_fr1"),
                defaultTA.findRegion("wnv4_rt1"),
                defaultTA.findRegion("wnv4_lf1"));

        return defaultAnimationSet1B;
    }
    public AnimationSet getDefaultAnimationSet3A() {

        defaultTA = new TextureAtlas("sprites.txt");
        Array<TextureAtlas.AtlasRegion> dBack = new Array<>();
        dBack.add(defaultTA.findRegion("wnv2_bk1"));
        dBack.add(defaultTA.findRegion("wnv2_bk2"));
        Array<TextureAtlas.AtlasRegion> dFront = new Array<>();
        dFront.add(defaultTA.findRegion("wnv2_fr1"));
        dFront.add(defaultTA.findRegion("wnv2_fr2"));
        Array<TextureAtlas.AtlasRegion> dRight = new Array<>();
        dRight.add(defaultTA.findRegion("wnv2_rt1"));
        dRight.add(defaultTA.findRegion("wnv2_rt2"));
        Array<TextureAtlas.AtlasRegion> dLeft = new Array<>();
        dLeft.add(defaultTA.findRegion("wnv2_lf1"));
        dLeft.add(defaultTA.findRegion("wnv2_lf2"));


        defaultAnimationSet1A = new AnimationSet(
                new Animation(0.3f / 2f, dBack, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dFront, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dRight, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dLeft, Animation.PlayMode.LOOP_PINGPONG),
                defaultTA.findRegion("wnv2_bk1"),
                defaultTA.findRegion("wnv2_fr1"),
                defaultTA.findRegion("wnv2_rt1"),
                defaultTA.findRegion("wnv2_lf1"));
        return defaultAnimationSet1A;
    }



    public AnimationSet getDefaultAnimationSet3B() {

        defaultTA = new TextureAtlas("sprites.txt");
        Array<TextureAtlas.AtlasRegion> dBack = new Array<>();
        dBack.add(defaultTA.findRegion("wnv3_bk1"));
        dBack.add(defaultTA.findRegion("wnv3_bk2"));
        Array<TextureAtlas.AtlasRegion> dFront = new Array<>();
        dFront.add(defaultTA.findRegion("wnv3_fr1"));
        dFront.add(defaultTA.findRegion("wnv3_fr2"));
        Array<TextureAtlas.AtlasRegion> dRight = new Array<>();
        dRight.add(defaultTA.findRegion("wnv3_rt1"));
        dRight.add(defaultTA.findRegion("wnv3_rt2"));
        Array<TextureAtlas.AtlasRegion> dLeft = new Array<>();
        dLeft.add(defaultTA.findRegion("wnv3_lf1"));
        dLeft.add(defaultTA.findRegion("wnv3_lf2"));


        defaultAnimationSet1B = new AnimationSet(
                new Animation(0.3f / 2f, dBack, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dFront, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dRight, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dLeft, Animation.PlayMode.LOOP_PINGPONG),
                defaultTA.findRegion("wnv3_bk1"),
                defaultTA.findRegion("wnv3_fr1"),
                defaultTA.findRegion("wnv3_rt1"),
                defaultTA.findRegion("wnv3_lf1"));

        return defaultAnimationSet1B;
    }
    public AnimationSet getDefaultAnimationSet4A() {

        defaultTA = new TextureAtlas("sprites.txt");
        Array<TextureAtlas.AtlasRegion> dBack = new Array<>();
        dBack.add(defaultTA.findRegion("knt3_bk1"));
        dBack.add(defaultTA.findRegion("knt3_bk2"));
        Array<TextureAtlas.AtlasRegion> dFront = new Array<>();
        dFront.add(defaultTA.findRegion("knt3_fr1"));
        dFront.add(defaultTA.findRegion("knt3_fr2"));
        Array<TextureAtlas.AtlasRegion> dRight = new Array<>();
        dRight.add(defaultTA.findRegion("knt3_rt1"));
        dRight.add(defaultTA.findRegion("knt3_rt2"));
        Array<TextureAtlas.AtlasRegion> dLeft = new Array<>();
        dLeft.add(defaultTA.findRegion("knt3_lf1"));
        dLeft.add(defaultTA.findRegion("knt3_lf2"));


        defaultAnimationSet1A = new AnimationSet(
                new Animation(0.3f / 2f, dBack, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dFront, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dRight, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dLeft, Animation.PlayMode.LOOP_PINGPONG),
                defaultTA.findRegion("knt3_bk1"),
                defaultTA.findRegion("knt3_fr1"),
                defaultTA.findRegion("knt3_rt1"),
                defaultTA.findRegion("knt3_lf1"));
        return defaultAnimationSet1A;
    }



    public AnimationSet getDefaultAnimationSet4B() {

        defaultTA = new TextureAtlas("sprites.txt");
        Array<TextureAtlas.AtlasRegion> dBack = new Array<>();
        dBack.add(defaultTA.findRegion("jli1_bk1"));
        dBack.add(defaultTA.findRegion("jli1_bk2"));
        Array<TextureAtlas.AtlasRegion> dFront = new Array<>();
        dFront.add(defaultTA.findRegion("jli1_fr1"));
        dFront.add(defaultTA.findRegion("jli1_fr2"));
        Array<TextureAtlas.AtlasRegion> dRight = new Array<>();
        dRight.add(defaultTA.findRegion("jli1_rt1"));
        dRight.add(defaultTA.findRegion("jli1_rt2"));
        Array<TextureAtlas.AtlasRegion> dLeft = new Array<>();
        dLeft.add(defaultTA.findRegion("jli1_lf1"));
        dLeft.add(defaultTA.findRegion("jli1_lf2"));


        defaultAnimationSet1B = new AnimationSet(
                new Animation(0.3f / 2f, dBack, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dFront, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dRight, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dLeft, Animation.PlayMode.LOOP_PINGPONG),
                defaultTA.findRegion("jli1_bk1"),
                defaultTA.findRegion("jli1_fr1"),
                defaultTA.findRegion("jli1_rt1"),
                defaultTA.findRegion("jli1_lf1"));

        return defaultAnimationSet1B;
    }
    public AnimationSet getDefaultAnimationSet5A() {

        defaultTA = new TextureAtlas("sprites.txt");
        Array<TextureAtlas.AtlasRegion> dBack = new Array<>();
        dBack.add(defaultTA.findRegion("npc8_bk1"));
        dBack.add(defaultTA.findRegion("npc8_bk2"));
        Array<TextureAtlas.AtlasRegion> dFront = new Array<>();
        dFront.add(defaultTA.findRegion("npc8_fr1"));
        dFront.add(defaultTA.findRegion("npc8_fr2"));
        Array<TextureAtlas.AtlasRegion> dRight = new Array<>();
        dRight.add(defaultTA.findRegion("npc8_rt1"));
        dRight.add(defaultTA.findRegion("npc8_rt2"));
        Array<TextureAtlas.AtlasRegion> dLeft = new Array<>();
        dLeft.add(defaultTA.findRegion("npc8_lf1"));
        dLeft.add(defaultTA.findRegion("npc8_lf2"));


        defaultAnimationSet1A = new AnimationSet(
                new Animation(0.3f / 2f, dBack, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dFront, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dRight, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dLeft, Animation.PlayMode.LOOP_PINGPONG),
                defaultTA.findRegion("npc8_bk1"),
                defaultTA.findRegion("npc8_fr1"),
                defaultTA.findRegion("npc8_rt1"),
                defaultTA.findRegion("npc8_lf1"));
        return defaultAnimationSet1A;
    }



    public AnimationSet getDefaultAnimationSet5B() {

        defaultTA = new TextureAtlas("sprites.txt");
        Array<TextureAtlas.AtlasRegion> dBack = new Array<>();
        dBack.add(defaultTA.findRegion("npc9_bk1"));
        dBack.add(defaultTA.findRegion("npc9_bk2"));
        Array<TextureAtlas.AtlasRegion> dFront = new Array<>();
        dFront.add(defaultTA.findRegion("npc9_fr1"));
        dFront.add(defaultTA.findRegion("npc9_fr2"));
        Array<TextureAtlas.AtlasRegion> dRight = new Array<>();
        dRight.add(defaultTA.findRegion("npc9_rt1"));
        dRight.add(defaultTA.findRegion("npc9_rt2"));
        Array<TextureAtlas.AtlasRegion> dLeft = new Array<>();
        dLeft.add(defaultTA.findRegion("npc9_lf1"));
        dLeft.add(defaultTA.findRegion("npc9_lf2"));


        defaultAnimationSet1B = new AnimationSet(
                new Animation(0.3f / 2f, dBack, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dFront, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dRight, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dLeft, Animation.PlayMode.LOOP_PINGPONG),
                defaultTA.findRegion("npc9_bk1"),
                defaultTA.findRegion("npc9_fr1"),
                defaultTA.findRegion("npc9_rt1"),
                defaultTA.findRegion("npc9_lf1"));

        return defaultAnimationSet1B;
    }
    public AnimationSet getDefaultAnimationSet6A() {

        defaultTA = new TextureAtlas("sprites.txt");
        Array<TextureAtlas.AtlasRegion> dBack = new Array<>();
        dBack.add(defaultTA.findRegion("gsd1_bk1"));
        dBack.add(defaultTA.findRegion("gsd1_bk2"));
        Array<TextureAtlas.AtlasRegion> dFront = new Array<>();
        dFront.add(defaultTA.findRegion("gsd1_fr1"));
        dFront.add(defaultTA.findRegion("gsd1_fr2"));
        Array<TextureAtlas.AtlasRegion> dRight = new Array<>();
        dRight.add(defaultTA.findRegion("gsd1_rt1"));
        dRight.add(defaultTA.findRegion("gsd1_rt2"));
        Array<TextureAtlas.AtlasRegion> dLeft = new Array<>();
        dLeft.add(defaultTA.findRegion("gsd1_lf1"));
        dLeft.add(defaultTA.findRegion("gsd1_lf2"));


        defaultAnimationSet1A = new AnimationSet(
                new Animation(0.3f / 2f, dBack, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dFront, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dRight, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dLeft, Animation.PlayMode.LOOP_PINGPONG),
                defaultTA.findRegion("gsd1_bk1"),
                defaultTA.findRegion("gsd1_fr1"),
                defaultTA.findRegion("gsd1_rt1"),
                defaultTA.findRegion("gsd1_lf1"));
        return defaultAnimationSet1A;
    }



    public AnimationSet getDefaultAnimationSet6B() {

        defaultTA = new TextureAtlas("sprites.txt");
        Array<TextureAtlas.AtlasRegion> dBack = new Array<>();
        dBack.add(defaultTA.findRegion("zph1_bk1"));
        dBack.add(defaultTA.findRegion("zph1_bk2"));
        Array<TextureAtlas.AtlasRegion> dFront = new Array<>();
        dFront.add(defaultTA.findRegion("zph1_fr1"));
        dFront.add(defaultTA.findRegion("zph1_fr2"));
        Array<TextureAtlas.AtlasRegion> dRight = new Array<>();
        dRight.add(defaultTA.findRegion("zph1_rt1"));
        dRight.add(defaultTA.findRegion("zph1_rt2"));
        Array<TextureAtlas.AtlasRegion> dLeft = new Array<>();
        dLeft.add(defaultTA.findRegion("zph1_lf1"));
        dLeft.add(defaultTA.findRegion("zph1_lf2"));


        defaultAnimationSet1B = new AnimationSet(
                new Animation(0.3f / 2f, dBack, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dFront, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dRight, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dLeft, Animation.PlayMode.LOOP_PINGPONG),
                defaultTA.findRegion("zph1_bk1"),
                defaultTA.findRegion("zph1_fr1"),
                defaultTA.findRegion("zph1_rt1"),
                defaultTA.findRegion("zph1_lf1"));

        return defaultAnimationSet1B;
    }
    public AnimationSet getDefaultAnimationSet7A() {

        defaultTA = new TextureAtlas("sprites.txt");
        Array<TextureAtlas.AtlasRegion> dBack = new Array<>();
        dBack.add(defaultTA.findRegion("npc5_bk1"));
        dBack.add(defaultTA.findRegion("npc5_bk2"));
        Array<TextureAtlas.AtlasRegion> dFront = new Array<>();
        dFront.add(defaultTA.findRegion("npc5_fr1"));
        dFront.add(defaultTA.findRegion("npc5_fr2"));
        Array<TextureAtlas.AtlasRegion> dRight = new Array<>();
        dRight.add(defaultTA.findRegion("npc5_rt1"));
        dRight.add(defaultTA.findRegion("npc5_rt2"));
        Array<TextureAtlas.AtlasRegion> dLeft = new Array<>();
        dLeft.add(defaultTA.findRegion("npc5_lf1"));
        dLeft.add(defaultTA.findRegion("npc5_lf2"));


        defaultAnimationSet1A = new AnimationSet(
                new Animation(0.3f / 2f, dBack, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dFront, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dRight, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dLeft, Animation.PlayMode.LOOP_PINGPONG),
                defaultTA.findRegion("npc5_bk1"),
                defaultTA.findRegion("npc5_fr1"),
                defaultTA.findRegion("npc5_rt1"),
                defaultTA.findRegion("npc5_lf1"));
        return defaultAnimationSet1A;
    }



    public AnimationSet getDefaultAnimationSet7B() {

        defaultTA = new TextureAtlas("sprites.txt");
        Array<TextureAtlas.AtlasRegion> dBack = new Array<>();
        dBack.add(defaultTA.findRegion("smr1_bk1"));
        dBack.add(defaultTA.findRegion("smr1_bk2"));
        Array<TextureAtlas.AtlasRegion> dFront = new Array<>();
        dFront.add(defaultTA.findRegion("smr1_fr1"));
        dFront.add(defaultTA.findRegion("smr1_fr2"));
        Array<TextureAtlas.AtlasRegion> dRight = new Array<>();
        dRight.add(defaultTA.findRegion("smr1_rt1"));
        dRight.add(defaultTA.findRegion("smr1_rt2"));
        Array<TextureAtlas.AtlasRegion> dLeft = new Array<>();
        dLeft.add(defaultTA.findRegion("smr1_lf1"));
        dLeft.add(defaultTA.findRegion("smr1_lf2"));


        defaultAnimationSet1B = new AnimationSet(
                new Animation(0.3f / 2f, dBack, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dFront, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dRight, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dLeft, Animation.PlayMode.LOOP_PINGPONG),
                defaultTA.findRegion("smr1_bk1"),
                defaultTA.findRegion("smr1_fr1"),
                defaultTA.findRegion("smr1_rt1"),
                defaultTA.findRegion("smr1_lf1"));

        return defaultAnimationSet1B;
    }
    public AnimationSet getDefaultAnimationSet8A() {

        defaultTA = new TextureAtlas("sprites.txt");
        Array<TextureAtlas.AtlasRegion> dBack = new Array<>();
        dBack.add(defaultTA.findRegion("npc4_bk1"));
        dBack.add(defaultTA.findRegion("npc4_bk2"));
        Array<TextureAtlas.AtlasRegion> dFront = new Array<>();
        dFront.add(defaultTA.findRegion("npc4_fr1"));
        dFront.add(defaultTA.findRegion("npc4_fr2"));
        Array<TextureAtlas.AtlasRegion> dRight = new Array<>();
        dRight.add(defaultTA.findRegion("npc4_rt1"));
        dRight.add(defaultTA.findRegion("npc4_rt2"));
        Array<TextureAtlas.AtlasRegion> dLeft = new Array<>();
        dLeft.add(defaultTA.findRegion("npc4_lf1"));
        dLeft.add(defaultTA.findRegion("npc4_lf2"));


        defaultAnimationSet1A = new AnimationSet(
                new Animation(0.3f / 2f, dBack, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dFront, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dRight, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dLeft, Animation.PlayMode.LOOP_PINGPONG),
                defaultTA.findRegion("npc4_bk1"),
                defaultTA.findRegion("npc4_fr1"),
                defaultTA.findRegion("npc4_rt1"),
                defaultTA.findRegion("npc4_lf1"));
        return defaultAnimationSet1A;
    }



    public AnimationSet getDefaultAnimationSet8B() {

        defaultTA = new TextureAtlas("sprites.txt");
        Array<TextureAtlas.AtlasRegion> dBack = new Array<>();
        dBack.add(defaultTA.findRegion("npc3_bk1"));
        dBack.add(defaultTA.findRegion("npc3_bk2"));
        Array<TextureAtlas.AtlasRegion> dFront = new Array<>();
        dFront.add(defaultTA.findRegion("npc3_fr1"));
        dFront.add(defaultTA.findRegion("npc3_fr2"));
        Array<TextureAtlas.AtlasRegion> dRight = new Array<>();
        dRight.add(defaultTA.findRegion("npc3_rt1"));
        dRight.add(defaultTA.findRegion("npc3_rt2"));
        Array<TextureAtlas.AtlasRegion> dLeft = new Array<>();
        dLeft.add(defaultTA.findRegion("npc3_lf1"));
        dLeft.add(defaultTA.findRegion("npc3_lf2"));


        defaultAnimationSet1B = new AnimationSet(
                new Animation(0.3f / 2f, dBack, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dFront, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dRight, Animation.PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, dLeft, Animation.PlayMode.LOOP_PINGPONG),
                defaultTA.findRegion("npc3_bk1"),
                defaultTA.findRegion("npc3_fr1"),
                defaultTA.findRegion("npc3_rt1"),
                defaultTA.findRegion("npc3_lf1"));

        return defaultAnimationSet1B;
    }

    public Animation getFlowerAnimation() {
        atlas = AbstractScreen.app.getTileAssetManager().get("graphics_packed/tiles/tilepack.atlas", TextureAtlas.class);

        flowerAnimation = new Animation(0.8f, atlas.findRegions("flowers"), Animation.PlayMode.LOOP_PINGPONG);
    return flowerAnimation;
    }

}
