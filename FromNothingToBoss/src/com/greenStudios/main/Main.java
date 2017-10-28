package com.greenStudios.main;

import com.greenStudios.objects.WorldController;

public class Main implements Runnable {

	private Thread mainThread;
	private boolean running = false;

	public Main() {
		new WorldController();
		start();
	}
//------------------------------------------------------------------------------------
	private void tick() {

	}

	private void render() {

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
