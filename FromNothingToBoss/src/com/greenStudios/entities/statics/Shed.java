package com.greenStudios.entities.statics;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import com.greenStudios.java2d.Assets;
import com.greenStudios.main.Handler;
import com.greenStudios.main.tiles.Tile;

public class Shed extends StaticEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2543011365577134346L;
	private boolean drawCollision = true;

	public Shed(Handler handler, float x, float y) {
		super(handler, x, y, 4*Tile.TILEWIDTH, 4*Tile.TILEHEIGHT);
		
		bounds.x = 28;
		bounds.y = 80;
		bounds.width = 75;
		bounds.height = 36;
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
		g.drawImage(Assets.shed,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		if(drawCollision) {
			g.setColor(Color.red);
			g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		}
	}
	
	@Override
	public Type getType(){
		return Type.Shed;
	}
}
