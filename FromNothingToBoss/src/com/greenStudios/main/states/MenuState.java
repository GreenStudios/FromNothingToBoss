package com.greenStudios.main.states;

import java.awt.Color;
import java.awt.Graphics;

import com.greenStudios.main.Handler;

public class MenuState extends State{

	public MenuState(Handler handler){
		super(handler);
	}
	
	@Override
	public void tick() {
		System.out.println(handler.getMouseManager().getMouseX() + "  " + handler.getMouseManager().getMouseY());
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed()){
			State.setState(handler.getGame().gameState);
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 12, 18);
	}

}
