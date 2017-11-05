package com.greenStudios.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import com.greenStudios.entities.World;
import com.greenStudios.entities.Entity.Type;
import com.greenStudios.java2d.Assets;
import com.greenStudios.main.Handler;
import com.greenStudios.main.tiles.Tile;

public class House extends StaticEntity{
	
	private boolean drawCollision = true;

	public House(Handler handler, float x, float y) {
		super(handler, x, y, 5*Tile.TILEWIDTH/2, 5*Tile.TILEHEIGHT/2);
		
		bounds.x = 18;
		bounds.y = 20;
		bounds.width = 128;
		bounds.height = 128;
		
		trigger.x = 35;
		trigger.y = 140;
		trigger.width = 40;
		trigger.height = 20;
		
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
		g.drawImage(Assets.house,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		if(drawCollision) {
			g.setColor(Color.red);
			g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
			
			g.setColor(Color.blue);
			g.fillRect((int) (x + trigger.x - handler.getGameCamera().getxOffset()), (int) (y + trigger.y - handler.getGameCamera().getyOffset()), trigger.width, trigger.height);
		}
	}
	
	@Override
	public Type getType(){
		return Type.House;
	}
	
	public void onTrigger() {
		handler.getWorldManager().setWorld("shop");
	}

}
