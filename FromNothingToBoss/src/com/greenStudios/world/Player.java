package com.greenStudios.world;

import java.awt.Graphics;

import com.greenStudios.java2d.Assets;

public class Player extends Creature{

	public Player(float x, float y){
		super(x,y);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.grass1, (int)x, (int)y, null);
	}
	
}
