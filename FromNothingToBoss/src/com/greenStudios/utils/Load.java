package com.greenStudios.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import com.greenStudios.entities.Entity;
import com.greenStudios.main.Handler;

public class Load {

	public static boolean load = false;
	private int count = 0;

	public Load(Handler handler) {
		InputStream fis = null;

		FileReader fr;
		try {
			fr = new FileReader("assets/save/save.txt");
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
			ObjectInputStream o = new ObjectInputStream(fis);
			String string = (String) o.readObject();

			for (int i = 0; i < count; i++)
				handler.getWorldManager().getCurrentWorld().getEntityManager().addEntity((Entity) o.readObject());

		} catch (IOException e) {
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		} finally {
			try {
				fis.close();
				load = true;
			} catch (Exception e) {
			}
		}
	}
}
