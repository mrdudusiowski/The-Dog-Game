package com.platform.game.entity;


import com.platform.core.enums.Direction;
import com.platform.core.game.StateManager;
import com.platform.core.render.Animation;
import com.platform.core.render.ModelManager;

public class Turtle extends Entity {

	private Animation walking;
	
	public Turtle(int posX, int posY) {
		super(posX, posY, ModelManager.model(ModelManager.TURTLE_1));
		this.killable = false;
		this.left = true;
		this.movementSpeed = 2;
		this.walking = new Animation(10, ModelManager.model(ModelManager.TURTLE_1), ModelManager.model(ModelManager.TURTLE_2), ModelManager.model(ModelManager.TURTLE_1), ModelManager.model(ModelManager.TURTLE_2));
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
			this.setModel(walking.getCurrentFrame());
		}
	}
}
