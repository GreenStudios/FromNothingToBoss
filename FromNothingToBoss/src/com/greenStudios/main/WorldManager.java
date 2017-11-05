package com.greenStudios.main;

import java.awt.Graphics;

import com.greenStudios.entities.World;
import com.greenStudios.main.ui.UIManager;

public class WorldManager {
	
	private World wMain, wShop;
	private UIManager uimanager;
	private Handler handler;
	private World currentWorld;
	
	public WorldManager(Handler handler) {
		this.handler = handler;
		wMain = new World(handler, "assets/worlds/world_test.csv");
		wShop = new World(handler, "assets/worlds/shop.csv");	
		currentWorld = wMain;
		handler.setWorld(currentWorld);
	}
	

	public void setWorld(String world) {
		if(world == "shop") {
			setCurrentWorld(wShop);
		}
	}
	
	public void tick() {
		currentWorld.tick();
	}
	
	public void render(Graphics g) {
		currentWorld.render(g);
	}
	
	private void setCurrentWorld(World w) {
		currentWorld = w;
		handler.setWorld(currentWorld);
	}
}
