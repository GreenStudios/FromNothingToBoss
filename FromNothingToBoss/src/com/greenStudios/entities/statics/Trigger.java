package com.greenStudios.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import com.greenStudios.main.Handler;

public class Trigger extends StaticEntity{

	private static final long serialVersionUID = 6554996824906643936L;

	public Trigger(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		// TODO Auto-generated constructor stub
		
		trigger.x = (int) x;
		trigger.y = (int) y;
		trigger.width = width;
		trigger.height = height;
		
		hurtable = false;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		if(checkTriggerCollisions(0, 0) == true){
			onTrigger();
			System.out.println("Trigger");
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.blue);
		g.fillRect((int) (x + trigger.x - handler.getGameCamera().getxOffset()), (int) (y + trigger.y - handler.getGameCamera().getyOffset()), trigger.width, trigger.height);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void onTrigger()
	{
		if(handler.getWorldManager().getWorldName() == "shop")
			handler.getWorldManager().setWorld("main");
	}

}