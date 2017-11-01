package com.greenStudios.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import com.greenStudios.items.Item;
import com.greenStudios.java2d.Assets;
import com.greenStudios.main.Handler;
import com.greenStudios.main.tiles.Tile;

public class WeedPlant extends StaticEntity{
	
	private boolean drawCollision = false;

	public WeedPlant(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, 96);
		
		bounds.x = width / 2;
		bounds.y = 70;
		bounds.width = 3;
		bounds.height = 3;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.weedItem.createNew((int) x, (int) y));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.weedPlant,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		if(drawCollision) {
			g.setColor(Color.red);
			g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		}
	}

}
