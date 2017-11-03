package com.greenStudios.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import com.greenStudios.java2d.Assets;
import com.greenStudios.main.Handler;
import com.greenStudios.main.tiles.Tile;

public class BrokenHouse extends StaticEntity{

	private boolean drawCollision = false;

	public BrokenHouse(Handler handler, float x, float y) {
		super(handler, x, y, 5*Tile.TILEWIDTH, 3*Tile.TILEHEIGHT);
		
		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 288;
		bounds.height = 133;
		hurtable = false;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void die() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.brokenhouse,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		if(drawCollision) {
			g.setColor(Color.red);
			g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		}
	}
}

