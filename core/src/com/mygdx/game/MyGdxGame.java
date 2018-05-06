package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.Screens.GameScreen;

import javax.swing.JOptionPane;

public class MyGdxGame extends Game {
	SpriteBatch batch;
	Texture img;
	private GameScreen gameScreen;
	private AssetManager tileAssetManager;
	Music sound;
	public static float timer;



	@Override
	public void create () {

		tileAssetManager = new AssetManager();
		tileAssetManager.load("graphics_packed/tiles/tilepack.atlas", TextureAtlas.class);
		tileAssetManager.finishLoading();
	gameScreen = new GameScreen(this);
		this.setScreen(gameScreen);
		timer = System.currentTimeMillis();
		sound = Gdx.audio.newMusic(Gdx.files.internal("Road to Dazir.mp3"));
		sound.setLooping(true);
		sound.setVolume(1);

	}

	@Override
	public void render () {
		sound.play();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
		if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
			this.setScreen(new GameScreen(this));
			timer = System.currentTimeMillis();
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
			Gdx.app.exit();
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
//                sound.play();

				sound.setVolume(1-sound.getVolume());
			}

		if (Gdx.input.isKeyJustPressed(Input.Keys.C)) {
			JOptionPane.showMessageDialog(null,
					"Move Left - Left Arrow" +
							"\nMove Right - Right Arrow" +
							"\n Move Down - Down Arrow" +
							"\nMove Up - Up Arrow" +
							"\n Free helpers - Spacebar" +
							"\n Pull helpers - Right Shift" +
							"\n Push helpers - Left Shift" +
							"\n Helpers chase a flower - Enter" +
							"\n Reset game - R" +
							"\n Toggle music - M" +
							"\n View this again - C");
		}

	}


	@Override
	public void dispose () {
//		batch.dispose();
//		img.dispose();
	}

	public AssetManager getTileAssetManager() {
		return tileAssetManager;
	}

	public static float getTime() {
	return 	 Math.round(Math.abs(timer-System.currentTimeMillis())*100)/1000000f;

	}
}
