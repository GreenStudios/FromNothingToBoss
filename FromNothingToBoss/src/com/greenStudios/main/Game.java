package com.greenStudios.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.greenStudios.java2d.Assets;
import com.greenStudios.java2d.Display;
import com.greenStudios.java2d.GameCamera;
import com.greenStudios.listeners.KeyManager;
import com.greenStudios.listeners.MouseManager;
import com.greenStudios.main.states.GameState;
import com.greenStudios.main.states.MenuState;
import com.greenStudios.main.states.SettingsState;
import com.greenStudios.main.states.State;
import com.greenStudios.main.ui.UIManager;

public class Game implements Runnable {
	//Frame
	private final Display display;
	//Listeners
	private final KeyManager keyManager;
	private final MouseManager mouseManager;
	//-------------------------------------
	private boolean running;
	private Thread mainThread;
	private Canvas canvas;
	private BufferStrategy bs;
	private Graphics g;
	private UIManager uiManager;
	private int timer;
	//-------------------------------------
	//States
	public State gameState;
	public State menuState;
	public State settingsState;
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public Game() {
		// ---initialization------		
		display = new Display();
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		uiManager = new UIManager(handler);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		this.canvas = display.getCanvas();
		//---States-----------------
		gameState = new GameState(handler);
		menuState = new MenuState(handler, uiManager);
		settingsState = new SettingsState(handler, uiManager);
		State.setState(menuState);
		// -------------------------
		start();
	}

	// ------------------------------------------------------------------------------------
	private void tick() {
		keyManager.tick();
		
		if(State.getState() != null){
			State.getState().tick();
		}
		timer++;
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
		if(State.getState() != null && timer >= 120){
			State.getState().render(g);
		}else{
			g.drawImage(Assets.loadingscreen, 0, 0, 1920, 1080, null);
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
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	public MouseManager getMouseManager(){
		return mouseManager;
	}
	public Display getDisplay(){
		return display;
	}
}
