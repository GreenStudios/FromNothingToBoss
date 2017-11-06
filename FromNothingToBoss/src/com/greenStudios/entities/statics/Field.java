package com.greenStudios.entities.statics;

import java.awt.Graphics;
import java.io.Serializable;

import com.greenStudios.java2d.Assets;
import com.greenStudios.main.Handler;
import com.greenStudios.main.tiles.Tile;

public class Field extends StaticEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2070303006411044984L;
	private boolean planted = false;
	private WeedPlant myPlant;
	
	public Field(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		hurtable = false;
		collision = false;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.field,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {

	}
	
	@Override
	public Type getType(){
		return Type.Terain;
	}
	public void setPlanted(boolean planted){
		this.planted = planted;
	}
	
	public boolean getPlanted(){
		return planted;
	}
	public void setPlant(WeedPlant plant){
		myPlant = plant;
	}
	public WeedPlant getPlant(){
		return myPlant;
	}

}
