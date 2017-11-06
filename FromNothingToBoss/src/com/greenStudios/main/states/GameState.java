package com.greenStudios.main.states;

import java.awt.Graphics;
import java.io.IOException;

import com.greenStudios.entities.Player;
import com.greenStudios.entities.statics.House;
import com.greenStudios.java2d.Assets;
import com.greenStudios.main.Handler;
import com.greenStudios.main.ui.ClickListener;
import com.greenStudios.main.ui.UIImageButton;
import com.greenStudios.main.ui.UIManager;
import com.greenStudios.utils.Save;
import com.greenStudios.worlds.World;
import com.greenStudios.worlds.WorldManager;

public class GameState extends State {

	private WorldManager worldManager;
	private UIManager uiManager;

	public GameState(Handler handler, UIManager uiManager) {
		super(handler);
		worldManager = new WorldManager(handler);
		handler.setWorldManager(worldManager);
		this.uiManager = uiManager;
		
	}

	@Override
	public void tick() {
		worldManager.tick();
		uiManager.tick();
		if(handler.getKeyListener().pausemenu){
			setButtons();
			handler.getWorldManager().getCurrentWorld().setPause(true);
		}else{
			uiManager.getObjects().clear();
			handler.getWorldManager().getCurrentWorld().setPause(false);
		}
	}

	@Override
	public void render(Graphics g) {
		worldManager.render(g);
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
				try {
					new Save(handler);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
