package com.platform.core.render;

import java.util.HashMap;

public class ModelManager {
	private static final HashMap<String, Model> models = new HashMap<>();
	//Player - model
	public static final String PLAYER = "character/idle/Idle (1)";
	//Player walk
	public static final String PLAYER_WALK_1 = "character/walk/Walk (1)";
	public static final String PLAYER_WALK_2 = "character/walk/Walk (2)";
	public static final String PLAYER_WALK_3 = "character/walk/Walk (3)";
	public static final String PLAYER_WALK_4 = "character/walk/Walk (4)";
	public static final String PLAYER_WALK_5 = "character/walk/Walk (5)";
	public static final String PLAYER_WALK_6 = "character/walk/Walk (6)";
	public static final String PLAYER_WALK_7 = "character/walk/Walk (7)";
	public static final String PLAYER_WALK_8 = "character/walk/Walk (8)";
	public static final String PLAYER_WALK_9 = "character/walk/Walk (9)";
	public static final String PLAYER_WALK_10 = "character/walk/Walk (10)";
	//Player run
	public static final String PLAYER_RUN_1 = "character/run/Run (1)";
	public static final String PLAYER_RUN_2 = "character/run/Run (2)";
	public static final String PLAYER_RUN_3 = "character/run/Run (3)";
	public static final String PLAYER_RUN_4 = "character/run/Run (4)";
	public static final String PLAYER_RUN_5 = "character/run/Run (5)";
	public static final String PLAYER_RUN_6 = "character/run/Run (6)";
	public static final String PLAYER_RUN_7 = "character/run/Run (7)";
	public static final String PLAYER_RUN_8 = "character/run/Run (8)";
	//Player jump
	public static final String PLAYER_JUMP_1 = "character/jump/Jump (1)";
	public static final String PLAYER_JUMP_2 = "character/jump/Jump (2)";
	public static final String PLAYER_JUMP_3 = "character/jump/Jump (3)";
	public static final String PLAYER_JUMP_4 = "character/jump/Jump (4)";
	public static final String PLAYER_JUMP_5 = "character/jump/Jump (5)";
	public static final String PLAYER_JUMP_6 = "character/jump/Jump (6)";
	public static final String PLAYER_JUMP_7 = "character/jump/Jump (7)";
	public static final String PLAYER_JUMP_8 = "character/jump/Jump (8)";
	//Player death
	public static final String PLAYER_DEATH_1 = "character/dead/Dead (1)";
	public static final String PLAYER_DEATH_2 = "character/dead/Dead (2)";
	public static final String PLAYER_DEATH_3 = "character/dead/Dead (3)";
	public static final String PLAYER_DEATH_4 = "character/dead/Dead (4)";
	public static final String PLAYER_DEATH_5 = "character/dead/Dead (5)";
	public static final String PLAYER_DEATH_6 = "character/dead/Dead (6)";
	public static final String PLAYER_DEATH_7 = "character/dead/Dead (7)";
	public static final String PLAYER_DEATH_8 = "character/dead/Dead (8)";
	public static final String PLAYER_DEATH_9 = "character/dead/Dead (9)";
	public static final String PLAYER_DEATH_10 = "character/dead/Dead (10)";
	//Player fall
	public static final String PLAYER_FALL_1 = "character/fall/Fall (1)";
	public static final String PLAYER_FALL_2 = "character/fall/Fall (2)";
	public static final String PLAYER_FALL_3 = "character/fall/Fall (3)";
	public static final String PLAYER_FALL_4 = "character/fall/Fall (4)";
	public static final String PLAYER_FALL_5 = "character/fall/Fall (5)";
	public static final String PLAYER_FALL_6 = "character/fall/Fall (6)";
	public static final String PLAYER_FALL_7 = "character/fall/Fall (7)";
	public static final String PLAYER_FALL_8 = "character/fall/Fall (8)";
	//Player life
	public static final String LIFE = "character/life";
	//Enemy turtle
	public static final String TURTLE_1 = "enemies/turtle/Turtle (1)";
	public static final String TURTLE_2 = "enemies/turtle/Turtle (2)";
	//Enemy wasp
	public static final String WASP = "enemies/wasp/Wasp (1)";
	//Enemy poop
	public static final String POO = "enemies/poo/Poo (1)";
	//Blocks
	public static final String START = "blocks/gameStart";
	public static final String FINISH = "blocks/gameFinish";
	public static final String BLOCK = "blocks/grassCenter";
	public static final String BLOCK_OF_MUD = "blocks/mudd";
	public static final String BLOCK_OF_MUD_BONE = "blocks/muddBone";
	public static final String BLOCK_OF_MUD_SKELETON = "blocks/muddSkeleton";
	public static final String BLOCK_ROUNDED = "blocks/blockRounded";
	public static final String BLOCK_GRASS_BONE = "blocks/grassBone";
	public static final String BLOCK_LEFT_ROUND = "blocks/grassLeftRound";
	public static final String BLOCK_RIGHT_ROUND = "blocks/grassRightRound";
	public static final String PLATFORM_CENTER = "blocks/platformCenter";
	public static final String PLATFORM_LEFT = "blocks/platformLeft";
	public static final String PLATFORM_RIGHT = "blocks/platformRight";
	public static final String PLATFORM_MINI = "blocks/platformMini";

