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
	
	private int invX = 800, invY = 300,
				invWidth = 320, invHeight = 480,
				invListCenterX = 918,
				invListCenterY = 496,
				invListSpacing = 32;
	
	private int invImageX = 1036, invImageY = 320,
				invImageWidth = 64, invImageHeight = 64;
	
	private int invCountX = 1068, invCountY = 441;
	
	private int selectedItem = 0;
	
	public Inventory(Handler handler) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
	}

	public void tick() {
		if(handler.getKeyListener().keyJustPressed(KeyEvent.VK_E))
			active = !active;
		if(!active) {
			return;
		}
		
		if(handler.getKeyListener().keyJustPressed(KeyEvent.VK_UP)) {
			selectedItem--;
		}
		if(handler.getKeyListener().keyJustPressed(KeyEvent.VK_DOWN)) {
			selectedItem++;
		}
		
		if(selectedItem < 0) {
			selectedItem = inventoryItems.size() - 1;
		}else if(selectedItem >= inventoryItems.size()) {
			selectedItem = 0;
		}
	}
	
	public void render(Graphics g) {
		if(!active) {
			return;
		}
		
		g.drawImage(Assets.inventoryScreen, invX, invY, invWidth, invHeight, null);
		
		int len = inventoryItems.size();
		
		if(len == 0) {
			return;
		}
		
		for(int i = -5; i < 6; i++) {
			
			if(selectedItem + i  < 0 || selectedItem + i >= len) {
				continue;
			}
			
			if(i == 0) {
				Text.drawString(g, inventoryItems.get(selectedItem + i).getName(), invListCenterX,
						invListCenterY + i * invListSpacing, true, Color.YELLOW, Assets.font28);
			}else {
				Text.drawString(g, inventoryItems.get(selectedItem + i).getName(), invListCenterX,
						invListCenterY + i * invListSpacing, true, Color.BLACK, Assets.font28);
			}
		}
		
		Item item = inventoryItems.get(selectedItem);
		g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
		Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.BLACK, Assets.font28);
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}
