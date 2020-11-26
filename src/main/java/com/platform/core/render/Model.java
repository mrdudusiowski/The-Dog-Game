package com.platform.core.render;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Model extends Rectangle {

	private static final long serialVersionUID = 1L;
	
	private BufferedImage texture;

	public Model(int width, int height, String fileName) {
		super(width, height);
		if(fileName != null) {
			try {
				URL modelURL = this.getClass().getResource("/textures/"+fileName+".png");
				this.texture = ImageIO.read(modelURL);
			} catch (Exception e) {
				System.err.println("[MODEL] Problem podczas ładowania modelu: "+fileName);
				texture = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
			}
		}
	}
	
	private Model(int w, int h, BufferedImage texture) {
		super(w, h);
		this.texture = texture;
	}
	
	public BufferedImage getTexture() {
		return texture;
	}
	
	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}
	
	public Model flipTexture() {
		int h = texture.getHeight();
		int w = texture.getWidth();
		BufferedImage rotated = new BufferedImage(h, w, texture.getType());
		
		for(int x=0;x<w;x++) {
			for(int y=0;y<h;y++) {
				rotated.setRGB(x, y, texture.getRGB(w-1-x, y));
			}
		}
		return new Model(this.width, this.height, rotated);
	}
}
