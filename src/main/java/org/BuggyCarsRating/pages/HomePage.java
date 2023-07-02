package org.BuggyCarsRating.pages;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverUtils;

public class HomePage extends BasePage {


    @FindBy(linkText = "Buggy Rating")
    WebElement buggyRating;

    @FindBy(linkText = "Register")
    WebElement register;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement login;

    @FindBy(name = "login")
    WebElement userName;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//span[contains(text(),'Hi')] ")
    WebElement greeting;

    @FindBy(xpath = "//span[contains(text(),'Invalid username/password')]")
    WebElement errorMessage;

    @FindBy(xpath = "//a[@href='/overall']")
    WebElement overallRating;

    @FindBy(linkText = "Profile")
    WebElement profile;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage clickRegister() {
        register.click();
        return new RegisterPage(driver);
    }

    public boolean isLoginAvailable() {
        return login.isEnabled();
    }


    public HomePage login(String userName, String password) {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        login.click();

        return new HomePage(driver);
    }

    public String isUserLoggedIn(String greeting) {

        return this.greeting.getText();
    }


    public String getErrorMessage() {

        return this.errorMessage.getText();
    }

    public OverallRatingPage clickOverallRating() {
        overallRating.click();
        return new OverallRatingPage(driver);
    }

    public ProfilePage clickProfile() {
        profile.click();
        return new ProfilePage(driver);
    }

    public HomePage clickBuggyRating(){
        buggyRating.click();
        return this;
    }
}
