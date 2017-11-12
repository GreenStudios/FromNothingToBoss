package com.greenStudios.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.greenStudios.entities.Entity;
import com.greenStudios.entities.Entity.Type;
import com.greenStudios.items.Item;
import com.greenStudios.main.Handler;

public class Save {

	private ArrayList<Entity> entities;
	private ArrayList<Item> items;
	
	public Save(Handler handler) throws IOException {
		OutputStream file = null;

		try {
			file = new FileOutputStream("assets/save/save.ser");
			@SuppressWarnings("resource")
			ObjectOutputStream o = new ObjectOutputStream(file);
			
			//entities = handler.getWorldManager().getwMain().getEntityManager().getEntities();
			//items = handler.getWorldManager().getwMain().getItemManager().getItems();
			o.writeObject(handler.getWorldManager());
			//o.writeObject(entities);
			//o.writeObject(items);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				file.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
