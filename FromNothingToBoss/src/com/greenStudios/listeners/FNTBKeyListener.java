package com.greenStudios.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.greenStudios.objects.WorldController;

public class FNTBKeyListener implements KeyListener {
	public enum KeyPressed {
		UP, DOWN, LEFT, RIGHT, STOP
	}

	private final WorldController controller;

	public FNTBKeyListener(WorldController controller) {
		super();
		this.controller = controller;

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			controller.onKeypressed(KeyPressed.UP);
			break;
		case KeyEvent.VK_DOWN:
			controller.onKeypressed(KeyPressed.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			controller.onKeypressed(KeyPressed.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			controller.onKeypressed(KeyPressed.RIGHT);
			break;
		default:
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		controller.onKeypressed(KeyPressed.STOP);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
