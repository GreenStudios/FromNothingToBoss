package com.greenStudios.entities;

import java.awt.Graphics;

import com.greenStudios.entities.statics.House;
import com.greenStudios.entities.statics.House_Jonah1;
import com.greenStudios.entities.statics.Shed;
import com.greenStudios.entities.statics.WeedPlant;
import com.greenStudios.items.ItemManager;
import com.greenStudios.main.Handler;
import com.greenStudios.main.tiles.Tile;
import com.greenStudios.utils.Utils;

public class World {

	private Handler handler;
	private int width;
	private int height;
	private int spawnX, spawnY;
	private int[][] tiles;
	private int timer;
	private boolean timerStatus = false;
	
	//Entities
	private EntityManager entityManager;
	
	//Item
	private ItemManager itemManager;
	
	public World(Handler handler, String path){
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 192, 192));
		itemManager = new ItemManager(handler);
		
		entityManager.addEntity(new House(handler, 2*64, 4*64));
		entityManager.addEntity(new WeedPlant(handler, 7*64, 4*64));
		entityManager.addEntity(new Shed(handler, 2*64, 8*64));
		entityManager.addEntity(new House_Jonah1(handler, 4*64, 10*64));
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX); //Loads spawnX from world1
		entityManager.getPlayer().setY(spawnY); //Loads spawnY from world1
	}
	
	public void tick() {
		itemManager.tick();
		entityManager.tick();
		getInput();
		
		if(timerStatus){
		timer++;
		}
		
		if(timer == 60*2){
			timer = 0;
			timerStatus = false;
		}
	}
	
	private void getInput(){
		if(handler.getKeyListener().action && timer == 0){
			entityManager.addEntity(new WeedPlant(handler, entityManager.getPlayer().getX(), entityManager.getPlayer().getY()));
			timerStatus = true;
		}
	}
	
	public void render(Graphics g) {
		//Tile Calculation
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		//Tiles
		for(int y = yStart; y < yEnd; y++) {
			for(int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int) (y*Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		
		//Items
		itemManager.render(g);
		
		//Entities
		entityManager.render(g);
		
	}
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) 
			return Tile.grass1;
		
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.grass1;
		return t;
	}
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
		
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
