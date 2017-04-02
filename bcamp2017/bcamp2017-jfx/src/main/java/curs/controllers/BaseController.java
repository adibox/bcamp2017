package curs.controllers;

import curs.nav.ControlledScreen;
import curs.nav.ScreensController;

public class BaseController implements ControlledScreen {
	private ScreensController mScreensController;

	@Override
	public void setScreenParent(ScreensController pScreenPage) {
		mScreensController = pScreenPage;
	}
	
	public void navigateToScreen(String pName) {
		mScreensController.setScreen(pName);
	}

}
