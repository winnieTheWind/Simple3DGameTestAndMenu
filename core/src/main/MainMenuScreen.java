package main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenuScreen implements Screen {
	
    final Drop game;
	OrthographicCamera camera;
	
	private Stage menuStage;
	private Skin menuSkin;
	private Table menuTable;
	private TextButton startButton;
	private TextButton loadButton;
	private TextButton aboutButton;
	private TextButton quitButton;
	private Dialog aboutDialog;
	
	public MainMenuScreen(final Drop gameDelta) {
		game = gameDelta;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		
		menuSkin = new Skin(Gdx.files.internal("uiskin.json"));
		menuStage = new Stage(new ScreenViewport());
		menuTable = new Table();
		menuTable.setWidth(menuStage.getWidth());

		menuTable.setPosition(0, Gdx.graphics.getHeight());
		
		startButton = new TextButton("New Game", menuSkin);
		loadButton = new TextButton("Load Game", menuSkin);
		aboutButton = new TextButton("    About    ", menuSkin, "default");
		quitButton = new TextButton("Quit Game", menuSkin);
		aboutDialog = new Dialog("Test Text", menuSkin);
		aboutDialog.pad(60);
		
		menuTable.padTop(950);
		menuTable.add(startButton).padBottom(10);
		menuTable.row();
		menuTable.add(loadButton).padBottom(10);
		menuTable.row();
		menuTable.add(aboutButton).padBottom(10);
		menuTable.row();
		menuTable.add(quitButton).padBottom(10);
	
		menuStage.addActor(menuTable);
		
		///////////////////////////
		/// ABOUT Button Trigger //
		///////////////////////////
		aboutButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				aboutDialog.show(menuStage);
				aboutDialog.setPosition(Gdx.graphics.getWidth()/2-122, Gdx.graphics.getHeight()/2-300);

				Timer.schedule(new Timer.Task() {
		
					@Override
					public void run() {
						aboutDialog.hide();
					}
				
				}, 3); //Seconds till the about dialog closes
		}
	});
		
		//////////////////////////
		/// EXIT Button Trigger //
		//////////////////////////
		quitButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
				}
	});
				
		///////////////////////////
		/// START Button Trigger //
		///////////////////////////
		startButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new GameScreen(game));
				dispose();
				}
	});
		
			Gdx.input.setInputProcessor(menuStage);
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT|GL20.GL_DEPTH_BUFFER_BIT);

		menuStage.act(Gdx.graphics.getDeltaTime());
		menuStage.draw();
		
		camera.update();

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
		
		menuStage.clear();
		menuStage.dispose();
		
	}
}