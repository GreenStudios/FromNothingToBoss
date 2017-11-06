package com.greenStudios.main.states;

import java.awt.Graphics;

import com.greenStudios.java2d.Assets;
import com.greenStudios.main.Handler;
import com.greenStudios.main.ui.ClickListener;
import com.greenStudios.main.ui.UIImageButton;
import com.greenStudios.main.ui.UIManager;

public class SettingsState extends State {

	private UIManager uiManager;

	public SettingsState(Handler handler, UIManager uiManager) {
		super(handler);
		this.uiManager = uiManager;
	}

	public void setButtons() {

		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(50, 50, 640, 160, Assets.btn_fullscreen, new ClickListener() {
			@Override
			public void onClick() {
				handler.getGame().getDisplay().setFullscreen();
			}
		}));

		uiManager.addObject(new UIImageButton(50, 850, 640, 160, Assets.btn_back, new ClickListener() {
			@Override
			public void onClick() {
				uiManager.getObjects().clear();

				handler.getGame().menuState.setButtons();
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
