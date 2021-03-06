package com.greenStudios.worlds;

import java.awt.Graphics;
import java.util.ArrayList;

import com.greenStudios.entities.Entity;
import com.greenStudios.entities.EntityManager;
import com.greenStudios.entities.Player;
import com.greenStudios.entities.Entity.Type;
import com.greenStudios.entities.statics.BrokenHouse;
import com.greenStudios.entities.statics.Field;
import com.greenStudios.entities.statics.House;
import com.greenStudios.entities.statics.House_Jonah1;
import com.greenStudios.entities.statics.WeedPlant;
import com.greenStudios.items.ItemManager;
import com.greenStudios.main.Handler;
import com.greenStudios.main.tiles.Tile;
import com.greenStudios.utils.Utils;

public class World {

	protected Handler handler;
	protected int width;
	protected int height;
	protected int spawnX, spawnY;
	protected int[][] tiles;
	protected Field lastTerainCol;
	protected int timer = 0;
	protected boolean actionallow = true;
	protected boolean pause = false;
	protected String worldName;

	// Entities
	protected EntityManager entityManager;

	// Item
	protected ItemManager itemManager;

	public World(Handler handler, String path, Player player) {
		this.handler = handler;

		entityManager = new EntityManager(handler, player);
		itemManager = new ItemManager(handler);

		loadWorld(path);

		
	}
	
	public void spawn() {
		entityManager.getPlayer().setX(spawnX); // Loads spawnX from world1
		entityManager.getPlayer().setY(spawnY); // Loads spawnY from world1
	}

	public void tick() {
		if (!pause) {
			itemManager.tick();
			entityManager.tick();
			getInput();
			timer++;
			if (timer >= 60) {
				actionallow = true;
			}
		}
	}

	protected void getInput() {
		if (handler.getKeyListener().action && entityManager.getPlayer().onField() && actionallow) {
			if (!lastTerainCol.getPlanted()) {
				entityManager.addEntity(
						new WeedPlant(handler, lastTerainCol.getX(), lastTerainCol.getY() - 55, lastTerainCol));
				lastTerainCol.setPlanted(true);
				actionallow = false;
				timer = 0;
			} else {
				lastTerainCol.getPlant().hurt(100);
				lastTerainCol.setPlanted(false);
				actionallow = false;
				timer = 0;
			}
		}
	}

	public void render(Graphics g) {
		// Tile Calculation
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		// Tiles
		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}

		// Items
		itemManager.render(g);

		// Entities
		ArrayList<Entity> entities = entityManager.getEntities();
		for (Entity e : entities) {
			if (Type.Terain == e.getType()) {
				e.render(g);
			}
		}
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
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grass1;

		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.grass1;
		return t;
	}

	protected void loadWorld(String path) {
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

	public void setLastTerainCol(Entity lastTerainCol) {
		this.lastTerainCol = (Field) lastTerainCol;
	}
	public void setPause(boolean b){
		pause = b;
	}
}
