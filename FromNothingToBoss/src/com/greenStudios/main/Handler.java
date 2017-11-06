package com.greenStudios.main;

import com.greenStudios.java2d.Display;
import com.greenStudios.java2d.GameCamera;
import com.greenStudios.listeners.KeyManager;
import com.greenStudios.listeners.MouseManager;
import com.greenStudios.worlds.World;
import com.greenStudios.worlds.WorldManager;

public class Handler {
	
	private Game game;
	private World world;
	private WorldManager worldManager;
	
	public WorldManager getWorldManager() {
		return worldManager;
	}

	public void setWorldManager(WorldManager worldManager) {
		this.worldManager = worldManager;
	}

	public Handler(Game game) {
		this.game = game;
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public KeyManager getKeyListener() {
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager(){
		return game.getMouseManager();
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	public Display getDisplay(){
		return game.getDisplay();
	}

}
