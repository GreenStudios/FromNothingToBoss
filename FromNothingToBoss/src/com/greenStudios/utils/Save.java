package com.greenStudios.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.greenStudios.main.Handler;

public class Save {
	
	private PrintWriter pWriter;
	
	public Save(Handler handler) {
		try {
			pWriter = new PrintWriter(new BufferedWriter(new FileWriter("/save/save.txt")));
			pWriter.println(handler.getWorld().getEntityManager().getEntities());
			pWriter.println(handler.getWorld().getItemManager().getItems());
			

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
