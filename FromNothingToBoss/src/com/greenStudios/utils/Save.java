package com.greenStudios.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.greenStudios.entities.Entity.Type;
import com.greenStudios.main.Handler;

public class Save {

	private String dateiname = "save";

	public Save(Handler handler) {
		OutputStream file = null;

		try {
			file = new FileOutputStream(dateiname + ".ser");
			@SuppressWarnings("resource")
			ObjectOutputStream o = new ObjectOutputStream(file);

			for (int i = 0; i < handler.getWorld().getEntityManager().getEntities().size(); i++) {
				if (handler.getWorld().getEntityManager().getEntities().get(i).getType() != Type.Player) {
					o.writeObject(handler.getWorld().getEntityManager().getEntities().get(i));
				}
				
			}
			for (int i = 0; i < handler.getWorld().getItemManager().getItems().size(); i++) {
				o.writeObject(handler.getWorld().getItemManager().getItems().get(i));

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
	}
}
