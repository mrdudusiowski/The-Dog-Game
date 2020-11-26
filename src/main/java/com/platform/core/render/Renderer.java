package com.platform.core.render;



import com.platform.core.enums.Direction;
import com.platform.game.entity.Camera;
import com.platform.game.entity.Entity;
import com.platform.game.entity.StaticEntity;

import java.awt.*;

public class Renderer {

	public static void renderEntity(StaticEntity entity, Camera camera, Graphics graphics) {
		int posX = entity.getPosX() - camera.getPosX();
		int posY = entity.getPosY() - camera.getPosY();
		Model model = entity.getModel();

		if(entity instanceof Entity) {
			if(((Entity) entity).getFacing() == Direction.LEFT) {
				model = model.flipTexture();
			}
		}

		renderModel(model, posX, posY, graphics);
	}

	public static void renderModel(Model model, int posX, int posY, Graphics graphics) {
		graphics.drawImage(model.getTexture(), posX, posY, model.width, model.height, null);
	}
}
