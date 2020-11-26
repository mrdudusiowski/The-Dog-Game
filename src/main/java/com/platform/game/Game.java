package com.platform.game;

import com.platform.core.DisplayManager;
import com.platform.core.GameLoop;
import com.platform.core.game.StateManager;
import com.platform.core.render.ModelManager;

import javax.swing.*;
import java.awt.*;

public class Game {

	private static Timer timer;
	private static boolean running = false;
	private static StateManager stateManager;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				ModelManager.init();
				DisplayManager.createDisplay();
				startGame();
			}
		});
	}

	private static void startGame() {
		stateManager = new StateManager();
		running = true;
		timer = new Timer(20, new GameLoop());
		timer.start();
	}

	public static boolean isRunning() {
		return running;
	}

	public static StateManager getStateManager() {
		return stateManager;
	}
}
