package com.greenStudios.java2d;

import java.awt.image.BufferedImage;

public class Assets {
	public static final int width = 64, height = 64;
	public static BufferedImage[] btn_start;
	public static BufferedImage grass1, grass2, grass3, grass4, grass5;
	public static BufferedImage water1;
	public static BufferedImage[] player_down, player_up, player_left, player_right, player_idle;
	public static BufferedImage house;
	public static BufferedImage weedPlant;
	
	public static void init(){
		
		//Sheets
		SpriteSheet sheetGrass = new SpriteSheet(ImageLoader.loadImage("/textures/sheets/sheetGrass.png"));
		SpriteSheet sheetWater = new SpriteSheet(ImageLoader.loadImage("/textures/sheets/sheetWater.png"));
		SpriteSheet sheetPlayerAnims = new SpriteSheet(ImageLoader.loadImage("/textures/sheets/sheetPlayerAnims.png"));
		SpriteSheet sheetMenu = new SpriteSheet(ImageLoader.loadImage("/textures/sheets/sheetMenu.png"));
		
		//Menu Buttons
		btn_start = new BufferedImage[2];
		
		btn_start[0] = sheetMenu.crop(0, 0, 640, 240);
		btn_start[1] = sheetMenu.crop(0, 240, 640, 240);
		
		//Player Animations
		player_down = new BufferedImage[4];
		player_up = new BufferedImage[4];
		player_left = new BufferedImage[4];
		
		player_right = new BufferedImage[4];
		player_idle = new BufferedImage[4];
		
		player_down[0] = sheetPlayerAnims.crop(0, 2*height, width, height);
		player_down[1] = sheetPlayerAnims.crop(width, 2*height, width, height);
		player_down[2] = sheetPlayerAnims.crop(0, 2*height, width, height);
		player_down[3] = sheetPlayerAnims.crop(2*width, 2*height, width, height);
		
		player_up[0] = sheetPlayerAnims.crop(0, 0, width, height);
		player_up[1] = sheetPlayerAnims.crop(width, 0, width, height);
		player_up[2] = sheetPlayerAnims.crop(0, 0, width, height);
		player_up[3] = sheetPlayerAnims.crop(2*width, 0, width, height);
		
		player_left[0] = sheetPlayerAnims.crop(0, height, width, height);
		player_left[1] = sheetPlayerAnims.crop(width, height, width, height);
		player_left[2] = sheetPlayerAnims.crop(0, height, width, height);
		player_left[3] = sheetPlayerAnims.crop(2*width, height, width, height);
		
		player_right[0] = sheetPlayerAnims.crop(0, 3*height, width, height);
		player_right[1] = sheetPlayerAnims.crop(width, 3*height, width, height);
		player_right[2] = sheetPlayerAnims.crop(0, 3*height, width, height);
		player_right[3] = sheetPlayerAnims.crop(2*width, 3*height, width, height);
		
		player_idle[0] = sheetPlayerAnims.crop(0, 2*height, width, height);
		player_idle[1] = sheetPlayerAnims.crop(0, 0, width, height);
		player_idle[2] = sheetPlayerAnims.crop(0, height, width, height);
		player_idle[3] = sheetPlayerAnims.crop(0, 3*height, width, height);
		
		//Grass
		grass1 = sheetGrass.crop(0, 0, width, height);
		grass2 = sheetGrass.crop(width, 0, width, height);
		grass3 = sheetGrass.crop(2*width, 0, width, height);
		grass4 = sheetGrass.crop(3*width, 0, width, height);
		grass5 = sheetGrass.crop(4*width, 0, width, height);
		
		//Stone
		
		//Water
		water1 = sheetWater.crop(0, 0, width, height);
		
		//House
		house = ImageLoader.loadImage("/textures/static_entities/house/house.png");
		
		//Plants
		weedPlant = ImageLoader.loadImage("/textures/static_entities/plants/weedPlant.png");
	}
}
