package com.greenStudios.objects;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.greenStudios.java2d.Display;
import com.greenStudios.listeners.FNTBKeyListener;
import com.greenStudios.listeners.FNTBKeyListener.KeyPressed;

public class WorldController implements Runnable {

	private final Display display;
	private final FNTBKeyListener keylis;
	private boolean running;
	private Thread mainThread;
	private Canvas canvas;
	private BufferStrategy bs;
	private Graphics g;
	private int x1 = 10,y1 = 50;
	private int x2 = 50,y2 = 70;
	private int directionY, directionX;

	public WorldController() {
		keylis = new FNTBKeyListener(this);
		display = new Display(keylis);
		
		this.canvas = display.getCanvas();
		start();
	}

	// ------------------------------------------------------------------------------------
	private void tick() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.fillRect(0, 0, display.getWidth(), display.getHeight());
		//--Clear Screen-----
		g.clearRect(0, 0, display.getWidth(), display.getHeight());
		//--Draw Picture-----
		g.setColor(Color.GREEN);
		g.fillRect((x1 += directionX), (y1 += directionY), (x2 ), (y2 ));
		//-------------------
		bs.show();
		g.dispose();
	}

	// GameLoop
	public void run() {
		while (running) {
			tick();
			render();
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

	public void onKeypressed(KeyPressed key) {
		if(key == KeyPressed.UP){
			directionY = -1;
		}else if(key == KeyPressed.DOWN){
			directionY = 1;
		}else if(key == KeyPressed.LEFT){
			directionX = -1;
		}else if(key == KeyPressed.RIGHT){
			directionX = 1;
		}else if(key == KeyPressed.STOP){
			directionX = 0;
			directionY = 0;
		}
	}
}
