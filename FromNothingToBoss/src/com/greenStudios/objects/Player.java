package com.greenStudios.objects;

import javax.swing.*;
import java.awt.*;

public class Player {

	int x, y;

	Image player;

	// edit
	public Player() {
		ImageIcon img = new ImageIcon(getClass().getResource("images/player.png"));
		player = img.getImage();
	}

	public Image getPlayer() {
		return player;
	}

	public void move(int x, int y) {
		this.x += x;
	}

	public int setX(int x) {
		this.x = x;
		return x;
	}

	public int setY(int y) {
		this.y = y;
		return y;
	}
}
