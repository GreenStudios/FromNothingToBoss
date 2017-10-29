package com.greenStudios.java2d;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.greenStudios.listeners.FNTBKeyListener;
import com.greenStudios.world.WorldController;

public class Display {

	private WorldController controller;
	
	private JFrame frame;
	private Canvas canvas;
	private FNTBKeyListener keylistener;

	private String title;
	private int width, height;

	public Display() {
		title = "From Nothing To Boss";
		width = 1280;
		height = 720;
		controller = new WorldController(this,keylistener);
		keylistener = new FNTBKeyListener(controller);
		
		createDisplay();
	}

	private void createDisplay() {

		
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
        frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		frame.setFocusable(true);
		frame.addKeyListener(keylistener);

		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}

}
