package myprojects.automation.assignment2;

import myprojects.automation.assignment2.utils.Credentials;
import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    /**
     *
     * @return New instance of {@link WebDriver} object.
     */
    public static WebDriver getDriver() {
        // TODO switcher for browsers
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        return new ChromeDriver();
    }

    public static String getAdminUrl(){
        return Properties.getBaseAdminUrl();
    }

    public static String getAdminLogin(){
        return Credentials.ADMIN_LOGIN.getValue();
    }

    public static String getAdminPassword(){
        return Credentials.ADMIN_PASS.getValue();
    }
}
