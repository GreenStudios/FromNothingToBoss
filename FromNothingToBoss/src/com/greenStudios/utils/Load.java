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
import com.greenStudios.entities.statics.House;
import com.greenStudios.main.Handler;

public class Load {

	public static boolean load = false;
	private int count = 0;
	private ArrayList<Entity> entities;
	
	@SuppressWarnings("unchecked")
	public Load(Handler handler) {
		InputStream fis = null;

		FileReader fr;
		try {
			fr = new FileReader("assets/save/save.txt");
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fr);
			String zeile1;
			zeile1 = br.readLine();
			count = Integer.parseInt(zeile1);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			fis = new FileInputStream("assets/save/save.ser");
			@SuppressWarnings("resource")
			ObjectInputStream o = new ObjectInputStream(fis);

				entities = (ArrayList<Entity>) o.readObject();
				handler.getWorldManager().getCurrentWorld().getEntityManager().setEntities(entities);

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
