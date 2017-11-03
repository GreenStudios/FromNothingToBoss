package com.greenStudios.main.states;

import java.awt.Graphics;

import com.greenStudios.entities.Player;
import com.greenStudios.entities.World;
import com.greenStudios.entities.statics.House;
import com.greenStudios.java2d.Assets;
import com.greenStudios.main.Handler;
import com.greenStudios.main.ui.ClickListener;
import com.greenStudios.main.ui.UIImageButton;
import com.greenStudios.main.ui.UIManager;
import com.greenStudios.utils.Save;

public class GameState extends State {

	private World world;
	private UIManager uiManager;

	public GameState(Handler handler, UIManager uiManager) {
		super(handler);
		
		world = new World(handler, "assets/worlds/world_test.csv");
		handler.setWorld(world);
		this.uiManager = uiManager;
		
	}

	@Override
	public void tick() {
		world.tick();
		uiManager.tick();
		if(handler.getKeyListener().pausemenu){
			setButtons();
		}else{
			uiManager.getObjects().clear();
		}
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		uiManager.render(g);
	}

	@Override
	public void setButtons() {
		uiManager.addObject(new UIImageButton(600, 50, 640, 160, Assets.btn_continue, new ClickListener() {
			@Override
			public void onClick() {
				handler.getKeyListener().pausemenu = false;
			}
		}));
		uiManager.addObject(new UIImageButton(600, 650, 640, 160, Assets.btn_savegame, new ClickListener() {
			@Override
			public void onClick() {
				new Save(handler);
			}
		}));
		uiManager.addObject(new UIImageButton(600, 850, 640, 160, Assets.btn_quitgame, new ClickListener() {
			@Override
			public void onClick() {
				System.exit(0);
			}
		}));
	}
	

}
