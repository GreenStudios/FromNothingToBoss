package com.greenStudios.main.states;

import java.awt.Graphics;

import com.greenStudios.java2d.Assets;
import com.greenStudios.main.Game;
import com.greenStudios.main.tiles.Tile;
import com.greenStudios.world.Player;
import com.greenStudios.world.World;

public class GameState extends State {

	private Player player;
	private World world;

	public GameState(Game game) {
		super(game);

		player = new Player(game, 100, 100);
		world = new World(game, "assets/worlds/world1.txt");
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
