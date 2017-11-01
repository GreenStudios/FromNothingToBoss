package com.greenStudios.main.states;

import java.awt.Graphics;
import java.util.concurrent.TimeUnit;

import com.greenStudios.java2d.Assets;
import com.greenStudios.main.Handler;
import com.greenStudios.main.ui.ClickListener;
import com.greenStudios.main.ui.UIImageButton;
import com.greenStudios.main.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;

	public MenuState(Handler handler, UIManager uiManager) {
		super(handler);
		this.uiManager = uiManager;
		handler.getMouseManager().setUIManager(uiManager);
		setButtons();
	}

	public void setButtons() {
		uiManager.addObject(new UIImageButton(600, 50, 640, 160, Assets.btn_continue, new ClickListener() {
			@Override
			public void onClick() {
				// handler.getMouseManager().setUIManager(null);
				// State.setState(handler.getGame().gameState);
			}
		}));
		
		uiManager.addObject(new UIImageButton(600, 250, 640, 160, Assets.btn_newgame, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
		
		uiManager.addObject(new UIImageButton(600, 450, 640, 160, Assets.btn_loadgame, new ClickListener() {
			@Override
			public void onClick() {
				// handler.getMouseManager().setUIManager(null);
				// State.setState(handler.getGame().gameState);
			}
		}));
		
		uiManager.addObject(new UIImageButton(600, 650, 640, 160, Assets.btn_settings, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().settingsState);
				uiManager.getObjects().clear();
				
				handler.getGame().settingsState.setButtons();
				
			}
		}));
		
		uiManager.addObject(new UIImageButton(600, 850, 640, 160, Assets.btn_quitgame, new ClickListener() {
			@Override
			public void onClick() {
				// handler.getMouseManager().setUIManager(null);
				System.exit(0);
			}
		}));
		
	}

	@Override
	public void tick() {
		uiManager.tick();

	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}