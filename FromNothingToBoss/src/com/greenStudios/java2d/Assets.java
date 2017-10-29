package com.greenStudios.java2d;

import java.awt.image.BufferedImage;

public class Assets {
	public static final int width = 64, height = 64;
	public static BufferedImage grass1, grass2, grass3, grass4, grass5;
	
	public static void init(){
		SpriteSheet sheetGrass = new SpriteSheet(ImageLoader.loadImage("/textures/sheets/sheetGrass.png"));
		
		grass1 = sheetGrass.crop(0, 0, width, height);
		grass2 = sheetGrass.crop(width, 0, width, height);
		grass3 = sheetGrass.crop(2*width, 0, width, height);
		grass4 = sheetGrass.crop(3*width, 0, width, height);
		grass5 = sheetGrass.crop(4*width, 0, width, height);
		
	}
}
