package com.platform.core.game.model;

import com.platform.core.game.StateManager;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public abstract class State {

	protected StateManager gsm;
	protected Clip backgroundClip;
	protected URL backgroundURL;
	protected URL soundURL;
	protected BufferedInputStream soundIS;
	protected URL fontURL;
	protected static final String FONT_LOCALISATION = "/font/BadaboomBB.ttf";
	protected Font customFont = null;

	public State(StateManager gsm) {
		this.gsm = gsm;
		this.init();
	}
	
	public abstract void init();
	
	public abstract void tick();
	
	public abstract void render(Graphics graphics);
	
	public abstract void keyPressed(int key);
	
	public abstract void keyReleased(int key);

	protected void setBackgroundMusic(BufferedInputStream audio) {
		try{
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audio);
			this.backgroundClip = AudioSystem.getClip();
			this.backgroundClip.open(audioInputStream);
			this.backgroundClip.stop();
		} catch (Exception ex) {
			System.out.println("[STATEINITIALIZE][MUSIC] Nie można załadować muzyki tła: "+ex.getMessage());
		}
	}

	protected void initializeAssets(String background, String sound, String font){
		try {
			this.backgroundURL = this.getClass().getResource(background);
		} catch (NullPointerException e){
			System.out.println("[STATEINITIALIZE][BACKGROUND] Tło "+ background +" nie istnieje: " + e.getMessage());
		}
		try {
			this.soundIS = new BufferedInputStream(this.getClass().getResource(sound).openStream());
		} catch (NullPointerException | IOException e){
			System.out.println("[STATEINITIALIZE][BACKGROUND] Muzyka "+ sound +" nie istnieje: " + e.getMessage());
		}
		try {
			this.fontURL = this.getClass().getResource(font);
		} catch (NullPointerException e){
			System.out.println("[STATEINITIALIZE][FONT] Zasób czcionki "+ font +" nie istnieje: " + e.getMessage());
		}
		if(this.soundIS != null)
			this.setBackgroundMusic(this.soundIS);
	}

	public void playBackgroundMusic(){
		if (backgroundClip != null)
			if (!backgroundClip.isActive()){
				backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
				backgroundClip.start();
			}else{
				backgroundClip.close();
			}
	}
}
