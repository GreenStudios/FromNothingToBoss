package com.greenStudios.java2d;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Display {
	
	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	
	public Display(String title, int with, int height){
		this.title = title;
		this.width = with;
		this.height = height;
		
		createDisplay();
	}

	private void createDisplay() {
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

}
