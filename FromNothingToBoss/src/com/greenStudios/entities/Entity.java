package com.greenStudios.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;

import com.greenStudios.main.Handler;


public abstract class Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6634115768774495958L;
	public static final int DEFAULT_HEALTH = 100;
	public static final int DEFAULT_ARMOR = 0;
	protected transient Handler handler;
	protected float x, y;
	protected int width, height;
	protected int health, armor;
	protected boolean hurtable = true;
	protected boolean active = true;
	protected Rectangle bounds;
	protected Rectangle trigger;
	protected boolean collision = true;
	protected boolean triggerActive = true;

	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		health = DEFAULT_HEALTH;
		armor = DEFAULT_ARMOR;
		
		bounds = new Rectangle(0, 0, width, height);
		trigger = new Rectangle(0, 0, width, height);
	}

	public enum Type {
		Player, Terain, House, WeedPlant, Shed
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public abstract void die();

	public abstract Type getType();

	public void hurt(int amt) {
		if (hurtable) {
			health -= amt;
		}

		if (health <= 0) {
			active = false;
			die();
		}
	}

	public boolean checkTerainCollisions(float xOffset, float yOffset) {
		for (Entity e : handler.getWorldManager().getCurrentWorld().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
				if (e.getType() == Type.Terain) {
					handler.getWorldManager().getCurrentWorld().setLastTerainCol(e);
					return true;
				}

			}
		}
		return false;
	}

	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for (Entity e : handler.getWorldManager().getCurrentWorld().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
				if (e.getCollision()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkTriggerCollisions(float xOffset, float yOffset) {
		for (Entity e : handler.getWorldManager().getCurrentWorld().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0f, 0f).intersects(getTriggerBounds(xOffset, yOffset))) {
				if (e.getTrigger()) {
					return true;
				}
			}
		}
		return false;
	}
	

	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width,
				bounds.height);
	}
	
	public Rectangle getTriggerBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (x + trigger.x + xOffset), (int) (y + trigger.y + yOffset), trigger.width,
				trigger.height);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean getCollision(){
		return collision;
	}

	public boolean getTrigger() {
		return triggerActive;
	}

}
