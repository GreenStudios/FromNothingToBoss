package com.greenStudios.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.greenStudios.main.Game;

public class KeyManager implements KeyListener {
	
	private boolean[] keys, justPressed, cantPress;
	public boolean moveUp, moveDown, moveLeft, moveRight;
	public boolean attack;
	public boolean action;
	public boolean sprint;

	public KeyManager() {
		super();
		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
	}
	
	public boolean keyJustPressed(int keyCode){
		if(keyCode == 0 || keyCode == keys.length)
			return false;
			return justPressed[keyCode];
		}
	
	public void tick(){
		for(int i = 0; i < keys.length; i++) {
			if(cantPress[i] && !keys[i]) {
				cantPress[i] = false;
			}else if(justPressed[i]){
				cantPress[i] = true;
				justPressed[i] = false;
			}
			if(!cantPress[i] && keys[i]) {
				justPressed[i] = true;
			}
		}
		
		if(keyJustPressed(KeyEvent.VK_E)) {
			System.out.println("E JUST PRESSED");
		}
		
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
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) {
			return;
		}
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
