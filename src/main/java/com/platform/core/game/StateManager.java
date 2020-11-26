package com.platform.core.game;

import com.platform.core.game.model.MenuState;
import com.platform.core.game.model.State;

import java.awt.*;
import java.util.Stack;

public class StateManager {

	private Stack<State> states;

	public StateManager() {
		this.states = new Stack<State>();
		this.states.add(new MenuState(this));
	}
	
	public void addState(State state) {
		this.states.add(state);
	}
	
	public void clearStack() {
		this.states.clear();
	}
	
	public State getActiveState() {
		return this.states.peek();
	}

	public void tick() {
		this.states.peek().tick();
	}

	public void render(Graphics graphics) {
		this.states.peek().render(graphics);
	}

	public void keyPressed(int key) {
		this.states.peek().keyPressed(key);
	}

	public void keyReleased(int key) {
		this.states.peek().keyReleased(key);
	}
}
