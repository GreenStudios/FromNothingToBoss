package com.greenStudios.worlds;

import java.awt.Graphics;
import java.io.Serializable;

import com.greenStudios.entities.Player;
import com.greenStudios.main.Handler;
import com.greenStudios.main.ui.UIManager;

public class WorldManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2146615500297627159L;
	private World wMain, wShop;
	private Handler handler;
	private World currentWorld;
	private Player player;

	public WorldManager(Handler handler) {
		this.handler = handler;
		player = new Player(handler, 0, 0);
		wMain = new WorldMain(handler, "assets/worlds/mexico.csv", player);
		wShop = new WorldShop(handler, "assets/worlds/shop.csv", player);
		setWorld(wMain);
		if (handler == null) {
			System.out.println("no handler1");
		}
		setWorld(currentWorld);
	}

	
	public void tick() {
		currentWorld.tick();
	}

	public void render(Graphics g) {
		currentWorld.render(g);
	}

	public World getCurrentWorld() {
		return currentWorld;
	}
	
	public void setWorld(World w) {
		currentWorld = w;
		currentWorld.spawn();
	}

	public World getwMain() {
		return wMain;
	}

	public World getwShop() {
		return wShop;
	}
	
	public String getWorldName()
	{
		return currentWorld.worldName;
	}
	
	public Player getPlayer() {
		return player;
	}
}
