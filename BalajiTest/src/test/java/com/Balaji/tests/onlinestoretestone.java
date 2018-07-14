package com.Balaji.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Balaji.Services.HomePage;

public class onlinestoretestone {
	HomePage Home = null;

	@BeforeClass
	public void init() throws InterruptedException {
		Home = new HomePage();
		Home.openonlinestoreHomePage();
	}

	@AfterClass
	public void tearDown() {
		Home.closepage();
	}
	@Test
	public void testone() throws InterruptedException {
		System.out.println("This is test one");
		  System.out.println("Test Case One in " + getClass().getSimpleName()
					+ " with Thread Id:- " + Thread.currentThread().getId());
	}
}
