package com.greenStudios.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import com.greenStudios.java2d.Assets;
import com.greenStudios.main.Handler;
import com.greenStudios.main.tiles.Tile;

public class House_Jonah1 extends StaticEntity{

	private boolean drawCollision = false;

	public House_Jonah1(Handler handler, float x, float y) {
		super(handler, x, y, 3*Tile.TILEWIDTH, 3*Tile.TILEHEIGHT);
		
		bounds.x = 6;
		bounds.y = 2*64;
		bounds.width = 180;
		bounds.height = 48;
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
		g.drawImage(Assets.house_jonah1,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		if(drawCollision) {
			g.setColor(Color.red);
			g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		}
	}
}

