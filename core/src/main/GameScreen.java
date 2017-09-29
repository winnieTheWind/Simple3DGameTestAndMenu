package main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import entities.FPSSystem;
import rendering.RenderingSystem;

public class GameScreen implements Screen {
	
  	final Drop game;
  	
	public RenderingSystem renderingSystem;
	public FPSSystem fpsSystem;

	public GameScreen(final Drop gameDelta) {

		this.game = gameDelta;
		renderingSystem = new RenderingSystem();
		fpsSystem = new FPSSystem();
		
		renderingSystem.create();
		fpsSystem.create();
	}

	@Override
	public void render(float delta) {
		// clear the screen with a dark blue color. The
		// arguments to glClearColor are the red, green
		// blue and alpha component in the range [0,1]
		// of the color to be used to clear the screen.
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT|GL20.GL_DEPTH_BUFFER_BIT);
		
		fpsSystem.render();
		renderingSystem.render();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {

	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		fpsSystem.dispose();
		renderingSystem.dispose();

	}

}