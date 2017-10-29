package com.greenStudios.world;

import java.awt.Graphics;

import com.greenStudios.java2d.Assets;
import com.greenStudios.java2d.ImageLoader;
import com.greenStudios.main.Game;
public class Player extends Creature {

	private Game game;
	
	public Player(Game game, float x, float y) {
		super(x, y);
		this.game = game;
		movementSpeed = 1;
	}

	@Override
	public void tick() {
		if(game.getKeyListener().up){
			y -= movementSpeed;
		}
		if(game.getKeyListener().down){
			y += movementSpeed;
		}
		if(game.getKeyListener().left){
			x -= movementSpeed;
		}
		if(game.getKeyListener().right){
			x += movementSpeed;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(ImageLoader.loadImage("/textures/playerRunning.png"), (int) x, (int) y, null);
	}

}
