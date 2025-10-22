package com.qa.mystepdefs;

import io.github.bonigarcia.wdm.WebDriverManager; // ✅ You forgot to import this

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class hooks {
	@Before
    public void setUp() {
		WebDriverManager.chromedriver().setup();  // ✅ Auto sets path
	    WebDriver driver = new ChromeDriver();
	    DriverFactory.setDriver(driver);
	    DriverFactory.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        DriverFactory.removeDriver();
    }
}
