package com.greenStudios.main.states;

import java.awt.Graphics;

import com.greenStudios.entitys.Player;
import com.greenStudios.entitys.World;
import com.greenStudios.main.Handler;

public class GameState extends State {

	private Player player;
	private World world;

	public GameState(Handler handler) {
		super(handler);

		world = new World(handler, "assets/worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, 100, 100);
	}

	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		//Tile.tiles[0].render();
		world.render(g);
		player.render(g);
	}

}
