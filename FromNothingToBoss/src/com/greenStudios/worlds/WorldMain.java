package com.greenStudios.worlds;

import java.awt.Graphics;

import com.greenStudios.entities.EntityManager;
import com.greenStudios.entities.statics.BrokenHouse;
import com.greenStudios.entities.statics.Field;
import com.greenStudios.entities.statics.House;
import com.greenStudios.entities.statics.House_Jonah1;
import com.greenStudios.main.Handler;

public class WorldMain extends World{
	
	private EntityManager entityManager;
	private Handler handler;
	
	public WorldMain(Handler handler) {
		super(handler, "/worlds/world_test.csv");
		
		this.handler = handler;
		
		entityManager.addEntity(new House(handler, 8 * 64, 155));
		// entityManager.addEntity(new WeedPlant(handler, 7*64, 4*64));
		// entityManager.addEntity(new Shed(handler, 14*64, 3*64));
		entityManager.addEntity(new Field(handler, 11 * 64, 11 * 64));
		entityManager.addEntity(new House_Jonah1(handler, 2 * 64, 2 * 64));
		entityManager.addEntity(new BrokenHouse(handler, 18 * 64, 2 * 64));

		entityManager.getPlayer().setX(spawnX); // Loads spawnX from world1
		entityManager.getPlayer().setY(spawnY); // Loads spawnY from world1
	}
	
	public void tick() {
		//handler.getWorldManager().tick();
		//handler.getWorld().tick();
		//entityManager.tick();
	}
	
	public void render(Graphics g) {
		//handler.getWorldManager().tick();
		//handler.getWorld().render(g);
		//entityManager.render(g);
	}
}
