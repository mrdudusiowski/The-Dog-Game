package com.platform.game.entity;


import com.platform.core.enums.Direction;
import com.platform.core.game.StateManager;
import com.platform.core.render.ModelManager;

public class Wasp extends Entity {

	public Wasp(int posX, int posY) {
		super(posX, posY, ModelManager.model(ModelManager.WASP));
		this.killable = false;
		this.left = true;
		this.movementSpeed = 1; //4
	}
	
	@Override
	public Direction checkCollision(StaticEntity block, StateManager gsm) {
		switch(super.checkCollision(block, gsm)) {
		case LEFT:
			this.left = true;
			this.right = false;
			return Direction.LEFT;
		case RIGHT:
			this.right = true;
			this.left = false;
			return Direction.RIGHT;
		default:
			return null;
		}
	}
	
	@Override
	public void move() {
		super.move();
		if(this.left || this.right) {
			this.setModel(ModelManager.model(ModelManager.WASP));
		}
	}
}
