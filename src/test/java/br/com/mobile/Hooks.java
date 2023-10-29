package br.com.mobile;

import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {
    // setar local ou deviceFarm
    public static String local = "local";
    // setar android ou iOS
    public static String plataforma = "android";

    private static AppiumDriver<?> driver;

    public static AppiumDriver<?> validateDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        File applicationParentDirectoryPath = new File("apps");

        if(local.equals("local") && plataforma.equals("android")) {
            File app = new File(applicationParentDirectoryPath, "app-debug.apk");
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            capabilities.setCapability("appium:platformName", "Android");
            driver = new AndroidDriver<>(new URL("http://10.0.0.119:4723/wd/hub"), capabilities);
        }else{
            File app = new File(applicationParentDirectoryPath, "app-debug.app");
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            capabilities.setCapability("appium:platformName", "iOS");
            capabilities.setCapability("appium:platformVersion", "15.0");
            capabilities.setCapability("appium:deviceName", "iPhone 13");
            driver = new AndroidDriver<>(new URL("http://10.0.0.119:4723/wd/hub"), capabilities);
        }
        return driver;
    }

    public static AppiumDriver<?> getDriver(){
        return driver;
    }

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
        }
    }

    @Before
    public static void startProject() throws MalformedURLException{
        if(getDriver() != null){
            getDriver().launchApp();
        }else{
            validateDriver();
        }
    }
}
