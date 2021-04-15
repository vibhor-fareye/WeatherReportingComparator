package com.test.weatherReportComparator.web.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

enum DriverType {
    CHROME, FIREFOX, SAFARI, IE
}


abstract public class PageFunctions {
    private WebDriver driver;

    public WebDriver getDriver(){
        if(driver == null){
            throw new NullPointerException("Driver not initialized!!");
        }
        return this.driver;
    }

    public WebDriver getDriver(DriverType driverType) {
        switch (driverType) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case IE:
                driver = new InternetExplorerDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Driver for " + driverType.name() + " does not exist");
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        return this.driver;
    }

    protected void click(By element){
        getWebElement(element).click();
    }

    protected void setText(By element, String ...text){
        getWebElement(element).sendKeys(text);
    }

    protected WebElement getWebElement(By by ){
        return driver.findElement(by);
    }

    protected List<WebElement> getWebElements(By by ){
        return driver.findElements(by);
    }


}

