package com.balaji.config;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.balaji.utils.CommonTestUtils;

public class BaseConfiguration extends CommonTestUtils {
	private static Logger logger = Logger.getLogger(BaseConfiguration.class.getName());
	protected WebDriver wd = null;
	private DesiredCapabilities dc = null;
	private FileInputStream brfis = null;
	private Properties brprop = null;
	private String baseUrl;
	private String browser;

	public void invokeBrowser() {
		try {
			PropertyConfigurator.configure("src//test//resources//log4j.properties");
			brfis = new FileInputStream("src//test//resources//config.properties");
			brprop = new Properties();
			brprop.load(brfis);
			browser = brprop.getProperty("Browser");
			if (browser.equalsIgnoreCase("firefox")) {
				wd = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.home")+""+ "//Documents//ScriptDrivers//chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				wd = new ChromeDriver(options);
			} else if (browser.equalsIgnoreCase("iexplore")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.home") + "" + "//Documents//ScriptDrivers//IEDriverServer.exe");
				wd = new InternetExplorerDriver();
			} else if (browser.equalsIgnoreCase("opera")) {
				System.setProperty("webdriver.opera.driver",
						System.getProperty("user.home") + "" + "//Documents//ScriptDrivers//operadriver.exe");
			}
			baseUrl = brprop.getProperty("TestUrl");
			openPage(baseUrl, wd);
			wd.manage().window().maximize();
			wd.manage().timeouts().implicitlyWait(Integer.parseInt(brprop.getProperty("ImplicitWait")),
					TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
			//logger.error("Base Configuration Error");
		}
	}
	public void tearDown(){
		wd.quit();
	}
}
