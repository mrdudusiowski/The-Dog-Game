package com.platform.core.game.model;

import com.platform.core.DisplayManager;
import com.platform.core.game.StateManager;
import com.platform.core.utils.FontHelper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class MenuState extends State {

    private String[] optionsMenu;
    private int selected;

    public MenuState(StateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        this.optionsMenu = new String[]{"GRAJ", "WYJDZ"};
        this.selected = 0;
        this.initializeAssets("/textures/background/background-menu.png", "/music/menu-theme.wav", FONT_LOCALISATION);
        this.playBackgroundMusic();
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics graphics) {
        try {
            BufferedImage img = ImageIO.read(getClass().getResource("/textures/background/background-menu.png"));
            graphics.drawImage(img, 0, -10, null);
        } catch (IOException e) {
            System.out.println("[MENU][BACKGROUND] Nie można załadować tła gry: " + e.getMessage());
        }
        if(fontURL != null)
            customFont = FontHelper.createFont(fontURL, 50f);
        if (customFont != null) {
            graphics.setFont(customFont);
        } else {
            graphics.setFont(new Font("Arial", Font.BOLD, 42));
        }

        for (int i = 0; i < optionsMenu.length; i++) {
            if (selected == i) graphics.setColor(new Color(255, 153, 51));
            else graphics.setColor(Color.WHITE);
            graphics.drawString(optionsMenu[i], DisplayManager.WIDTH / 2 - 300, 150 + i * 60);
        }
    }

    @Override
    public void keyPressed(int key) {
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            if (selected > 0) selected--;
        }
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
        } else if (key == KeyEvent.VK_ENTER || key == KeyEvent.VK_E) {
            if (selected == 0) {
                this.playBackgroundMusic();
                gsm.addState(new LevelState(gsm));
            } else if (selected == 1) {
                System.exit(0);
            }
        }
    }

    @Override
    public void keyReleased(int key) {
    }

}
