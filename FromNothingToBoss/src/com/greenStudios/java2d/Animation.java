package com.greenStudios.java2d;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Animation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8149660526268846767L;
	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;
	
	public Animation(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed) {
			index++;
			timer = 0;
			
			if(index >= frames.length)
				index = 0;
		}
	}
	
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}

}
