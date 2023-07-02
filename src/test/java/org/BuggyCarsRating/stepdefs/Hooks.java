package org.BuggyCarsRating.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.annotations.BeforeTest;
import utilities.WebDriverUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.logging.log4j.ThreadContext;
import lombok.extern.log4j.Log4j2;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Hooks {

    final WebDriverUtils web;

    public Hooks(WebDriverUtils web) {
        this.web = web;
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        ThreadContext.put("loggerId", scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        log.info(scenario.getStatus());
        if (scenario.isFailed()) {
            log.error(scenario.getName() + " failed!!! Attaching a screenshot...");
            byte[] screenshot = ((TakesScreenshot) web.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        web.quitDriver();
        ThreadContext.put("loggerId", "main");
}}
