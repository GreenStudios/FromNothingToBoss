package com.greenStudios.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.greenStudios.entities.Entity;
import com.greenStudios.items.Item;
import com.greenStudios.main.Handler;

public class Save {

	private PrintWriter pWriter;

	public Save(Handler handler) {
		try {
			pWriter = new PrintWriter(new BufferedWriter(new FileWriter("assets/save/save.txt")));
			ArrayList<Entity> entities = handler.getWorld().getEntityManager().getEntities();
			for (Entity e : entities) {
				pWriter.println(e);
			}
			ArrayList<Item> items = handler.getWorld().getItemManager().getItems();
			for(Item i : items){
				pWriter.println(i);
			}
			

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (pWriter != null) {
				pWriter.flush();
				pWriter.close();
			}
		}
	}
}
