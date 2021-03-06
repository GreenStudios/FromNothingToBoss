package com.greenStudios.java2d;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	public static final int width = 64, height = 64;
	
	public static Font font28;
	
	public static BufferedImage grass1, grass2, grass3, grass4, grass5, grass6;
	public static BufferedImage water1;
	public static BufferedImage straightStreet1, straightStreet2, sideStreet1, sideStreet2, sideStreet3, sideStreet4;
	public static BufferedImage voidTile;
	public static BufferedImage[] player_down, player_up, player_left, player_right, player_idle;
	public static BufferedImage house, shed, house_jonah1, brokenhouse;
	public static BufferedImage weedPlantMature, weedPlant;
	public static BufferedImage field;	
	public static BufferedImage[] btn_continue;
	public static BufferedImage[] btn_newgame;
	public static BufferedImage[] btn_loadgame;
	public static BufferedImage[] btn_settings;
	public static BufferedImage[] btn_quitgame;
	public static BufferedImage[] btn_savegame;
	
	public static BufferedImage hud;
	public static BufferedImage inventoryScreen;
	
	public static BufferedImage weedItem;

	public static BufferedImage[] btn_fullscreen;
	public static BufferedImage[] btn_back;
	
	public static BufferedImage loadingscreen;
	
	
	public static void init(){
		
		//Sheets
		SpriteSheet sheetTiles = new SpriteSheet(ImageLoader.loadImage("/textures/sheets/sheetTiles.png"));
		SpriteSheet sheetPlayerAnims = new SpriteSheet(ImageLoader.loadImage("/textures/sheets/sheetPlayerAnims.png"));
		SpriteSheet sheetMenu = new SpriteSheet(ImageLoader.loadImage("/textures/sheets/sheetmenubutton.png"));
		SpriteSheet sheetSave = new SpriteSheet(ImageLoader.loadImage("/textures/sheets/sheetsavebuttons.png"));
		
		//Font
		font28 = FontLoader.loadFont("assets/textures/gui/8_bit_party.ttf", 28);
		
		//Menu Buttons
		btn_continue = new BufferedImage[2];
		btn_newgame = new BufferedImage[2];
	    btn_loadgame = new BufferedImage[2];
		btn_settings = new BufferedImage[2];
		btn_quitgame = new BufferedImage[2];
		btn_fullscreen = new BufferedImage[2];
		btn_back = new BufferedImage[2];
		btn_savegame = new BufferedImage[2];
		
		btn_continue[0] = sheetMenu.crop(0, 0, 639, 159);
		btn_continue[1] = sheetMenu.crop(639, 0, 639, 159);
		btn_newgame[0] = sheetMenu.crop(0, 159, 639, 159);
		btn_newgame[1] = sheetMenu.crop(639, 159, 639, 159);
		btn_loadgame[0] = sheetMenu.crop(0, 319, 639, 159);
		btn_loadgame[1] = sheetMenu.crop(639, 319, 639, 159);
		btn_settings[0] = sheetMenu.crop(0, 479, 639, 159);
		btn_settings[1] = sheetMenu.crop(639, 479, 639, 159);
		btn_quitgame[0] = sheetMenu.crop(0, 639, 639, 159);
		btn_quitgame[1] = sheetMenu.crop(639, 639, 639, 159);
		btn_fullscreen[0] = sheetMenu.crop(0, 799, 639, 159);
		btn_fullscreen[1] = sheetMenu.crop(639, 799, 639, 159);
		btn_back[0] = sheetMenu.crop(0, 959, 639, 159);
		btn_back[1] = sheetMenu.crop(639, 959, 639, 159);
		btn_savegame[0] = sheetSave.crop(0, 0, 639, 159);
		btn_savegame[1] = sheetSave.crop(639, 0, 639, 159);
		
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
		grass1 = sheetTiles.crop(0, 0, width, height);
		grass2 = sheetTiles.crop(width, 0, width, height);
		grass3 = sheetTiles.crop(2*width, 0, width, height);
		grass4 = sheetTiles.crop(3*width, 0, width, height);
		grass5 = sheetTiles.crop(4*width, 0, width, height);
		grass6 = sheetTiles.crop(5*width, 0, width, height);
		
		//Street
		straightStreet1 = sheetTiles.crop(0, 3*height, width, height);
		straightStreet2 = sheetTiles.crop(width, 3*height, width, height);
		sideStreet1 = sheetTiles.crop(2*width, 3*height, width, height);
		sideStreet2 = sheetTiles.crop(3*width, 3*height, width, height);
		sideStreet3 = sheetTiles.crop(4*width, 3*height, width, height);
		sideStreet4 = sheetTiles.crop(5*width, 3*height, width, height);
		
		//Water
		water1 = sheetTiles.crop(0, height, width, height);
		
		//Field
		field = ImageLoader.loadImage("/textures/terrain/field/Field.png");
		
		voidTile = sheetTiles.crop(0, 2*height, width, height);
		
		//Buildings
		house = ImageLoader.loadImage("/textures/static_entities/buildings/house.png");
		shed = ImageLoader.loadImage("/textures/static_entities/buildings/shed.png");
		house_jonah1 = ImageLoader.loadImage("/textures/static_entities/buildings/house_jonah1.png");
		brokenhouse = ImageLoader.loadImage("/textures/static_entities/buildings/brokenhouse.png");
		
		//Plants
		weedPlantMature = ImageLoader.loadImage("/textures/static_entities/plants/weedPlant.png");
		weedPlant = ImageLoader.loadImage("/textures/static_entities/plants/weed.png");
		
		//Items
		inventoryScreen = ImageLoader.loadImage("/textures/gui/inventory.png");
		weedItem = ImageLoader.loadImage("/textures/items/weedItem.png");
		
		hud = ImageLoader.loadImage("/textures/gui/hud.png");
		
		loadingscreen = ImageLoader.loadImage("/textures/other/LoadingScreen.png");
	}
}
