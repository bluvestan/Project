package com.balaji.pageobjects;

import java.io.FileInputStream;
import java.util.Properties;

public class LocateObjects {
	private Properties obprop = null;
	private FileInputStream obfis = null;

	public Properties getBalajiob() {
		try {
			obfis = new FileInputStream("src//test//resources//onlinestore.properties");
			obprop = new Properties();
			obprop.load(obfis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obprop;
	}

}
