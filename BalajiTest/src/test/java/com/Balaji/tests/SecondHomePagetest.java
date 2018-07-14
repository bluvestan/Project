package com.Balaji.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Balaji.Services.HomePage;

public class SecondHomePagetest {
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
	public void testtwo() throws InterruptedException {
		System.out.println("This is test two");
		  System.out.println("Test Case two in " + getClass().getSimpleName()
					+ " with Thread Id:- " + Thread.currentThread().getId());
	}
}

