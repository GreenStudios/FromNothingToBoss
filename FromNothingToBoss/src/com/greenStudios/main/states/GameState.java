package com.greenStudios.main.states;

import java.awt.Graphics;

import com.greenStudios.entities.Player;
import com.greenStudios.entities.World;
import com.greenStudios.entities.statics.House;
import com.greenStudios.main.Handler;

public class GameState extends State {

	private World world;

	public GameState(Handler handler) {
		super(handler);

		world = new World(handler, "assets/worlds/world1.txt");
		handler.setWorld(world);
	}

	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
