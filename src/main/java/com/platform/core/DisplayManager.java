package com.platform.core;

import javax.swing.*;

public class DisplayManager {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 500;
	
	public static void createDisplay() {
		JFrame window = new JFrame("The Dog Game");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(100, 50, WIDTH, HEIGHT);
		window.add(new GameScreen());
		window.setResizable(false);
		window.setVisible(true);
	}
}
