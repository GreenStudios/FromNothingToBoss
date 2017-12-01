package com.greenStudios.hud;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import com.greenStudios.java2d.Assets;
import com.greenStudios.java2d.Text;
import com.greenStudios.main.Handler;

public class HUD{

	private Handler handler;
	
	private int hudWidth = 1920,
				hudHeight = 1080;
	
	private int hpX = 750,
				hpY = 992;
	
	private int apX = 1050,
				apY = 992;
	
	private int playerHP, playerAP;
	
	private int currentWeapon;
	
	public HUD(Handler handler) {
		this.handler = handler;
	}
	
	public void tick() {
		playerHP = handler.getWorldManager().getCurrentWorld().getEntityManager().getPlayer().getHealth();
		playerAP = handler.getWorldManager().getCurrentWorld().getEntityManager().getPlayer().getArmor();
	}
	
	public void render(Graphics g) {
		g.drawImage(Assets.hud, 0, 0, hudWidth, hudHeight, null);
		Text.drawString(g, Integer.toString(playerHP), hpX, hpY, true, Color.BLACK, Assets.font28);
		Text.drawString(g, Integer.toString(playerAP), apX, apY, true, Color.BLACK, Assets.font28);
	}
	
	//Getters & Setters
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

}
