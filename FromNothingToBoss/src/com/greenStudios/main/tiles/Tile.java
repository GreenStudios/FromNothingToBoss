package com.greenStudios.main.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.greenStudios.main.tiles.grass.Grass1;
import com.greenStudios.main.tiles.grass.Grass2;
import com.greenStudios.main.tiles.grass.Grass3;
import com.greenStudios.main.tiles.grass.Grass4;
import com.greenStudios.main.tiles.grass.Grass5;
import com.greenStudios.main.tiles.grass.Grass6;
import com.greenStudios.main.tiles.misc.VoidTile;
import com.greenStudios.main.tiles.street.SideStreet1;
import com.greenStudios.main.tiles.street.SideStreet2;
import com.greenStudios.main.tiles.street.SideStreet3;
import com.greenStudios.main.tiles.street.SideStreet4;
import com.greenStudios.main.tiles.street.StraightStreet1;
import com.greenStudios.main.tiles.street.StraightStreet2;
import com.greenStudios.main.tiles.water.Water1;

public class Tile {
	
	//STATIC STUFF HERE
	//Tile Initialization
	
	//Tile Array
	public static Tile[] tiles = new Tile[256];
	
	//Grass 0-9
	public static Tile grass1 = new Grass1(0);
	public static Tile grass2 = new Grass2(1);
	public static Tile grass3 = new Grass3(2);
	public static Tile grass4 = new Grass4(3);
	public static Tile grass5 = new Grass5(4);
	public static Tile grass6 = new Grass6(5);
	
	
	//Water 10-19
	public static Tile water1 = new Water1(10);
	
	//Street
	public static Tile straightStreet1 = new StraightStreet1(30);
	public static Tile straightStreet2 = new StraightStreet2(31);
	public static Tile sideStreet1 = new SideStreet1(32);
	public static Tile sideStreet2 = new SideStreet2(33);
	public static Tile sideStreet3 = new SideStreet3(34);
	public static Tile sideStreet4 = new SideStreet4(35);
	
	//Misc
	public static Tile voidTile = new VoidTile(20);
	
	//CLASS
	
	public static final int TILEWIDTH = 64;
	public static final int TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public Boolean isSolid() {
		return false;
	}
	
	public int getID(){
		return id;
	}

}
