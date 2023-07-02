package utilities;

import org.BuggyCarsRating.pages.HomePage;
import org.BuggyCarsRating.pages.ModelPage;
import org.BuggyCarsRating.pages.OverallRatingPage;
import org.BuggyCarsRating.pages.RegisterPage;
import org.BuggyCarsRating.pages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.ThreadContext;


@Log4j2
public class WebDriverUtils {
    public WebDriver driver;

    public HomePage home;
    public RegisterPage register;
    public OverallRatingPage overallRating;
    public ModelPage model;
    public ProfilePage profile;

    public WebDriverUtils() {
        ThreadContext.put("loggerId", "main");
        initDriver();
        initPages();
    }

    private void initPages() {
        log.info("Initializing page objects");
        home = new HomePage(driver);
        register = new RegisterPage(driver);
        overallRating = new OverallRatingPage(driver);
        model = new ModelPage(driver);
        profile = new ProfilePage(driver);
        log.info(String.format("Thread-%s %s", Thread.currentThread().getId(), "Pages Initialized"));
    }

    public void initDriver() {
        log.info("Initializing driver");
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            }
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get("https://buggy.justtestit.org/");
        }


    public void restDriver() {
        if (driver != null && !driver.getCurrentUrl().equals("https://buggy.justtestit.org/")) {
            driver.manage().deleteAllCookies();
            driver.get("https://buggy.justtestit.org/");
        }
    }

    public void quitDriver() {

        driver.quit();
    }

}
