package com.platform.game.entity;

import com.platform.core.DisplayManager;
import com.platform.core.game.StateManager;
import com.platform.core.render.Animation;
import com.platform.core.render.ModelManager;
import javafx.scene.media.AudioClip;

import java.io.File;
import java.net.URL;


public final class Player extends Entity {

	private int deathTime;
	
	private Animation walking;
	private Animation jump;
	private Animation death;
	private Animation fall;
	private Animation run;

	private URL footStepsSlowURL;
	private URL footStepFastURL;
	private URL deathURL;
	private URL jumpURL;
	private AudioClip footStepSlowAudio;
	private AudioClip footStepFastAudio;
	private AudioClip deathAudio;
	private AudioClip jumpAudio;

	public Player(int posX, int posY) {
		super(posX, posY, ModelManager.model(ModelManager.PLAYER));

		try{
			this.footStepsSlowURL = this.getClass().getClassLoader().getResource("music/footstepsSlow.wav");
			this.footStepFastURL = this.getClass().getClassLoader().getResource("music/footstepsFast.wav");
			this.deathURL = this.getClass().getClassLoader().getResource("music/death.wav");
			this.jumpURL = this.getClass().getClassLoader().getResource("music/jump.wav");
		}catch (Exception e) {
			System.out.println("[PLAYER][INITIALIZE] Problem z załadowaniem plików dźwiękowych playera" + e.getMessage());
		}
		if( footStepsSlowURL != null)
			this.footStepSlowAudio = new AudioClip(footStepsSlowURL.toString());
		if( footStepFastURL != null)
			this.footStepFastAudio = new AudioClip(footStepFastURL.toString());
		if( deathURL != null)
			this.deathAudio = new AudioClip(deathURL.toString());
		if( jumpURL != null)
			this.jumpAudio = new AudioClip(jumpURL.toString());

		this.deathTime = 0;
		
		this.walking = new Animation(5, ModelManager.model(ModelManager.PLAYER_WALK_1), ModelManager.model(ModelManager.PLAYER_WALK_2),
				ModelManager.model(ModelManager.PLAYER_WALK_3), ModelManager.model(ModelManager.PLAYER_WALK_4),
				ModelManager.model(ModelManager.PLAYER_WALK_5), ModelManager.model(ModelManager.PLAYER_WALK_6), ModelManager.model(ModelManager.PLAYER_WALK_7),
				ModelManager.model(ModelManager.PLAYER_WALK_8), ModelManager.model(ModelManager.PLAYER_WALK_9), ModelManager.model(ModelManager.PLAYER_WALK_10));
		this.death = new Animation(5, ModelManager.model(ModelManager.PLAYER_DEATH_1), ModelManager.model(ModelManager.PLAYER_DEATH_2),
				ModelManager.model(ModelManager.PLAYER_DEATH_3), ModelManager.model(ModelManager.PLAYER_DEATH_4), ModelManager.model(ModelManager.PLAYER_DEATH_5),
				ModelManager.model(ModelManager.PLAYER_DEATH_6), ModelManager.model(ModelManager.PLAYER_DEATH_7), ModelManager.model(ModelManager.PLAYER_DEATH_8),
				ModelManager.model(ModelManager.PLAYER_DEATH_9), ModelManager.model(ModelManager.PLAYER_DEATH_10));
		this.jump = new Animation(5, ModelManager.model(ModelManager.PLAYER_JUMP_1), ModelManager.model(ModelManager.PLAYER_JUMP_2),
				ModelManager.model(ModelManager.PLAYER_JUMP_3), ModelManager.model(ModelManager.PLAYER_JUMP_4), ModelManager.model(ModelManager.PLAYER_JUMP_5),
				ModelManager.model(ModelManager.PLAYER_JUMP_6), ModelManager.model(ModelManager.PLAYER_JUMP_7), ModelManager.model(ModelManager.PLAYER_JUMP_8));
		this.fall = new Animation(5, ModelManager.model(ModelManager.PLAYER_FALL_1), ModelManager.model(ModelManager.PLAYER_FALL_2),
				ModelManager.model(ModelManager.PLAYER_FALL_3), ModelManager.model(ModelManager.PLAYER_FALL_4), ModelManager.model(ModelManager.PLAYER_FALL_5),
				ModelManager.model(ModelManager.PLAYER_FALL_6), ModelManager.model(ModelManager.PLAYER_JUMP_7), ModelManager.model(ModelManager.PLAYER_FALL_8));
		this.run = new Animation(5, ModelManager.model(ModelManager.PLAYER_RUN_1), ModelManager.model(ModelManager.PLAYER_RUN_2),
				ModelManager.model(ModelManager.PLAYER_RUN_3), ModelManager.model(ModelManager.PLAYER_RUN_4),
				ModelManager.model(ModelManager.PLAYER_RUN_5), ModelManager.model(ModelManager.PLAYER_RUN_6), ModelManager.model(ModelManager.PLAYER_RUN_7),
				ModelManager.model(ModelManager.PLAYER_RUN_8));
	}

	@Override
	public void move() {
		if(!this.dead)
			super.move();

		if(this.getPosY() > DisplayManager.HEIGHT)
			this.setDead(true);
		
		if(this.dead)
			this.deathTime++;
		
		changeAnimations();
	}
	
	public boolean shouldRespawn() {
		return deathTime >= 20;
	}
	
	private void changeAnimations() {
		if(this.fallSpeed < 0 && this.isInAir) {
			this.setModel(jump.getCurrentFrame());

		}
		else if(this.fallSpeed >= 0 && this.isInAir) {
			this.setModel(fall.getCurrentFrame());
		}
		else {
			if(this.left || this.right && !this.isRuning) {
				if(!footStepSlowAudio.isPlaying())
					footStepSlowAudio.play();
				this.setModel(walking.getCurrentFrame());
			}
			else if(this.left || this.right && this.isRuning){
				if(!footStepFastAudio.isPlaying())
					footStepFastAudio.play();
				this.setModel(run.getCurrentFrame());
			}
			else {
				this.setModel(ModelManager.model(ModelManager.PLAYER));
			}
		}
		
		if(this.dead) {
			if(!deathAudio.isPlaying())
				deathAudio.play();
			this.setModel(death.getCurrentFrame());
		}
	}
	
	@Override
	public void onEntityCollision(Entity entity, StateManager gsm) {
		if(entity instanceof Turtle || entity instanceof Wasp || entity instanceof Poo) {
			if(entity.killable) {
				entity.setDead(true);
				if(entity instanceof Poo){
					this.movementSpeed = 1;
				}
			}else {
				this.setDead(true);
			}
		}
		if(entity instanceof Fruit){
			entity.setDead(true);
		}
	}

	@Override
	public void jump() {
		jumpAudio.play();
		super.jump();
	}
}
