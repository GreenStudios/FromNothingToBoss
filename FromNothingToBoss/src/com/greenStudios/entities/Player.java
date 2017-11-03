package com.greenStudios.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.greenStudios.inventory.Inventory;
import com.greenStudios.java2d.Animation;
import com.greenStudios.java2d.Assets;
import com.greenStudios.main.Handler;
public class Player extends Creature {
	
	//Animations
	private Animation animDown;
	private Animation animUp;
	private Animation animLeft;
	private Animation animRight;
	
	//0 = Down, 1 = Up, 2 = Left, 3 = Right
	private int lastAnim;
	
	//Inventory
	private Inventory inventory;
	
	//Stuff

	
	
	private EntityManager entityManager;
	
	private boolean drawCollision = false;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		movementSpeed = Creature.DEFAULT_SPEED;
		
		
		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;
		
		//Animations
		animDown = new Animation(120, Assets.player_down);
		animUp = new Animation(120, Assets.player_up);
		animLeft = new Animation(120, Assets.player_left);
		animRight = new Animation(120, Assets.player_right);
		
		inventory = new Inventory(handler);
	}

	@Override
	public void tick() {
		//Animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		
		//Movement
		getInput();
		move();
		
		//Camera
		handler.getGameCamera().centerOnEntity(this);
		
		//Attack
		checkAttacks();
		
		//Inventory
		inventory.tick();
	}
	
	private void checkAttacks() {
		if(inventory.isActive()) {
			return;
		}
		
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		//Up
		if(handler.getKeyListener().attack && lastAnim == 1) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		}
		
		//Down
		else if(handler.getKeyListener().attack && lastAnim == 0) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		}
		
		//Left
		else if(handler.getKeyListener().attack && lastAnim == 2) {
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}
		
		//Right
		else if(handler.getKeyListener().attack && lastAnim == 3) {
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}
		
		//Not Attacking
		else {
			return;
		}
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this)) {
				continue;
			}
			if(e.getCollisionBounds(0, 0).intersects(ar)) {
				e.hurt(40);
				return;
			}
		}
	}
	
	public void die() {
		System.out.println("You died");
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(inventory.isActive()) {
			return;
		}
		
		if(handler.getKeyListener().moveUp){
			if(handler.getKeyListener().sprint){
				animUp.setSpeed(80);
				yMove = -movementSpeed * 2;
			}
			else {
			animUp.setSpeed(120);
			yMove = -movementSpeed;
			}
		}
		
		else if(handler.getKeyListener().moveDown){
			if(handler.getKeyListener().sprint){
				animDown.setSpeed(80);
				yMove = movementSpeed * 2;
			}else {
				animDown.setSpeed(120);	
				yMove = movementSpeed;
			}
		}
		
		else if(handler.getKeyListener().moveLeft){
				if(handler.getKeyListener().sprint){
					animLeft.setSpeed(80);
					xMove = -movementSpeed * 2;
				}
				else {
					animLeft.setSpeed(120);
					xMove = -movementSpeed;
				}
			}
				
		else if(handler.getKeyListener().moveRight){
				if(handler.getKeyListener().sprint){
					animRight.setSpeed(80);
					xMove = movementSpeed * 2;
				}
				else {
					animRight.setSpeed(120);
					xMove = movementSpeed;
				}
			}
		
		
	}
	

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), null);
		
		
		if(drawCollision) {
			g.setColor(Color.red);
			g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		}
	}
	
	public void postRender(Graphics g) {
		inventory.render(g);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0) {
			lastAnim = 2;
			return animLeft.getCurrentFrame();
		}else if(xMove > 0) {
			lastAnim = 3;
			return animRight.getCurrentFrame();
		}else if(yMove < 0) {
			lastAnim = 1;
			return animUp.getCurrentFrame();
		}else if(yMove > 0){
			lastAnim = 0;
			return animDown.getCurrentFrame();
		}else {
			return Assets.player_idle[lastAnim];
		}
		
	}
	
	public boolean onField(){
		if (checkTerainCollisions(xMove, 0f)) {
			
			return true;
		}

		if (checkTerainCollisions(0f, yMove)) {
			
			return true;
		}
		return false;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	@Override
	public Type getType(){
		return Type.Player;
	}
}
		




