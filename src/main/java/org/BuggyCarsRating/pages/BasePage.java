package org.BuggyCarsRating.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import lombok.extern.log4j.Log4j2;


import java.util.concurrent.TimeUnit;
import java.time.Duration;

@Log4j2
public class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait driverWait;



    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 15), this);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        int timeoutInSeconds = 30;
        Duration timeoutDuration = Duration.ofSeconds(timeoutInSeconds);
        driverWait = new WebDriverWait(this.driver, timeoutDuration);
    }



    public WebElement waitUntilVisibilityOf(WebElement element) {
        log.debug("Wait until element to be visible");
        return (WebElement) driverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getPageSource() {
        log.info("Returning Page Source");
        return driver.getPageSource();
    }

    public void mouseover(WebElement webElement) {
        Actions action = new Actions(driver);
        action.moveToElement(webElement).build().perform();
    }
    public String getTitle() {
        log.info("Returning Title");
        String title = driver.getTitle();
        int counter = 0;
        while (title.isEmpty() && counter++ < 10) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                //log.error(e);
            }
            title = driver.getTitle();
        }
        return title;
    }
    public String preLogin() {
        new HomePage(driver).clickRegister();
        String dateTime = new RegisterPage(driver).registerANewUser("BCR-RANDOM", "fn", "ln", "BCR123^bcr");
        driver.navigate().back();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            //log.error(e);
        }

        new HomePage(driver).login("BCR-" + dateTime, "BCR123^bcr");
        return dateTime;
    }

}
