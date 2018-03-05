package com.greenStudios.worlds;

import java.awt.Graphics;
import java.io.Serializable;

import com.greenStudios.entities.EntityManager;
import com.greenStudios.entities.Player;
import com.greenStudios.entities.statics.BrokenHouse;
import com.greenStudios.entities.statics.Field;
import com.greenStudios.entities.statics.House;
import com.greenStudios.entities.statics.House_Jonah1;
import com.greenStudios.entities.statics.Trigger;
import com.greenStudios.main.Handler;

public class WorldShop extends World implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1184194931823702713L;

	public WorldShop(Handler handler, String path, Player player) {
		super(handler, path, player);
		this.worldName = "shop";
		this.handler = handler;
		
		entityManager.addEntity(new Trigger(handler, 15 * 64, 16 * 64 - 5, 40, 20));
	}
	
	
}
