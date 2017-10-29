package com.greenStudios.java2d;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.greenStudios.listeners.FNTBKeyListener;

public class Display {

	private JFrame frame;
	private Canvas canvas;

	private String title;
	private int width, height;

	public Display() {
		title = "From Nothing To Boss";
		width = 1920;
		height = 1024;
		
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
		canvas.setFocusable(false);
		frame.setFocusable(true);

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
	public JFrame getFrame(){
		return frame;
		
	}

}
