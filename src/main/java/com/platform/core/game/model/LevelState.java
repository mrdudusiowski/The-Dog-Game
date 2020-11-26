package com.platform.core.game.model;

import com.platform.core.DisplayManager;
import com.platform.core.game.StateManager;
import com.platform.core.render.ModelManager;
import com.platform.core.render.Renderer;
import com.platform.core.utils.FontHelper;
import com.platform.game.entity.*;
import com.platform.game.world.Map;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class LevelState extends State {

	private Player player;
	private Camera camera;
	
	private ArrayList<StaticEntity> blocks;
	private ArrayList<Turtle> turtlesInLevel;
	private ArrayList<Wasp> waspsInLevel;
	private ArrayList<Poo> poosInLevel;
	public ArrayList<StaticEntity> extraEntities;
	public ArrayList<BGObject> bgObjects;

	private static int playerLives = 3;
	private static int levelIndex = 0;
	public static int totalScore = 0;

	public LevelState(StateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		if(levelIndex == 0)
			totalScore = 0;
		levelIndex++;
		this.initializeAssets(String.format("/textures/background/background%d.png", levelIndex), String.format("/music/level%d.wav", levelIndex), FONT_LOCALISATION);
		playBackgroundMusic();
		this.reset();
	}

	private void reset() {
		Map map = new Map(levelIndex);
		this.player = map.getPlayer();
		this.camera = new Camera(player);
		this.blocks = map.getBlocks();
		this.turtlesInLevel = map.getTurtles();
		this.waspsInLevel = map.getWasps();
		this.poosInLevel = map.getPoos();
		this.bgObjects = map.getBgObjects();
		this.extraEntities = map.getExtraEntities();
	}

	@Override
	public void tick() {
		if(levelIndex == 4){
			this.gsm.addState(new Win(gsm));
			levelIndex = 0;
			playerLives = 3;
		}
		this.moveEntities();
		this.checkCollisions();
		
		this.findEntitiesToDespawn();
		this.respawnPlayerIfNecessary();

		this.camera.setPosition(player.getPosX(), player.getPosY());
	}

	@Override
	public void render(Graphics graphics) {
		try {
			BufferedImage img = ImageIO.read(backgroundURL);
			graphics.drawImage(img, 0, 0, DisplayManager.WIDTH, DisplayManager.HEIGHT, null);
		} catch (IOException e) {
			System.out.println("[LEVEL][BACKGROUND] Nie można załadować tła gry: "+e.getMessage());
		}

		for(BGObject bgObject : this.bgObjects) {
			Renderer.renderEntity(bgObject, camera, graphics);
		}

		Renderer.renderEntity(player, camera, graphics);

		for(StaticEntity block : this.blocks) {
			Renderer.renderEntity(block, camera, graphics);
		}

		for(Turtle turtle : this.turtlesInLevel) {
			Renderer.renderEntity(turtle, camera, graphics);
		}

		for(Poo poo : this.poosInLevel) {
			Renderer.renderEntity(poo, camera, graphics);
		}

		for(Wasp wasp : this.waspsInLevel) {
			Renderer.renderEntity(wasp, camera, graphics);
		}

		for(StaticEntity extra : this.extraEntities) {
				Renderer.renderEntity(extra, camera, graphics);
		}

		for(int i=0;i<playerLives;i++) {
			Renderer.renderModel(ModelManager.model(ModelManager.LIFE), 10+i*30, 0, graphics);
		}
		graphics.setColor(Color.BLACK);
		if(fontURL != null)
			customFont = FontHelper.createFont(fontURL, 20f);
		if(customFont != null){
			graphics.setFont(customFont);
		} else{
			graphics.setFont(new Font("Arial", Font.BOLD, 20));
		}
		graphics.drawString("Wynik: "+totalScore, 25, 55);
	}

	@Override
	public void keyPressed(int key) {
		if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
			this.player.setLeft(true);
		}
		else if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
			this.player.setRight(true);
		}
		else if(key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP) {
			this.player.jump();
		}
		else  if(key == KeyEvent.VK_SHIFT){
			this.player.run();
		}
	}

	@Override
	public void keyReleased(int key) {
		if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
			this.player.setLeft(false);
		}
		else if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
			this.player.setRight(false);
		}
		else if(key == KeyEvent.VK_SHIFT){
			this.player.stopRuning();
		}
	}

	private void moveEntities() {
		this.player.move();

		if(!this.player.isDead()) {
			for(Turtle turtle : this.turtlesInLevel) {
				turtle.move();
			}
			for(Wasp wasp : this.waspsInLevel) {
				wasp.move();
			}
			for(Poo poo : this.poosInLevel) {
				poo.move();
			}
			for(StaticEntity entity : this.extraEntities) {
				if(entity instanceof Entity) {
					((Entity) entity).move();
				}
			}
		}
	}

	private void checkCollisions() {
		for(StaticEntity block : this.blocks) {
			this.player.checkCollision(block, gsm);
			
			for(Turtle turtle : this.turtlesInLevel) {
				turtle.checkCollision(block, gsm);
				turtle.checkCollision(player, gsm);
			}

			for(Wasp wasp : this.waspsInLevel) {
				wasp.checkCollision(block, gsm);
				wasp.checkCollision(player, gsm);
			}

			for(Poo poo : this.poosInLevel) {
				poo.checkCollision(block, gsm);
				poo.checkCollision(player, gsm);
			}

			for(StaticEntity entity : this.extraEntities) {
				if(entity instanceof Entity) {
					((Entity) entity).checkCollision(block, gsm);
				}
			}
		}

		for(StaticEntity entity : this.extraEntities) {
			this.player.checkCollision(entity, gsm);
		}
	}

	private void findEntitiesToDespawn() {
		for(int i = 0; i<this.turtlesInLevel.size(); i++) {
			if(this.turtlesInLevel.get(i).isDead())
				this.turtlesInLevel.remove(i);
		}

		for(int i = 0; i<this.waspsInLevel.size(); i++) {
			if(this.waspsInLevel.get(i).isDead())
				this.waspsInLevel.remove(i);
		}

		for(int i = 0; i<this.poosInLevel.size(); i++) {
			if(this.poosInLevel.get(i).isDead())
				this.poosInLevel.remove(i);
		}
		
		for(int i=0;i<this.extraEntities.size();i++) {
			if(this.extraEntities.get(i) instanceof Entity) {
				if(((Entity) this.extraEntities.get(i)).isDead())
					this.extraEntities.remove(i);
			}
		}
	}

	private void respawnPlayerIfNecessary() {
		if(this.player.shouldRespawn()) {
			this.player.setDead(false);
			playerLives--;
			if(playerLives >= 0) {
				this.reset();
			} else {
				this.backgroundClip.stop();
				this.gsm.addState(new GameOver(gsm));
				levelIndex = 0;
				playerLives = 3;
			}
		}
	}
}
