package com.greenStudios.world;

import com.greenStudios.main.Handler;

public abstract class Creature extends Entity{

	public static final int DEFAULT_HEALTH = 100;
	public static final float DEFAULT_SPEED = 5;
	public static final int DEFAULT_CREATURE_WIDTH = 64, DEAFUALT_CREATURE_HEIGHT = 64;
	
	protected int health;
	protected float movementSpeed;
	protected float xMove, yMove;
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		movementSpeed = DEFAULT_SPEED;
	}

	public void move(){
		x += xMove;
		y += yMove;
	}
	
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getMovementSpeed() {
		return movementSpeed;
	}

	public void setMovementSpeed(float movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

}
