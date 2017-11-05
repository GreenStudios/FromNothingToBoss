package com.greenStudios.utils;

import java.io.BufferedReader;
import java.io.FileReader;

public class Load {
	
	public Load(){
		FileReader fr = new FileReader("save.txt");
	    BufferedReader br = new BufferedReader(fr);
	    
	    String zeile1 = br.readLine();
	    preis1=Integer.parseInt(zeile1);
	}
}
