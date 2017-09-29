package com.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import main.Drop;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Drop(), config);
		config.width = 1366;
		config.height = 768;
		config.resizable = false;
		config.title = "Test Game : 25/09/2017";
		config.samples=3;
	}
}