	public static final String CLOUD = "blocks/cloud";
	public static final String FLOWER_1 = "blocks/redflower";
	public static final String FLOWER_2 = "blocks/yellowflower";
	public static final String PIPE_GRASS = "blocks/pipegrass";


	//Blocks - spikes
	public static final String SPIKES_UP = "blocks/spikes_up";
	public static final String SPIKES_LEFT = "blocks/spikes_left";
	public static final String SPIKES_DOWN = "blocks/spikes_down";
	public static final String SPIKES_RIGHT = "blocks/spikes_right";
	//Frutis
	public static final String APPLE = "fruits/Apple";
	public static final String BANANA = "fruits/Banana";
	public static final String CHERRY = "fruits/Cherry";
	public static final String KIWI = "fruits/Kiwi";
	public static final String MELON = "fruits/Melon";
	public static final String ORANGE = "fruits/Orange";
	public static final String PINEAPPLE = "fruits/Pineapple";
	public static final String STRAWBERRY = "fruits/Strawberry";
	public static final String BISCOUT = "fruits/Biscout";

	public static void init() {
		models.put(PLAYER, new Model(64, 64, PLAYER));
		//Set player - walk
		models.put(PLAYER_WALK_1, new Model(64, 64, PLAYER_WALK_1));
		models.put(PLAYER_WALK_2, new Model(64, 64, PLAYER_WALK_2));
		models.put(PLAYER_WALK_3, new Model(64, 64, PLAYER_WALK_3));
		models.put(PLAYER_WALK_4, new Model(64, 64, PLAYER_WALK_4));
		models.put(PLAYER_WALK_5, new Model(64, 64, PLAYER_WALK_5));
		models.put(PLAYER_WALK_6, new Model(64, 64, PLAYER_WALK_6));
		models.put(PLAYER_WALK_7, new Model(64, 64, PLAYER_WALK_7));
		models.put(PLAYER_WALK_8, new Model(64, 64, PLAYER_WALK_8));
		models.put(PLAYER_WALK_9, new Model(64, 64, PLAYER_WALK_9));
		models.put(PLAYER_WALK_10, new Model(64, 64, PLAYER_WALK_10));
		//Set player - run
		models.put(PLAYER_RUN_1, new Model(64, 64, PLAYER_RUN_1));
		models.put(PLAYER_RUN_2, new Model(64, 64, PLAYER_RUN_2));
		models.put(PLAYER_RUN_3, new Model(64, 64, PLAYER_RUN_3));
		models.put(PLAYER_RUN_4, new Model(64, 64, PLAYER_RUN_4));
		models.put(PLAYER_RUN_5, new Model(64, 64, PLAYER_RUN_5));
		models.put(PLAYER_RUN_6, new Model(64, 64, PLAYER_RUN_6));
		models.put(PLAYER_RUN_7, new Model(64, 64, PLAYER_RUN_7));
		models.put(PLAYER_RUN_8, new Model(64, 64, PLAYER_RUN_8));
		//Set player - jump
		models.put(PLAYER_JUMP_1, new Model(64, 64, PLAYER_JUMP_1));
		models.put(PLAYER_JUMP_2, new Model(64, 64, PLAYER_JUMP_2));
		models.put(PLAYER_JUMP_3, new Model(64, 64, PLAYER_JUMP_3));
		models.put(PLAYER_JUMP_4, new Model(64, 64, PLAYER_JUMP_4));
		models.put(PLAYER_JUMP_5, new Model(64, 64, PLAYER_JUMP_5));
		models.put(PLAYER_JUMP_6, new Model(64, 64, PLAYER_JUMP_6));
		models.put(PLAYER_JUMP_7, new Model(64, 64, PLAYER_JUMP_7));
		models.put(PLAYER_JUMP_8, new Model(64, 64, PLAYER_JUMP_8));
		//Set player - death
		models.put(PLAYER_DEATH_1, new Model(64, 64, PLAYER_DEATH_1));
		models.put(PLAYER_DEATH_2, new Model(64, 64, PLAYER_DEATH_2));
		models.put(PLAYER_DEATH_3, new Model(64, 64, PLAYER_DEATH_3));
		models.put(PLAYER_DEATH_4, new Model(64, 64, PLAYER_DEATH_4));
		models.put(PLAYER_DEATH_5, new Model(64, 64, PLAYER_DEATH_5));
		models.put(PLAYER_DEATH_6, new Model(64, 64, PLAYER_DEATH_6));
		models.put(PLAYER_DEATH_7, new Model(64, 64, PLAYER_DEATH_7));
		models.put(PLAYER_DEATH_8, new Model(64, 64, PLAYER_DEATH_8));
		models.put(PLAYER_DEATH_9, new Model(64, 64, PLAYER_DEATH_9));
		models.put(PLAYER_DEATH_10, new Model(64, 64, PLAYER_DEATH_10));
		//Set player - fall
		models.put(PLAYER_FALL_1, new Model(64, 64, PLAYER_FALL_1));
		models.put(PLAYER_FALL_2, new Model(64, 64, PLAYER_FALL_2));
		models.put(PLAYER_FALL_3, new Model(64, 64, PLAYER_FALL_3));
		models.put(PLAYER_FALL_4, new Model(64, 64, PLAYER_FALL_4));
		models.put(PLAYER_FALL_5, new Model(64, 64, PLAYER_FALL_5));
		models.put(PLAYER_FALL_6, new Model(64, 64, PLAYER_FALL_6));
		models.put(PLAYER_FALL_7, new Model(64, 64, PLAYER_FALL_7));
		models.put(PLAYER_FALL_8, new Model(64, 64, PLAYER_FALL_8));
		//Set player - life
		models.put(LIFE, new Model(50, 50, LIFE));
		//Set enemies
		models.put(TURTLE_1, new Model(32, 32, TURTLE_1));
		models.put(TURTLE_2, new Model(32, 32, TURTLE_2));
		models.put(WASP, new Model(32, 32, WASP));
		models.put(POO, new Model(32, 32, POO));
		//Set blocks
		models.put(START, new Model(60, 60, START));
		models.put(FINISH, new Model(60, 60, FINISH));
		models.put(BLOCK, new Model(40, 40, BLOCK));
		models.put(BLOCK_OF_MUD, new Model(40, 40, BLOCK_OF_MUD));
		models.put(BLOCK_OF_MUD_BONE, new Model(40, 40, BLOCK_OF_MUD_BONE));
		models.put(BLOCK_OF_MUD_SKELETON, new Model(40, 40, BLOCK_OF_MUD_SKELETON));
		models.put(BLOCK_ROUNDED, new Model(40, 40, BLOCK_ROUNDED));
		models.put(BLOCK_GRASS_BONE, new Model(40, 40, BLOCK_GRASS_BONE));
		models.put(BLOCK_LEFT_ROUND, new Model(40, 40, BLOCK_LEFT_ROUND));
		models.put(BLOCK_RIGHT_ROUND, new Model(40, 40, BLOCK_RIGHT_ROUND));

		models.put(PLATFORM_CENTER, new Model(40, 40, PLATFORM_CENTER));
		models.put(PLATFORM_LEFT, new Model(40, 40, PLATFORM_LEFT));
		models.put(PLATFORM_RIGHT, new Model(40, 40, PLATFORM_RIGHT));
		models.put(PLATFORM_RIGHT, new Model(40, 40, PLATFORM_RIGHT));
		models.put(PLATFORM_MINI, new Model(40, 40, PLATFORM_MINI));

		models.put(CLOUD, new Model(60, 60, CLOUD));
		models.put(FLOWER_1, new Model(60, 60, FLOWER_1));
		models.put(FLOWER_2, new Model(60, 60, FLOWER_2));
		models.put(PIPE_GRASS, new Model(60, 60, PIPE_GRASS));

		//Set blocks - spikes
		models.put(SPIKES_UP, new Model(40, 40, SPIKES_UP));
		models.put(SPIKES_LEFT, new Model(40, 40, SPIKES_LEFT));
		models.put(SPIKES_DOWN, new Model(40, 40, SPIKES_DOWN));
		models.put(SPIKES_RIGHT, new Model(40, 40, SPIKES_RIGHT));
		//Fruits
		models.put(APPLE, new Model(32, 32, APPLE));
		models.put(BANANA, new Model(32, 32, BANANA));
		models.put(CHERRY, new Model(32, 32, CHERRY));
		models.put(KIWI, new Model(32, 32, KIWI));
		models.put(MELON, new Model(32, 32, MELON));
		models.put(ORANGE, new Model(32, 32, ORANGE));
		models.put(PINEAPPLE, new Model(32, 32, PINEAPPLE));
		models.put(STRAWBERRY, new Model(32, 32, STRAWBERRY));
		models.put(BISCOUT, new Model(32, 32, BISCOUT));
	}
	
	public static Model model(String key) {
		return models.get(key);
	}
}
