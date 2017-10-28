package com.greenStudios.main;

import com.greenStudios.objects.WorldController;

public class Main {
	
	private Thread mainThread;
	private boolean running;
	
	public Main(){
		new WorldController();
	}

	// GameLoop
	public void run() {

		init();
		while (running) {

		}
	}

	public synchronized void start() {
		mainThread = new Thread();
		mainThread.start();
	}

	public synchronized void stop() {
		try {
			mainThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ------------------------------------------------
	private void tick() {

	}

	private void init() {

	}

	private void render() {

	}

}
