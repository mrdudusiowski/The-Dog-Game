package com.platform.game.world;

import com.platform.core.enums.Direction;
import com.platform.core.render.Model;
import com.platform.core.render.ModelManager;
import com.platform.game.Game;
import com.platform.game.entity.*;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.CodeSource;
import java.util.ArrayList;

public class Map {

	private Player player;
	private ArrayList<StaticEntity> blocks;
	private ArrayList<StaticEntity> extraEntities;
	private ArrayList<Turtle> turtles;
	private ArrayList<Poo> poos;
	private ArrayList<Wasp> wasps;
	private ArrayList<BGObject> bgObjects;
	
	private int height;
	private int width;
	
	public Map(int levelIndex) {
		this.blocks = new ArrayList<>();
		this.turtles = new ArrayList<>();
		this.poos = new ArrayList<>();
		this.wasps = new ArrayList<>();
		this.bgObjects = new ArrayList<>();
		this.extraEntities = new ArrayList<>();
		
		System.out.println("[MAP]: Ładowanie mapy: "+levelIndex);
		this.loadFile(levelIndex);

	}
	
	public ArrayList<StaticEntity> getBlocks() {
		return blocks;
	}
	
	public ArrayList<Turtle> getTurtles() {
		return turtles;
	}

	public ArrayList<StaticEntity> getExtraEntities() { return extraEntities; }

	public ArrayList<Poo> getPoos() { return poos; }

	public ArrayList<Wasp> getWasps() { return wasps; }

	public Player getPlayer() {
		return player;
	}

	public ArrayList<BGObject> getBgObjects() { return bgObjects; }

	private void loadFile(int levelIndex) {
		BufferedReader reader = null;
		try {
			InputStream in = Game.class.getResourceAsStream("/maps/level"+levelIndex+".txt");
			reader = new BufferedReader(new InputStreamReader(in));

			this.height = Integer.parseInt(reader.readLine());
			this.width = Integer.parseInt(reader.readLine());
			
			Model block = ModelManager.model(ModelManager.BLOCK);
			Model blockRounded = ModelManager.model(ModelManager.BLOCK_ROUNDED);
			Model blockLeftRounded = ModelManager.model(ModelManager.BLOCK_LEFT_ROUND);
			Model blockRightRounded = ModelManager.model(ModelManager.BLOCK_RIGHT_ROUND);
			Model platform = ModelManager.model(ModelManager.PLATFORM_CENTER);
			Model platformRounded = ModelManager.model(ModelManager.PLATFORM_MINI);
			Model platformLeftRounded = ModelManager.model(ModelManager.PLATFORM_LEFT);
			Model platformRightRounded = ModelManager.model(ModelManager.PLATFORM_RIGHT);
			Model mud = ModelManager.model(ModelManager.BLOCK_OF_MUD);
			Model mudWithBone = ModelManager.model(ModelManager.BLOCK_OF_MUD_BONE);
			Model mudWithSkeleton = ModelManager.model(ModelManager.BLOCK_OF_MUD_SKELETON);
			Model startDoor = ModelManager.model(ModelManager.START);
			Model cloud = ModelManager.model(ModelManager.CLOUD);
			Model grass = ModelManager.model(ModelManager.PIPE_GRASS);
			Model flower1 = ModelManager.model(ModelManager.FLOWER_1);
			Model flower2 = ModelManager.model(ModelManager.FLOWER_2);

			for(int y=0;y<height;y++) {
				String line = reader.readLine();
				String[] singles = line.split("\\s+");
				
				for(int x=0;x<width;x++) {
					switch(singles[x]) {
					case "P":
						this.player = new Player(x*block.width, y*block.height);
						break;
					case "1":
						this.blocks.add(new StaticEntity(x*block.width, y*block.height, block));
						break;
					case "2":
						this.blocks.add(new StaticEntity(x*mud.width, y*mud.height, mud));
						break;
					case "3":
						this.blocks.add(new StaticEntity(x*blockLeftRounded.width, y*blockLeftRounded.height, blockLeftRounded));
						break;
					case "4":
						this.blocks.add(new StaticEntity(x*blockRightRounded.width, y*blockRightRounded.height, blockRightRounded));
						break;
					case "5":
						this.blocks.add(new StaticEntity(x*mudWithBone.width, y*mudWithBone.height, mudWithBone));
						break;
					case "6":
						this.blocks.add(new StaticEntity(x*mudWithSkeleton.width, y*mudWithSkeleton.height, mudWithSkeleton));
						break;
					case "7":
						this.blocks.add(new StaticEntity(x*blockRounded.width, y*blockRounded.height, blockRounded));
						break;
					case "8":
						this.blocks.add(new StaticEntity(x*platformLeftRounded.width, y*platformLeftRounded.height, platformLeftRounded));
						break;
					case "u":
						this.blocks.add(new StaticEntity(x*platformRightRounded.width, y*platformRightRounded.height, platformRightRounded));
						break;
					case "i":
						this.blocks.add(new StaticEntity(x*platformRounded.width, y*platformRounded.height, platformRounded));
						break;
					case "9":
						this.blocks.add(new StaticEntity(x*platform.width, y*platform.height, platform));
						break;
					case "t":
						this.turtles.add(new Turtle(x*block.width, y*block.height));
						break;
					case "w":
						this.wasps.add(new Wasp(x*block.width, y*block.height));
						break;
					case "p":
						this.poos.add(new Poo(x*block.width, y*block.height));
						break;
					case "^":
						this.blocks.add(new Spikes(x*block.width, y*block.height, Direction.UP));
						break;
					case "<":
						this.blocks.add(new Spikes(x*block.width, y*block.height, Direction.LEFT));
						break;
					case ">":
						this.blocks.add(new Spikes(x*block.width, y*block.height, Direction.RIGHT));
						break;
					case ".":
						this.blocks.add(new Spikes(x*block.width, y*block.height, Direction.DOWN));
						break;
					case "F":
						this.blocks.add(new ExitDoor(x*block.width, y*block.height-20));
						break;
					case "S":
						this.bgObjects.add(new BGObject(x*block.width, y*block.height-20, startDoor));
						break;
					case "c":
						this.bgObjects.add(new BGObject(x*block.width, y*block.height-20, cloud));
						break;
					case "n":
						this.bgObjects.add(new BGObject(x*block.width, y*block.height-20, grass));
						break;
					case "g":
						this.bgObjects.add(new BGObject(x*block.width, y*block.height-20, flower1));
						break;
					case "r":
						this.bgObjects.add(new BGObject(x*block.width, y*block.height-20, flower2));
						break;
					case "f":
						this.extraEntities.add(new Fruit(x*block.width, y*block.height-20));
						break;
					case "0":
						break;
					}
				}
			}
		} catch(Exception e) {
			System.err.println("[MAP] Problem z załadowaniem mapy level"+levelIndex + ".txt :" + e.getMessage());
			this.loadFile(levelIndex-1);
		}
	}
}
