package com.greenStudios.world;

import com.greenStudios.java2d.Display;
import com.greenStudios.listeners.FNTBKeyListener;
import com.greenStudios.listeners.FNTBKeyListener.KeyPressed;

public class WorldController {

	private final Display display;
	private final FNTBKeyListener keylistener;
	
	public WorldController(Display display, FNTBKeyListener keylistener){
		this.display = display;
		this.keylistener = keylistener;
	}
	
	public void onKeypressed(KeyPressed key) {
		if (key == KeyPressed.UP) {

		} else if (key == KeyPressed.DOWN) {

		} else if (key == KeyPressed.LEFT) {

		} else if (key == KeyPressed.RIGHT) {

		} else if (key == KeyPressed.STOP) {

		}
	}
}
