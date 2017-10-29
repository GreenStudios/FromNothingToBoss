package com.greenStudios.java2d;

import com.greenStudios.main.Game;
import com.greenStudios.world.Entity;

public class GameCamera {
	
	private Game game;
	private float xOffset, yOffset;
	
	public GameCamera(Game game, float xOffset, float yOffset) {
		this.game = game;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void centerOnEntity(Entity player) {
		xOffset = player.getX() - game.getWidth() / 2 + player.getWidth() / 2;
		yOffset = player.getY() - game.getHeight() / 2+ player.getHeight() / 2;
	}
	
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
