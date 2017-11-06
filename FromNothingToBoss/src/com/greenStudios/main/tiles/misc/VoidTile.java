package com.greenStudios.main.tiles.misc;


import com.greenStudios.java2d.Assets;
import com.greenStudios.main.tiles.Tile;

public class VoidTile extends Tile{
	
	public VoidTile(int id) {
		super(Assets.voidTile, id);
	}
	
	@Override
	public Boolean isSolid() {
		return true;
	}
	
}

