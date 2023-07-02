package org.BuggyCarsRating.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProfilePage extends BasePage {

    @FindBy(id = "gender")
    WebElement gender;

    @FindBy(id = "age")
    WebElement age;

    @FindBy(id = "address")
    WebElement address;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement save;

    @FindBy(xpath = "//div[contains(text(),'The profile has been saved successful')]")
    WebElement successMessage;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String updateData(String gender, String age, String address) {
        this.gender.sendKeys(gender);
        this.age.sendKeys(age);
        this.address.sendKeys(address);
        save.click();
        return waitUntilVisibilityOf(successMessage).getText();
    }

    public String getGender() {
        return gender.getAttribute("value");
    }

    public String getAge() {
        return age.getAttribute("value");
    }

    public String getAddress() {
        return address.getAttribute("value");
    }
}