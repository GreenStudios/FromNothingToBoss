package com.greenStudios.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.greenStudios.main.Game;

public class KeyManager implements KeyListener {
	
	private boolean[] keys;
	public boolean moveUp, moveDown, moveLeft, moveRight;
	public boolean attack;
	public boolean action;
	public boolean sprint;

	public KeyManager() {
		super();
		keys = new boolean[256];
	}
	
	public void tick(){
		moveUp = keys[KeyEvent.VK_UP];
		moveDown = keys[KeyEvent.VK_DOWN];
		moveLeft = keys[KeyEvent.VK_LEFT];
		moveRight = keys[KeyEvent.VK_RIGHT];
		
		attack = keys[KeyEvent.VK_D];
		
		action = keys[KeyEvent.VK_SPACE];
		
		sprint = keys[KeyEvent.VK_SHIFT];
		
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
