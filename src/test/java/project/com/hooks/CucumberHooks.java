package project.com.hooks;

import project.com.common.BaseTest;
import project.com.driver.DriverFactory;
import project.com.driver.DriverManager;
import project.com.helpers.CaptureHelpers;
import project.com.helpers.PropertiesHelpers;
import io.cucumber.java.*;
import project.com.utils.LogUtils;

public class CucumberHooks {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("================ beforeAll ================");
        PropertiesHelpers.loadAllFiles();
        //Khởi chạy Report
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("================ afterAll ================");

    }

    @Before
    public void beforeScenario() {
        System.out.println("================ beforeScenario ================");
//        BaseTest.createDriver();
        //Record video
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("================ afterScenario ================");
//        BaseTest.closeDriver();
        DriverManager.quit();
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        System.out.println("================ beforeStep ================");
        //Ghi file log4j
        LogUtils.info(scenario.getName());
        //Ghi log step vào report
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        System.out.println("================ afterStep ================");
        //validate if scenario has failed then Screenshot
        if (scenario.isFailed()) {
            CaptureHelpers.takeScreenshot(scenario.getName());
        }
    }
}