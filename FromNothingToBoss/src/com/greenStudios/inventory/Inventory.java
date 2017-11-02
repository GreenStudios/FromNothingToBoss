package com.greenStudios.inventory;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.greenStudios.items.Item;
import com.greenStudios.main.Handler;

public class Inventory {
	
	private Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	
	public Inventory(Handler handler) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
		
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
