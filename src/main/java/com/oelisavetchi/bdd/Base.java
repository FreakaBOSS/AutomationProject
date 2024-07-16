package com.oelisavetchi.bdd;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

    public WebDriver driver;

    public WebDriver inheritance() {

        String driverPath = "E:\\Projects\\bdd\\ChromeDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        return new ChromeDriver(options);
    }

}
