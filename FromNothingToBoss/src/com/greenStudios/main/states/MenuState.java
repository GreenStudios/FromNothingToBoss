package com.greenStudios.main.states;

import java.awt.Color;
import java.awt.Graphics;

import com.greenStudios.audio.AudioPlayer;
import com.greenStudios.java2d.Animation;
import com.greenStudios.java2d.Assets;
import com.greenStudios.main.Handler;
import com.greenStudios.main.ui.ClickListener;
import com.greenStudios.main.ui.UIImageButton;
import com.greenStudios.main.ui.UIManager;
import com.greenStudios.utils.Load;

public class MenuState extends State {

	private UIManager uiManager;

	private AudioPlayer menuMusic;

	public MenuState(Handler handler, UIManager uiManager) {
		super(handler);
		this.uiManager = uiManager;
		handler.getMouseManager().setUIManager(uiManager);
		setButtons();

		menuMusic = new AudioPlayer("/music/bgm_mainMenu.wav");
		menuMusic.loop(-10f);
	}

	public void setButtons() {
		uiManager.addObject(new UIImageButton(50, 50, 640, 160, Assets.btn_continue, new ClickListener() {
			@Override
			public void onClick() {
				// handler.getMouseManager().setUIManager(null);
				// State.setState(handler.getGame().gameState);
			}
		}));

		uiManager.addObject(new UIImageButton(50, 250, 640, 160, Assets.btn_newgame, new ClickListener() {
			@Override
			public void onClick() {
				menuMusic.stop();
				State.setState(handler.getGame().gameState);
				uiManager.getObjects().clear();
				handler.getGame().gameState.setButtons();
			}
		}));

		uiManager.addObject(new UIImageButton(50, 450, 640, 160, Assets.btn_loadgame, new ClickListener() {
			@Override
			public void onClick() {
				new Load(handler);
				menuMusic.stop();
				State.setState(handler.getGame().gameState);
				uiManager.getObjects().clear();
				handler.getGame().gameState.setButtons();
				
			}
		}));

		uiManager.addObject(new UIImageButton(50, 650, 640, 160, Assets.btn_settings, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().settingsState);
				uiManager.getObjects().clear();

				handler.getGame().settingsState.setButtons();

			}
		}));

		uiManager.addObject(new UIImageButton(50, 850, 640, 160, Assets.btn_quitgame, new ClickListener() {
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
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1920, 1080) ;
		uiManager.render(g);
		
	}

}