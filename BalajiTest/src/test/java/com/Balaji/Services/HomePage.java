package com.Balaji.Services;

import org.apache.log4j.Logger;

import com.balaji.config.BaseConfiguration;
import com.balaji.pageobjects.LocateObjects;

public class HomePage extends BaseConfiguration {
	private static Logger logger = Logger.getLogger(HomePage.class.getName());
	public LocateObjects Homeobjects;

	public void openonlinestoreHomePage() throws InterruptedException {
		Homeobjects = new LocateObjects();
		invokeBrowser();

	}
public void enterloginid() throws InterruptedException{
	
}
	public void closepage() {
		tearDown();
	}
}
