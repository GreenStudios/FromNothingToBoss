package com.greenStudios.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import com.greenStudios.entities.Entity.Type;
import com.greenStudios.items.Item;
import com.greenStudios.java2d.Assets;
import com.greenStudios.main.Handler;
import com.greenStudios.main.tiles.Tile;

public class WeedPlant extends StaticEntity {

	private boolean drawCollision = false;
	private int growTime = 0;
	private final static int NEEDED_GROW_TIME = 60 * 10;
	private boolean mature = false;

	public WeedPlant(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, 96);

		bounds.x = width / 2;
		bounds.y = 70;
		bounds.width = 3;
		bounds.height = 3;
		hurtable = true;
	}

	@Override
	public void tick() {
		if (growTime >= NEEDED_GROW_TIME) {
			mature = true;
		}
		growTime++;
	}

	@Override
	public void die() {
		if (mature) {
			handler.getWorld().getItemManager().addItem(Item.weedItem.createNew((int) x, (int) y));
		}
	}

	@Override
	public void render(Graphics g) {
		if (mature) {
			g.drawImage(Assets.weedPlantMature, (int) (x - handler.getGameCamera().getxOffset()),
					(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		} else {
			g.drawImage(Assets.weedPlant, (int) (x - handler.getGameCamera().getxOffset()),
					(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}
		if (drawCollision) {
			g.setColor(Color.red);
			g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
					(int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		}
	}
	@Override
	public Type getType(){
		return Type.WeedPlant;
	}

}
