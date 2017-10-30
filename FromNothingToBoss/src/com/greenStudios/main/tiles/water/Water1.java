package com.greenStudios.main.tiles.water;

import java.awt.image.BufferedImage;

import com.greenStudios.java2d.Assets;
import com.greenStudios.main.tiles.Tile;

public class Water1 extends Tile{
	
	public Water1(int id) {
		super(Assets.water1, id);
	}
	
	@Override
	public Boolean isSolid() {
		return true;
	}
	
}

