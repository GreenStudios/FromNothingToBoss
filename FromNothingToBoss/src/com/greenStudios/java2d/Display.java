package com.greenStudios.java2d;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;


public class Display {

	private JFrame frame;
	private Canvas canvas;

	private String title;
	private int width, height;
	private boolean fullscreen = true;
	
	private GraphicsDevice device;

	public Display() {
		title = "From Nothing To Boss";
		width = 1920;
		height = 1080;
		
		createDisplay();
	}

	private void createDisplay() {

		
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
      //frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		frame.setFocusable(true);
		
		 GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		 device =ge.getDefaultScreenDevice();
		 setFullscreen();

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
	public GraphicsDevice getDevice(){
		return device;
	}
	public void setFullscreen(){
		if(fullscreen){
			if(device.isFullScreenSupported()){
	            device.setFullScreenWindow(null);
	            fullscreen = false;
	        }
		}else{
			if(device.isFullScreenSupported()){
	            device.setFullScreenWindow(frame);
	            fullscreen = true;
	        }
		}
	}

}
