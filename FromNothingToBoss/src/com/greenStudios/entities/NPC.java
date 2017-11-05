package com.greenStudios.entities;

import java.awt.Graphics;

import com.greenStudios.main.Handler;

public class NPC extends Creature{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7227758707501494857L;

	public NPC(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
