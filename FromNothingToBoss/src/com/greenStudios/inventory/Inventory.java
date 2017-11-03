package com.greenStudios.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.greenStudios.items.Item;
import com.greenStudios.java2d.Assets;
import com.greenStudios.java2d.Text;
import com.greenStudios.main.Handler;

public class Inventory {
	
	private Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	
	private int invX = 256, invY = 256,
				invWidth = 512, invHeight = 512,
				invListCenterX,
				invListCenterY;
	
	public Inventory(Handler handler) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
		
		addItem(Item.weedItem.createNew(5));
	}

	public void tick() {
		if(handler.getKeyListener().keyJustPressed(KeyEvent.VK_E))
			active = !active;
		if(!active)
			return;
	}
	
	public void render(Graphics g) {
		if(!active)
			return;
		
		g.drawImage(Assets.inventoryScreen, invX, invY, invWidth, invHeight, null);
		
		Text.drawString(g, "Weed", invListCenterX, invListCenterY, false, Color.WHITE, Assets.font64);
	}
	
	//Inventory Methods
	
	public void addItem(Item item) {
		for(Item i : inventoryItems) {
			if(i.getId() == item.getId()) {
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
	}
	
	//Getters & Setters

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	
	
}
