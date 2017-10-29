package com.greenStudios.world;

public abstract class Creature extends Entity{

	protected int health;
	
	public Creature(float x, float y) {
		super(x, y);
		health = 100;
	}

}
