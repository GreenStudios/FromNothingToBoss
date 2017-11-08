package com.greenStudios.entities.statics;

import java.io.Serializable;

import com.greenStudios.entities.Entity;
import com.greenStudios.main.Handler;

public abstract class StaticEntity extends Entity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8539216932648312266L;

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	
	}
	
	

}
