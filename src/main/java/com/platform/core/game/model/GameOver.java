package com.platform.core.game.model;

import com.platform.core.game.StateManager;
import com.platform.core.utils.FontHelper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class GameOver extends State {

	public GameOver(StateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		this.initializeAssets("textures/background/background-gameover.png", "music/gameover-theme.wav", FONT_LOCALISATION);
		this.playBackgroundMusic();
	}

	@Override
	public void tick() {}

	@Override
	public void render(Graphics graphics) {
		try {
			//BufferedImage img = ImageIO.read(new File(backgroundURI));
			BufferedImage img = ImageIO.read(backgroundURL);
			graphics.drawImage(img, 0, -10, null);
		} catch (IOException e) {
			System.out.println("[GAMEOVER][BACKGROUND] Nie można załadować tła gry: "+e.getMessage());
		}
		graphics.setColor(Color.RED);
		if(fontURL != null)
			customFont = FontHelper.createFont(fontURL, 40f);
		if(customFont != null){
			graphics.setFont(customFont);
		} else{
			graphics.setFont(new Font("Arial", Font.BOLD, 40));
		}
		graphics.drawString("Game Over!", 200, 100);
		graphics.setColor(Color.BLACK);
		if(fontURL != null)
			customFont = FontHelper.createFont(fontURL, 30f);
		if(customFont != null){
			graphics.setFont(customFont);
		} else{
			graphics.setFont(new Font("Arial", Font.BOLD, 30));
		}
		graphics.drawString("Wcisnij enter", 200, 150);
	}

	@Override
	public void keyPressed(int key) {}

	@Override
	public void keyReleased(int key) {
		if (key == KeyEvent.VK_ENTER) {
			this.gsm.clearStack();
			this.playBackgroundMusic();
			this.gsm.addState(new MenuState(gsm));
		}
	}
}
