package com.greenStudios.utils;

import java.io.BufferedReader;
import java.io.FileReader;

import com.greenStudios.main.Handler;

public class Save {

	public Save(Handler handler){
		FileReader fr = new FileReader("save.txt");
	    BufferedReader br = new BufferedReader(fr);
	    
	    String zeile1 = br.readLine();
	    preis1=Integer.parseInt(zeile1);
	   
	    br.close();
	}
}
