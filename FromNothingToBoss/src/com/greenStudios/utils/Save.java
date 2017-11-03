package com.greenStudios.utils;

public class Save {

	public Save(){
		FileReader fr = new FileReader("save.txt");
	    BufferedReader br = new BufferedReader(fr);
	    
	    String zeile1 = br.readLine();
	    preis1=Integer.parseInt(zeile1);
	   
	    br.close();
	}
}
