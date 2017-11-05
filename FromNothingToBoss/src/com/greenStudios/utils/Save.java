package com.greenStudios.utils;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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
				o.writeObject(handler.getWorld().getEntityManager().getEntities().get(i));
				System.out.println(handler.getWorld().getEntityManager().getEntities().get(i) + "saved");
			}
			for (int i = 0; i < handler.getWorld().getItemManager().getItems().size(); i++) {
				o.writeObject(handler.getWorld().getItemManager().getItems().get(i));
				System.out.println(handler.getWorld().getItemManager().getItems().get(i) + "saved");
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
