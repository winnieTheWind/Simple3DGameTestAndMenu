package main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Drop extends Game {
	
	public SpriteBatch batch;
	public BitmapFont font;

	public void create() {

		this.setScreen(new MainMenuScreen(this));
	}



	public void render() {
		super.render(); //important!
	}
	
	public void dispose() {
		batch.dispose();
		font.dispose();
	}

}