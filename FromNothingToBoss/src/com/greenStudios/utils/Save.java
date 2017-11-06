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

import com.greenStudios.entities.Entity.Type;
import com.greenStudios.main.Handler;

public class Save {

	private int count = 0;

	public Save(Handler handler) throws IOException {
		OutputStream file = null;

		try {
			file = new FileOutputStream("assets/save/save.ser");
			@SuppressWarnings("resource")
			ObjectOutputStream o = new ObjectOutputStream(file);

			for (int i = 0; i < handler.getWorld().getEntityManager().getEntities().size(); i++) {
				if (handler.getWorld().getEntityManager().getEntities().get(i).getType() != Type.Player) {
					o.writeObject(handler.getWorld().getEntityManager().getEntities().get(i));
					count++;
				}

			}
			for (int i = 0; i < handler.getWorld().getItemManager().getItems().size(); i++) {
				o.writeObject(handler.getWorld().getItemManager().getItems().get(i));
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				file.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		PrintWriter pWriter = null;
		try {
			pWriter = new PrintWriter(new BufferedWriter(new FileWriter("assets/save/save.txt")));
			pWriter.println(count);
			
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
