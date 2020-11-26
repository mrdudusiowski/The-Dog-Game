package com.platform.game.entity;

import com.platform.core.game.StateManager;
import com.platform.core.game.model.LevelState;
import com.platform.core.render.Animation;
import com.platform.core.render.ModelManager;
import com.platform.core.utils.MathHelper;


public class Fruit extends Entity {

	private int score;

	private Animation apple;
	
	public Fruit(int posX, int posY) {
		super(posX, posY, null);
		switch(MathHelper.randomInt(9)) {
		case 0:
			this.setModel(ModelManager.model(ModelManager.APPLE));
			this.score = 100;
			break;
		case 1:
			this.setModel(ModelManager.model(ModelManager.BANANA));
			this.score = 200;
			break;
		case 2:
			this.setModel(ModelManager.model(ModelManager.CHERRY));
			this.score = 350;
			break;
		case 3:
			this.setModel(ModelManager.model(ModelManager.KIWI));
			this.score = 400;
			break;
		case 4:
			this.setModel(ModelManager.model(ModelManager.MELON));
			this.score = 450;
			break;
		case 5:
			this.setModel(ModelManager.model(ModelManager.ORANGE));
			this.score = 500;
			break;
		case 6:
			this.setModel(ModelManager.model(ModelManager.PINEAPPLE));
			this.score = 550;
			break;
		case 7:
			this.setModel(ModelManager.model(ModelManager.STRAWBERRY));
			this.score = 950;
			break;
		case 8:
			this.setModel(ModelManager.model(ModelManager.BISCOUT));
			this.score = 1500;
			break;
		}
	}

	@Override
	public void onEntityCollision(Entity entity, StateManager gsm) {
		if(entity instanceof Player) {
			LevelState.totalScore += this.score;
			this.setDead(true);
		}
	}
}
