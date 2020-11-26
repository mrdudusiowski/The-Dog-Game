package com.platform.game.entity;

import com.platform.core.enums.Direction;
import com.platform.core.game.StateManager;
import com.platform.core.render.Model;

import java.awt.*;


public class Entity extends StaticEntity {

	protected boolean left;
	protected boolean right;
	protected int movementSpeed;

	protected boolean isRuning;
	protected boolean isInAir;
	protected int fallSpeed;
	protected boolean killable=true;
	
	protected Direction facing;
	protected boolean dead;

	public Entity(int posX, int posY, Model model) {
		super(posX, posY, model);
		this.left = false;
		this.right = false;
		this.fallSpeed = 0;
		this.isInAir = true;
		this.isRuning = false;
		this.facing = Direction.RIGHT;
		this.movementSpeed = 5;
		this.dead = false;
	}

	public void move() {
		if(left) {
			if(this.posX > 0)
				this.posX-=this.movementSpeed;
			this.facing = Direction.LEFT;
		}
		if(right) {
			this.posX+=this.movementSpeed;
			this.facing = Direction.RIGHT;
		}
		
		this.posY+=this.fallSpeed;
		this.fallSpeed++;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void setRuning(boolean runing) { isRuning = runing; }

	public void jump() {

		if(!isInAir) {
			this.fallSpeed = -15;
			this.isInAir = true;
		}
	}

	public void run(){
		if(!isRuning) {
			this.movementSpeed = 10;
			this.isRuning = true;
		}
	}

	public void stopRuning(){
		if(isRuning) {
			this.movementSpeed = 5;
			this.isRuning = false;
		}
	}

	public Direction checkCollision(StaticEntity block, StateManager gsm) {
		Rectangle intersection = this.getModel().intersection(block.getModel());
		
		if(intersection.isEmpty()) {
			return Direction.NULL;
		}
		
		if(intersection.width > intersection.height) {
			block.onEntityCollision(this, gsm);
			
			if(this.posY < block.posY) {
				this.posY = block.posY - this.getModel().height;
				this.fallSpeed = 0;
				this.isInAir = false;
				return Direction.NULL;
			} else {
				this.posY = block.posY + block.getModel().height;
				this.fallSpeed = 0;
				return Direction.NULL;
			}
		} else {
			block.onEntityCollision(this, gsm);
			
			if(this.posX < block.posX) {
				this.posX = block.posX - this.getModel().width;
				return Direction.LEFT;
			} else {
				this.posX = block.posX + block.getModel().width;
				return Direction.RIGHT;
			}
		}
	}
	
	public Direction getFacing() {
		return facing;
	}
	
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
	public boolean isDead() {
		return dead;
	}
}
