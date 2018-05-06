package com.mygdx.game.Screens;

import com.badlogic.gdx.Screen;
import com.mygdx.game.MyGdxGame;

/**
 * Created by minad on 10/22/17.
 */

public class AbstractScreen implements Screen {
    public static MyGdxGame app;

    public AbstractScreen(MyGdxGame app) {
        this.app = app;
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public MyGdxGame getApp() {
        return app;
    }
}
