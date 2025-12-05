package com.qa.mystepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import pages.DriverFactory;
import util.ConfigReader;

public class hooks {

    @Before
    public void setup() {
        ConfigReader.init();
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(ConfigReader.get("url"));
    }

    @After
    public void tearDown() {
        DriverFactory.removeDriver();
    }
}
