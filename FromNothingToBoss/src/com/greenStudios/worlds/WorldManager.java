package com.greenStudios.worlds;

import java.awt.Graphics;
import java.io.Serializable;

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

	public WorldManager(Handler handler) {
		this.handler = handler;
		wMain = new WorldMain(handler, "assets/worlds/world_test.csv");
		wShop = new World(handler, "assets/worlds/shop.csv");
		currentWorld = wMain;
		if (handler == null) {
			System.out.println("no handler1");
		}
		setWorld(currentWorld);
	}

	public void setWorld(String world) {

		if(world == "shop") {
			setCurrentWorld(wShop);
		}
	}

	public void setWorld(World w) {
		currentWorld = w;
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
	
	private void setCurrentWorld(World w) {
		currentWorld = w;
	}

	public World getwMain() {
		return wMain;
	}

	public World getwShop() {
		return wShop;
	}

}
