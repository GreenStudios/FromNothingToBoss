package com.greenStudios.world;

import java.awt.Graphics;

import com.greenStudios.java2d.ImageLoader;
import com.greenStudios.main.Handler;
public class Player extends Creature {

	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEAFUALT_CREATURE_HEIGHT);
		movementSpeed = Creature.DEFAULT_SPEED;
	}

	@Override
	public void tick() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
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
		g.drawImage(ImageLoader.loadImage("/textures/player/playerFront.png"), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), null);
	}

}
