package com.greenStudios.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.greenStudios.java2d.Animation;
import com.greenStudios.java2d.Assets;
import com.greenStudios.main.Handler;
public class Player extends Creature {
	
	//Animations
	private Animation animDown;
	private Animation animUp;
	private Animation animLeft;
	private Animation animRight;
	private int lastAnim;
	
	private boolean drawCollision = false;

	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		movementSpeed = Creature.DEFAULT_SPEED;
		
		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;
		
		//Animations
		animDown = new Animation(80, Assets.player_down);
		animUp = new Animation(80, Assets.player_up);
		animLeft = new Animation(80, Assets.player_left);
		animRight = new Animation(80, Assets.player_right);
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
	}
	
	public void die() {
		System.out.println("You died");
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyListener().up){
			yMove = -movementSpeed;
		}
		if(handler.getKeyListener().down){
			yMove = movementSpeed;
		}
		if(handler.getKeyListener().left){
			xMove = -movementSpeed;
		}
		if(handler.getKeyListener().right){
			xMove = movementSpeed;
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
}
		




