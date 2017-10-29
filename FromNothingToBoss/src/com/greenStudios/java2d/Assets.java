package com.greenStudios.java2d;

import java.awt.image.BufferedImage;

public class Assets {
	public static final int width = 49, height = 49;
	public static BufferedImage grass1, grass2;
	
	public static void init(){
		SpriteSheet sheetBackground = new SpriteSheet(ImageLoader.loadImage("/textures/sheetBackground.png"));
		
		grass1 = sheetBackground.crop(0, 0, width, height);
		grass2 = sheetBackground.crop(width, 0, width, height);
	}
}
