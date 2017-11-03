package com.greenStudios.main.states;

import java.awt.Graphics;

import com.greenStudios.audio.AudioPlayer;
import com.greenStudios.entities.World;
import com.greenStudios.main.Handler;

public class GameState extends State {

	private World world;
	
	private AudioPlayer ambient;

	public GameState(Handler handler) {
		super(handler);
		
		world = new World(handler, "assets/worlds/world_test.csv");
		handler.setWorld(world);
		
		ambient = new AudioPlayer("/music/bgm_ambient.wav");
		ambient.play();
	}

	@Override
	public void tick() {
		world.tick();
		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

	@Override
	public void setButtons() {
		
	}

}
