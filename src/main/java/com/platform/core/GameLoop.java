package com.platform.core;

import com.platform.game.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLoop implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Game.getStateManager().tick();
	}

}
