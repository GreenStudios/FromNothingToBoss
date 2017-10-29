package com.greenStudios.world;

import java.awt.Graphics;

import com.greenStudios.java2d.ImageLoader;
import com.greenStudios.main.Game;
public class Player extends Creature {

	private Game game;
	
	public Player(Game game, float x, float y) {
		super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEAFUALT_CREATURE_HEIGHT);
		this.game = game;
		movementSpeed = Creature.DEFAULT_SPEED;
	}

	@Override
	public void tick() {
		getInput();
		move();
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
		g.drawImage(ImageLoader.loadImage("/textures/playerRunning.png"), (int) x, (int) y, width, height, null);
	}

}
