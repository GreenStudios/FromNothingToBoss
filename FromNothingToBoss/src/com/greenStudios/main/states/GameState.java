package com.greenStudios.main.states;

import java.awt.Graphics;

import com.greenStudios.java2d.Assets;
import com.greenStudios.main.Game;
import com.greenStudios.world.Player;

public class GameState extends State {

	private Player player;

	public GameState(Game game) {
		super(game);

		player = new Player(game, 100, 100);
	}

	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}

}
