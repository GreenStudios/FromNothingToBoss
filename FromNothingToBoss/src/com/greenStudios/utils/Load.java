package com.greenStudios.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.greenStudios.entities.Entity;
import com.greenStudios.entities.Entity.Type;
import com.greenStudios.entities.Player;
import com.greenStudios.entities.statics.House;
import com.greenStudios.items.Item;
import com.greenStudios.main.Handler;

public class Load {

	public static boolean load = false;
	private ArrayList<Entity> entities;
	private ArrayList<Item> items;
	@SuppressWarnings("unchecked")
	public Load(Handler handler) {
		InputStream fis = null;

		try {
			
			fis = new FileInputStream("assets/save/save.ser");
			@SuppressWarnings("resource")
			ObjectInputStream o = new ObjectInputStream(fis);

				entities = (ArrayList<Entity>) o.readObject();
				for(int i = 0; i < entities.size(); i++) {
					entities.get(i).setHandler(handler);
					if(entities.get(i).getType() == Type.Player) {
						Player p = (Player) entities.get(i);
						p.loadPlayer();
						entities.remove(i);
						entities.add(p);
					}
					if(entities.get(i).getType() == Type.Terain) {
						entities.get(i).setHandler(handler);
					}
				}
				handler.getWorldManager().getCurrentWorld().getEntityManager().setEntities(entities);
				
				items = (ArrayList<Item>) o.readObject();
				for(int i = 0; i < items.size(); i++) {
					items.get(i).setHandler(handler);
				}
				handler.getWorldManager().getCurrentWorld().getItemManager().setItems(items);
				
				
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				load = true;
				
			} catch (Exception e) {
			}
		}
	}
}
