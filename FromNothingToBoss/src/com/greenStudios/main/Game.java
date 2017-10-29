package com.greenStudios.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.greenStudios.java2d.Assets;
import com.greenStudios.java2d.Display;
import com.greenStudios.java2d.ImageLoader;
import com.greenStudios.java2d.SpriteSheet;
import com.greenStudios.listeners.FNTBKeyListener;
import com.greenStudios.listeners.FNTBKeyListener.KeyPressed;
import com.greenStudios.main.states.GameState;
import com.greenStudios.main.states.MenuState;
import com.greenStudios.main.states.State;
import com.greenStudios.world.WorldController;

public class Game implements Runnable {

	private final Display display;
	
	private boolean running;
	private Thread mainThread;
	private Canvas canvas;
	private BufferStrategy bs;
	private Graphics g;
	
	private State gameState;
	private State menuState;

	public Game() {
		// ---init------
		
		display = new Display();

		Assets.init();
		this.canvas = display.getCanvas();
		//---States-----------------
		gameState = new GameState();
		menuState = new MenuState();
		State.setState(gameState);
		// -------------------------
		start();
	}

	// ------------------------------------------------------------------------------------
	private void tick() {
		if(State.getState() != null){
			State.getState().tick();
		}
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();

		g.fillRect(0, 0, display.getWidth(), display.getHeight());
		// --Clear Screen-----
		g.clearRect(0, 0, display.getWidth(), display.getHeight());
		// --Draw Picture-----
		if(State.getState() != null){
			State.getState().render(g);
		}
		// -------------------
		bs.show();
		g.dispose();
	}

	// GameLoop
	public void run() {

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("FPS:"+ ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}

	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		mainThread = new Thread(this);
		mainThread.start();
	}

	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			mainThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
