package com.greenStudios.worlds;

import java.awt.Graphics;
import java.io.Serializable;

import com.greenStudios.entities.EntityManager;
import com.greenStudios.entities.statics.BrokenHouse;
import com.greenStudios.entities.statics.Field;
import com.greenStudios.entities.statics.House;
import com.greenStudios.entities.statics.House_Jonah1;
import com.greenStudios.main.Handler;
import com.greenStudios.utils.Load;

public class WorldMain extends World  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8478270020939504923L;

	public WorldMain(Handler handler, String path) {
		super(handler, path);

		this.handler = handler;
		//if (!Load.load) {
			entityManager.addEntity(new House(handler, 8 * 64, 155));
			// entityManager.addEntity(new WeedPlant(handler, 7*64, 4*64));
			// entityManager.addEntity(new Shed(handler, 14*64, 3*64));
			entityManager.addEntity(new Field(handler, 11 * 64, 11 * 64));
			entityManager.addEntity(new House_Jonah1(handler, 2 * 64, 2 * 64));
			entityManager.addEntity(new BrokenHouse(handler, 18 * 64, 2 * 64));
		//}

	}

}
