package com.greenStudios.world;

public abstract class Creature extends Entity{

	protected int health;
	protected int movementSpeed;
	
	public Creature(float x, float y) {
		super(x, y);
		health = 100;
	}

}
