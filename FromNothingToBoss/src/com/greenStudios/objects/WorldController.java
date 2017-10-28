package com.greenStudios.objects;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.greenStudios.java2d.Display;

public class WorldController implements Runnable {

	private final Display display;
	private boolean running;
	private Thread mainThread;
	private Canvas canvas;
	private BufferStrategy bs;
	private Graphics g;

	public WorldController() {
		display = new Display();
		this.canvas = display.getCanvas();
		start();
	}

	// ------------------------------------------------------------------------------------
	private void tick() {

	}
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.fillRect(0, 0, display.getWidth(), display.getHeight());
		
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
}
