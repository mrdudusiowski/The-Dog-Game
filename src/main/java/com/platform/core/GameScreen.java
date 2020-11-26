package com.platform.core;

import com.platform.core.input.Keyboard;
import com.platform.game.Game;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {

	private static final long serialVersionUID = 1L;

	public GameScreen() {
		super();
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Keyboard());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(Game.isRunning()) {
			Game.getStateManager().render(g);
		}
		repaint();
	}
}
