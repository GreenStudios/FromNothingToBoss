package com.greenStudios.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.greenStudios.main.Game;

public class FNTBKeyListener implements KeyListener {
	
	private boolean[] keys;
	public boolean up, down, left, right;

	public FNTBKeyListener() {
		super();
		keys = new boolean[256];
	}
	
	public void tick(){
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		
		if(keys[KeyEvent.VK_ESCAPE]){
			System.exit(0);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
