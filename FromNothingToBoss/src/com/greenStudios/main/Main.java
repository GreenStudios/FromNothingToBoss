package com.greenStudios.main;

import com.greenStudios.objects.WorldController;

public class Main implements Runnable{

	private Thread mainThread;
	private boolean running;

	public Main() {
		running = false;
		start();
	}

	private void init() {
		new WorldController();
	}

	// GameLoop
	public void run() {
		init();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void tick() {

	}

	private void render() {

	}

}
