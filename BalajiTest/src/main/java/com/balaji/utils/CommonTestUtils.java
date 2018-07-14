package com.balaji.utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class CommonTestUtils {
	public static WebDriver wd = null;

public static void openPage(String url, WebDriver wd){
	wd.navigate().to(url);
	wd.manage().window().maximize();
	}
public static void takeScreenShot(WebDriver wd){
	try{
		int count = 0;
		String NewFileNamePath;
		File directory = new File(".");
		DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");
		Date date = new Date();
		
		NewFileNamePath = directory.getCanonicalPath()+ "\\ScreenShots\\" + dateFormat.format(date) + "_" + ".png";
		BufferedImage screencapture = new Robot().createScreenCapture(new Rectangle(968, 1009));
		
		File file = new File(NewFileNamePath);
		ImageIO.write(screencapture, "png", file);
		count++;
		
		File screenshot = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(NewFileNamePath));
		Reporter.log("<a href=" + NewFileNamePath+ " target='NewFileNamePath' >ScreenShot" + count + "</a>");
	}
	
	catch(Exception e){
		e.printStackTrace();
	}
}
}
