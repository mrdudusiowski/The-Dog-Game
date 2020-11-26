package com.platform.game.entity;


import com.platform.core.game.StateManager;
import com.platform.core.game.model.LevelState;
import com.platform.core.render.ModelManager;

public class ExitDoor extends StaticEntity {

	public ExitDoor(int posX, int posY) {
		super(posX, posY, ModelManager.model(ModelManager.FINISH));
	}
	
	@Override
	public void onEntityCollision(Entity entity, StateManager gsm) {
		if(entity instanceof Player) {
			if(gsm.getActiveState() instanceof LevelState)
				gsm.getActiveState().playBackgroundMusic();
			gsm.addState(new LevelState(gsm));
		}
	}

}
