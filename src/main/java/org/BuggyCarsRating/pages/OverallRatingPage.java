package org.BuggyCarsRating.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class OverallRatingPage extends BasePage {

    public OverallRatingPage(WebDriver driver) {
        super(driver);
    }

    public ModelPage selectCar(String make, String model) {
        if(driver.findElements(By.linkText(model)).size() != 0){
            driver.findElement(By.linkText(model)).click();
        } else if(driver.findElements(By.linkText(make)).size() != 0){
            driver.findElement(By.linkText(make)).click();
            driver.findElement(By.linkText(model)).click();
        }
        return new ModelPage(driver);
    }
}
