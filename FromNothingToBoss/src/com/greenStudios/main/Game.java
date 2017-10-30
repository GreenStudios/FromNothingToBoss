package com.greenStudios.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.greenStudios.java2d.Assets;
import com.greenStudios.java2d.Display;
import com.greenStudios.java2d.GameCamera;
import com.greenStudios.listeners.FNTBKeyListener;
import com.greenStudios.main.states.GameState;
import com.greenStudios.main.states.MenuState;
import com.greenStudios.main.states.State;

public class Game implements Runnable {

	private final Display display;
	private final FNTBKeyListener keyListener;
	
	private boolean running;
	private Thread mainThread;
	private Canvas canvas;
	private BufferStrategy bs;
	private Graphics g;
	
	private State gameState;
	private State menuState;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public Game() {
		// ---initialization------		
		display = new Display();
		keyListener = new FNTBKeyListener();
		display.getFrame().addKeyListener(keyListener);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		this.canvas = display.getCanvas();
		//---States-----------------
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(gameState);
		// -------------------------
		start();
	}

	// ------------------------------------------------------------------------------------
	private void tick() {
		keyListener.tick();
		
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
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public int getWidth() {
		return display.getWidth();
	}
	
	public int getHeight() {
		return display.getHeight();
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
	
	public FNTBKeyListener getKeyListener(){
		return keyListener;
		
	}
}
