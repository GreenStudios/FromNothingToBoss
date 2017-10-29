package com.greenStudios.world;

import java.awt.Graphics;

import com.greenStudios.java2d.ImageLoader;
import com.greenStudios.main.Game;
public class Player extends Creature {

	
	public Player(Game game, float x, float y) {
		super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEAFUALT_CREATURE_HEIGHT);
		movementSpeed = Creature.DEFAULT_SPEED;
	}

	@Override
	public void tick() {
		getInput();
		move();
		game.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyListener().up){
			yMove = -movementSpeed;
		}
		if(game.getKeyListener().down){
			yMove = movementSpeed;
		}
		if(game.getKeyListener().left){
			xMove = -movementSpeed;
		}
		if(game.getKeyListener().right){
			xMove = movementSpeed;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(ImageLoader.loadImage("/textures/player/playerFront.png"), (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), null);
	}

}
